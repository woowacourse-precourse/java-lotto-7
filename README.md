# java-lotto-precourse
# 🎲 로또 🎰

---
작성자 : [임재홍](https://github.com/ahpicl64)
# 🔧 구현 목록

---
## 1️⃣ 입력
### [1.1 사용자 값 입력]
- [ ] 로또 구입 금액을 `1,000원 단위로` 입력
- [ ] 해당 회차 당첨 번호 입력
  - [ ] `,`를 구분자로 하는 `6개 정수`인 당첨번호 입력
  - [ ] 보너스 번호 입력

---
## 2️⃣ 출력
### [2.1 사용자 값 입력 시 출력]
- [x] `구입금액을 입력해 주세요.`
- [x] `n개를 구매했습니다.`
- [x] `당첨 번호를 입력해 주세요.`
- [x] `보너스 번호를 입력해 주세요.`

### [2.2 발행된 로또를 출력]
- [x] `[]` 내부에 `,`를 구분자로하여 로또 1장을 출력
- [x] 구입한 모든 로또를 줄바꿈하여 출력

### [2.3 당첨내역 출력]
- [x] 3개 부터 6개 까지 n개의 일치 개수를 출력
```
3개 일치 (5,000원) - n개
4개 일치 (50,000원) - n개
5개 일치 (1,500,000원) - n개
5개 일치, 보너스 볼 일치 (30,000,000원) - n개
6개 일치 (2,000,000,000원 - n개)
```

### [2.4 수익률 출력]
- [x] 계산된 수익률 출력
- [x] `총 수익률은 n%입니다.`

### [예외상황 시]
- [ ] `[ERROR]`로 시작하는 에러 문구를 출력
  - 예시: `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

---
## 3️⃣ 로또
### [3.1 로또 발행]
- [x] 구입 금액에 해당하는 만큼의 로또를 발행
  - [x] 1,000원당 1장 발행
  - [x] 로또에는 `1 ~ 45` 사이의 중복되지 않는 6개의 정수를 저장

### [3.2 로또 정리]
- [x] 발행된 로또 번호는 `오름차순`으로 재정렬

### [3.3 당첨 확인]
- [x] 입력된 `당첨 번호`와 `보너스 번호`를 `발행된 로또`와 대조
- [x] 3개 부터 6개까지 일치한 로또를 확인
  - [x] `당첨 번호 5개 일치` 시 남은 한개의 번호를 `보너스 번호`와 대조
- [x] 일치한 로또는 통계에 저장

### [3.4 당첨 통계]
- [x] 1 ~ 5등 결과가 당첨 된 로또의 수량을 기록
  - 당첨 기준 및 금액
  > 1등: 6개 번호 일치 / 2,000,000,000원   
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원   
    3등: 5개 번호 일치 / 1,500,000원   
    4등: 4개 번호 일치 / 50,000원   
    5등: 3개 번호 일치 / 5,000원

- [x] 결과에 따른 당첨금액 계산
- [x] 구매금액 대비 당첨금액을 계산하여 백분율로 전환
  - [x] 수익률 = `순이익(당첨금액-구매금액) / 구매금액 * 100`
  - [x] 백분율은 소수점 둘째 자리에서 `반올림`하여 첫째 자리까지만 저장

---
## 4️⃣ 예외처리
- [ ] Exception이 아닌 `IllegalArgumentException, IllegalStateException` 등 명확한 유형 처리
- [ ] 잘못된 값을 입력 시 `IllegalArgumentException`을 발생
- [ ] `[ERROR]`로 시작하는 에러메시지 출력
- [ ] 그 부분을 다시 입력 받도록 처리

### [4.1 금액 입력 시]
- [ ] 입력된 금액이 양수인 정수가 아닌 경우
- [ ] 입력된 금액이 1,000으로 나뉘었을 때 나머지가 0이 아닌 경우
- [ ] 입력된 금액이 공백이거나 null인 경우
- [ ] 입력된 금액기 1,000 미만인 경우
- [ ] 숫자가 아닌 문자를 입력한 경우

### [5.2 당첨번호 입력 시]
- [ ] 입력된 번호가 `1 ~ 45` 범위를 벗어나는 `정수`일 경우
- [ ] `잘못된 구분자`를 입력한 경우
- [ ] `6개`가 아닌 `5개 이하 7개 이상`의 정수를 입력한 경우
- [ ] 숫자와 구분자가 아닌 문자를 입력한 경우

---
### 실행 결과 예시
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