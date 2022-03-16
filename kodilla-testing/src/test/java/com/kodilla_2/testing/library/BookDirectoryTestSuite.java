package com.kodilla_2.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;
    @InjectMocks
    private LibraryUser libraryUser1Mock;

    @Mock
    private  LibraryDatabase libraryDatabaseMock2;
    @InjectMocks
    private LibraryUser libraryUser2Mock;

    @Mock
    private  LibraryDatabase libraryDatabaseMock3;
    @InjectMocks
    private LibraryUser libraryUser3Mock;


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
    void testUserHasNnumberofBooks() {

        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        BookLibrary bookLibrary2 = new BookLibrary(libraryDatabaseMock2);
        BookLibrary bookLibrary3 = new BookLibrary(libraryDatabaseMock3);

        List<Book> bookList0 = generateListOfNBooks(0);
        List<Book> bookList1 = generateListOfNBooks(1);
        List<Book> bookList5 = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1Mock)).thenReturn(bookList0);
        when(libraryDatabaseMock2.listBooksInHandsOf(libraryUser2Mock)).thenReturn(bookList1);
        when(libraryDatabaseMock3.listBooksInHandsOf(libraryUser3Mock)).thenReturn(bookList5);
        //When
        List<Book> result0 = bookLibrary.listBooksInHandsOf(libraryUser1Mock);
        List<Book> result1 = bookLibrary2.listBooksInHandsOf(libraryUser2Mock);
        List<Book> result5 = bookLibrary3.listBooksInHandsOf(libraryUser3Mock);
        //then
        assertEquals(0, result0.size());
        assertEquals(1, result1.size());
        assertEquals(5, result5.size());


    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int i = 0; i < booksQuantity; i++) {
            Book theBook = new Book("title" + i, "author" + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }

}
