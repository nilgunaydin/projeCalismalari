package interwievQuestionsMe;

import java.util.HashMap;
import java.util.Map;

public class a3b2sorusu<i> {
    public static void main(String[] args) {

    /*
           Char occurences in a String
          input : "aaabbccccddddd"
          output : a3b2c4d5
          verilen bir string'deki tekrarlayan character'leri ve tekrar sayisini yazdırınız.
         */

        String str = "aaabbccccddddd";
       Map<String,Integer> newStr= new HashMap();

        for (int i = 0; i < str.length(); i++) {
          if (!str.contains(str.substring(i,i+1))){
newStr.put(str.substring(i,i+1),1);
            }else{
          //newStr.setkey(str.substring(i,i+1),newStr.get(str.substring(i,i+1))+1);
          }
        }


    }}





