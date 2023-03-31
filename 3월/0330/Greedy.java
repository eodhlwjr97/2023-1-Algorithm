package day_0330;

import java.io.*;
import java.util.*;

// 조건1) 양쪽 팀 몸무게가 같도록 함
// 조건2) 최대한 많은 선수 출전
// 조건3) 선수 선발 방식이 여러가지인 경우(=최대한 많은 선수가 출전하는 방식이 여러개이면), 몸무게 합이 가장 큰 방법 선택
public class Greedy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt(); // 출전 가능한 선수
		int[] weight = new int[N]; // 선수들의 몸무게
		for (int i = 0; i < N; i++) {
			weight[i] = in.nextInt();
		}
		Arrays.sort(weight);
		// 20 35 40 45 60 100 (100,40) | (35,45,60)
		// 40 40 50 50 80 100 (40,40,50,50) | (80,100)
		// 40 50 90 90 (40,50) | (90)
		/** 배열 내림차순 정렬하는 법 **/
		
		int ans, sum = 0;
		int point = N-1;
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		listA.add(weight[point]);
		int x = 1;
		while(true) {
			listB.add(weight[point-x]);
			x--;			
		}
	}

}
