# 로또

---

## 📌 프로젝트 개요
- 사용자에게 랜덤 로또 번호를 발급해주고 당첨 번호를 입력받아 수익률을 계산하는 프로그램

## 📝 기능 구현 목록
## 입력
#### 로또 구입 금액 입력
- [X] 로또 구입 금액을 입력 받는다.
  - [X] "구입금액을 입력해 주세요."를 안내 메시지로 출력한다.
- [X] 예외 처리
  - [X] 로또 구입 금액이 빈 값일 때
  - [X] 로또 구입 금액이 양수가 아닐 때 (0, 음수일 때)
  - [X] 로또 구입 금액이 숫자가 아닐 때
  - [X] 로또 구입 금액이 1,000으로 나누어 떨어지지 않을 때
  - [X] 구입 금액이 100,000,000 원 이상일 때

#### 당첨 번호 입력
- [X] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  - [X] "당첨 번호를 입력해 주세요."를 안내 메시지로 출력한다.
- [X] 예외 처리
  - [X] 당첨 번호가 빈 값일 때
  - [X] 당첨 번호가 1~45 사이가 아닐 때
  - [X] 당첨 번호가 중복일 때
  - [X] 당첨 번호가 금액이 숫자가 아닐 때

#### 보너스 번호 입력
- [X] 보너스 번호를 입력 받는다.
  - [X] "보너스 번호를 입력해 주세요."를 안내 메시지로 출력한다.
- [ ] 예외 처리
  - [ ] 보너스 번호가 공백일 때
  - [ ] 보너스 번호가 1~45 사이가 아닐 때
  - [ ] 보너스 번호가 당첨 번호와 중복일 때
  - [ ] 보너스 번호가 숫자가 아닐 때

### 당첨 번호 문자열 분리
- [X] 입력받은 번호를 쉼표(,)로 분리한다.
- [X] 예외 처리
  - [X] 입력된 번호의 개수가 6개가 아닌 경우

### 로또 번호 생성
- [X] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
  - [X] 1개의 로또를 발행할 때 중복되지 않는 랜덤한 6개의 숫자를 뽑는다.
  - [X] 로또 1장의 가격은 1,000원이다.
  - [X] 로또 번호는 개당 6개씩 발행된다.

### 당첨 계산 기능
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하고 당첨을 확인한다.
- [ ] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원

### 수익률 계산 기능
- [ ] 수익률은 소수점 두번째 자리에서 반올림한다.
- [ ] 수익률 = 당첨금액 /구입금액x100

### 출력
- [X] 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
 
      8개를 구매했습니다.
      [8, 21, 23, 41, 42, 43]
      [3, 5, 11, 16, 32, 38]
      [7, 11, 16, 35, 36, 44]
      [1, 8, 11, 31, 41, 42]
      [13, 14, 16, 38, 42, 45]
      [7, 11, 30, 40, 42, 43]
      [2, 13, 22, 32, 38, 45]
      [1, 3, 5, 14, 22, 45] 

- [ ] 당첨 통계를 출력한다.

      당첨 통계
      ---
      3개 일치 (5,000원) - 1개
      4개 일치 (50,000원) - 0개
      5개 일치 (1,500,000원) - 0개
      5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
      6개 일치 (2,000,000,000원) - 0개

- [ ] 수익률을 출력한다.
 
       총 수익률은 62.5%입니다.
- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
 
       [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`



### 전체 실행 결과 예시

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
