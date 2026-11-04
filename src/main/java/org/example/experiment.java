package org.example;

import java.util.Arrays;

public class experiment {
    public static void main(String[] args) {
        String hi = "HELLO GIT";
        String [] n1 = hi.split(" ");
        System.out.println(Arrays.toString(n1));
        StringBuilder q1 = new StringBuilder();
        for (int i = n1.length-1; i >= 0 ; i--) {
            if (i == 0){
                q1.append(n1[i]);
            } else {
                q1.append(n1[i] + " ");
            }
        }
        hi = q1.toString();
        System.out.println(hi);
    }
}
