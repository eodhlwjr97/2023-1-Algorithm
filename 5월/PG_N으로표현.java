import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        // 주어진 number가 N 그 자체일 때는 return 1
        if(N==number) return 1;
        
        // 그 외 (N을 이용하여 number를 만들어야 한다)
        HashSet<Integer> hashset = new HashSet<>();
        
        // N이 1,2,3, ... 개 일 때의 경우를 Set에 넣고, 그때그때 number가 발견되면 그 1,2,3 ... 의 숫자를 리턴       
        int idx = 1; 
        
        // N이 1개인 경우 한가지 경우만 존재하므로, 미리 처리해주고
        String N_str = ""+String.valueOf(N);
        // hashset.add(N);
        hashset.add(Integer.parseInt(N_str));
        
        while(true) {
            if(idx>8) {
                answer = -1;
                break;
            }
            if(hashset.contains(number)) {
                answer = idx;
                break;
            }
            
            // Iterator 사용해서 반복문 돌면서 값에 사칙연산하기
            Iterator<Integer> iter = hashset.iterator(); 
            ArrayList<Integer> list = new ArrayList<>(); // iter.next()를 담을 변수
            while(iter.hasNext()) {
                // int num = iter.next(); -> Integer, int 둘 모두 가능
                Integer num = iter.next();
                list.add(num);
                // Integer.parseInt(String s) 임
                // Object obj_num = iter.next();
                // int num = Integer.parseInt(obj_num);
                
                // 더하기
                hashset.add(num+N);
                // 빼기
                hashset.add(num-N);
                // 곱하기
                hashset.add(num*N);
                // 나누기
                hashset.add(num/N);
            }
            
            /** 
            java HashMap 등에서 iteration 중에 remove 메소드를 호출하거나 keySet 에 대한 for 문 안에서 remove 메소드를 호출하면 java.util.ConcurrentModificationException 이 발생하는 것 같습니다.
            **/
            
            // length : 배열길이, length() : 문자열길이, size() : 컬렉션프레임워크 타입의 길이
            for(int i=0; i<list.size(); i++) {
                hashset.remove(list.get(i));
            }
            list.clear();
            
            // 이는 조합으로 만들 수 없으므로 일단 넣어주고
            N_str += String.valueOf(N);
            hashset.add(Integer.parseInt(N_str));
            
            idx++;
        }
        return answer;
    }
}
