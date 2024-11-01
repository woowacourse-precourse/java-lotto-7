# java-lotto-precourse

# 📄기능 구현 목록

## 1. 로또 구매하기✅

### 1-1. 사용자로부터 구매금액 입력받기✅

### 1-2. 구매 금액에 대한 유효성 검사✅

- 구입 금액에 대한 유효성 검사✅
    - [x] 사용자가 입력한 구입 금액이 숫자로만 입력되었는지 검사 -> validator를 이용한 검사
    - [x] 구입 금액이 Integer로 파싱할 수 있는지 검사 -> validator를 이용한 검사
    - [x] 구입 금액이 1000원으로 나누어 떨어지는지 검사 -> model 생성시 검사


- 구입 금액이 유효하지 않을 시 다시 입력받기✅

### 1-3. 사용자의 로또 번호 모델 생성하기✅

- 생성한 로또 번호 오름차순 정렬하기✅

### 1-4. 사용자의 로또 번호 출력하기✅

- 구매한 개수 출력하기✅
- 사용자의 로또 번호 모두 출력하기✅

  > **사용자 로또 번호 출력 예시**
  > ```text
    > 8개를 구매했습니다.
    > [8, 21, 23, 41, 42, 43] 
    > [3, 5, 11, 16, 32, 38] 
    > [7, 11, 16, 35, 36, 44] 
    > [1, 8, 11, 31, 41, 42] 
    > [13, 14, 16, 38, 42, 45] 
    > [7, 11, 30, 40, 42, 43] 
    > [2, 13, 22, 32, 38, 45] 
    > [1, 3, 5, 14, 22, 45]
    > ```

## 2. 로또 당첨번호 생성하기

### 2-1. 당첨 번호 및 보너스 번호 입력 받기

### 2-2. 당첨 번호 및 보너스 번호 유효성 검사

- 당첨 번호에 대한 유효성 검사
    - [ ] 사용자가 입력한 번호가 6개인지 검사
    - [ ] 사용자가 입력한 번호 요소가 Integer로 파싱할 수 있는지 검사
    - [ ] 사용자가 입력한 번호가 1~45 범위안에 있는지 검사
    - [ ] 번호 중복 확인하기


- 당첨 번호나 보너스 번호가 유효하지 않을 시 다시 입력받기

### 2-3. 로또 당첨번호 모델 생성하기

## 3. 당첨 계산하기

- 사용자가 당첨된 로또 개수 확인하기
- 사용자의 수익률 계산하기

## 4. 당첨 통계 출력하기

- 등수별 당첨 개수 출력하기
- 수익률 출력하기
    - 소수점 2번째 자리에서 반올림하기

  > **당첨 통계 출력 예시**
  > ```text
    > 당첨 통계
    > ---
    > 3개 일치 (5,000원) - 1개
    > 4개 일치 (50,000원) - 0개
    > 5개 일치 (1,500,000원) - 0개
    > 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    > 6개 일치 (2,000,000,000원) - 0개
    > 총 수익률은 62.5%입니다.
    > ```

---

# 도메인 설계 목록

## 사용자의 구매 금액과 관련된 객체✅

- 사용자의 구매 금액을 받아 유효성 검사 로직✅
- ~~사용자가 구매할 수 있는 로또 개수를 상태를 가짐~~ => 불필요하므로 삭제

## 사용자의 로또를 관리하는 객체✅

- 사용자의 구매 장수를 바탕으로 로또 생성✅

## 당첨 로또를 관리하는 객체✅

- 당첨 로또 번호 6개를 상태로 가짐✅
- 보너스 로또 번호를 상태로 가짐✅
- 당첨 로또 번호들과 보너스 로또 번호의 중복 유효성 검사 로직✅
