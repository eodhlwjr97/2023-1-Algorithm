package day_0607;

import java.io.*;
import java.util.*;

public class BJ_9996_한국이그리울땐서버에접속하지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 정규표현식 사용하기 : ^a.*d$
		// 1) 		^a : a로 시작
		// 2) 		. : 임의의 한 문자가
		// 3) 		* : 여러번 발생한다
		// 4) 		d$ : 그리고 d로 문자가 끝남
		String pattern = "^" + br.readLine().replace("*", ".*") + "$";

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.matches(pattern)) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	}

}
