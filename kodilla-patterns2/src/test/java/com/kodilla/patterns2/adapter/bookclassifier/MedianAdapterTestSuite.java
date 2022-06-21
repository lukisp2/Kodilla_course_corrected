package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book_A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Book_A book1 = new Book_A("author1", "title1", 2000, "signature1");
        Book_A book2 = new Book_A("author2", "title2", 2005, "signature1");
        Book_A book3 = new Book_A("author1", "title3", 2011, "signature1");

        Set<Book_A> set = new HashSet<>();
        set.add(book1);
        set.add(book2);
        set.add(book3);
        //When
        MedianAdapter medianAdapter = new MedianAdapter();
        int median = medianAdapter.publicationYearMedian(set);
        //Then
        Assertions.assertEquals(2005, median);
    }
}
