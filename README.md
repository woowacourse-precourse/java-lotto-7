# java-lotto-precourse

# 3주차 로또 발매기

### 기능 요구 사항

간단한 로또 발매기를 구현한다.

* 로또 번호의 숫자 범위는 1\~45까지이다.
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
* 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  * 1등: 6개 번호 일치 / 2,000,000,000원
  * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  * 3등: 5개 번호 일치 / 1,500,000원
  * 4등: 4개 번호 일치 / 50,000원
  * 5등: 3개 번호 일치 / 5,000원
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
* 로또 1장의 가격은 1,000원이다.
* 당첨 번호와 보너스 번호를 입력받는다.
* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  * `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

---

### 사용자 플로우

1.구입금액입력

2.구매한 n개의 로또 번호 확인

3.당첨번호입력

4.보너스번호 입력

5.당첨 결과 통계로 확인

---

*5개가 당첨일때는 보너스 번호 확인

\*수익률은 소수점 둘째 자리에서 반올림한다.

\*예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

*Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.

---

### Lotto 클래스

* 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
* `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
* `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
* `Lotto`의 패키지를 변경할 수 있다.

---

### 구현순서

1. 요구사항 분석 및 README.md에 구현 순서 목록작성
2. 기능 최소단위로 작성 후, 해당하는 테스트 코드 작성
3. 테스트코드에 따라 기능 구현
4. 리스트업 한 기능 요구사항 점검

---

### 기능 구현 목록

1. 로또 1장 가격은 1000원
2. 구입 금액을 입력받고 1000으로 나누어 떨어지지 않는경우 예외처리
3. 로또 발행 후 출력(오름차순 정렬)
4. 로또 여러개 발행후 List에 넣고 출력
5. 당첨번호 입력받음, 쉼표(,)로 구분
6. 보너스 번호 입력받음
7. 당첨번호 비교하여 등수 매기는 로직 구현
8. 2등일 시 보너스번호 비교 구현
9. 잘못된 번호 입력 예외처리
10. 수익률 계산 구입금액/총 당첨금액 100 , 소수점 두번째자리에서 반올림 String.format("%.1f", number)


---

###

#### 실행 결과 예시

```prolog
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

### ENUM

ENUM으로 사용 가능한 값

1.로또 가격

2.당첨 금액

3.로또 번호 범위
