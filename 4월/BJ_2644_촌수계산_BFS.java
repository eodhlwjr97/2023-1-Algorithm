package day_0417;

import java.io.*;
import java.util.*;

//그래프 탐색 문제
public class BJ_2644_촌수계산_BFS {
	static List<Integer>[] relation;
	static boolean[] visited;
	static int[] distance;
	static int res = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		relation = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<Integer>();
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relation[p].add(c);
			relation[c].add(p);
		}

		distance = new int[N + 1];
		for (int i = 1; i < N; i++) {
			distance[i] = -1;
		}
		bfs(x, y); // x로부터 y까지 값을 너비우선탐색

		System.out.println(distance[y]);
	}

	private static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start);
		visited[start] = true;
		distance[start] = 0;

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < relation[temp].size(); i++) {
				int next = relation[temp].get(i);
				if (visited[next])
					continue;

				// 방문한 적 없다면 queue에 넣어주기
				q.add(next);
				visited[next] = true;
				distance[next] = distance[temp] + 1;
			}
		}
	}

}
