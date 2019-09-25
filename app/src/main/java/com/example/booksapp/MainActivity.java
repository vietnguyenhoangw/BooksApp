package com.example.booksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Book> arrayList;
    BookListAdapter bookListAdapter;

    String url = "http://192.168.1.10:5000/books";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        bookListAdapter = new BookListAdapter(MainActivity.this, R.layout.book_item, arrayList);

        listView.setAdapter(bookListAdapter);
        getBooks();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
                intent.putExtra("image",arrayList.get(i).getBookImage());
                intent.putExtra("title", arrayList.get(i).getBookName());
                intent.putExtra("author", arrayList.get(i).getBookAuthor());
                intent.putExtra("descriptions", arrayList.get(i).getBookDescription());

                startActivity(intent);
            }
        });
    }

    // get book from API using volley
    private void getBooks() {

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new GsonBuilder().create();
                        Books books = gson.fromJson(response, Books.class);

                        arrayList.addAll(books.getBooks());
                        bookListAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }
}
