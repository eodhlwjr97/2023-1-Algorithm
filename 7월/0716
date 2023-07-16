package day_0715;

import java.io.*;
import java.util.*;

/**
 * scanner				373940KB	2384ms
 * bufferedReader		285044KB	936ms
 **/


// 1에서 n까지의 수가 한 번만 나타나는 수열이므로, 원래 수열의 두 숫자간의 차이와 다른 차이를 가지면 bad puzzle이라 생각해보자
public class BJ_15501_부당한퍼즐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean flag = true; // good/bad puzzle 판별 변수 : Default는 good puzzle

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 원래 수열의 두 숫자간의 차이를 담은 Set
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N - 1; i++) {
			set.add(Math.abs(arr[i] - arr[i + 1]));
		}
		set.add(Math.abs(arr[0] - arr[N - 1]));

		// 주어진 수열이 good|bad puzzle인지 판별
		int[] newArr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			newArr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N - 1; i++) {
			// 해당 차이를 가지고 있으면
			if (set.contains(Math.abs(newArr[i] - newArr[i + 1]))) {
				continue;
			} else {
				flag = false;
			}
		}

		if (flag) { // good puzzle
			System.out.println("good puzzle");
		} else {
			System.out.println("bad puzzle");
		}

	}

}
