package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class funcDevel {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> r = new ArrayList<>();
        Queue<Integer> score_que = new LinkedList<>();
        ArrayList<Integer> result_arr = new ArrayList<>();
        for(int i = 0; i<progresses.length; i++){
            int score = (100 - progresses[i]) / speeds[i];
            int remind = (100 - progresses[i]) % speeds[i];
            if(remind != 0)
                score++;
            result_arr.add(score);
            score_que.add(score);
        }
        while (!score_que.isEmpty()){
            int num = get_score(score_que, result_arr);
            r.add(num);
        }
        int[] result = r.stream().mapToInt(i->i).toArray();
        return result;

    }

    public static int get_score(Queue<Integer> score_que, ArrayList<Integer> result_arr){
        int peak = score_que.peek();
        int result = 0;
        for(int i = 0; i<result_arr.size(); i++){
            if(peak >= result_arr.get(i)){
                result++;
            }else {
                break;
            }
        }
        for(int i = 0; i<result; i++){
            score_que.poll();
            result_arr.remove(0);
        }
        return result;
    }
}
