package com.company;

public class onetwothreenation {
    public static void main(String[] args) {
        solution(6);
    }

    public static String solution(int n){
        int share = n/3;
        int remain = n%3;
        StringBuilder sb = new StringBuilder();
        sb = calc(share,remain,sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static StringBuilder calc(int share, int remain, StringBuilder sb){
        StringBuilder result_sb = sb;
        int num = share*3 + remain;
        if(num % 3 == 0){
            share = share-1;
        }
        if(share>0){
            int more_share = share/3;
            int more_remain = share%3;
            result_sb = calc(more_share, more_remain, result_sb);

        }
        sb.append(add_word(remain));

        return result_sb;

    }

    public static String add_word(int num){
        String result = "";
        if(num == 0)
            return "4";
        if(num == 1)
            return "1";
        if(num == 2)
            return "2";
        return "";
    }
}
