# java-lotto-precourse

간단한 <u>로또 발매기</u>를 구현한다.

## 기능구현목록

- **LottoStore**
- [x] 로또를 구매할 시 로또를 생성하는 기능

- **LottoNumberGenerator**
- [x] 1과 45사이의 6개의 랜덤 숫자를 생성하는 로또 생성 기능

- **WinningNumber**
- [x] 입력한 로또 번호와 보너스 번호를 저장하는 기능

- **Lotto**
- [x] 사용자가 입력한 로또 번호와 생성된 로또 번호를 맞춰보는 기능
- [x] 사용자가 입력한 보너스 번호를 로또 번호와 맞춰보는 기능

- **Calculator**
- [x] 로또 당첨 결과를 계산하는 기능

  - 결과에 해당되지 않을 경우 NONE 카테고리로 분류

- [x] 수익률을 계산하는 기능

  - 소수점 둘째 자리에서 반올림 한다.

- **LottoResult**
- [x] 로또 결과를 출력 형식에 맞춰 내보내는 기능

  - NONE 카테고리는 출력에서 분리한다.

## 예외처리

- 예외 메세지와 종류는 클래스로 따로 분리

* [x] 로또 번호가 중복되는지 체크
* [x] 보너스 번호가 로또와 중복되는지 체크
* [x] 입력된 구분자가 ,가 아닐때 체크
* [x] 문자 입력과 공백 입력 체크

## 테스트 코드 추가(11.3)

- **LottoTest**
- [x] 사용자가 입력한 로또 번호와 생성된 로또 번호를 맞춰보는 기능
- [x] 사용자가 입력한 보너스 번호를 생성된 로또 번호와 맞춰보는 기능

- **LottoStoreTest**
- [x] 생성된 로또 장수 체크 테스트
- [x] 로또 번호 범위 확인 테스트
- [x] 생성된 로또 번호 테스트
- [x] 생성된 로또 숫자의 중복 확인

- **LottoResultTest**
- [x] 출력되는 로또 결과 형식과 반환율 확인

- **CalculatorTest**
- [x] 생성된 로또 결과에 대한 카운트
