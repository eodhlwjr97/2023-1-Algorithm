package day_0315;

import java.io.*;
import java.util.*;

// 2, 5원으로만 거스름돈을 남겨줄 때, 최소 동전 개수
public class BJ_14916_거스름돈 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // 거스름돈 액수

		// 거스름돈이 5원으로 나누어 떨어지면 최소동전개수 완성
		if (n % 5 == 0) {
			System.out.println(n / 5);
		} else { // 5원으로 안나누어 떨어진다면 -2원씩
			int cnt = 0; // 최소동전개수
			boolean check = false; // 2, 5원으로 나눠지지 않는 경우를 체크

			while (n > 0) {
				n -= 2;
				cnt++;
				if (n % 5 == 0) {
					cnt += n / 5;
					check = true;
					break;
				}

				// 2, 5원으로 나누어 떨어지지 않음
				if (n < 0)
					check = false;
			}
			if (!check) {
				System.out.println(-1);
			} else {
				System.out.println(cnt);
			}
		}

	}

}


// 처음에 n-=5로 접근해서 생각 고치느라 1시간 소요
