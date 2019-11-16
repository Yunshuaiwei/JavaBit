package com.bit.operation;

import com.bit.book.BookList;

/**
 * @author DELL
 */
public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要删除的书籍：");
        String name=scanner.next();
        int i = 0;
        for (; i <bookList.getSize(); i++) {
            if(name.equals(bookList.getBook(i).name)){
                for (int j = i; j <bookList.getSize() ; j++) {
                    bookList.setBooks(j,bookList.getBook(j+1));
                }
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书！");
            return ;
        }
        int size=bookList.getSize();
        bookList.setSize(size-1);
        System.out.println("书籍删除成功！");
    }
}
