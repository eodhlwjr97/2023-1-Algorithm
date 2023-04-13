package day_0411;

import java.io.*;
import java.util.*;

public class BJ_14503_로봇청소기_내풀이 {
	static int R, C;
	static int[][] room;

	// 0북1동2남3서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		room = new int[R][C];

		st = new StringTokenizer(br.readLine(), " ");
		int inputR = Integer.parseInt(st.nextToken());
		int inputC = Integer.parseInt(st.nextToken());
		int inputD = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input 입력 완료

		go(inputR, inputC, inputD);

		System.out.println(cnt);

	}

	private static void go(int r, int c, int d) {
		// 1. 현재 위치가 청소가 되어있지 않다면 청소(-1)
		if (room[r][c] == 0) {
			room[r][c] = -1;
//			System.out.println("room[r][c] | 좌표 r: " + r + " " + "좌표 c: " + c);
			cnt++;
		}

		// 2. 현재 위치의 주변(4방탐색) 칸 탐색
		if (!surroundClean(r, c, d)) { // 주변에 청소 X인 칸 존재 O
//			for (int i = d; i <= 4; i++) {
//			System.out.println("i(=d): " + i);
			for (int i = 0; i < 4; i++) {
				int nd = (d + 3) % 4; // 반시계방향 회전
//				System.out.println("nd: " + nd);
				int nr = r + dr[nd];
				int nc = c + dc[nd];

				if (checkRange(nr, nc) && room[nr][nc] == 0) {
					go(nr, nc, nd);
					break;
				}
				d = nd; // 방향 돌린 거 재설정 반드시 다시 해줘야함 << 이거때문에 자꾸 오류났음
//				System.out.println("방향돌리기");
			}
		} else { // 주변에 청소 X인 칸 존재 X
//			if (checkRange(r, c)) {
			int nd = (d + 2) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			if (checkRange(nr, nc) && room[nr][nc] != 1) { // 벽이 아니면
				go(nr, nc, d); // 방향 유지 상태로 한 칸 후진
			} else { // 벽이면 멈춘다
				return;
			}
		}

	}

	private static boolean surroundClean(int r, int c, int d) {
		int dirty = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (checkRange(nr, nc) && room[nr][nc] == 0) {
				dirty++;
				break; // 하나라도 더러운 곳이 존재함을 발견했으니 4방탐색을 하지 않아도 됨
			}
		}

		if (dirty >= 1) // 주변에 더러운 곳이 하나라도 있으면
			return false; // 주변이 클린(surrondClean) 하지않다(false)
		return true;
	}

	private static boolean checkRange(int r, int c) {
		return 0 < r && r < R - 1 && 0 < c && c < C - 1; // 벽 제외
//		return 0 < r && r < R && 0 <= c && c < C; 
	}

}
