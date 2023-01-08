import java.io.*;
import java.util.*;

class Solution {
    static int year, month, day;
    static Map<String, Integer> hm = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 현재 날짜 쪼개기
        year = Integer.parseInt(today.substring(0,4));
        System.out.println("year: "+year);
        month = Integer.parseInt(today.substring(5,7));
        System.out.println("month: "+month);
        day = Integer.parseInt(today.substring(8,10));
        System.out.println("day: "+day);
        
        // 약관 쪼개기 (해시맵)
        for(int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            System.out.println("term[0]: "+term[0]);
            System.out.println("term[1]: "+term[1]);
            hm.put(term[0], Integer.parseInt(term[1]));
        }
        
        // 날짜 계산을 위한 <현재 날짜> total 구하기
        int total = (year * 12 * 28) + ((month - 1) * 28) + day;
        
        // 개인약관 쪼개기
        for(int i=0; i<privacies.length; i++) {
            int y = Integer.parseInt(privacies[i].substring(0,4));
            int m = Integer.parseInt(privacies[i].substring(5,7));
            int d = Integer.parseInt(privacies[i].substring(8,10));
            String t = privacies[i].substring(11,12);
            System.out.println("t: "+t);
            
            int p_total = (y * 12 * 28) + ((m - 1) * 28) + d;
            System.out.println("p_total: "+p_total);
            System.out.println("total: "+total);
            
            if((hm.get(t) * 28) <= (total - p_total)) {
                System.out.println("hm.get(t) * 28: "+hm.get(t) * 28);
                list.add(i+1);
                System.out.println("i+1 번: "+(i+1));
            }
        }
        
        // list -> array
        /* 1. toArray */
        // int[] answer = list.toArray(new int[list.size()]);       
        /* 2. 반복문 */
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

/** substring : Returns a string that is a substring of this string. Thesubstring begins at the specified beginIndex andextends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.  **/
