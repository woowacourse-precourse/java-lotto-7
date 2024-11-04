#  💵 미션 - 로또

## 학습 목표
1. 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하기
2. 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보하기
3. 2주차 공통 피드백을 최대한 반영하기

## 💡 핵심 기능

### What

- 사용자가 입력한 금액에 맞추어 로또를 발행하고, 발행된 로또 번호와 당첨 번호를 비교하여 당첨 여부를 확인하고 결과를 출력하는 기능을 제공

### How

- 1~45 범위의 중복되지 않는 6개의 숫자를 무작위로 선택하여 로또를 생성
- 현재는 자동 발급만 지원하지만, 자동 생성 로직과 수동 입력 로직을 분리하여 사용자가 원하는 방식으로 티켓을 발급받을 수 있도록 확장성을 고려하여 설계

### Why
- 자동/수동 발급 방식을 분리하여 유연한 사용자 경험을 제공하기 위해
  - 수동 발급 방식을 지원함으로써 사용자가 선호하는 번호를 선택할 수 있도록 하여 로또 구매에 대한 사용자 참여도를 높이기 위하여
  - 발급 로직의 분리를 통해 코드의 확장성과 재사용성을 확보하고, 추후 기능 추가 시 유지보수를 용이하게 위하여

## ⛳️ 2주차 목표
- [ ] 1주차 피드백 모두 반영하기
- [ ] 2주차 피드백 모두 반영하기
- [ ] 로또 프로그램을 확장성 있게 설계하기

## ✏️ 구현할 기능 목록

### 구입 금액 입력 안내 멘트

- [x] "`구입금액을 입력해 주세요.`" 를 출력한다.

### 구입 금액 입력값 확인

- [x] 사용자에게 로또 구입 금액을 입력받는다.
    - [x] 입력된 문자열의 앞뒤 공백을 제거한다.
    - [x] 입력된 문자열이 `null`인지 확인한다.
        - [x] `null`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] null은 입력할 수 없는 값입니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] 입력된 문자열이 빈 문자열(`""`)인지 확인한다.
        - [x] `빈 문자열`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 빈 문자열은 입력할 수 없습니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] 입력된 구입 금액이 `1000원 미만`인지 확인한다.
        - [x] `1000원 미만`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] 입력된 구입 금액이 `1000원 이상인데, 1000원으로 나누어 떨어지는지` 확인한다.
        - [x] `1000원 이상인데 1000원으로 나누어 떨어지지 않는` 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] 입력된 구입 금액이 `음수`인지 확인한다.
        - [x] `음수`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] 입력된 구입 금액이 `0원`인지 확인한다.
        - [x] `0원`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] 입력된 구입 금액이 `숫자`인지 확인한다.
        - [x] `숫자가 아닌` 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] 입력된 구입 금액이 `100000원 초과`인지 확인한다.
        - [x] `100000원 초과`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 로또는 1인당 최대 100장까지 구매할 수 있습니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [x] **그외 경우 다음 단계를 진행한다.**

### 로또 발급 진행

- [x] **로또 발급을 시작한다.**
    - [x] 사용자가 입력한 `구입 금액에 따라 발행할 로또 수량을 계산한다.`
        - [x] 구입 금액을 1,000원으로 나눈 값을 통해 로또 수량을 계산한다.
        - [x] 계산된 로또 수량을 사용자에게 출력한다.
            - 예시: **"8개를 구매했습니다."**

- [x] **로또 번호를 발행한다(구매 수량만큼 반복)** 
    - [x] 각 로또에 대해 **1~45 범위의 중복되지 않는 6개의 숫자를 랜덤하게 선택**한다.
    - [x] **선택된 숫자를 오름차순으로 정렬**하여 로또 번호를 구성한다.
    - [x] 발행한 로또 번호를 출력 형식에 맞게 출력한다.
        - 예시: **"[8, 21, 23, 41, 42, 43]"**

- [x] **발행한 모든 로또 번호를 사용자에게 출력한다.**
    - [x] 발행한 로또 수량만큼의 번호를 오름차순으로 출력한다.
    - [x] 예시 출력 형식을 따른다.
        - 예시:
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

- [x] **로또 발행 완료 후, 다음 단계로 진행한다.**

### 당첨 번호 입력 안내 멘트

- [ ] "`당첨 번호를 입력해 주세요.`" 를 출력한다.

