package day_0421;

import java.io.*;
import java.util.*;

public class BJ_5014_스타트링크 {
	static int floors, pos, target, up, down;
	static int visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		floors = Integer.parseInt(st.nextToken()); // 몇 층 건물
		pos = Integer.parseInt(st.nextToken()); // 현재 층
		target = Integer.parseInt(st.nextToken()); // 가려는 층
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		visited = new int[floors + 1];

		bfs(floors, pos, target, up, down);

	}

	private static void bfs(int floors, int pos, int target, int up, int down) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(pos);
		visited[pos] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll(); // 현재 층

			if (temp == target) { // 현재 층 = 가려는 층
				System.out.println(visited[temp] - 1);
			}

			if (temp - down > 0 && visited[temp - down] == 0) {
				visited[temp - down] = visited[temp] + 1;
				q.add(temp - down);
			}

			if (temp + up <= floors && visited[temp + up] == 0) {
				visited[temp + up] = visited[temp] + 1;
				q.add(temp + up);
			}

		}

		if (visited[target] == 0)
			System.out.println("use the stairs");

	}
}
