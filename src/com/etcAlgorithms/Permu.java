package com.etcAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Permu {

   private int n; // nPr의 n
   private int r; // nPr의 r
   private ArrayList<Integer> itemList;
   private int[] res;
   int cnt = 0;
   // 초기화
   public Permu(int[] intArr, int r){
       this.r = r;             // nPr의 r
       this.n = intArr.length; // nPr의 n
       this.res = new int[r];  // 결과값 배열
       
       
       // 아이템이 들어갈 리스트
       itemList = new ArrayList<Integer>();
       for(int item : intArr)
           itemList.add(item);
   }
   
   public void perm(int depth){
       perm(itemList, 0);
   }

   public void perm(ArrayList<Integer> itemList, int depth) {
       
       // depth가 0부터 시작했을 경우 depth == r에서 리턴
       if (depth == r) {
           System.out.println(Arrays.toString(res));
           cnt++;
           return;
       }
       
       for (int i = 0; i < n-depth; i++){
           res[depth] = itemList.remove(i); // 아이템 선택 + 리스트에서 제거
           perm(itemList, depth+1);         // 재귀호출
           itemList.add(i, res[depth]);     // 제거된 아이템 복원
       }
   }
   
   public static void main(String[] args) {

	   
       int r = 8;
       int[] arr = {1,2,3,5,6,7,8,9};
       
       Permu main = new Permu(arr, r);
       main.perm(0);
       
       System.out.println(main.cnt);
   }
}