### 당첨 번호 입력값 확인
- [ ] **사용자에게 당첨 번호를 입력받는다.**
    - [ ] 입력된 문자열의 앞뒤 공백을 제거한다.
    - [ ] 입력된 문자열이 `null`인지 확인한다.
        - [ ] `null`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] null은 입력할 수 없는 값입니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 문자열이 빈 문자열(`""`)인지 확인한다.
        - [ ] `빈 문자열`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 빈 문자열은 입력할 수 없습니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 당첨 번호에 `숫자가 아닌 값이 포함되어 있는지` 확인한다.
        - [ ] `숫자가 아닌 값`이 포함된 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 숫자만 입력할 수 있습니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 당첨 번호에 `음수`가 포함되어 있는지 확인한다.
        - [ ] `음수`가 포함된 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 당첨 번호에 `숫자 0`이 포함되어 있는지 확인한다.
        - [ ] `숫자 0`이 포함된 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 당첨 번호에 `양수이지만 범위가 1~45가 아닌 경우`가 있는지 확인한다.
        - [ ] `범위 1~45를 벗어난 숫자`가 포함된 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 당첨 번호에 `숫자가 중복되어 있는지` 확인한다.
        - [ ] 당첨 번호에 `중복된 숫자`가 있는 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 당첨 번호에 중복된 숫자가 있습니다. 중복 없이 6개의 숫자를 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 `당첨 번호의 개수가 6개 초과`인지 확인한다.
        - [ ] `당첨 번호의 개수가 6개 초과`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 당첨 번호는 6개의 숫자로 구성되어야 합니다. 초과된 숫자를 제거하고 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 `당첨 번호의 개수가 1개~5개`인지 확인한다.
        - [ ] `당첨 번호의 개수가 1개~5개`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 당첨 번호는 정확히 6개의 숫자로 구성되어야 합니다. 부족한 숫자를 추가하고 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] **그 외 경우 다음 단계를 진행한다.**

### 보너스 번호 입력값 확인
- [ ] **사용자에게 보너스 번호를 입력받는다.**
    - [ ] 입력된 문자열의 앞뒤 공백을 제거한다.
    - [ ] 입력된 문자열이 `null`인지 확인한다.
        - [ ] `null`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] null은 입력할 수 없는 값입니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 문자열이 빈 문자열(`""`)인지 확인한다.
        - [ ] `빈 문자열`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 빈 문자열은 입력할 수 없습니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 보너스 번호가 `숫자`인지 확인한다.
        - [ ] `숫자가 아닌` 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 숫자만 입력할 수 있습니다. 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 보너스 번호가 `음수`인지 확인한다.
        - [ ] `음수`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 보너스 번호가 `숫자 0`인지 확인한다.
        - [ ] `숫자 0`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 보너스 번호가 `양수이지만 범위가 1~45가 아닌 경우`가 있는지 확인한다.
        - [ ] `범위 1~45를 벗어난 숫자`가 포함된 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 `보너스 번호의 개수가 1개 초과`인지 확인한다.
        - [ ] `보너스 번호의 개수가 1개 초과`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 보너스 번호는 1개의 숫자로 구성되어야 합니다. 초과된 숫자를 제거하고 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 `보너스 번호의 개수가 1개 미만`인지 확인한다.
        - [ ] `보너스 번호의 개수가 1개 미만`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 보너스 번호는 정확히 1개의 숫자로 구성되어야 합니다. 부족한 숫자를 추가하고 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.
    - [ ] 입력된 `보너스 번호와 당첨 번호가 중복`인지 확인한다.
        - [ ] `보너스 번호와 당첨 번호가 중복`인 경우 `IllegalArgumentException`을 발생시키고 **"[ERROR] 보너스 번호는 당첨 번호와 중복이 될 수 없습니다. 당첨번호와 다른 번호를 다시 입력해 주세요."** 라는 오류 메시지를 출력한 후 다시 입력을 받는다.

### 당첨 여부 판단

- [ ] **사용자가 구매한 각 로또 번호에 대해 당첨 여부를 판단한다.**
    - [ ] 각 로또 번호와 입력된 당첨 번호 6개를 비교하여 **일치하는 숫자의 개수를 계산**한다.
    - [ ] 보너스 번호를 확인하여 **보너스 번호가 일치하는지** 판단한다.
    - [ ] **당첨 기준을 충족하는 등수를 확인**한다.
        - [ ] 1등: **6개 번호 모두 일치**
        - [ ] 2등: **5개 번호 일치 + 보너스 번호 일치**
        - [ ] 3등: **5개 번호 일치**
        - [ ] 4등: **4개 번호 일치**
        - [ ] 5등: **3개 번호 일치**
        - [ ] 그 외: **당첨되지 않음**
    - [ ] **각 등수별 당첨된 로또 개수를 기록**한다.

### 당첨 통계 출력

- [ ] **당첨 통계 출력 안내 멘트를 출력한다.**
    - [ ] "**당첨 통계**" 안내 문구를 출력한다.
    - [ ] **"---"**(구분선)을 출력한다.

