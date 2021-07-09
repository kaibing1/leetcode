package com.kb.d17;

import java.util.HashMap;

public class wordPattern {
    public boolean getSolution(String pattern, String str){
        if (pattern==null || str==null) return false;
        String[] s = str.split(" ");
        if(pattern.length() != s.length) return false;
        HashMap<Character, String> hashMap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char tmp = pattern.charAt(i);
            if(hashMap.containsKey(tmp)){
                if(!hashMap.get(tmp).equals(s[i])) return false;
            }else{
                if (hashMap.containsValue(s[i])) return false;
                else hashMap.put(tmp, s[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        wordPattern wordPattern = new wordPattern();
        System.out.println(wordPattern.getSolution("abb", "a b b c"));
    }
}
