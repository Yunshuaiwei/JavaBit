package com.bit.user;

import com.bit.book.BookList;
import com.bit.operation.IOperation;

/**
 * @author DELL
 */
public abstract class User{
    protected String name;
    protected  IOperation[] operations;
    /**
     *
     * @return
     */
    public abstract int menu();
    /**
     *
     * @param choice
     * @param bookList
     */
    public void doOperation(int choice, BookList bookList){
        operations[choice].work(bookList);
    }
}
