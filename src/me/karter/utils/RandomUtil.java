package me.karter.utils;

import java.util.Random;

public class RandomUtil {
    public static String getRandomString(int engCode,int numCode){
        //声明一个StringBuffer存储随机数
        StringBuffer sb = new StringBuffer();
        char[] englishCodeArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numCodeArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        //获取英文
        for (int i = 0; i <engCode; i++){
            char num = englishCodeArray[random.nextInt(englishCodeArray.length)];
            sb.append(num);
        }
        //获取数字
        for (int i = 0; i <numCode; i++){
            char num = numCodeArray[random.nextInt(numCodeArray.length)];
            sb.append(num);
        }
        return sb.toString();
    }

    public static int nextInt(final int startInclusive, final int endExclusive) {
        if (endExclusive - startInclusive <= 0)
            return startInclusive;

        return startInclusive + new Random().nextInt(endExclusive - startInclusive);
    }
}
