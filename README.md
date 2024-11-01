# 로또
**간단한 로또 발매기를 구현**<br>
**로또 번호의 숫자 범위는 1~45이다**<br>
**당첨은 1등부터 5등까지 존재**<br>
**로또 하나의 가격은 1000원이고, 사용자가 입력한 금액 만큼의 로또를 발행**<br>
**사용자가 당첨번호 6개와 보너스 번호 1개 입력**<br>
**사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료**<br>
**사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생**

## 프로그래밍 요구 사항

1. **Indent Depth 제한**
    - 들여쓰기 깊이(indent depth)는 2까지만 허용
    - 예: `while` 문 안에 `if` 문이 있으면 들여쓰기는 2이다

2. **복잡성 줄이기**
    - Indent depth를 줄이기 위해 함수(또는 메서드)를 분리해 사용
    - 삼항 연산자는 사용하지 않는다

3. **함수의 단일 책임 원칙**
    - 함수(또는 메서드)는 한 가지 일만 하도록 최대한 작게 만들 것

4. **JUnit 5와 AssertJ 활용**
    - 정리된 기능 목록이 제대로 작동하는지 테스트 코드로 확인
5. **Java Enum을 적용하여 프로그램을 구현**

6. **구현한 기능에 대한 단위 테스트를 작성**

## 기능 요구 사항

1. **사용자 입력 받기**
    - [ ] 구입하고 싶은 금액 입력
        - [ ] 금액은 1000원 단위로 입력
    - [ ] 당첨 번호 6개와, 보너스 번호 1개 입력
        - [ ] 로또 번호는 중복되지 않아야 하며, 보너스 번호는 따로 입력 받는다.
2. **출력**
    - [ ] 구매한 로또 번호 출력
        - [ ] 구매한 로또의 개수 출력
        - [ ] 구매한 로또 번호는 오름차순으로 정렬후 출력
    - [ ] 당첨 내역 출력
        - [ ] 특정 개수 일치 항목 출력하기
    - [ ] 수익률 출력
        - [ ] 수익률은 소수점 둘째 자리에서 반올림
3. **예외 처리**
    - [ ] 모든 예외 상황 시 에러 문구를 출력
      - [ ] 에러 문구는 `[ERROR]`로 시작
    - [ ] 로또 구입 금액 입력시 1000원 단위가 아닐 시 
    - [ ] 로또 번호 입력 시 1 ~ 45 사이의 숫자가 아닐 시
    - [ ] 중복된 로또 번호가 있을 시
    - [ ] 구입 금액 입력할 때 정수가 아닌 문자가 입력 시
    - [ ] 로또 번호 입력 시 정수가 아닌 문자가 입력 시
