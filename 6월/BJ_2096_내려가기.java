package day_0603;

import java.io.*;
import java.util.*;

/**
 * Scanner : 		217900KB	920ms
 * BufferedReader : 40136KB		316ms
 * **/

public class BJ_2096_내려가기 {
	static int N;
//	static int[][] arr;

	static int[] min;
	static int[] max;

//	static int[] dr = {1, 1, 1};
//	static int[] dc = {-1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 3개씩 N줄
//		arr = new int[N][N]; 
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				arr[i][j] = in.nextInt();
//			}
//		}

		min = new int[3];
		max = new int[3];

		st = new StringTokenizer(br.readLine(), " ");
		// 첫째줄 입력받아서
		for (int i = 0; i < 3; i++) {
			max[i] = Integer.parseInt(st.nextToken());
			min[i] = max[i];
		}

		// 둘째줄부터 계산
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // left 
			int y = Integer.parseInt(st.nextToken()); // middle
			int z = Integer.parseInt(st.nextToken()); // right

			// 계산시 값이 변하므로 위의 값을 미리 백업
			// max
			int up_left_origin = max[0];
			int up_origin = max[1];

			// x를 기준으로 (-1,0), (-1, 1) 비교 
			max[0] = Math.max(max[0], max[1]) + x;

			// y를 기준으로 (-1,-1), (-1, 0), (-1, 1) 비교
			max[1] = Math.max(up_left_origin, Math.max(max[1], max[2])) + y; // max[0]이 위에서 변경되므로 temp1값 이용

			// z를 기준으로 (-1, 0), (-1, 1) 비교
			max[2] = Math.max(up_origin, max[2]) + z;

			// 계산시 값이 변하므로 위의 값을 미리 백업
			// min (min에 대한 백업도 이루어져야 한다!)
			up_left_origin = min[0];
			up_origin = min[1];

			// x를 기준으로 (-1,0), (-1, 1) 비교 
			min[0] = Math.min(min[0], min[1]) + x;

			// y를 기준으로 (-1,-1), (-1, 0), (-1, 1) 비교
			min[1] = Math.min(up_left_origin, Math.min(min[1], min[2])) + y;

			// z를 기준으로 (-1, 0), (-1, 1) 비교
			min[2] = Math.min(up_origin, min[2]) + z;

		}

		Arrays.sort(max);
		Arrays.sort(min);

		System.out.println(max[2] + " " + min[0]);

	}

}
