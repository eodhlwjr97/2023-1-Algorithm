import java.io.*;
import java.util.*;

public class BJ_1181_단어정렬 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] words= new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		// 1. 길이, 2. 길이 같으면 사전순
		Arrays.sort(words, (s1, s2) -> {
			if(s1.length()!=s2.length()) {
				return s1.length() - s2.length();	
			} else {
				return s1.compareTo(s2);	
			}
		});
		
//		Arrays.sort(words, new Comparator<String>() {
//			public int compare(String s1, String s2) {
//				// 단어 길이가 같을 경우 
//				if (s1.length() == s2.length()) {
//					return s1.compareTo(s2);
//				} 
//				// 그 외의 경우 
//				else {
//					return s1.length() - s2.length();
//				}
//			}
//		});
		
		System.out.println(Arrays.toString(words));
		
	}

}
