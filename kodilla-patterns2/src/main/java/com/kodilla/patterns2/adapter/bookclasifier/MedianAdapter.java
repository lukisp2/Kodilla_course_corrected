package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book_B;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book_A;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book_A> bookSet) {
        Map<BookSignature, Book_B> map = new HashMap<>();
        for (Book_A books : bookSet) {
            map.put(new BookSignature(books.getSignature()), new Book_B(books.getAuthor(), books.getTitle(), books.getPublicationYear()));
        }
        return medianPublicationYear(map);
    }

}