- [ ] **등수별 당첨 개수를 출력한다.**
    - [ ] **1등부터 5등까지 등수별 당첨 개수를 출력한다.**
        - [ ] **등수별 당첨 금액과 일치하는 개수**를 출력 형식에 맞게 출력한다.
        - 예시:
            ```
            3개 일치 (5,000원) - 1개
            4개 일치 (50,000원) - 0개
            5개 일치 (1,500,000원) - 0개
            5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
            6개 일치 (2,000,000,000원) - 0개
            ```

- [ ] **출력 형식이 일관되도록 주의하여 출력한다.**
    - [ ] 금액은 세 자리마다 콤마(,)를 포함해 출력한다.
    - [ ] 당첨되지 않은 등수는 **"0개"**로 출력한다.

### 총 수익률 출력

- [ ] **총 수익률을 계산한다.**
    - [ ] **구매한 총 금액을 기준으로 수익률을 계산**한다.
        - [ ] **수익률 = (총 당첨 금액 / 총 구입 금액) * 100**으로 계산한다.
    - [ ] 계산된 수익률을 **소수점 둘째 자리에서 반올림**하여 표시한다.
    - [ ] **수익률이 100% 이상인 경우에도 정확히 계산된 값을 출력한다.**

- [ ] **총 수익률을 출력한다.**
    - [ ] 출력 형식에 맞게 "**총 수익률은 XX.X%입니다.**"와 같은 형태로 출력한다.
    - 예시:
        ```
        총 수익률은 62.5%입니다.
        ```


## ✅ 1,2 주차 피드백 반영 여부
- [ ]  요구 사항을 정확하게 준수한다
- [ ]  커밋 메시지를 의미 있게 작성한다
- [ ]  커밋 메시지에 이슈 또는 풀 리퀘스트 번호를 포함하지 않는다
- [ ]  풀 리퀘스트를 만든 후에는 닫지 말고 추가 커밋을 한다
- [ ]  오류를 찾을 때 출력 함수 대신 디버거를 사용한다
- [ ]  이름을 통해 의도를 드러낸다
- [ ]  축약하지 않는다
- [ ]  if, for, while문 사이의 공백도 코딩 컨벤션이다.
- [ ]  공백 라인을 의미 있게 사용한다
- [ ]  스페이스와 탭을 혼용하지 않는다
- [ ]  의미 없는 주석을 달지 않는다
- [ ]  코드 포매팅을 사용한다
- [ ]  Java에서 제공하는 API를 적극 활용한다
- [ ]  배열 대신 컬렉션을 사용한다
- [ ]  README.md를 상세히 작성한다
- [ ]  기능 목록을 재검토한다
- [ ]  기능 목록을 업데이트 한다
- [ ]  값을 하드 코딩 하지 않는다
- [ ]  상수, 멤버변수, 생성자, 메서드 순으로 작성한다
- [ ]  변수 이름에 자료형은 사용하지 않는다
- [ ]  한 메서드가 한 가지 기능만 담당하게 한다
- [ ]  메서드가 한 가지 기능을 하는지 확인하는 기준을 세운다
- [ ]  테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리한다
- [ ]  처음부터 큰 단위의 테스트를 만들지 않는다


## ✅ 과제 진행 요구 사항

- [x]  **[java-lotto-7](https://github.com/woowacourse-precourse/java-lotto-7)** 저장소를 Fork & Clone
- [x]  README.md에 구현할 기능 목록을 정리해 추가
- [ ]  완료 후 Pull Request
- [ ]  중간 회고를 진행하고 소감에 구체적인 결과를 작성해서 제출
- [ ]  제출한 후 결과 확인, 통과하지 못했다면 수정해 다시 제출

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [ ]  JDK-21 사용
- [ ]  프로그램 실행의 시작점은 `Application`의 `main()`
- [ ]  `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [ ]  [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [ ]  프로그램 종료 시`System.exit()`를 호출 X
- [ ]  프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
- [ ]  자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ]  3항 연산자를 쓰지 않는다.
- [ ]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ]  JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [ ]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ]  else 예약어를 쓰지 않는다
- [ ]  Java Enum을 적용하여 프로그램을 구현한다
- [ ]  구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.


### 라이브러리 요구 사항

- [ ]  camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
    - [ ]  Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
    - [ ]  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용 

### Lotto 클래스 요구 사항

- [ ] 제공된 Lotto 클래스를 활용해 구현
- [ ] numbers의 접근 제어자인 private를 변경 X
- [ ] Lotto에 numbers 이외의 필드(인스턴스 변수) 추가 X
- [ ] Lotto의 패키지 변경은 가능
