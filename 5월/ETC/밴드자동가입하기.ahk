F1::
;밴드 A 입장하기
click, 1387, 61
sleep, 1000
sendinput, https://band.us/band/91187106{enter}
sleep, 1000

;밴드 가입하기 이미지를 찾기
imagesearch, x,y,0,0,1920,1200, 밴드가입하기.PNG
;이미지가 있으면 가입하기
if(errorlevel=0) { 
	click, %x%, %y%
	sleep, 1000

	;팝업창 밴드가입하기
	imagesearch, x,y,0,0,1920,1200, 밴드가입하기.PNG
	if(errorlevel=0) {
		click, %x%, %y%
		sleep, 1000
		send, {enter}
		sleep, 2000
	} else {
		msgbox, 팝업창 밴드가입하기 이미지를 못찾았습니다.
	}
	
	;가입 글 쓰기
	imagesearch, x,y,0,0,1920,1200, 글쓰기A.PNG
	if(errorlevel=0) {
		click, %x%, %y%
		sleep, 1000
		send, 안녕하세요
		sleep, 1000

		;게시하기
		imagesearch, x,y,0,0,1920,1200, 게시.PNG
		if(errorlevel=0) {
			click, %x%, %y%
		} else {
			msgbox, 게시하기 이미지를 찾을 수 없습니다.
		}
		
	} else {
		msgbox, 가입글 쓰기를 찾을 수 없습니다.
	}
}
;이미지가 없으면 alert창 출력
if(errorlevel=1) {
msgbox, 가입할 수 있습니다
}
RETURN
