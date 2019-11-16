package com.bit.user;

import com.bit.operation.*;

/**
 * @ProjectName JavaBit
 * @ClassName NormalUser
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:28
 * @Version 1.0
 **/
public class NormalUser extends User{
    public NormalUser(String name){
        this.name=name;
        this.operations=new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }
    @Override
    public int menu() {
        return 0;
    }
}
