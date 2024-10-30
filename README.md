# 로또
- 간단한 로또 발매기를 구현한다.

## 1. 기능 요구 사항
- 로또 번호의 숫자 범위는 1~45까지이다.
-  로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
	- 14000
- 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
	- 1,2,3,4,5,6
-  번호를 입력 받는다.
	- 7

### 출력
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
    - 8개를 구매했습니다.
    - [8, 21, 23, 41, 42, 43]
    - [3, 5, 11, 16, 32, 38]
    - [7, 11, 16, 35, 36, 44]
    - [1, 8, 11, 31, 41, 42]
    - [13, 14, 16, 38, 42, 45]
    - [7, 11, 30, 40, 42, 43]
    - [2, 13, 22, 32, 38, 45]
    - [1, 3, 5, 14, 22, 45]

- 당첨 내역을 출력한다.
    - 3개 일치 (5,000원) - 1개
    - 4개 일치 (50,000원) - 0개
    - 5개 일치 (1,500,000원) - 0개
    - 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    - 6개 일치 (2,000,000,000원) - 0개

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
  - 총 수익률은 62.5%입니다.

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
  - [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

## 2. 기능 목록
1) [ ] 로또 구입 금액을 입력
   - [ ] "구입금액을 입력해 주세요."를 출력한다.
   - [ ] 구입금액을 입력 받은 후 한 줄 띈다.

2) [ ] 구매한 로또 번호 출력
   - [ ] 구입금액을 1,000으로 나눈 개수를 구하고, "개를 구매했습니다."를 출력한다.
   - [ ] 구매한 개수만큼 로또 번호를 출력한다.
      - [ ] 형식은 "[" + 랜덤 숫자 6개 + "]" 이다.
      - [ ] 랜덤 숫자 6개는 1이상 45이하이다.
      - [ ] 랜덤 숫자 6개는 오름차순 정렬한다.
   - [ ] 로또 번호 출력이 끝나면 한 줄 띈다.

3) [ ] 당첨 번호 입력
   - [ ] "당첨 번호를 입력해 주세요."를 출력한다.
   - [ ] 번호 6개를 입력받는다.
   - [ ] 번호 6개를 입력 받은 후 한 줄 띈다.

4) [ ] 보너스 번호 입력
   - [ ] "보너스 번호를 입력해 주세요."를 출력한다.
   - [ ] 번호 한 개를 입력받는다.
   - [ ] 번호 한 개를 입력 받은 후 한 줄 띈다.

5) [ ] 결과 출력
   - [ ] "당첨 통계"를 출력한다.
   - [ ] "---"를 출력한다.
   - [ ] 구매한 로또 번호들의 결과를 계산한다.
      - [ ] 각 로또 번호의 당첨 여부를 확인한다.
         - [ ] 3개 일치시 3개 결과에 1 값을 추가하고, 총 수입금에 5,000원을 더한다.
         - [ ] 4개 일치시 4개 결과에 1 값을 추가하고, 총 수입금에 50,000원을 더한다.
         - [ ] 5개 일치시 5개 결과에 1 값을 추가하고, 총 수입금에 1,500,000원을 더한다.
         - [ ] 5개 + 보너스 볼 일치시 5개 + 보너스 볼 결과에 1 값을 추가하고, 총 수입금에 30,000,000원을 더한다.
         - [ ] 6개 일치시 6개 결과에 1 값을 추가하고, 총 수입금에 2,000,000,000원을 더한다.
      - [ ] '총 수익률 = 총 수입금 / 구입금액'을 구한다.
         - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
   - [ ] "'n'개 일치 ('n개 당첨금'원) - 'm'개"를 출력한다.
      - [ ] "3개 일치 (5,000원) - '3개 결과'개" 출력.
      - [ ] "4개 일치 (50,000원) - '4개 결과'개" 출력.
      - [ ] "5개 일치 (1,500,000원) - '5개 결과'개" 출력.
      - [ ] "5개 일치, 보너스 볼 일치 (30,000,000원) - '5개 + 보너스 볼 결과'개" 출력.
      - [ ] "6개 일치 (2,000,000,000원) - '6개 결과'개" 출력.
   - [ ] 총 수익률을 출력한다.
      - [ ] "총 수익률은 '총 수익률'%입니다."


## 3. 예외 처리
- 사용자가 잘못된 값을 입력한 경우 "[ERROR]"로 시작하는 에러 메세지 출력 후 그 부분부터 다시 입력 받는다.
- IllegalArgumentException: 잘못된 파라미터가 넘어간 경우
- IllegalStateException: 대상 객체의 상태가 호출된 메소드를 수행하기에 적절하지 않을 때 발생시킬 수 있는 경우

1) 로또 구입금액 입력
   - [ ] 구입금액이 공백, null, \n 값인 경우
   - [ ] 구입금액이 숫자가 아닌 경우
   - [ ] 구입금액이 1000원 미만인 경우(음수, 0 포함)
   - [ ] 구입금액이 1,000원 단위가 아닌 경우

2) 당첨 번호 입력
   - [ ] 당첨번호가 공백, null, \n 값인 경우
   - [ ] 구분자가 ','가 아닌 경우
   - [ ] 당첨번호 개수가 6개가 아닌 경우
   - [ ] 당첨번호가 숫자가 아닌 경우
   - [ ] 당첨번호가 1 이상 45 이하가 아닌 경우(0, 음수, 46 이상 완료)

3) 보너스 번호 입력
   - [ ] 보너스 번호가 공백, null, \n 값인 경우
   - [ ] 당첨번호가 숫자가 아닌 경우
   - [ ] 당첨번호가 1 이상 45 이하가 아닌 경우(0, 음수, 46 이상 완료)