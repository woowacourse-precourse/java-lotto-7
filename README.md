# java-lotto-precourse

## 기능 목록

1. 로또 구입 금액 입력
- [x] 1,000원 단위로 입력받기
- [x] 입력 예외 처리  
  - [x] 1,000원 단위로 나누어 떨어지지 않는 경우 예외처리
  - [x] 공백 입력 시 예외처리
  - [x] 문자 포함 입력 시 예외처리  
- [x] 예외 발생 시 [ERROR] 메시지를 출력

2. 당첨 번호와 보너스 번호 입력
- [x] 쉼표를 기준으로 분리하여 6개의 당첨 번호를 입력받기
- [x] 각 번호가 1~45 사이의 숫자인지 검증하는 로직
- [x] 입력 예외처리
  - [x] 입력한 로또 번호의 개수가 6개를 넘어간 경우
  - [x] 중복된 숫자가 있는 경우
  - [x] 1~45 사이의 번호가 아닌 경우

3. 보너스 번호 입력받기
- [x] 입력 예외처리
  - [x] 공백 입력 시 예외처리
  - [x] 문자 포함 입력 시 예외처리  
  - [x] 1~45 사이의 번호가 아닌 경우

4. 로또 발행
- [x] 구입 금액에 따른 로또 수량 구하기
- [x] 1~45 사이 중복되지 않은 로또 번호 6개 랜덤 생성

5. 당첨 확인 로직
- [x] 입력받은 로또 번호를 당첨 번호와 비교하여 일치하는 수 개수 카운팅
- [x] 일치하는 번호 수가 5개 이상이면서 보너스 번호 일치할 경우, 순위 조정

6. 당첨 통계 출력
- [x] 발행한 로또 수량에 따른 당첨 번호 출력
- [x] 당첨 금액별 맞춘 당첨 번호 개수 출력
- [x] 수익률 구하여 출력(소수점 둘째 자리에서 반올림)

