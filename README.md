# java-lotto-precourse

# 기능 요구 사항
- [x] 사용자로부터 투입할 금액 입력받기
- [x] 사용자로부터 당첨 번호 입력받기
- [ ] 중복 없이 번호 6개와 보너스 번호 1개를 추첨하기
- [ ] 발행한 로또와 당첨 번호를 비교하기
- [ ] 잘못된 값이 입력된 경우 IllegalArgumentException을 발생시키고 에러 메시지 출력 후 다시 입력받기

# 입력
로또 구입 금액  
당첨 번호
보너스 번호

# 출력
발행한 로또 수량 및 번호 (번호는 오름차순)

# 실행 결과 예시
구입금액을 입력해 주세요.  
8000  

8개를 구매했습니다.  
[8, 21, 23, 41, 42, 43]  
[3, 5, 11, 16, 32, 38]  
[7, 11, 16, 35, 36, 44]  
[1, 8, 11, 31, 41, 42]  
[13, 14, 16, 38, 42, 45]  
[7, 11, 30, 40, 42, 43]  
[2, 13, 22, 32, 38, 45]  
[1, 3, 5, 14, 22, 45]  

당첨 번호를 입력해 주세요.  
1,2,3,4,5,6  

보너스 번호를 입력해 주세요.  
7  

당첨 통계  
\-\-\-  
3개 일치 (5,000원) - 1개  
4개 일치 (50,000원) - 0개  
5개 일치 (1,500,000원) - 0개  
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개  
6개 일치 (2,000,000,000원) - 0개  
총 수익률은 62.5%입니다.