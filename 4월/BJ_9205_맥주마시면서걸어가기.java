package day_0422;

import java.io.*;
import java.util.*;

public class BJ_9205_맥주마시면서걸어가기 {
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int T, storeCnt;
	static ArrayList<Pos> store;
	static int start_r, start_c, store_r, store_c, end_r, end_c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			storeCnt = Integer.parseInt(br.readLine());
			store = new ArrayList<>();

			// 집 위치
			st = new StringTokenizer(br.readLine(), " ");
			start_r = Integer.parseInt(st.nextToken());
			start_c = Integer.parseInt(st.nextToken());

			// 편의점 위치
			for (int i = 0; i < storeCnt; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				store_r = Integer.parseInt(st.nextToken());
				store_c = Integer.parseInt(st.nextToken());
				store.add(new Pos(store_r, store_c));
			}

			// 페스티벌 위치
			st = new StringTokenizer(br.readLine(), " ");
			end_r = Integer.parseInt(st.nextToken());
			end_c = Integer.parseInt(st.nextToken());

			// BFS
			Queue<Pos> q = new LinkedList<>();
			boolean res = false;
			q.add(new Pos(start_r, start_c)); // 처음 위치를 넣고
			while (!q.isEmpty()) {
				Pos temp = q.poll();
				// 집-페스티벌까지 맨해튼 거리를 계산해서 1000 이하면 happy
				if (Math.abs(temp.r - end_r) + Math.abs(temp.c - end_c) <= 1000) {
					res = true;
					break;
				}
				// 집-페스티벌까지 맨해튼 거리를 계산해서 1000 초과면 편의점 들러야 한다
				for (int i = 0; i < store.size(); i++) {
					if (Math.abs(temp.r - store.get(i).r) + Math.abs(temp.c - store.get(i).c) <= 1000) {
						q.add(new Pos(store.get(i).r, store.get(i).c));
						store.remove(store.get(i));
					}
				}
			}
			if (!res) {
				System.out.println("sad");
			} else {
				System.out.println("happy");
			}
		} // tc for문 end

	}

}
