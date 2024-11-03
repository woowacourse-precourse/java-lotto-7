# java-lotto-precourse

# 구현할 기능 정보

- 구매금액 입력받기
- 로또 번호 자동 생성기 구현
- 구매 금액만큼 로또 자동 생성
- 당첨/보너스 번호 입력받기
- 입력받은 장 수 만큼 1~45난수 6개 뽑기
- 뽑은 번호 출력
- 당첨조회 구현
- 당첨여부 출력
- 수익률 출력

- 예외처리
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고 "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
  - 에러 메세지 출력 후 종료하지 않고 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

- 리팩토링

- 순서 다이어그램(활동막대 생략)
![img.png](img.png)
