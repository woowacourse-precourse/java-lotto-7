# java-lotto-precourse

### 목표

- 객체들이 협력하여 하나의 기능을 수행하도록 한다.
- 단위 테스트를 작성한다.

### 구현할 애플리케이션: 로또
로또 발매기를 구현한다.  
1. 구입 금액을 입력한다.
2. 구입 금액에 해당하는 만큼 로또를 발행한다.
   - 로또는 하나당 1,000원이다.
   - 로또 번호는 랜덤으로 뽑아준다.
3. 당첨 번호 추첨기가 6개의 숫자와 보너스 번호 1개를 뽑는다.
   - 당첨 번호와 보너스 번호는 입력을 통해 받는다.
4. 당첨 번호 추첨기의 로또 번호와 사용자의 로또 번호를 비교한다. 당첨 금액은 다음과 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
5. 최종 수익률을 출력하고 로또 게임을 종료한다.
6. 사용자가 잘못된 값을 입력할 경우 예외를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 실행 예시는 다음과 같다.

    ```
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
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ```

---

### 구현 목록

- [x]  구입 금액 입력
    - [x]  숫자가 아닌 문자가 입력될 경우 예외 발생
    - [x]  입력 금액이 1,000원 이하일 경우 예외 발생
- [x]  판매할 로또 개수 계산
- [x]  판매한 로또 개수 출력
- [x]  로또 번호 랜덤 추첨
    - [x]  판매할 로또 개수만큼 생성
- [ ]  랜덤으로 뽑은 로또 번호 출력
- [ ]  당첨 번호 입력
    - [ ]  번호가 숫자로 되어있지 않을 경우 예외 발생
    - [ ]  1~45 범위의 숫자가 아닌 경우 예외 발생
    - [ ]  숫자를 6개 이상 입력할 경우 예외 발생
- [ ]  보너스 번호 입력
    - [ ]  숫자가 아닐 경우 예외 발생
    - [ ]  1~45 범위의 숫자가 아닌 경우 예외 발생
- [ ]  로또 당첨 여부 확인
- [ ]  당첨 통계 출력
- [ ]  수익률 계산
- [ ]  수익률 출력
- [ ]  예외가 발생할 경우 예외 지점부터 다시 입력