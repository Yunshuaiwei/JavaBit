package com.bit.user;

import com.bit.operation.*;

/**
 * @ProjectName JavaBit
 * @ClassName Admin
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:27
 * @Version 1.0
 **/
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
        return 0;
    }
}
