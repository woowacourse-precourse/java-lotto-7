# 프리코스 3주차 미션 - 로또 🎱


![Generic badge](https://img.shields.io/badge/precourse-week3-green.svg)




> 🔑 우아한테크코스 웹 백엔드 7기 3주차 미션, '로또'를 구현한 저장소입니다.

---

### ▶️ 프로세스 흐름도
![로또__다이어그램 drawio](https://github.com/user-attachments/assets/a9dfe309-314f-4798-98f9-243f31490669)

### 클래스 구조
> ### lotto
> 
> ── Controller
> 
> └── LottoController   // 전체 흐름 제어
> 
> ── Model
> 
> └── Lotto           // 발행된 로또 번호 관리, 유효성 검사
> 
> └── LottoGenerator      // 로또 수량 계산, 로또 번호 발행
> 
> └── LottoResult     // 당첨 결과 계산, 수익률 계산
> 
> └── WinningLotto      // 발행 번호와 당첨 번호 비교
> 
> ── View
> 
> └── InputView.java        // 구입 금액 입력, 당첨 번호 입력
> 
> └── OutputView.java       // 발행 로또 번호 출력, 당첨 결과 출력(당첨 내역, 수익률)
> 
> ── Application
### 📝 구현할 기능 목록

✔️ 로또 구입 금액을 입력받는다. `구입금액을 입력해 주세요.`

✔️ 🔧 구입 금액은 1,000원 단위로 입력 받는다.(로또 1장의 가격은 1,000원이다.)

✔️ 🔧 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

✔️ 🔧 구입 금액에 해당하는 만큼 로또를 발행해야 한다.

✔️ 발행한 로또 수량 및 번호를 출력한다. `_개를 구매했습니다. [_, _, _, _, _, _]`

✔️ 🔧 로또 번호의 숫자 범위는 1~45까지이다.

✔️ 🔧 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

✔️ 🔧 로또 번호는 오름차순으로 정렬하여 보여준다.

✔️ 당첨 번호를 입력받는다. `당첨 번호를 입력해 주세요.`

✔️ 🔧 번호는 쉼표(,)를 기준으로 구분한다.

✔️ 🔧 당첨 번호는 중복되지 않는 숫자 6개이다.

✔️ 보너스 번호를 입력받는다. `보너스 번호를 입력해 주세요.`

✔️ 당첨 내역을 출력한다. `당첨 통계 --- _개 일치, (보너스 볼 일치) (_원) - _개`

✔️ 🔧 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원

✔️ 수익률을 출력한다. `총 수익률은 __._%입니다.`

✔️ 🔧 수익률은 소수점 둘째 자리에서 반올림한다.

✔️ 사용자가 잘못된 값을 입력할 경우(예외 상황 시) `IllegalArgumentException` 발생 후 에러 문구를 출력한다.

✔️ 🔧 에러 문구는 "[ERROR]"로 시작해야 한다.

✔️ 에러 메세지 출력 후 그 부분부터 입력을 다시 받는다.


### ☑️ check
✔️ 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.

✔️ 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

✔️ 2주 차 공통 피드백을 최대한 반영한다.

✔️ indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.

✔️ 3항 연산자를 쓰지 않는다.

✔️ 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

✔️ JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

✔️ else/switch/case를 쓰지 않는다.

✔️ Java Enum을 적용하여 프로그램을 구현한다.

✔️ 구현한 기능에 대한 단위 테스트를 작성한다.




> ### ⭐ 구현할 프로그램
> 간단한 로또 발매기를 구현한다.
> - 로또 번호의 숫자 범위는 1~45까지이다.
> - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
> - 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
> - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
> - 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
> - 로또 1장의 가격은 1,000원이다.
> - 당첨 번호와 보너스 번호를 입력받는다.
> - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
> - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
> #### 입력
> - 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
> - " 14000 "
> - 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
> - " 1,2,3,4,5,6 "
> - 보너스 번호를 입력 받는다.
> - " 7 "
> #### 출력
> - 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
> - " 8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]  "
> - 당첨 내역을 출력한다.
> - " 3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개 "
> - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
> - " 총 수익률은 62.5%입니다. "
> - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
> - " [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다. "
> #### 실행 결과 예시
> - 구입금액을 입력해 주세요.
    " 8000 "
> - " 8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45] "
> - 당첨 번호를 입력해 주세요.
    " 1,2,3,4,5,6 "
> - 보너스 번호를 입력해 주세요.
    " 1,2,3,4,5,6 "
> - "당첨 통계
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다. "




