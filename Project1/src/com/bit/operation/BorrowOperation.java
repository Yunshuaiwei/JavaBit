package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

/**
 * @author DELL
 */
public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入借阅书籍名称：");
        String name=scanner.next();
        //不会从bookList 中删除，即将isBorrowed置位true
        int i = 0;
        for (; i <bookList.getSize() ; i++) {
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书！");
            return;
        }
        Book book =bookList.getBook(i);
        if(book.isBorrowed){
            System.out.println("已经被借出！");

        }else{
            book.isBorrowed=true;
            System.out.println("借书成功！");
        }
    }
}
