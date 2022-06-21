package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Map;


public interface BookStatistics {
    int averagePublicationYear(Map<BookSignature, Book_B> books);
    int medianPublicationYear(Map<BookSignature, Book_B> books);
}