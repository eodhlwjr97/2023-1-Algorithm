package day_0316;

import java.io.*;
import java.util.*;

public class BJ_1343_폴리오미노 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String res = "";
		input = input.replaceAll("XXXX", "AAAA");
		res = input.replaceAll("XX", "BB");

		if (res.contains("X")) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}

}
