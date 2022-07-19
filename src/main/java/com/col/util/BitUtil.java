package com.col.util;

import java.util.ArrayList;
import java.util.List;

public class BitUtil {
    private BitUtil(){
    }
    /**
     *判断整数num的第n个bit位是否是1，是1返回true，否则返回false
     * 1.按位与&两个相应位都为1,则该位的结果为1,否则为0
     * 2.num为非负数时，>> n和/ pow(2,n)的结果是一样的
     */
    public static boolean isBit(int num,int n){
        int j= num/(int)Math.pow(2,n)&1;
        return j==1;
    }

    /**
     * 将整数num，按照bit位拆分成n个数之和
     *
     * @param num 整数
     * @return list
     */
    public static List<Integer> int2ints(int num){
        ArrayList<Integer> newNum = new ArrayList<Integer>();
        for(int a=0;a<16;a++){
            int b = 1<<a;
            int c=num/b&1;
            if(c == 1)
                newNum.add(b);
        }
        return newNum;
    }
}
