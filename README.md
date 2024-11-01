# java-lotto-precourse

# 🎰 로또 게임
* * *
간단한 **로또 발매기**를 구현한다.

로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
<br> <br>당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

1등: 6개 번호 일치 / 2,000,000,000
<br>
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
<br>
3등: 5개 번호 일치 / 1,500,000원
<br>
4등: 4개 번호 일치 / 50,000원
<br>
5등: 3개 번호 일치 / 5,000원
<br> <br>
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.


사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 🎯 이번 주 목표
* * *
* mvc 패턴 하에 패키지 내 클래스가 올바르게 분류돼 있는지 확인하기
* JUnit 등을 활용하여 메소드를 구현할 때마다 작은 기능 단위로 테스트 케이스 확인하기
* 무분별한 인스턴스 생성과 필드 초기화를 지양하고, this를 남발하지 않기
* 의존성 주입과 DI 관련 공부하여 반영하기
* 목적에 맞게 static, final 사용하기
* 2주차 피드백 반영하기

# 🧩 패키지 구조
* * *
```
src
└── main
    └── java
        └── lotto
            ├── controller
            ├── constant
            ├── exception
            ├── model
            ├── service
            ├── utils
            ├── validation
            ├── view
            └── Application.class

└── test
    └── java
        └── lotto
```


# 💡 구현할 기능 목록
* * *

## 입력 (Input View)
 - [ ] 로또 구입 금액 입력
 - [ ] 당첨 번호 입력 (쉼표 기준)
 - [ ] 보너스 번호 입력

## 컨트롤러 (Controller)
 - [ ] 입력 검증 (Input Validation)
 - [ ] 로또 게임 초기화 (Lotto Initialization)
 - [ ] 로또 게임 실행 (Lotto Start)

## 상수 (Constant)
- [ ] 로또 게임 상수
- [ ] 수익률 계산기 상수

## 모델 (Model)
 - [ ] 로또 결과 (Lottery Result)
 - [ ] 로또 종이 (Lotto Ticket)
 - [ ] 로또 (Lotto)
 - [ ] 로또 기계 (Lottery Machine)
 - [ ] 수익률 계산기 (Profit Calculator)

## 서비스 (Service)
 - [ ] 로또 종이 서비스 (Lotto Ticket Service)
 - [ ] 로또 기계 서비스 (Lottery Machine Service)
 - [ ] 수익률 계산기 서비스 (Profit Calculator Service)
 - [ ] 로또 결과 서비스 (Lottery Result Service)

## 검증 (Validation)
 - [ ] 로또 종이 검증
 - [ ] 로또 기계 검증
 - [ ] 수익률 계산기 검증

## 예외 처리 (Exception)
 - [ ] 예외 부모 클래스
 - [ ] 로또 게임 예외
 - [ ] 수익률 게산기 예외

## 유틸 (Utils)
 - [ ] 랜덤 번호 제공

## 출력 (Output View)
 - [ ] 발행한 로또 수량 출력
 - [ ] 발행한 로또 수량만큼의 로또 번호 오름차순으로 출력
 - [ ] 당첨 내역 출력
 - [ ] 소수점 둘째 자리에서 반올림한 수익률 출력