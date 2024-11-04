# 로또 발매기 구현

1. 로또 구입 금액을 입력 받는다.
    * 1,000원 단위로 입력 받는다.
      * 1,000원으로 나누어 떨어지짖 않는 경우 예외 처리.
      * IllegalArgumentException을 발생시키고, 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
   

 
2. 당첨 번호를 입력 받는다.
   * 번호는 쉽표(,)를 기준으로 구분한다.
   * 번호는 1~45 숫자 범위이다.
     * 잘못된 값을 입력할 경우 에러 메시지 출력 후 다시 입력.



3. 보너스 번호를 입력 받는다.
    * 당첨 번호와 중복되지 않는 보너스 번호 1개를 뽑는다.
      * 잘못된 값을 입력할 경우 에러 메시지 출력 후 다시 입력.



4. 발행한 로또 수량 및 번호를 출력한다.
    * 로또 번호는 오름차순으로 정렬하여 보여준다.
    * Randoms.pickUniqueNumbersInRange를 사용하여 로또를 발행한다.



5. 당첨 내역을 출력한다.
    * 1등 : 6개 번호 일치 / 2,000,000,000원
    * 2등 : 5개 번호 + 보너스 번호 잋리 / 30,000,000원
    * 3등 : 5개 번호 일치 / 1,500,000원
    * 4등 : 4개 번호 일치 / 50,000원
    * 5등 : 3개 번호 일치 / 5,000원



6. 총 수익률을 출력한다.
   * 수익률은 소수점 둘째 자리에서 반올림 한다.


-[x] 요구 사항
  - else 예약어를 쓰지 않는다.
  - Java Enum을 적용하여 프로그램을 구현한다.
  - 구현한 기능에 대한 단위 테스트를 작성한다.
  - Lotto 클래스를 사용하여 구현해야 한다.
