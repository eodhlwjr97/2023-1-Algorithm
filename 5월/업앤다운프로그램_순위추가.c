#include <stdio.h>
#include <string.h>

int main(void){
	printf("[업앤다운 프로그램입니다]\n\n");
	
	int ans = 63;
	int guess;
	int cnt;     
		
	int people;
	printf("참여할 사람은 몇명인가요? ");
	scanf("%d", &people);
	
	char nickname[people];
	
	int score[people]; // 입장 순 cnt 저장 배열   
	int score_copy[people]; // 오름차순 정렬 순 cnt 저장 배열   
	
	int i;
	for(i=0; i<people; i++) {
		printf("\n");
		printf("<닉네임을 입력하세요> : ");
		getchar(); // 개행 문자 소비
		scanf("%c", &nickname[i]); 
		
		cnt = 0; // 유저별 게임횟수 초기화 
	while(1) {
		printf("숫자를 입력하세요: ");
		scanf("%d", &guess);
		
		if(0<=guess && guess<=100) {
			cnt++;
			if(guess<ans){
				printf("UP \n");
			} 
			if(guess>ans){
				printf("DOWN \n");
			}
			if(guess==ans){
				printf("정답입니다! \n");
				printf("시도횟수는 %d번 입니다. \n", cnt);
				
				score[i] = cnt;
				break; // 해당 닉네임 사용자의 game 종료  
			}
		}
		
		if(0>=guess || guess >= 100) {
			printf("유효범위의 숫자가 아닙니다. \n");
			}
		
		} // end while 
	} // end for
	
	memcpy(score_copy, score, sizeof(score)); // 배열 복사
	int j, k, temp;
	for(j=0; j<people; j++){ // 오름차순 정렬  
		for(k=j+1; k<people; k++){
			if(score_copy[j]>score_copy[k]) {
				temp = score_copy[j];
				score_copy[j] = score_copy[k];
				score_copy[k] = temp;
			}
		}
	}
	
	printf("\n업앤다운 게임 최종 순위입니다.\n");
	int rank = 0;
	int idx;
	while(1){
		if(rank==people){
			break;
		}
		
		for(int idx=0; idx<people; idx++){
			if(score_copy[rank] == score[idx]){
				printf("%c ", nickname[idx]);
				rank++;
				break;
			}		
		}
	}
	
	return 0;
} // end main
