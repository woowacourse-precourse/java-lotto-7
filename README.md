# java-lotto-precourse

## 프로젝트 설명

> 아래의 기능 요구사항을 충족하는 간단한 `로또 발매기 프로그램`입니다.

### 입력

- [x] 로또 구입 금액 입력
- [x] 당첨 번호 입력

### 출력

- [x] 구입 수량 출력
- [x] 발행 로또 번호 오름차순 출력
- [x] 당첨 내역 출력
- [x] 수익률 출력 _(소수점 둘째자리 반올림)_

### 로또 발행기 기능

- [x] 발행된 N개의 로또 번호마다 순위를 계산한다.
- [x] 발행된 N개의 로또 번호마다 당첨 금액을 계산한다.
- [x] **당첨 금액**과 **구입 금액**을 통해 **수익률**을 계산한다.
  - `수익률(%) = (총 상금 / 구입 금액) X 100`

### 예외

- [x] `1,000`원 단위의 금액이 아닌 경우
- [x] 당첨 번호 입력 형식을 지키지 않은 경우
  - [x] 콤마(`,`)를 기준으로 파싱할 수 없는 경우
  - [x] 공백이 포함된 경우 _(ex. `1,,2`)_
  - [x] 로또 숫자 범위(`1 ~ 45`)를 벗어난 숫자가 포함된 경우
  - [x] 정수가 아닌 값이 포함된 경우
  - [x] 중복된 값이 존재하는 경우
- [x] 보너스 번호 입력 형식을 지키지 않은 경우
  - [x] 공백이 입력된 경우
  - [x] 로또 숫자 범위(`1 ~ 45`)를 벗어난 숫자가 입력된 경우
  - [x] 정수가 아닌 값이 입력된 경우
  - [x] 당첨 번호와 중복되는 숫자가 입력된 경우

### 추가 예외

- [ ] 입력 제한
  - [ ] 로또 구입 가능 수량은 최대 **50개**로 제한한다. _(`구입 금액 <= 50 X 1000 원`)_

### 기타

- [x] 예외 메시지 포맷 - `[ERROR]`로 시작하는 문구를 출력한다.

## 프로젝트 목표

> 지난 과제에서는 **아키텍처 설계**에 집중해서 진행했습니다.  
> 이번 과제에서는 아래 항목들을 스스로 고민하면서 진행하는 것을 목표로 설정했습니다.

- `TDD`를 적용하며 _"테스트하기 쉬운 코드"_ 에 대해 고민한다.
- `OOP` 기본 개념에 집중하며 리팩토링한다.
  - 특히, 이번에는 `불변성`에 대해서도 학습하고 적용해본다.
- 각 객체마다 `단일 책임 원칙`이 잘 지켜지고 있는지 점검한다.
- 도메인의 **상태**와 **로직**의 `응집도`를 점검한다.

## 코드리뷰 반영하기

- [x] `VO` 도입

  - 불변성 유지
  - 요구사항과 결합된 값

- [x] validation 분리

  - 요구사항과 강하게 결합되지 않은, 기초적인 검증 과정은 별도의 서비스로 분리한다.

- [x] `UseCase` 네이밍

  - 각각의 UseCase는 비즈니스 로직을 나타낸다.

- [x] 변수명에 자료형을 쓰지 않는다.

- [x] 에러 메시지 상수화
