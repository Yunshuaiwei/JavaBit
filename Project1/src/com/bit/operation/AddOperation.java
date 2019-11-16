package com.bit.operation;
import com.bit.book.Book;
import com.bit.book.BookList;

/**
 * @author DELL
 */
public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("添加书籍：");
        System.out.println("请输入图书的名字：");
        String name=scanner.nextLine();
        System.out.println("请输入图书作者：");
        String author=scanner.nextLine();
        System.out.println("请输入图书价格：");
        int price=scanner.nextInt();
        System.out.println("请输入图书类型：");
        String type=scanner.next();
        Book book=new Book(name,author,price,type);
        bookList.setBooks(bookList.getSize(),book);
        int size=bookList.getSize()+1;
        bookList.setSize(size);
        System.out.println("添加成功！");
    }
}
