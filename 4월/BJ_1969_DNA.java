package day_0413;

import java.io.*;
import java.util.*;

public class BJ_1969_DNA_다시풀기 {
	static int N, len;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		len = Integer.parseInt(st.nextToken());

		String[] nucleotide = new String[N];
		for (int i = 0; i < N; i++) {
			nucleotide[i] = br.readLine();
		} // input 완료

		/** Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수이다 **/
		int cntA, cntC, cntG, cntT;
//		cntA = cntC = cntG = cntT = 0;

		String res = "";
		cnt = 0;

		for (int j = 0; j < len; j++) {
			cntA = cntC = cntG = cntT = 0; // 열 초기화
			for (int k = 0; k < N; k++) {
				char c = nucleotide[k].charAt(j);
				switch (c) {
				case 'A':
					cntA++;
					break;
				case 'C':
					cntC++;
					break;
				case 'G':
					cntG++;
					break;
				case 'T':
					cntT++;
					break;
				} // end switch
			}
			res += selectChar(cntA, cntC, cntG, cntT);
		} // 각 위치의 문자 비교하기

		sb.append(res + "\n" + cnt);
		System.out.println(sb);
	}

	private static String selectChar(int cntA, int cntC, int cntG, int cntT) {
//		System.out.println("cntA: " + cntA + " cntC: " + cntC + " cntG: " + cntG + " cntT: " + cntT);

		// 문자 선정하기 (순서대로 hm에 넣기)
		HashMap<Character, Integer> hm = new HashMap<>();
		int max = Integer.MIN_VALUE; // 공통된 문자가 가장 많이 나온 것이 그 자리의 문자가 될 것임

		hm.put('A', cntA);
		hm.put('C', cntC);
		hm.put('G', cntG);
		hm.put('T', cntT);

		max = Math.max(Math.max(cntA, cntC), Math.max(cntG, cntT));

		String returnS = "";

		// 틀린 이유를 발견하기 위해 keySet을 찍어보니 A,C,T,G 순으로 출력된다
//		for (char c : hm.keySet()) {
//			System.out.print(c + " ");
//		}

//		for (char c : hm.keySet()) {
//			if (hm.get(c).equals(max)) {
//				returnS = String.valueOf(c);
//				break;
//			}
//		}

//		// A, C, G, T 순으로 정렬 : Object[] 이용해서 keySet 정렬 : 100ms
//		Object[] mapKey = hm.keySet().toArray();
//		Arrays.sort(mapKey);
//
//		for (Object obj : mapKey) {
//			String s = String.valueOf(obj);
//			if (hm.get(s.charAt(0)).equals(max)) {
//				returnS = String.valueOf(s.charAt(0));
//				break;
//			}
//
//		}

		// List 이용해서 keySet 정렬 : 96ms
		List<Character> keySet = new ArrayList<>(hm.keySet());
		Collections.sort(keySet);
		for (char c : keySet) {
			if (hm.get(c).equals(max)) {
				returnS = String.valueOf(c);
				break;
			}
		}

		// Hamming Distance 구하기
		cnt += (N - max);

		return returnS;
	}
}
