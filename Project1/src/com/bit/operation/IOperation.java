package com.bit.operation;

import com.bit.book.BookList;

import java.util.Scanner;

public interface IOperation {
    Scanner scanner =new Scanner(System.in);
    /**
     *在实现类当中完成特定的操作
     * @param bookList
     */
    void work(BookList bookList);
}
