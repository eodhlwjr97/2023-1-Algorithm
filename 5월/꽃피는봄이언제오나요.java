// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;
import java.io.*;
class Pos {
			int r;
			int c;
			public Pos(int r, int c){
				this.r = r;
				this.c = c;
			}
		}
class Main {
    public int solution(int n, int[][] garden) {
    	  int answer = 0;
      
			  int[] dr = {1, -1, 0, 0};
				int[] dc = {0, 0, 1, -1};
				
				Queue<Pos> q = new LinkedList<>();
			
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						if(garden[i][j]==1){
							q.add(new Pos(i,j));
						}
					}
				}
				
				while(!q.isEmpty()) {
					Pos pos = q.poll();
					for(int d=0; d<4; d++){
						int nr = pos.r + dr[d];
						int nc = pos.c + dc[d];
						
						if(nr<0||nr>=n||nc<0||nc>=n) continue;
						if(garden[nr][nc]==0){
							q.add(new Pos(nr, nc));
						  garden[nr][nc] = garden[pos.r][pos.c] + 1;
						}
					}
				}
			
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						answer = Math.max(answer, garden[i][j]);
					}
				}
				answer--;
        return answer;
    }
