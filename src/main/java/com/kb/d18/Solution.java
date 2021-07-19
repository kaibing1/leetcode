package com.kb.d18;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    // 2106
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        HashMap<String, List<String>> map = new HashMap<>();
//        for(String s : strs){
//            String sortStr = sort(s);
//            if(!map.containsKey(sortStr)){
//                List<String> tmp = new ArrayList<>();
//                tmp.add(s);
//                map.put(sortStr, tmp);
//            }else{
//                List<String> tmp = map.get(sortStr);
//                tmp.add(s);
//            }
//        }
//        map.forEach((key, value) ->{
//            result.add(value);
//        });
//        return result;
//    }
//
//    public String sort(String s){
//        char[] c = s.toCharArray();
//        Arrays.sort(c);
//        return Arrays.toString(c);
//    }
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (int i=0; i<strs.length;i++){
//            char[] tmp = strs[i].toCharArray();
//            Arrays.sort(tmp);
//            String key = new String(tmp);
//            List<String> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(strs[i]);
//            map.put(key, list);
//        }
//        return new ArrayList<>(map.values());
//    }
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello world");
    }
}
