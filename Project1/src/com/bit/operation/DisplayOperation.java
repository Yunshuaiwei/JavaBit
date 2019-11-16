package com.bit.operation;

import com.bit.book.BookList;

/**
 * @author DELL
 */
public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i <bookList.getSize() ; i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
