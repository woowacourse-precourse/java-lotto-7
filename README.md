# 로또 프로젝트
---
### 프로젝트 시작 동기
--- 
우아한 테크 코스 프리 코스 3주차 과제로 해당 프로젝트를 진행하게 되었다.

### 프로젝트 목표
---
1. README의 작성 방법에 대해 다양한 레퍼런스들을 참고해 나만의 양식을 정한다.
2. README와 같은 문서 작성과 프로그래밍의 연결을 긴밀하게 한다.
3. 프리 코스 측에서 3주차 학습 목표를 학습하여 적용한다.
	 - 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
	- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
	- [2주 차 공통 피드백](https://docs.google.com/document/d/1QW_762N0WC6JvAiDHNBYXzLJ60y1Azex1d7tID0BggM/edit?usp=sharing)을 최대한 반영한다.
4. 프리코스 측에서 제공한 기능 요구사항에 만족하는 로또 발매기를 구현한다.

### 기능 정의
---
##### 입력 프로세스
- [ ] 로또 발매기는 사용자의 로또 번호를 자동으로 생성해 준다.
	- [ ] 로또 번호의 숫자 범위는 1~45까지이다.
	- [ ] 로또 번호는 6개의 번호와 보너스 번호 1개 총 7개의 숫자로 이루어져 있다.
	- [ ] 7개의 숫자로 이루어진 로또 번호는 각각이 중복되지 않는다.
	
- [ ] 로또 발매기는 사용자에게 로또 구입 금액을 입력 받는다.
	- [ ] 입력 안내문은 `구입금액을 입력해 주세요.` 이다.
	- [ ] ***Exception** : 로또 구입 금액 입력 시 입력이 비어있으면 예외 발생*
	- [ ] ***Exception** : 로또 구입 금액 입력 시 양의 정수 입력이 아니면 예외 발생*
	- [ ] ***Exception** : 로또 구입 금액 입력 시 1000원 단위의 입력이 아니면 예외 발생*
	- 예시 : `14000`
	
- [ ] 로또 발매기는 사용자가 입력한 로또 구입 금액에 맞는 수량의 로또 번호를 생성해 발급한다.
	- [ ] 로또 1장의 가격은 1000원이다.
	- [ ] 항상 입력 받은 구입 금액을 다 사용해서 구입한 수량 만큼의 로또 번호를 생성한다.
	
- [ ] 로또 발매기는 발행한 로또 수량 및 번호를 출력한다.
	- [ ] 로또 번호는 오름차순으로 정렬하여 보여준다.
	- 예시
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

- [ ] 보너스 번호를 제외한 로또 당첨 번호 6개를 사용자에게 입력 받는다.
	- [ ] 입력 안내문은 `당첨 번호를 입력해 주세요.` 이다.
	- [ ] 번호는 쉼표(,)를 기준으로 구분한다.
	- [ ] ***Exception** : 입력이 비어있을 시 예외 발생*
	- [ ] ***Exception** : 입력에 쉼표(,)와 양의 정수 이외의 문자가 존재할 시 예외 발생
	- [ ] ***Exception** : 양의 실수와 쉼표(,)의 순서가 잘못되었을 시 예외 발생
	- [ ] ***Exception** : 양의 정수가 1~45 범위에 존재 하지 않을 시 예외 발생
	- 예시 : `1,2,3,4,5,6`
	
- [ ] 보너스 번호 1개를 사용자에게 입력 받는다.
	- [ ] 입력 안내문은 `보너스 번호를 입력해 주세요.` 이다. 
	- [ ] ***Exception** : 입력이 비어있을 시 예외 발생*
	- [ ] ***Exception** : 양의 정수 이외의 문자가 존재할 시 예외 발생
	- [ ] ***Exception** : 양의 정수가 1~45 범위에 존재 하지 않을 시 예외 발생

##### 출력 프로세스
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 생성한다.
	- [ ] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
	    - 1등: 6개 번호 일치 / 2,000,000,000원
	    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
	    - 3등: 5개 번호 일치 / 1,500,000원
	    - 4등: 4개 번호 일치 / 50,000원
	    - 5등: 3개 번호 일치 / 5,000원
	- [ ] 당첨 내역은 각 등수 별로 당첨된 번호의 개수를 가져야한다.
	- [ ] 수익률은 `총 당첨금액/총 구입금액` 이다.
		- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
		
- [ ] 당첨 내역 및 수익률을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

### 실행 결과 예시
---
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