package com.company;

import java.util.*;

public class spicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K){
        int result = 0;
        PriorityQueue<Integer> pq_sco = new PriorityQueue<>();
        for(int i = 0; i<scoville.length; i++){
            pq_sco.add(scoville[i]);
        }
        while(true){
            if(pq_sco.peek() >= K && result == 1)
                return result;
            if(pq_sco.size() == 1)
                return -1;

            if(pq_sco.peek() >= K && result>0)
                return result;
            int first = pq_sco.poll();
            int second = pq_sco.poll();
            int sum_sco = first + second*2;
            result++;
            pq_sco.add(sum_sco);
        }
    }
}
