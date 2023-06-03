package day_0603;

import java.io.*;
import java.util.*;

public class BJ_2096_내려가기 {
	static int N;
	static int[][] arr;
	static int[] min;
	static int[] max;

//	static int[] dr = {1, 1, 1};
//	static int[] dc = {-1, 0, 1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		N = in.nextInt(); // 3개씩 N줄
//		arr = new int[N][N];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				arr[i][j] = in.nextInt();
//			}
//		}
		min = new int[3];
		max = new int[3];

		// 첫째줄 입력받아서
		for (int i = 0; i < 3; i++) {
			max[i] = in.nextInt();
			min[i] = max[i];
		}

		// 둘째줄부터 계산
		for (int i = 1; i < N; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();

			// 계산시 값이 변하므로 위의 값을 미리 백업
			int origin1 = max[0];
			int origin2 = max[1];
			

			// (-1,0), (-1, 1) 비교
			max[0] = Math.max(max[0], max[1]) + x;
//			min[0] = Math.min(min[0], min[1]) + x;

			// (-1,-1), (-1, 0), (-1, 1) 비교
			max[1] = Math.max(origin1, Math.max(max[1], max[2])) + y; // max[0]이 위에서 변경되므로 temp1값 이용
//			min[1] = Math.min(origin1, Math.min(min[1], min[2])) + y;

			// (-1, 0), (-1, 1) 비교
			max[2] = Math.max(origin2, max[2]) + z;
//			min[2] = Math.min(origin2, min[2]) + z;
			
			origin1 = min[0];
			origin2 = min[1];
			origin3 = min[2];
			
			min[0] = Math.min(min[0], min[1]) + x;
			min[1] = Math.min(origin1, Math.min(min[1], min[2])) + y;
			min[2] = Math.min(origin2, min[2]) + z;

//			System.out.println("\n" + Arrays.toString(min));
		}

		Arrays.sort(max);
		Arrays.sort(min);

		System.out.println(max[2] + " " + min[0]);

	}

}
