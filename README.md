# java-lotto-precourse


## 기능 구현 목록 📝

### ✨ 업데이트 내용
- 숫자가 2,147,483,647(Integer.MAX_VALUE)를 넘을 경우 예외 처리
- 총 수익률 계산을 위한 LottoProfit 객체 구현
- 유효성 검증 클래스 이름에 `Lotto` 키워드 제거
- ListValidator, NumberValidator 클래스에 제네릭 적용
- 단일 숫자일 경우 InvalidNumberException, 복수 숫자일 경우 InvalidNumbersException 으로 예외 처리 분리
- LottoGenerator 추상화 및 QuickLottoGenerator(자동 로또) 구현 

---

### ✅ 진행과정

#### 1. 로또 구입 금액을 입력 받는다.
- 구입 금액은 1,000원 단위만 가능
- 구입 금액의 최대는 Integer.MAX_VALUE로 제한

#### 2. 당첨 번호를 입력 받는다.
- 번호는 `,`(쉼표) 기준으로 구분
- 당첨 번호를 중복 불가
- 당첨 번호는 1 부터 45사이 자연수만 가능

#### 3. 보너스 번호를 입력 받는다.
- 보너스 번호는 당첨번호와 중복 불가
- 보너스 번호는 1 부터 45사이 자연수만 가능

#### 4. 발행한 로또 수량 번호를 출력한다.
- 로또 번호는 `오름차순`으로 정렬

#### 5. 당첨 내역을 출력한다.
- 당첨 내역은 5등 부터 1등까지 차례대로 출력
- 등수마다 당첨된 갯수 포함

#### 6. 수익률을 출력한다.
- 수익률은 소수점 둘째 자리에서 반올림  (ex. 100.0%, 51.5%, 1,000,000.0%)

#### 7. 예외 상황 시 에러 문구를 출력해야 한다.
- 에러 문구는 `[ERROR]`로 시작

---

### ✅ 실행 결과 예시
```text
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

### ✅ 클래스 및 기능

#### 1. domain
##### Lotto

- [X] 로또 번호의 정보를 갖고 있음
- [X] 특정 숫자가 로또 번호에 있는지 판단

###### 예외 처리
- [X] 번호가 중복된 경우
- [X] 번호가 1~45를 벗어난 경우

##### Money

- [X] 구입 금액의 정보를 갖고 있음
- [X] 1,000으로 나눈 몫을 반환 (로또 티켓 수)

###### 예외 처리
- [X] 1,000 단위가 아닌 경우

##### QuickLottoGenerator
- [X] 자동 로또를 발행
- [X] LottoGenerator의 구현체

##### LottoStore
- [X] 로또를 구입금액 만큼 발행

##### WinningNumbers

- [X] 당첨 번호와 보너스 번호의 정보를 갖고 있음
- [X] 당첨 번호에 특정 숫자가 있는지 판단

##### BonusNumber
- [X] 보너스 번호의 정보를 갖고 있음
- [X] 특정 숫자가 보너스 번호와 일치하는지 판단

###### 예외 처리
- [X] 보너스 번호가 1~45 사이의 자연수가 아닌 경우
- [X] 보너스 번호가 당첨 번호와 중복 되는 경우

##### WinningResult
- [X] 로또 당첨 결과를 반환

##### LottoProfit
- [X] 총 수익률을 계산하여 반환

##### LottoRank
- [X] 로또 당첨 정보를 갖고 있음

#### 2. util

##### ListValidator
- [X] 리스트 사이즈 검증
- [X] 리스트 중복 검증
- [X] 리스트 요소 범위 검증

##### NumberValidator
- [X] 숫자 범위 검증
- [X] 숫자 단위 검증

##### InputConvertor
- [X] 문자열을 숫자 리스트로 변환
- [X] 문자열을 숫자로 변환

#### 3. constant

##### LottoRule
- [X] 로또 규칙을 정의

#### 4. error

##### ErrorMessage
- [X] 에러 메세지를 정의

##### AppException
- [X] IllegalArgumentException의 하위 클래스

##### InvalidNumberException
- [X] 숫자 관련 예외 클래스
- [X] AppException의 하위 클래스

##### InvalidNumbersException
- [X] 여러 숫자 관련 예외 클래스
- [X] AppException의 하위 클래스

#### 5. view

##### ConsoleInputView
- [X] 사용자의 콘솔 입력을 읽음
- [X] InputView의 구현체

##### ConsoleOutputView
- [X] 사용자에게 결과를 콘솔 출력
- [X] OuputView의 구현체

#### 6. controller
- [X] 애플리케이션 흐름을 제어

---

### ✅ 클래스 다이어그램

#### 1. Main
![3주차_다이어그램_메인](https://github.com/user-attachments/assets/317b5f47-925c-47e5-b5ad-0ddffb747d4c)

#### 2. Util
![3주차_다이어그램_유틸](https://github.com/user-attachments/assets/ffeb68fd-c4fc-41cd-a7eb-30454e549bb6)

#### 3. Constant
![3주차_다이어그램_상수](https://github.com/user-attachments/assets/b42b5fb8-cc74-4058-bbd2-d03b34b73b55)

#### 4. Error
![3주차_다이어그램_에러](https://github.com/user-attachments/assets/9ef3e31b-4e37-4d0a-afa0-5f7d86424822)

#### 5. View
![3주차_다이어그램_뷰](https://github.com/user-attachments/assets/644bb47f-fb70-4fec-8202-052d53ebcb26)
