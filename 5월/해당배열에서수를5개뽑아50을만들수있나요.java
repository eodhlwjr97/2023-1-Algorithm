package day_0514;

import java.io.*;
import java.util.*;

/** 클래스 자리 **/

// 문제 : 배열에서 5개의 숫자를 이용하여 50을 만들 수 있는가?
public class 나무판자이어붙여50만들기 {
	static int[] input, numbers;
	static int N, R;

	public boolean solution(int[] numArr) {
		boolean answer = false;

		/** 5개를 선택하기 위해 조합을 구현한다 **/
		N = numArr.length; // N개의 수 중에서
		R = 5; // 5개의 숫자를 뽑을건데
		input = numArr;
		int[] numbers = new int[5]; // 5개의 숫자를 담을 배열을 선언

		answer = combination(0, 0);
		// 5개의 조합으로 구성된 각 숫자들의 합이 50인지 확인한다
		return answer;
	}

	/**
	 * 조합구하기
	 * 
	 * @param cnt   : R개를 뽑아야 하니까, 이를 카운팅 해주는 변수
	 * @param start : 중복방지
	 */
	public boolean combination(int cnt, int start) {
		// 기저파트
		if (cnt == R) {
			int sum = 0;
			for (int n : numbers) {
				sum += n;
			}

			if (sum == 50)
				return true;
			else
				return false;
		}

		// 유도파트
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
		return false;
	}

	public static void main(String[] args) {
		나무판자이어붙여50만들기 sol = new 나무판자이어붙여50만들기();

		int[] arr = { 1, 3, 5, 11, 19, 13, 2, 7, 10 };
		boolean flag = sol.solution(arr);

		System.out.println("solution의 결과는" + flag + "입니다.");

	}

}
