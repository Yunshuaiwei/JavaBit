package com.bit.operation;

import com.bit.book.BookList;

/**
 * @author DELL
 */
public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("bye!");
        System.exit(0);
    }
}
