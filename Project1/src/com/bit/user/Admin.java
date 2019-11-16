package com.bit.user;

import com.bit.operation.*;
import com.sun.media.sound.SoftTuning;

import java.util.Scanner;
/**
 * @author DELL
 */
public class Admin extends User{
    public Admin(String name){
        this.name=name;
        this.operations=new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }
    @Override
    public int menu() {
        System.out.println("欢迎"+this.name+"登陆图书管理系统");
        System.out.println("1、查找图书");
        System.out.println("2、增加图书");
        System.out.println("3、删除图书");
        System.out.println("4、显示所有图书");
        System.out.println("0、退出");
        System.out.println("请输入你的选择：");
        Scanner scanner =new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
