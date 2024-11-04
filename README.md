# java-lotto-precourse

## 기능 구현 목록
- 로또 구입 금액 입력
  - 사용자는 로또 구입 금액을 입력할 수 있다.
  - 구입 금액은 1,000원 단위로 입력해야 한다.
    - 입력 예외
      - 구입금액이 1,000원으로 나누어떨어지지 않으면 예외를 발생시키고 재입력을 받도록 한다.
      - 숫자 형식이 아닐경우 예외를 발생시키고 재입력을 받는다.

- 로또 발행
  - 구입 금액에 따라 발행할 로또 수량을 계산하도록 한다.(1개당 1,000원)
  - 각 로또마다 다음을 수행한다.
    - 로또 번호는 중복되지 않는다.
    - 로또 번호는 1부터 45 사이의 숫자여야 한다.
    - 로또 번호는 정확히 6개여야 한다.
    - 로또 번호를 오름차순으로 정렬한다.
  - 구매한 로또 수량과 각 로또 번호를 출력한다.
    - 출력 형식:
      예시: [1, 5, 13, 23, 34, 45]

- 당첨 번호 입력
  - 사용자는 당첨번호 6개를 입력한다.
  - 당첨 번호는 쉼표로 구분된 1부터 45사이 숫자중 중복되지 않은 숫자 6개를 입력받아 사용한다.
    - 입력 예외 상황이 발생하면 예외를 발생시키고 재입력을 받도록 한다.
      - 당첨번호의 구분자는 쉼표여야한다.
      - 당첨번호는 정확히 6개 여야 한다.
      - 중복된 숫자가 없어야 한다.
      - 1~45사이 숫자여야한다.

- 보너스 번호 입력
    - 사용자는 보너스 번호 1개를 입력한다.
    - 보너스 번호는 1부터 45사이 숫자중 단일 번호 1개를 입력받아 사용한다.
        - 입력 예외 상황이 발생하면 예외를 발생시키고 재입력을 받도록 한다.
            - 보너스 번호는 당첨번호와 중복되지 않아야한다.
            - 1~45사이 숫자여야 한다.
            - 보너스 번호는 정확히 단일 번호여야 한다.

- 당첨 결과 계산
  - 발행한 각 로또 번호를 당첨 번호와 비교해 일치 여부를 계산한다.
  - 보너스 번호와 일치 여부를 확인하여 계산한다.
  - 각 로또에 대한 당첨 등수를 당첨 기준에 따라 결정한다.

- 당첨 내역 출력
  - 당첨 등수별로 발행된 로또의 개수를 집계한다.
  - 당첨 내역을 출력한다.
    - 당첨 기준을 기준으로 일치한 번호 개수, 상금, 발행 로또중 당첨된 로또 개수를 출력한다.
    - 출력 형식 :
      예시: 3개 일치 (5,000원) - 1개
      4개 일치 (50,000원) - 0개
      5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
      6개 일치 (2,000,000,000원) - 0개


- 수익률 계산 및 출력
  - 총 당첨 상금을 계산한다.
  - 수익률을 계산한다.(총 당첨상금 / 구입금액) * 100%
  - 수익률은 소수점 첫째 자리까지 반올림한다.
  - 총 수익률을 출력한다.
    - 출력 형식: 총 수익률은 62.5%입니다.



## 리팩토링 구현 목록
- 유효성 검사 로직 리팩토링
  - 인터페이스와 팩토리를 활용하여 상황별 유효성 검사 로직을 개선하고 코드 재사용성을 높임.
- 에러 메시지 관리
  - 에러 메시지를 ErrorMessages 클래스로 관리하여 중앙 집중화 및 일관성 유지.
- 구조 리팩토링
  - 절차지향적으로 작성된 프로젝트의 전체적인 구조를 리팩토링하여 객체지향적으로 리팩토링 하여 코드 가독성 및 유지보수성을 향상.

