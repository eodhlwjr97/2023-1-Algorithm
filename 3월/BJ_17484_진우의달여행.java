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
			go(0, start, fuel, -1); // 처음 시작할때는 이전 방향이 없으므로 -1으로 설정한다
		}
		System.out.println(answer);
	}

	private static void go(int r, int c, int fuel, int dir) {
		// 기저조건
		if (r == R - 1) { // 끝까지 왔을 때
			if (fuel < answer) {
				answer = fuel;
				return;
			}
		}

		// 유도파트
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 우주선은 전에 움직인 방향으로 움직일 수 없으므로
			if ((dir != i) && check(nr, nc)) {
				go(nr, nc, fuel + space[nr][nc], i);
			}
		}
	}

	private static boolean check(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

}
