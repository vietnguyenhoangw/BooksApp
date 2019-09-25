package com.example.booksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity {

    ImageView bookImage;
    TextView bookTitle, bookAuthor, bookDescription;

    String image, title, author, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        createWidgets();
        getDataFromMainActivity();

        /* add data from getdata...() below to widgets */
        Picasso.get()
                .load(image)
                .into(bookImage);
        bookTitle.setText(title);
        bookAuthor.setText(author);
        bookDescription.setText(description);

    }

    /* get book item data passed from main activity */
    private void getDataFromMainActivity() {
        Bundle bundle = getIntent().getExtras();

        image = bundle.getString("image");
        title = bundle.getString("title");
        author = bundle.getString("author");
        description = bundle.getString("descriptions");
    }

    private void createWidgets() {
        bookImage = findViewById(R.id.book_image);
        bookTitle = findViewById(R.id.book_title);
        bookAuthor = findViewById(R.id.book_author);
        bookDescription = findViewById(R.id.book_description);
    }


}
