package day_0403;

import java.io.*;
import java.util.*;

// 틀린이유 : 	Double.MAX_VALUE * (-1) != Double.MIN_VALUE
// 고층 빌딩 A에서 다른 고층 빌딩 B가 볼 수 있는 빌딩이 되려면, 두 지붕을 잇는 선분이 A와 B를 제외한 1) 다른 고층 빌딩을 지나거나 2) 다른 고층 빌딩과 접하지 않아야 한다.
public class BJ_1027_고층건물 {
	static int N;
	static int[] building;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 빌딩 수
		building = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0; // 가장 많은 고층 빌딩이 보이는 빌딩에서 보이는 빌딩의 수
		for (int i = 1; i <= N; i++) {
//			System.out.println("i번째 빌딩: " + i);
			int left = countL(i);
			int right = countR(i);
//			System.out.println("left: "+left);
//			System.out.println("right: "+right);

			ans = Math.max(ans, left + right);
		}

		System.out.println(ans);
	}

	// 오른쪽의 경우 기준 빌딩과 가까울수록 |기울기|가 커야한다 (X) : 음수에서 양수로 기울기가 변하는 경우가 있을 수 있다
	// 기울기(-)가 작아야한다
	private static int countR(int pickBuilding) {
		int cntR = 0; // 볼 수 있는 건물의 수
		double maxInclination = (-1) * Double.MAX_VALUE; // (-) 기울기이기 때문
		for (int i = pickBuilding + 1; i <= N; i++) {
			double inclination = (double) (building[pickBuilding] - building[i]) / (pickBuilding - i);
//			System.out.println("countR의 inclination: " + inclination);
			if(maxInclination < inclination) {
				cntR++;
				maxInclination = inclination; // 더 오른쪽 빌딩과 비교하기 위해 기울기 갱신
			}
		}
//		double maxInclination = Double.MAX_VALUE;
//		for (int i = pickBuilding + 1; i <= N; i++) {
//			double inclination = Math.abs((double) (building[pickBuilding] - building[i]) / (pickBuilding - i));
//			System.out.println("countR의 inclination: " + inclination);
//			if (maxInclination > inclination) {
//				System.out.println("maxInclination: "+maxInclination);
//				cntR++;
//				maxInclination = inclination; // 더 오른쪽 빌딩과 비교하기 위해 기울기 갱신
//			}
//		}
		return cntR;
	}

	// 왼쪽의 경우 기준 빌딩과 가까울수록 기울기가 커야한다.
	private static int countL(int pickBuilding) {
		int cntL = 0; // 볼 수 있는 건물의 수
		double maxInclination = Double.MAX_VALUE;
		for (int i = pickBuilding - 1; i >= 1; i--) {
			double inclination = (double) (building[pickBuilding] - building[i]) / (pickBuilding - i);
//			System.out.println("building[pickBuilding]: "+building[pickBuilding]);
//			System.out.println("building[i]: "+building[i]);
//			System.out.println("(building[pickBuilding] - building[i]): "+(building[pickBuilding] - building[i]));
//			System.out.println("(pickBuilding - i): "+(pickBuilding - i));
//			System.out.println("countL의 inclination: " + inclination);
//			System.out.println(1 / 3); // 0이 출력된다 
			/**
			 * 수를 나눠 실수가 나오게 하는 법
			 * 1) 초기 속성타입을 double로 지정
			 * 2) 정수일 경우, 1.0을 곱해줘 double 형 데이터로 변경해준 뒤 계산
			 * 3) 정수형 데이터 중 하나를 double 형 데이터로 바꾸어 준 뒤 계산
			 * */

			if (maxInclination > inclination) {
				cntL++;
				maxInclination = inclination; // 더 오른쪽 빌딩과 비교하기 위해 기울기 갱신
			}
		}
		return cntL;
	}

}
