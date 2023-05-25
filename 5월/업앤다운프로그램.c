#include <stdio.h>

int main(void) {
	printf("[업앤다운 프로그램입니다]\n");
	int ans = 63;
	
	int cnt = 0; // 시도 횟수

	while(1) {
     	int num ;
		printf("숫자를 입력하세요: ");
		scanf("%d", &num);
		if(0<=num && num<=100) {
			cnt++;
			if(num<ans){
				printf("UP \n");
			} 
			if(num>ans){
				printf("DOWN \n");
			}
			if(num==ans){
				printf("정답입니다! \n");
				printf("시도횟수는 %d번 입니다. \n", cnt);
			}
		}
		
		if(0>=num || num >= 100) {
			printf("유효범위의 숫자가 아닙니다. \n");
		}
		
	}
	return 0;
}
