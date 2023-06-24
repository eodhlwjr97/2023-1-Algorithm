package day_0624;

import java.io.*;
import java.util.*;

class Pos {
	int r;
	int c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class ObstacleCheck {
	int r;
	int c;

	public ObstacleCheck(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BJ_18428_감시피하기 {
	static int N;
	static char[][] corridor;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static ArrayList<Pos> rc = new ArrayList<>();
	static ArrayList<ObstacleCheck> obs_rc = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int obstacle = 3;
		int std_cnt = 0;

		corridor = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				corridor[i][j] = st.nextToken().charAt(0);

				// S를 기준으로 4방탐색 예정이므로, S의 좌표를 미리 알아놓는다
				if (corridor[i][j] == 'S') {
					rc.add(new Pos(i, j));
					std_cnt++;
				}
			}
		} // end input

		// S를 기준으로 4방탐색을 길게 했을 때 T가 존재하면 obstacle 놓기
		for (int i = 0; i < std_cnt; i++) {
			whole: for (int dir = 0; dir < 4; dir++) {// 4방 탐색
				for (int far = 1; far <= (N - 1); far++) { // 4방 탐색 방향으로 수평선 탐색

					int nr = rc.get(i).r + dr[dir] * far;
					int nc = rc.get(i).c + dc[dir] * far;

					// 범위가 넘어가면 continue
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					// 놓을 수 없는 위치라면 continue
					if (corridor[nr][nc] == 'O' || corridor[nr][nc] == 'S')
						continue whole;

					// 범위 내에서 T(선생님)을 만나면
					if (corridor[nr][nc] == 'T') {
						corridor[(rc.get(i).r + dr[dir])][(rc.get(i).c + dc[dir])] = 'O';
						obs_rc.add(new ObstacleCheck((rc.get(i).r + dr[dir]), (rc.get(i).c + dc[dir])));
//						System.out.println("O를 놓은 r: " + (rc.get(i).r + dr[dir]) + " O를 놓은 c: " + (rc.get(i).c + dc[dir]));
						obstacle--;
						continue whole;
					}
				}
			}
		}

		for (int i = 0; i < obs_rc.size(); i++) {
			int obs_cnt = 0;
			for (int d = 0; d < 4; d++) {
				if (obs_cnt >= 2) {
					corridor[(obs_rc.get(i).r)][(obs_rc.get(i).c)] = 'X';
					obstacle++;
					break;
				}
				int nr = obs_rc.get(i).r + dr[d];
				int nc = obs_rc.get(i).c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (corridor[nr][nc] == 'O')
					obs_cnt++;
			}
		}

		if (obstacle == 0) {
			System.out.println("YES");
		} else {
//			System.out.println(obstacle);
//
//			// debug
//			for (char[] arr : corridor) {
//				System.out.println(Arrays.toString(arr));
//			}

			System.out.println("NO");
		}

	}

}
