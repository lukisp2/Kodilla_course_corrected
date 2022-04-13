package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testShallowCopy() {
        Library library = new Library("Library one");
        Book book = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", LocalDate.of(1912, 11, 11));
        Book book1 = new Book("Pan Tadeusz", "Adam Mickiewicz", LocalDate.of(1812, 11, 11));
        Book book2 = new Book("Jak Wojtek zostal kolejarzem", "Jan Kowalski", LocalDate.of(2000, 11, 11));

        library.getBooks().add(book);
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        Library libraryShallowCopy = null;
        try {
            libraryShallowCopy = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library libraryDeepCopy = null;
        try {
            libraryDeepCopy = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.books.remove(book);
        libraryDeepCopy.books.remove(book1);

        Assertions.assertEquals(2, library.books.size());
        Assertions.assertEquals(2, libraryShallowCopy.books.size());
        Assertions.assertEquals(2, libraryDeepCopy.books.size());

    }
}
