package com.bit.operation;

import com.bit.book.BookList;
/**
 * @author DELL
 */
public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要查找的名称：");
        String name=scanner.next();
        int i = 0;
        for (; i <bookList.getSize(); i++) {
            if(name.equals(bookList.getBook(i).name)){
                System.out.println(bookList.getBook(i));
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书！");
            return ;
        }
        System.out.println("书籍查找成功！");
    }
}
