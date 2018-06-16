package com.teachweb.utils;

public class Method {
    public static String randomString(int n){
        String s = "";
        for(int i=0; i<n; i++){
            int r = (int)(Math.random()*3);
            char c;
            if(r==0){
                int d = (int)(Math.random()*10)+48;
                c = (char)d;
            }else if(r==1){
                int d = (int)(Math.random()*26) + 65;
                c = (char)d;
            }else{
                int d = (int)(Math.random()*26) + 97;
                c = (char)d;
            }
            s += c;
        }
        return s;
    }
}
