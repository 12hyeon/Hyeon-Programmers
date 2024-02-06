package Lv_2;

import java.util.*;

class 단체사진_찍기 {

    public boolean[] used;
    public char[] arr;
    public String[] data;
    public int answer;

    public int solution(int n, String[] data) {
        this.answer = 0;
        this.data = data;
        arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        used = new boolean[arr.length];
        dfs("", 0);
        return answer;
    }

    public void dfs(String str, int len) { // 가능 경우만 담기 -> 담고 가능한지 보기
        if(len == arr.length) {
            if(isPossible(str)) answer++; // 완성된 string 확인
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(used[i]) continue;
            used[i] = true;
            dfs(str+arr[i], len+1);
            used[i] = false;
        }
    }

    public boolean isPossible(String str){
        for(String rule : data){
            int idx1 = str.indexOf(String.valueOf(rule.charAt(0)));
            int idx2 = str.indexOf(String.valueOf(rule.charAt(2)));
            char oper = rule.charAt(3);
            int diff = Integer.parseInt(String.valueOf(rule.charAt(4)));
            int realDiff = Math.abs(idx1-idx2)-1;
            if ((oper == '<') && !(realDiff < diff)) return false;
            else if ((oper == '>') && !(realDiff > diff)) return false;
            else if ((oper == '=') && !(realDiff == diff)) return false;
        }
        return true;
    }
}