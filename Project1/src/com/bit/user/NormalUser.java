package com.bit.user;

import com.bit.operation.*;
import com.sun.media.sound.SoftTuning;

import java.util.Scanner;
/**
 * @author DELL
 */
public class NormalUser extends User{
    public NormalUser(String name){
        this.name=name;
        this.operations=new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new DisplayOperation()
        };
    }
    @Override
    public int menu() {
        System.out.println("欢迎"+this.name+"登录图书管理系统");
        System.out.println("1、查找图书");
        System.out.println("2、借阅图书");
        System.out.println("3、归还图书");
        System.out.println("4、显示所有图书");
        System.out.println("0、退出系统");
        System.out.println("请输入你的选择：");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
