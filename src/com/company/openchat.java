package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class openchat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }
    public static String[] solution(String[] record){
        HashMap<String, String> admin = new HashMap<>();
        HashMap<String, String> open = new HashMap<>();
        open.put("Enter","들어왔습니다.");
        open.put("Leave", "나갔습니다.");
        ArrayList<String> arr_list = new ArrayList<>();
        for(int i = 0; i<record.length; i++){
            String[] arr = record[i].split(" ");
            if(arr.length>2)
                admin.put(arr[1],arr[2]);
            if(arr[0].equals("Enter") || arr[0].equals("Leave"))
                arr_list.add(record[i]);
        }
        String[] result = new String[arr_list.size()];
        for(int i = 0; i<result.length; i++){
            String[] arr = arr_list.get(i).split(" ");
            result[i] = getStr(arr, admin, open);
        }
        return result;
    }

    public static String getStr(String[] arr, HashMap<String, String> admin,HashMap<String, String> open ){
        String result = "";
        result += admin.get(arr[1])+"님이 " +open.get(arr[0]);
        return result;
    }
}
