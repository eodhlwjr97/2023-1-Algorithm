package day_0329; 

import java.io.*;
import java.util.*;

public class BJ_1969_DNA {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); //

		// 염기 배열
		int[] A = new int[M + 1];
		int[] G = new int[M + 1];
		int[] C = new int[M + 1];
		int[] T = new int[M + 1];

		int ans = 0;
		String dna = "";
		for (int i = 0; i < N; i++) {
			// 입력값을 읽어와서
			String sequence = br.readLine();

			for (int j = 1; j <= M; j++) {
				// 염기 하나씩 비교
				String s = String.valueOf(sequence.charAt(j - 1));
				switch (s) {
				case "A":
					A[j]++;
					break;
				case "G":
					G[j]++;
					break;
				case "C":
					C[j]++;
					break;
				case "T":
					T[j]++;
					break;
				}
			}
			// 각 염기별 최대 빈출염기를 구하기
			ans += N - (Math.max(Math.max(A[i + 1], G[i + 1]), Math.max(C[i + 1], T[i + 1])));

			String pick1 = (A[i] >= G[i]) ? "A" : "G";
			String pick2 = (C[i] >= T[i]) ? "C" : "T";
			if (pick1.equals("A")) {
				if (pick2.equals("C")) {
					String base = (A[i] >= C[i]) ? "A" : "C";
					System.out.println("1번");
					dna += base;
				} else { // pick2.equals("T")
					String base = (A[i] >= T[i]) ? "A" : "T";
					System.out.println("2번");
					dna += base;
				}
			} else { // pick1.equals("G")
				if (pick2.equals("C")) {
					String base = (C[i] >= G[i]) ? "C" : "G"; // 알파벳순서
					System.out.println("3번");
					dna += base;
				} else { // pick2.equals("T")
					String base = (G[i] >= T[i]) ? "G" : "T";
					System.out.println("4번");
					dna += base;
				}
			}
		}

		System.out.println(dna);
		System.out.println(ans);
	}

}
