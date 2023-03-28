package day_0328;

import java.io.*;
import java.util.*;

public class BJ_17484_진우의달여행 {
	static int R, C;
	static int[][] space;
	static int[] dr = { 1, 1, 1 };
	static int[] dc = { -1, 0, 1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		space = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int start = 0; start < C; start++) {
			int fuel = 0;
			fuel = fuel + space[0][start];
			go(0, start, fuel, 3);
		}
		System.out.println(answer);
	}

	private static void go(int r, int c, int fuel, int dir) {
		// 기저조건
		if (r == R - 1) { // 끝까지 왔을 떄
			if (fuel < answer) {
				
			}
		}
	}

}
