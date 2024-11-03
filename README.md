# 로또
## 목표
1~45까지의 숫자 중 **중복되지 않게 6개의 당첨 숫자**를 입력받은 후,   
**로또 구입 금액**을 입력받은 뒤에 **중복되지 않는 숫자 6개와 보너스 숫자 1개**를   
입력받은 금액의 **로또 수량만큼** 무작위 추첨해 **당첨된 수량과 수익률**을 출력
## 기능
- 입력에 대한 유효성 검사
- 입력으로 들어온 금액만큼 랜덤 번호 로또 생성 후 저장
- 입력으로 들어온 당첨 번호와 보너스 번호로 생성된 로또 검사
- 검사 후 당첨 통계에 값 반영
- 랜덤 로또 번호 및 당첨 통계 출력
## 패키지 / 클래스
```angular2html
├─main
│  └─java
│      └─lotto
│          │  Application.java
│          │  Lotto.java
│          │
│          ├─domain // 로또의 생성 및 관리
│          │      DrawNumber.java // 랜덤 번호 생성
│          │      IssueRandomLotto.java // 랜덤 번호를 넣은 로또를 LottoPool에 추가
│          │      LottoPool.java // 생성된 로또 관리
│          │
│          ├─game // 로또 추첨 후 당첨 과정 전체
│          │      LoopForException.java // 예외 발생 시 반복 입력
│          │      LottoGame.java // 로또 게임 전반
│          │
│          ├─service // 여러 서비스 클래스
│          │      LottoConverter.java // 당첨 번호 -> 로또 변환, 돈 -> 로또 변환
│          │      ValidChecker.java // 입력 유효성 검사
│          │      WinningNumberChecker.java // 당첨 번호와 생성된 번호 대조
│          │      WinningNumberPool.java // 당첨 번호 및 보너스 번호 관리
│          │      WinningStatisticsManager.java // 당첨 통계 관리
│          │
│          ├─test // 테스트 패키지
│          │  │  WholeTest.java // 통합 테스트 클래스
│          │  │
│          │  ├─domainTest
│          │  │      DrawNumberTest.java
│          │  │      IssueRandomLottoTest.java
│          │  │      LottoPoolTest.java
│          │  │
│          │  └─serviceTest
│          │          LottoConverterTest.java
│          │          ValidCheckerTest.java
│          │          WinningNumberCheckerTest.java
│          │          WinningNumberPoolTest.java
│          │          WinningStatisticsManagerTest.java
│          │
│          └─ui // 입출력
│                  InputManager.java
│                  OutputManager.java
│
└─test
└─java
└─lotto
ApplicationTest.java
LottoTest.java
```
## 입출력 예시
### 입력
- 로또 구입 금액을 입력받음
```angular2html
14000
```
- 당첨 번호 6개를 중복되지 않게 쉼표로 구분해서 입력받음
```angular2html
1,2,3,4,5,6
```
- 보너스 번호를 입력받음
```angular2html
7
```
### 출력
- 발행한 로또 번호를 오름차순으로 정렬해 구입 수량만큼 출력
```angular2html
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
- 당첨 내역을 출력
```angular2html
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```
- 수익률은 소수점 둘째 자리에서 반올림
```angular2html
총 수익률은 62.5%입니다.
```
- 예외 상황 시 에러 문구 출력("[ERROR]"로 시작해야 함)
```angular2html
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```
### 실행결과
```angular2html
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
총 수익률은 62.5%입니다
```