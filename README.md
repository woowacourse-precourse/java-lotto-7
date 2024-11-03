# java-lotto-precourse

## 기능 구현 목록

- [x] 기능 구현 목록 작성 (7분)
- [x] 테스트 작성
  - [x] 뽑은 로또 번호 숫자 범위는 1~45 이내이다. (3분)
  - [x] 중복되지 않는 6개의 숫자를 뽑는다. (4분)
  - [x] 당첨 번호와 중복되지 않는 보너스 번호 1개를 뽑는다. (2분)
  - [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발행한다. (7분)
  - [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 계산한다. (12분)
- [x] 기능 구현
  - [x] 뽑은 로또 번호 숫자 범위는 1~45 이내이다. (3분)
  - [x] 중복되지 않는 6개의 숫자를 뽑는다. (2분)
  - [x] 당첨 번호와 중복되지 않는 보너스 번호 1개를 뽑는다. (4분)
  - [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발행한다. (7분)
  - [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 계산한다. (30분)
  - [x] 당첨 번호와 보너스 번호를 입력받는다. (50분)
- [x] MVP 완성
  - [x] 최소한의 버그 수정 (50분 + 60분)
  - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. (40분)

최소기능제품(MVP) 완성까지 걸린 시간: 4시간 41분

## 예외 목록

- [ ] 잘못된 값을 입력할 경우 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
- [x] 로또 구입 금액이 1000원으로 나누어떨어지지 않으면 예외를 반환한다.
- [x] 당첨 번호는 중복될 수 없다.
- [x] 당첨 번호와 보너스 번호는 겹칠 수 없다.
- [x] 당첨 번호는 6개여야 한다.
- [x] 로또 번호는 1에서 45 범위를 벗어나면 안된다.

## 리팩토링 목록

- [x] 테스트용 랜덤 추출 로직 분리
- [x] repository 계층 추가
- [x] dto 및 validate 추가
- [x] enum getMessage 가변인자 적용
- [x] 출력문 모아서 한 번에 출력하기 (like 쿼리 최적화)
- [ ] 불변 객체 적용
- [ ] 테스트 리팩토링
- [ ] 테스트 구체적으로 작성

## 실행 결과 예시
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