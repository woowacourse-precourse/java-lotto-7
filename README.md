# 🎱 java-lotto-precourse

## ⭐️ 미션에서 지키려고 노력한 것
1. 과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항 모두 만족
2. 기능 구현 전 프로그램 진행 순서, 기능 목록 작성, 대략적 설계 (돌아가는 쓰레기 만들기)
3. 1차 기능 구현 후 기본 테스트 통과 여부 확인
4. 기본 테스트 통과 후 리팩토링, 추가 테스트 목록 작성 (클린코드 지향)
5. 기능 요구 사항 이외에 판단할 수 있는 추가 요구 사항 수립
6. 커밋 메시지를 제목과 내용으로 나누어 기능 단위 커밋
7. class와 method의 역할을 명확히 구분 / 특히 method가 단일 역할을 수행하는지 확인
8. method naming이 명확한지 한 번 더 확인
9. Java Code Convention을 지키며 구현
10. 2주차 공통 피드백을 최대한 반영

## 📁 디렉토리 구조
```
```

## 💻 프로그램 진행 순서
1. 구입 금액을 입력 받는다.
    * 1,000원 단위인지 검증한다.
2. 당첨 번호를 입력 받는다.
    * 쉼표(,) 기준으로 구분한다.
    * 1~45 사이의 중복되지 않는 6개의 숫자인지 검증한다.
3. 보너스 번호를 입력 받는다.
    * 1~45 사이의 당첨 번호와 중복되지 않는 숫자인지 검증한다.
4. 구입한 개수의 로또를 발행한다.
    * 발행하는 로또는 1~45 사이의 중복되지 않는 6개의 숫자이다.
5. 발행한 로또 수량과 번호를 출력한다.
    * 로또 번호는 오름차순으로 정렬하여 보여준다.
6. 발행한 로또 번호와 당첨 번호, 보너스 번호를 비교한다.
7. 당첨 내역을 출력한다.
8. 수익률을 계산한다.
9. 수익률을 출력한다.
10. 사용자가 잘못된 값을 입력할 경우 ``IllegalArgumentException``을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후, 그 부분부터 입력을 다시 받는다. 
11. 실행 결과 예시
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

## 📋 기능 목록
### 사용자 입력
1. 로또 구입 금액
- [x] 구입할 로또 금액 입력 받기
- [x] 숫자인지 검증
- [x] 1,000원으로 나누어 떨어지는지 검증

2. 당첨 번호
- [x] 당첨 번호 입력 받기
- [x] 번호가 쉼표(,)를 기준으로 나누어지는지 검증
- [x] 번호가 1~45 사이인지 검증
- [x] 번호가 서로 중복되지 않는 6개의 숫자인지 검증

3. 보너스 번호
- [x] 보너스 번호 입력 받기
- [x] 번호가 1~45 사이인지 검증
- [x] 번호가 당첨 번호와 중복되지 않는 숫자인지 검증

4. 입력 검증 후 재입력 받기
- [x] 잘못된 값을 입력할 경우 ``IllegalArgumentException`` 발생 후 그 부분부터 재입력 받기

###  로또 발행
- [x] 구입 개수만큼의 로또 발행
- [x] 번호가 1~45 사이인지 검증
- [x] 번호가 서로 중복되지 않는 6개의 숫자인지 검증

### 당첨 비교
- [x] 발행한 로또와 당첨 번호, 보너스 번호 비교
- [x] 일치하는 번호의 수대로 개수 계산
 
### 수익률 계산
- [ ] 구입 금액과 당첨 금액을 비교하여 수익률 계산

### 출력
1. 예외 상황 시 에러 문구 출력
- [x] "[ERROR]"로 시작하는 에러 메시지 출력

2. 구매하여 발행한 로또 출력
- [x] 구매 개수 출력
- [x] 구매 개수만큼 발행한 로또 출력

3. 당첨 내역 출력
- [x] 일치하는 번호별로 당첨 금액과 개수 출력

4. 수익률 출력
- [ ] 소수점 둘째 자리에서 반올림하여 출력

## 🤔 요구 사항 이외의 추가 기능

## ✅ 테스트 목록
### 사용자 입력
1. 로또 구입 금액
- [ ] 1,000원으로 나누어 떨어지는지
- [ ] 1,000원으로 나누어 떨어지는 숫자가 아니라면 예외처리 되는지

2. 당첨 번호
- [ ] 번호가 쉼표(,)를 기준으로 나누어지는지
- [ ] 번호가 1~45 사이인지
- [ ] 번호가 서로 중복되지 않는 6개의 숫자인지
- [ ] 번호가 쉼표(,)로 나누어지지 않으면 예외처리 되는지
- [ ] 번호가 1~45 사이가 아니라면 예외처리 되는지
- [ ] 번호가 서로 중복된다면 예외처리 되는지

3. 보너스 번호
- [ ] 번호가 1~45 사이인지
- [ ] 번호가 당첨 번호와 중복되지 않는 숫자인지
- [ ] 번호가 1~45 사이가 아니라면 예외처리 되는지
- [ ] 번호가 당첨 번호와 중복된다면 예외처리 되는지

### 로또 발행
- [ ] 구입 개수만큼 로또가 발행되는지
- [ ] 발행된 로또 번호가 1~45 사이인지
- [ ] 발행된 로또 번호가 서로 중복되지 않는 6개의 숫자인지

### 당첨 비교
- [ ] 3개, 4개, 5개, 5개+보너스볼, 6개 일치 개수가 맞는지

### 수익률 계산
- [ ] 계산된 수익률이 총 당첨금액 / 구매금액 * 100 이 맞는지

### 출력
- [ ] 수익률이 소수점 둘째 자리에서 반올림하여 출력되는지