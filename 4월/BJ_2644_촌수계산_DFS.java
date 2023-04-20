package day_0417;

import java.io.*;
import java.util.*;

// 그래프 탐색 문제
public class BJ_2644_촌수계산_DFS {
	static List<Integer>[] relation; // 배열 안에 리스트
	static boolean[] checked;
	static int res = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		// Type safety: The expression of type ArrayList[] needs unchecked conversion to conform to List<Integer>[]
		relation = new ArrayList[N + 1];
		checked = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<Integer>();
		}

		st = new StringTokenizer(br.readLine());

		// 촌수 계산 관계
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// 관계 수
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relation[p].add(c);
			relation[c].add(p);
		}

		dfs(x, y, 0);
		System.out.println(res);
	}

	private static void dfs(int start, int end, int cnt) {
		// 기저조건
		if (start == end) {
			res = cnt;
			return;
		}

		// 유도파트
		checked[start] = true;
		for (int i = 0; i < relation[start].size(); i++) {
			int next = relation[start].get(i);
			if (!checked[next]) {
				dfs(next, end, cnt + 1);
			}
		}

	}
}
