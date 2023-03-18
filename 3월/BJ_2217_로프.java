package day_0318;

import java.io.*;
import java.util.*;

public class BJ_2217_로프 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // 줄의 개수
		int[] rope = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			rope[i] = in.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(rope);

		// 로프 사용하기
		int w = N;
		for (int i = 1; i <= N; i++) {
			rope[i] = rope[i] * w;

			// for 문에 걸려있는 N도 줄어버리게 된다
			// N--;
			w--;
		}
		// 최대중량을 알기위해 오름차순 정렬
		Arrays.sort(rope);

		System.out.println(rope[N]);
	}

}
