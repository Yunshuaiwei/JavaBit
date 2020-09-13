
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/8 18:47
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String src = input.nextLine();
        String str = input.nextLine();
        String des = input.nextLine();
        if (src.equals("") || des.equals("")) {
            System.out.println(str);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (map.containsKey(c)) {
                Integer val = map.get(c);
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 97 && c <= 122) {
                s.append(c);
            } else {
                if (method(s.toString(), map)) {
                    str = str.replaceFirst(s.toString(), des);
                }
                s = new StringBuilder();
            }
        }
        System.out.println(str);
    }

    private static boolean method(String str, HashMap<Character, Integer> map) {
        if (str.equals("")) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                Integer val = hashMap.get(c);
                hashMap.put(c, val + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (Character character : hashMap.keySet()) {
            if (map.containsKey(character)) {
                if (!map.get(character).equals(hashMap.get(character))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        short s=1;
        s+=1;
        System.out.println(s);

    }


}
