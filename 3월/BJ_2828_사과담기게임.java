/** '가장 처음에 바구니는 왼쪽 M칸을 차지하고 있다' = 바구니가 낱개가 아닌 일괄로 큰 바구니를 생각해야 함 **/

import java.io.*;
import java.util.*;

public class BJ_2828_사과담기게임 {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // 칸
		int M = in.nextInt(); // 바구니 수, 바구니 최초 위치(가장 왼쪽 기준)
		int J = in.nextInt(); // 떨어지는 사과 수

		int left = 1; // 바구니 왼쪽 좌표
		int right = M; // 바구니 오른쪽 좌표
		int move = 0; // 이동거리

		// J개의 사과가 떨어지는데
		for (int i = 0; i < J; i++) {
			// 떨어진 사과의 위치
			int pos = in.nextInt();

			// 바구니 안에 떨어지는 경우
			if (left <= pos && pos <= right) {
				continue; // 이동거리 없음
			}

			// 바구니 왼쪽에 가깝게 떨어지는 경우
			if (left > pos) {
				move += (left - pos);
				// 옮긴 바구니 위치
				right -= (left - pos); // left 위치 변경 전에 간격을 먼저 구해야 한다! 이것 때문에 답답해서 돌아가실뻔
				left = pos;
			}
			// 바구니 오른쪽에 가깝게 떨어지는 경우
			else {
				move += (pos - right);
				// 옮긴 바구니 위치
				left += (pos - right);
				right = pos;
			}
		}

		System.out.println(move);
	}

}
