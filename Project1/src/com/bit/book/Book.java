package com.bit.book;

/**
 * @ProjectName JavaBit
 * @ClassName Book
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:27
 * @Version 1.0
 **/

/**
 * @author DELL
 */
public class Book {
    public String name;
    public String author;
    public int price;
    public String type;
    /**
     * 标记书是否借出
     */
    public boolean isBorrowed;

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + ((isBorrowed)?",已经被借出":",未借出") +
                '}';
    }
}
