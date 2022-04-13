package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    final String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }


    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book element : books) {
            clonedLibrary.books.add(element);
        }
        return clonedLibrary;
    }


}