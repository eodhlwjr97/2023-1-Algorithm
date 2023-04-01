package day_0401;

import java.io.*;
import java.util.*;

public class BJ_11047_동전0 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // N개의 동전 종류
		int K = in.nextInt(); // 합 K

		ArrayList<Integer> numList = new ArrayList<>();
		// 합 K보다 동전가치가 크다면 굳이 입력받을 필요가 없음
		for (int i = 0; i < N; i++) {
			int n = in.nextInt();
			if (n <= K) {
				numList.add(n);
				continue;
			}
			break;
		}
//		System.out.println(numList.toString());

		int cnt = 0; // 필요한 동전 개수의 최솟값
		// 조건에 가지고 있는 동전의 가치로 합 K를 못만든다는 말이 없으므로 가치 큰 동전부터 쓰기
		while (true) {
			// 가장 큰 가치의 동전으로 한 번에 나누어 떨어지면 그 몫이 최솟값
			if (K % numList.get(numList.size() - 1) == 0) {
				cnt += K / numList.get(numList.size() - 1);
				break;
			} else { // 한 번에 나누어 떨어지지 않는다면
				// 틀렸던 이유 : cnt 먼저 체크 후 K 나머지를 구해야한다
				cnt += K / numList.get(numList.size() - 1);
				K = K % numList.get(numList.size() - 1);

				numList.remove(numList.size() - 1);
			}
		}

		System.out.println(cnt);
	}

}
