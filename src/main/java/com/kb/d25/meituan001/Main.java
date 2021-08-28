package com.kb.d25.meituan001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < i; j++) {
            String s = scanner.nextLine().trim();
//            scanner.next();
//            System.out.println(s);
            int aNum = 0;
            int dNum = 0;
            boolean flag = true;
            for (int k = 0; k < s.length(); k++) {
                char c = s.charAt(k);
                if (k == 0){
                    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                        aNum++;
                    }else {
                        System.out.println("Wrong");
                        flag = false;
                        break;
                    }
                }else {
                    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                        aNum++;
                    }else if (c<='9' && c>='0'){
                        dNum++;
                    }else {
                        System.out.println("Wrong");
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag)continue;
            if (dNum != 0 && aNum != 0){
                System.out.println("Accept");
            }else {
                System.out.println("Wrong");
            }
        }
    }
}
