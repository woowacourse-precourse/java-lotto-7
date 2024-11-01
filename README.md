# java-lotto-precourse

## 구현 기능 목록
> * 로또 구매 금액 입력
>   - "구입금액을 입력해 주세요." 출력
>   - camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력
>   - 1000원 단위로 입력 받아 나누어 떨어지지 않으면 예외 발생
>   - 숫자가 아닌 다른 값 입력 시 예외 발생

> * 로또 발행
>   - "8개를 구매했습니다." 형식으로 로또 수량 출력
>       - = "%d개를 구매했습니다." 
>   - "[8, 21, 23, 41, 42, 43]" 형식으로 6개의 로또 번호를 오름차순으로 정렬하여 출력
>       - = "[%d, %d, %d, %d, %d, %d]" 
>   - 로또 번호를 구매한 개수만큼 출력

> * 로또 추첨
>   - 당첨 번호 6개를 입력
>   - 로또 번호의 숫자 범위는 1~45까지
>   - 6개를 쉼표 기준으로 구분하며 ',' 형식이 아니라면 예외 발생
>   - 보너스 번호를 입력
>   - 숫자가 아닌 다른 값 입력 시 예외 발생
>   - 중복된 숫자 입력 시 예외 발생

> * 당첨 내역 확인
>   - 1~5등까지의 당첨 내역을 아래 형식에 맞게 출력
>   > 3개 일치 (5,000원) - 1개  
>   > 4개 일치 (50,000원) - 0개  
>   > 5개 일치 (1,500,000원) - 0개  
>   > 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개  
>   > 6개 일치 (2,000,000,000원) - 0개
>   - "총 수익률은 62.5%입니다." 형식으로 수익률 출력
>       - = "총 수익률은 %.1f%%입니다."

> * 예외 처리
>   - 잘못된 값 입력 시 IllegalArgumentException 발생
>   - "[ERROR]"로 시작하는 에러 메시지 출력 후 그 부분부터 다시 입력