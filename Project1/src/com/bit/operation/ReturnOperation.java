package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;
/**
 * @author DELL
 */
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要归还的书籍：");
        String name=scanner.nextLine();
        int i = 0;
        for (; i <bookList.getSize() ; i++) {
            if(name.equals(bookList.getBook(i).name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书！");
        }
        Book book =bookList.getBook(i);
        if(book.isBorrowed){
            bookList.getBook(i).isBorrowed=false;
            System.out.println("归还成功！");
        }else{
            System.out.println("归还失败！");
            return ;
        }
    }
}
