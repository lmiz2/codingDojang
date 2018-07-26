package com.backjun.q1;

import java.util.Scanner;

public class tet {
   public static void main(String args[]) {
      Scanner scanner = new Scanner(System.in);
      int N = Integer.parseInt(scanner.nextLine());
      StringBuilder sb = new StringBuilder();
      int[] stack = new int[1000000];
      int top = -1;
      for (int i = 0; i < N; i++) {
         String method = scanner.next();
         if (method.equals("push")) {
            int n = Integer.parseInt(scanner.next());
            top++;
            stack[top] = n;
         } else if (method.equals("pop")) {
            if (top < 0) {
               sb.append("-1" + "\n");
            } else {
               sb.append(stack[top]);
               sb.append("\n");
               stack[top] = 0;
               top--;
            }
         } else if (method.equals("size")) {
            sb.append(top + 1);
            sb.append("\n");
         } else if (method.equals("empty")) {
            if (top <= -1) {
               sb.append("1" + "\n");
            } else {
               sb.append("0" + "\n");
            }
         } else if (method.equals("top")) {
            if (top == -1) {
               sb.append("-1\n");
            } else {
               sb.append(stack[top]);
               sb.append("\n");
            }
         }
      }
      System.out.println(sb);
   }
}