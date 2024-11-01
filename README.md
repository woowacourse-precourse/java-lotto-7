# java-lotto-precourse

## 개요
---
간단한 로또 발매기를 구현한다. 고객은 1000원당 한장인 로또를 구입할 비용을 입력하고,
당첨 번호와 보너스 번호를 입력받은 후, 고객이 구매한 로또와 당첨 번호및 보너스 번호와 비교를 한다.
비교후 당첨결과와 수익률을 출력한다.

## 세부요구사항

### 로또

- [x] 로또 번호를 가진다.
    - [x] 번호의 숫자 범위는 1~45까지이다.
    - [x] 번호는 중복되지 않는 6개의 숫자를 갖는다.
- [x] 로또 번호를 자신과 비교하여 몇개 일치하는지 반환한다.

### 고객로또

- [x] 로또들을 가진다.
- [ ] 로또들과 당첨로또를 비교하여 랭크와 개수를 반환한다.

### 당첨로또

- [ ] 로또와 보너스 번호를 가진다.
    - [ ] 보너스 번호는 로또 번호와 중복되지 않는다.
- [ ] 로또와 당첨 로또와 비교하여 랭크를 반환한다.

### 로또 컨트롤러

- [ ] 구입한 금액에 해당하는 만큼 로또를 발행한다. 1000원당 한장
- [ ] 당첨 로또를 발행한다.
- [ ] 당첨 결과(등수)를 반환한다.

### 랭크

- [ ] 1등부터 5등을 가진다
    - 1등은 6개의 번호일치, 상금은 2,000,000,000원
    - 2등은 5개번호 일치 + 보너스 번호 일치, 상금은 30,000,000원
    - 3등은 5개 번호 일치, 상금은 1,500,000원
    - 4등은 4개 번호 일치, 상금은 50,000원
    - 5등은 3개 번호 일치, 상금은 5,000원
- [ ] 각 등수에 맞는 Enum 값을 반환한다.

### 입력

- [x] 사용자가 잘못된 입력을 하면 예외메시지를 출력하고 다시 입력을 받는다.

- [x] 구입금액을 입력받는다.

```
구입금액을 입력해 주세요.
8000
```

- [x] 당첨 번호를 입력받는다.

```
구입금액을 입력해 주세요.
8000
```

- [x] 보너스 번호를 입력받는다.

```
보너스 번호를 입력해 주세요.
7
```

### 출력

- [ ] 생성된 로또 번호를 출력한다.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- [ ] 당첨 통계를 출력한다
    - 일치여부, 수익률

```
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```