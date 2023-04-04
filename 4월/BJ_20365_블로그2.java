package day_0404;

import java.io.*;
import java.util.*;

/** 후에 list 반복문 안돌리고, 처음 for문에서 처리할 수 있는 방법 생각해보기 **/
public class BJ_20365_블로그2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 문제 수
		ArrayList<Character> list = new ArrayList<>();

		String input = br.readLine();
		list.add(input.charAt(0));

		for (int i = 1; i < N; i++) {
			char color = input.charAt(i);

			if (color == input.charAt(i - 1)) // 앞문자와 같으면
				continue;
			else
				list.add(color);

		}
    
		int B = 0;
		int R = 0;
		int paint = 1; // 개수가 많은 것으로 한 번 칠했다고 생각하고 시작하면
		for (char c : list) {
			if (c == 'B')
				B++;
			else
				R++;

		}
		paint += Math.min(B, R);

		System.out.println(paint);

	}

}
