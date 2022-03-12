package com.kodilla_2.testing.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int i = 0; i < booksQuantity; i++) {
            Book theBook = new Book("title" + i, "author" + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }


    @Mock
    private LibraryDatabase libraryDatabaseMock;


    @Test
    void testListBooksWithConditionsReturnList() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4, theListOfBooks.size());

    }

    @Test
    void testListBooksWithConditionMoreThen20() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());

    }


    @Test
    void testUserHasOneBook_true(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser0 = new LibraryUser("Jan", "Kowalsky","0000");
        LibraryUser libraryUser1 = new LibraryUser("Jan", "Kowalsky","1111");
        LibraryUser libraryUser5 = new LibraryUser("Jan", "Kowalsky","2222");

        List<Book> bookList0 = generateListOfNBooks(0);
        List<Book> bookList1 = generateListOfNBooks(1);
        List<Book> bookList5 = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser0)).thenReturn(bookList0);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(bookList1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5)).thenReturn(bookList5);

        //when
        List<Book> result0 = bookLibrary.listBooksInHandsOf(libraryUser0);
        List<Book> result1 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> result5 = bookLibrary.listBooksInHandsOf(libraryUser5);

        //then
        assertEquals(0, result0.size());
        assertEquals(1, result1.size());
        assertEquals(5, result5.size());


    }

}
