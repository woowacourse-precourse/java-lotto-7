# 🎰로또 발매기
사용자에게 로또를 발행하고, 당첨 번호를 입력받아 당첨 결과를 출력하는 로또 발매기입니다. 구입 금액에 따라 여러 개의 로또 번호를 생성하며, 발행한 로또 번호와 당첨 번호를 비교하여 당첨 내역과 수익률을 제공합니다.

## 동작 과정
1. `Application` 클래스를 실행해 프로그램을 시작합니다. 
2. 구매 금액을 1,000원 단위로 입력하고, 발행된 로또 번호를 확인합니다.
3. 당첨 번호와 보너스 번호를 입력하여 당첨 결과를 확인합니다.
4. 등수 별 당첨 개수와 총 수익률을 확인합니다.

## 패키지 구조
```
📦lotto
┣ 📂controller
┃ ┗ 📜LottoController.java
┣ 📂domain
┃ ┗ 📜Lotto.java
┣ 📂enums
┃ ┣ 📜Constants.java
┃ ┣ 📜ExceptionMessage.java
┃ ┣ 📜Message.java
┃ ┗ 📜Rank.java
┣ 📂service
┃ ┗ 📜LottoService.java
┣ 📂util
┃ ┣ 📜RandomUtil.java
┃ ┗ 📜Validator.java
┣ 📂view
┃ ┣ 📜InputView.java
┃ ┗ 📜OutputView.java
┗ 📜Application.java
```
- `LottoController`: 사용자 입력과 출력을 관리하며 로또 발매기의 전체 흐름을 제어합니다.
- `Lotto` : 로또 객체를 정의하는 클래스입니다. 로또의 발행 번호를 저장하고 당첨 번호와 보너스 번호와 일치 여부를 반환합니다.
- `Constants` : 로또 번호의 최소/최대와 같은 상수 값을 관리합니다.
- `ExceptionMessage` : 예외 상황에서 사용하는 메시지를 관리합니다.
- `Message` : 일반적인 출력 메시지를 관리합니다.
- `Rank` : 당첨 등수에 대한 정보를 관리하며 당첨 여부에 따라 등수를 반환합니다.
- `LottoService` : 로또 발매기에 필요한 로직을 처리합니다. 로또를 발행하며, 등수와 수익률을 처리합니다.
- `RandomUtil` : 로또 번호에 해당하는 랜덤 숫자를 생성합니다.
- `Validator` : 입력값의 유효성을 검사하여 잘못된 입력 시 `IllegalArgumentException`을 발생시킵니다.
- `InputView`, `OutputView` : 콘솔 입출력을 담당합니다.
- `Application` : `LottoController`를 호출하여 애플리케이션을 시작하는 메인 클래스입니다.

## 기능 목록
- 로또 구입 금액 입력 및 유효성 검사
  - [x] 로또 구입 금액 입력
  - [x] 구입 금액 1,000원 단위 유효성 검사
  - [x] 구입 금액만큼 로또 번호 생성
- 당첨 번호 입력 및 유효성 검사
  - [x] 당첨 번호 입력
  - [x] 당첨 번호 쉼표 구분 저장
  - [x] 보너스 번호 입력
  - [x] 모든 번호 1~45 사이 유효성 검사 
  - [x] 당첨 번호와 보너스 번호 중복 검사
- 로또 당첨 확인
  - [x] 로또 번호와 당첨 번호 일치 개수 카운트
  - [x] 보너스 번호 포함 여부 확인
- 당첨 내역 및 수익률 관리
  - [x] 발행한 로또의 등수 저장
  - [x] 당첨금 계산
  - [x] 수익률 계산 (소수점 둘째 자리 반올림)
- 출력 형식
  - [x] 구입한 로또 번호 출력
  - [x] 각 등수별 당첨 개수 출력
  - [x] 총 수익률을 출력
- 예외 처리
  - [x] 잘못된 입력값 `IllegalArgumentException` 예외 처리
  - [x] 에러 메시지 출력 후 입력 재시도