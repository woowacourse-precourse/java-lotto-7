# 🎰 프리코스 3주차 미션 - 로또
## 🔍 목차
- [기능 요구사항](#기능-요구-사항)
- [폴더 구조](#폴더-구조)
- [구현한 기능 목록](#구현한-기능-목록)
- [생각의 흐름](#생각의-흐름)

## 📝 기능 요구 사항

간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  | 당첨 등수 | 조건                         | 상금            |
  | ---------- | --------------------------- | --------------- |
  | 1등        | 6개 번호 모두 일치          | 2,000,000,000원 |
  | 2등        | 5개 번호 + 보너스 번호 일치 | 30,000,000원    |
  | 3등        | 5개 번호 일치               | 1,500,000원     |
  | 4등        | 4개 번호 일치               | 50,000원        |
  | 5등        | 3개 번호 일치               | 5,000원         |

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - `Exception`이 아닌`IllegalArgumentException`,`IllegalStateException`등과 같은 명확한 유형을 처리한다.
## 📂 폴더 구조
## ✅ 구현한 기능 목록
### 1. 로또 구입 금액 입력
- [x] 유효하지 않은 경우 IllegalArgumentException 발생 후 재입력
### 2. 로또 번호 생성
  - [x] 구입 금액만큼 로또를 발행한다
  - [x] 번호는 1 ~ 45 범위 내에서 생성되어야 한다
  - [x] 하나의 로또에 6개의 번호가 포함된다
    - [x] 각 번호는 중복되지 않는다
### 3. 구매한 로또 번호 출력
  - [x] 로또 번호는 오름차순으로 출력한다
  - [x] 한 줄에 하나의 로또를 출력한다
  - [x] 각 번호는 쉼표`,`로 구분한다
  - [x] 한 줄의 시작과 끝은 대괄호`[]`로 구분한다
### 4. 당첨 번호와 보너스 번호 입력

### 5. 당첨 유무 확인
### 6. 당첨 통계 출력
  - [x] 3개 ~ 6개의 번호가 일치하는 경우에 대해 출력한다
  - [x] 일치하는 로또의 개수를 출력한다
### 7. 수익률 계산
### 8. 당첨 금액 계산

## ⚠️ 예외 검증
- [x] 유효하지 않은 경우 IllegalArgumentException 발생 후 재입력
### 당첨 번호와 보너스 번호 예외
- [x] 당첨/보너스 번호 입력
- [x] 중복 검증
- [x] 개수 검증
- [x] 숫자가 아닌 문자 검증
- [x] 범위 검증
- [x] 정수 검증
### 로또 구입 금액 예외
- [x] 0원 이하의 금액 검증
- [x] 1000원으로 나누어 떨어지지 않는 금액 검증
- [x] 숫자가 아닌 문자 검증
- [x] 정수 검증

## 🤔 생각의 흐름
