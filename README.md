# java-lotto-precourse
## 기능 목록
### 1. 입력
#### 입력 기능 구현 시 공통 주의 사항
`camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
#### 입력 기능 구현
- [ ] **로또 구입 금액**
  - 1,000원 단위로 입력 받기
-[ ] **당첨 번호 입력**
  - 쉼표로 구분된 6개의 숫자 입력 받기
-[ ] **보너스 번호 입력**
  - 숫자 1개 입력 받기

### 2. 출력
-[ ] 발행한 로또 수량 및 번호 출력
  - 출력 형식
      ```text 
      n개를 구매했습니다.
      [1, 2, 3, 4, 5, 6]
      ...
      n개의 배열
      ```
  - 로또 번호 오름차순 정렬하기
- [ ] 당첨 내역 출력
  - 출력 형식
    ```text 
    3개 일치 (5,000원) - n개
    4개 일치 (50,000원) - n개
    5개 일치 (1,500,000원) - n개
    5개 일치, 보너스 볼 일치 (30,000,000원) - n개
    6개 일치 (2,000,000,000원) - n개
    ```
- [ ] 수익률 출력
  - 소수점 둘째 자리에서 반올림
  - % 사용하여 나타낼 것
    ```text
    총 수익률은 00.0%입니다.
    ```
- [ ] 에러 문구 출력
  - 에러 문구는 `[ERROR]` 로 시작해야 한다.
    ```text
    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
    ```
    
### 3. 로또 발매기 구현
-[ ] 로또 발행 기능 구현
    - 로또 구입 금액을 기반으로 발행할 로또의 개수 구하기
      - 로또는 1,000원 당 1장
      - 만약 14,000원을 입력 받았다면 14장을 발행해야 함
    - 로또 번호 숫자 범위 : 1 ~ 45
    - 1개의 로또는 중복되지 않는 6개의 숫자로 구성
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()` 활용
      ```text
        Randoms.pickUniqueNumbersInRange(시작범위, 종료범위, 개수);
      ```
-[ ] 번호 일치 확인 기능 구현
  - 제공된 `Lotto 클래스` 사용하기
    - 중복되지 않는 숫자 6개와 보너스 번호 1개를 입력 받아 List에 저장
  - 일치/불일치 확인 후 Map에 해당 정보를 저장
    - 일치하는 번호 개수 - 해당하는 로또 개수
    - 일치하는 번호 개수 - 당첨 금액
-[ ] 수익률 계산 기능
  - 로또 당첨 금액 계산하기
    - Map에 저장된 데이터를 기반으로, 금액 * 당첨 개수 합산
  - 수익률 계산하기
    - 수익률 = 순이익/투자금액 * 100 = (당첨금액-투자금액)/투자금액 * 100

### 4. 예외처리
`IllegalArgumentException` 을 발생시키고, 에러메시지 출력
- [ ] 구입 금액 입력 시
  - 1000원 단위가 아닌 경우
    - `[ERROR] 로또는 1장 당 1000원입니다. 1000원 단위로 입력해주세요.`
  - 0원를 입력했을 경우
    - `[ERROR] 로또를 살 수 없습니다! 최소 1000원 이상 입력해주세요.`
- [ ] 당첨 번호 입력 시 6개의 숫자가 아닌 경우
  - 당첨 번호가 쉼표로 구분되지 않음
    - `[ERROR] 쉼표(,)로 구분하여 입력해주세요. 예) 1,2,3,4,5,6`
  - 쉼표로 구분이 되지만 숫자가 아님
    - `[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.`
  - 당첨 번호의 개수가 6개 미만이거나 초과
    - `[ERROR] 당첨 번호는 6개의 숫자만 가능합니다. `
- [ ] 보너스 번호 입력 시 1개의 숫자가 아닌 경우
  - 보너스 번호 미입력 혹은 1개 초과
    - `[ERROR] 보너스 번호는 1개의 숫자만 가능합니다.`
  - 보너스 번호가 숫자가 아님
    - `[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.`
- [ ] 입력한 숫자의 범위가 1~45 사이의 숫자가 아닌 경우
  - `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`