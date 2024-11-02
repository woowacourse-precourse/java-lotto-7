# java-lotto-precourse

## ✨ 기능 요구 사항

간단한 로또 발매기를 구현한다.

로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## ✅ 구현할 기능 목록

입력

1. 로또 구매 금액을 입력받는다.
   - 로또는 1개당 1,000원이다.
   - 만약 입력된 금액이 1,000원 으로 나누어 떨어지지 않으면 예외처리한다.
2. 로또 구매 금액 / 1,000원 만큼 로또 당첨번호를 입력받는다.
   - 6개의 숫자를 쉼표를 구분자로 사용해서 입력받는다.
     - ex) 1,2,3,4,5,6
3. 보너스 번호를 입력받는다.
   - 숫자 1개를 입력받는다.
   - 보너스 번호는 1~45 중에서 입력해야 된다.

출력

6. 최종 구매한 로또의 수를 출력한다.
    
        8개를 구매했습니다.
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        [7, 11, 16, 35, 36, 44]
        [1, 8, 11, 31, 41, 42]
        [13, 14, 16, 38, 42, 45]
        [7, 11, 30, 40, 42, 43]
        [2, 13, 22, 32, 38, 45]
        [1, 3, 5, 14, 22, 45]
7. 당첨 내역을 출력한다. 

       3개 일치 (5,000원) - 1개
       4개 일치 (50,000원) - 0개
       5개 일치 (1,500,000원) - 0개
       5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
       6개 일치 (2,000,000,000원) - 0개
       총 수익률은 62.5%입니다.