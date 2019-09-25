package com.example.booksapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookListAdapter extends ArrayAdapter<Book> {

    Context context;
    int layout;
    ArrayList<Book> arrayList;

    ImageView bookImage;
    TextView bookTitle, bookAuthor;

    public BookListAdapter(@NonNull Context context, int resource, ArrayList<Book> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.layout = resource;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(layout, null);

        bookImage = convertView.findViewById(R.id.book_image);
        bookTitle = convertView.findViewById(R.id.book_title);
        bookAuthor = convertView.findViewById(R.id.book_author);

        final Book book = arrayList.get(position);

        Picasso.get()
                .load(book.getBookImage())
                .into(bookImage);
        bookTitle.setText(book.getBookName());
        bookAuthor.setText(book.getBookAuthor());

        return convertView;
    }


}
