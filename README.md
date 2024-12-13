# java-lotto-precourse

### **파일 구조**

```
main
└── java
    └── lotto
    │   ├── controller
    │   │   └── MainController
    │   ├── domain
    │   │   ├── Lotto
    │   │   ├── LottoDraw
    │   │   └── LottoPrizeMap
    │   ├── enums
    │   │   ├── ErrorMessage
    │   │   ├── InputMessage
    │   │   ├── LottoPrice
    │   │   └── OutputMessage
    │   ├── service
    │   │   ├── CalculateProfitRate
    │   │   ├── LottoWinning
    │   │   └── RandomNumbersDraw
    │   ├── validate
    │   │   └── LottoValidator
    │   └── view
    │       ├── InputView
    │       └── OutputView
    └── Application
test
└── java
    ├── lotto
    │   ├── domain
    │   │   ├── LottoDrawTest
    │   │   ├── LottoPriceMapTest
    │   │   └── LottoTest
    │   ├── service
    │   │   └── CalculateProfitRateTest
    └── ApplicationTest
```
---
### **기능 목록**

- [x]  로또 구입 금액 입력
- [x]  로또 당첨 번호 입력
- [x]  로또 보너스 번호 입력
- [x]  랜덤으로 (1 ~ 45) 숫자 6개 뽑아내기
- [x]  랜덤 번호 오름차순 정렬
- [x]  로또 수량 및 번호 출력
- [x]  당첨된 로또 선별
- [x]  당첨 내역 출력
- [x]  수익률 계산
- [x]  수익률 출력
- [x]  예외 상황 시 에러 문구 출력
    - 사용자가 잘못된 값을 입력할 경우
        - [x] 로또 구입 금액
          ```
          1000원 단위로 나누어 떨어지지 않는 경우

          숫자가 아닌 경우

          음수인 경우
          ```
        - [x] 당첨 번호, 보너스 번호
          ```
          1 ~ 45 사이 값이 아닌 경우

          당첨 번호가 6개 이상 입력되는 경우

          숫자가 아닌 경우

          번호가 중복되는 경우
          ```