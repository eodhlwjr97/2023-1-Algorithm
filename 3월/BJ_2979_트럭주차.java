package day_0324;

import java.io.*;
import java.util.*;

public class BJ_2979_트럭주차 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int top = in.nextInt(); // 1대 주차요금
		int middle = in.nextInt(); // 2대 주차요금
		int bottom = in.nextInt(); // 3대 주차요금

		// 수직선을 배열로 생각 EX) [1] = 1 ~ 2, [2] = 2 ~ 3
		int[] time = new int[100];
		int max = 0;
  int min = 0;
		for (int i = 0; i < 3; i++) { // 3대의 트럭이 들어옴
			int start = in.nextInt(); // 입차시간
			int finish = in.nextInt(); // 출차시간
			int term = finish - start;
			for (int t = 0; t < term; t++) {
				time[start + t]++;
			}
   // 후에 배열 계산시 가지치기로 이용
   min = Math.min(start, min);
			max = Math.max(finish, max); 
		}
		// System.out.println(Arrays.toString(time));

		int cost = 0; // 최종 주차요금
		// 배열의 값이 1, 2, 3인 경우를 차로 생각해서 계산
		for (int i = min; i < max; i++) {
			// System.out.println("time[i]: " + time[i]);
			if (time[i] == 0)
				continue;
			if (time[i] == 1) {
				cost += time[i] * top;
			} else if (time[i] == 2) {
				cost += time[i] * middle;
			} else {
				cost += time[i] * bottom;
			}
		}

		System.out.println(cost);

	}

}
