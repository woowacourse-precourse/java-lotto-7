# java-lotto-precourse

# 로또 발매기 기능 목록

## 1. 로또 발매기 초기 설정

- 로또 발매를 위해 필요한 기능과 클래스 정의
- 당첨 기준과 상금 설정

## 2. 입력 기능

- 로또 구입 금액 입력
    - 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
- 당첨 번호 입력
    - 쉼표(,)로 구분하여 6개의 번호 입력받기
- 보너스 번호 입력
    - 당첨 번호와 중복되지 않는 1개의 번호 입력받기

## 3. 로또 번호 생성 및 관리

- 로또 번호 생성 기능 구현
    - 1에서 45 사이의 중복되지 않는 6개 숫자 생성
    - 로또 번호 오름차순 정렬
- 구매한 로또 수량에 맞춰 로또 발행
    - 구입 금액에 따른 발행 수량 결정
- 발행한 로또 수량 및 번호 출력

## 4. 당첨 번호 비교 및 결과 계산

- 사용자가 구매한 로또 번호와 당첨 번호 비교
- 당첨 내역 생성 및 수익률 계산
    - 당첨 조건: 1등부터 5등까지의 기준과 상금 설정에 따라 당첨 결과 도출
    - 수익률은 소수점 둘째 자리에서 반올림하여 출력

## 5. 예외 처리

- 잘못된 입력값에 대한 예외 처리
    - 로또 구입 금액, 당첨 번호 및 보너스 번호 입력에 대한 유효성 검증
    - `IllegalArgumentException`과 같은 명확한 예외 유형 처리
    - [ERROR]로 시작하는 에러 메시지 출력 및 입력 재시도

## 6. 테스트

- 주요 기능에 대한 단위 테스트 작성
    - 입력 기능 테스트
    - 로또 번호 생성 및 당첨 비교 테스트
    - 예외 상황 테스트 (예외 발생 및 에러 메시지 확인)

---
# 로또 발매기 - 단위 테스트 목록

## 1. `LottoServiceTest`
`LottoServiceTest` 클래스는 로또 발행과 구입 금액에 따른 예외 처리 기능을 검증합니다.

- **테스트 케이스 목록**:
  - **구입_금액이_1000원_단위가_아니면_예외_발생**
    - 구입 금액이 1,000원 단위가 아니면 `IllegalArgumentException`이 발생해야 합니다.
  - **구입_금액에_맞게_로또_티켓_발행**
    - 구입 금액에 따라 올바른 수량의 로또 티켓이 발행됩니다. 예: 5,000원을 입력하면 5개의 티켓이 발행되어야 합니다.

---

## 2. `LottoTicketTest`
`LottoTicketTest` 클래스는 로또 티켓의 유효성을 검증하고, 올바른 로또 번호 구성을 확인합니다.

- **테스트 케이스 목록**:
  - **로또번호_개수가_6개가_아니면_예외_발생**
    - 로또 번호 리스트가 6개가 아니면 `IllegalArgumentException`이 발생해야 합니다.
  - **로또번호에_중복이_있으면_예외_발생**
    - 로또 번호 리스트에 중복이 있는 경우 예외가 발생해야 합니다.

---

## 3. `WinningLottoTest`
`WinningLottoTest` 클래스는 당첨 번호와 보너스 번호 관련 유효성 및 당첨 번호 생성 기능을 검증합니다.

- **테스트 케이스 목록**:
  - **보너스번호가_당첨번호와_중복되면_예외_발생**
    - 보너스 번호가 당첨 번호와 중복되는 경우 `IllegalArgumentException`이 발생해야 합니다.
  - **정상적인_당첨번호와_보너스번호_설정**
    - 당첨 번호와 보너스 번호가 유효하게 설정되면, `WinningLotto` 객체가 정상적으로 생성됩니다.

---

## 4. `LottoResultDtoTest`
`LottoResultDtoTest` 클래스는 당첨 결과에 대한 정보를 담은 DTO를 검증합니다. 당첨 내역과 각 등급의 당첨 횟수를 올바르게 반환하는지 확인합니다.

- **테스트 케이스 목록**:
  - **당첨_결과_DTO_올바른_당첨_내역_반환**
    - DTO가 정확한 당첨 결과를 반환합니다. 각 등급별로 맞는 당첨 횟수를 제공해야 합니다.

---

## 5. `ProfitCalculatorTest`
`ProfitCalculatorTest` 클래스는 총 투자 금액과 당첨 금액을 통해 수익률을 계산하는 기능을 검증합니다.

- **테스트 케이스 목록**:
  - **수익률_계산**
    - 총 투자 금액과 당첨 금액을 통해 수익률이 정확하게 계산되어야 합니다. 예: 투자 금액이 5000원이고 당첨 금액이 2500원이면, 수익률은 50.0%입니다.

---