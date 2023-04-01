// 시간초과 → 백준 통과 X
package day_0401;

import java.io.*;
import java.util.*;

public class BJ_3020_개똥벌레 {
	static int R, C;
	static int[][] cave;

	// 석순, 종유석 방향
	static int[] dr = { -1, 1 };
	static int[] dc = { 0, 0 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		C = in.nextInt();
		R = in.nextInt();
		cave = new int[R][C];

		// 석순, 종유석 개수만큼 반복문을 돌건데
		for (int i = 0; i < C; i++) {
			int length = in.nextInt();
			if (i % 2 == 0) { // 석순 (아래서 위로 자란다)
				bottomGrow(i, length);
			} else { // 종유석 (위에서 아래로 자란다)
				ceilGrow(i, length);
			}
		}

		// 라인별 1 개수 카운트 후 최솟값을 ans에 저장
		int ans = Integer.MAX_VALUE;
		int[] sumSave = new int[R];
		int k = 0; // sumSave 배열 인덱싱
		for (int[] line : cave) {
			int sum = 0;
			for (int one : line) {
				sum += one;
			}
			ans = Math.min(ans, sum);

			sumSave[k] = sum;
			k++;
		}
//		System.out.println(Arrays.toString(sumSave));

		// ans와 같은 구간 수 출력
		int section = 0; // 구간 수
		for (int res : sumSave) {
			if (res == ans) {
				section++;
			}
		}
		System.out.println(ans + " " + section);
	}

	private static void ceilGrow(int c, int length) {
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			if (cnt == length)
				return;

			cave[i][c] = 1;
			cnt++;
		}
	}

	private static void bottomGrow(int c, int length) {
		int cnt = 0;
		for (int i = R - 1; i > 0; i--) {
			if (cnt == length)
				return;

			cave[i][c] = 1;
			cnt++;
		}
	}

}
