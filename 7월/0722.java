package day_0722;

import java.io.*;
import java.util.*;

public class BJ_19941_햄버거분해 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String s = br.readLine();
		char[] input = s.toCharArray();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// 사람이면
//			if(s.charAt(i)=='P') {
			if (input[i] == 'P') {
				// K범위의 햄버거 탐색
				for (int j = (i - K); j <= (i + K); j++) {
					// 가지치기
					if (j < 0 || j >= N)
						continue;

					// K범위의 햄버거가 맞다면 햄버거 먹기
					if (input[j] == 'H') {
//						s.charAt(j) = 'X';
						input[j] = 'X';
						cnt++;
						break;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(input));
		System.out.println(cnt);
	}

}
