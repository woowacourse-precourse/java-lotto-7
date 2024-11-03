# java-lotto-precourse

## Purchase

- Domain
    - Money
        - money: long
    - Purchase
        - lottos: List<Lotto>
        - money: Money
    - PurchaseResult
        - purchase: Purchase

## Lotto

- Domain
    - LottoResult: Root
        - lotto: Lotto
        - lottoRank: LottoRank
    - Lotto
        - numbers: List<Integer>
    - Winning Lotto
        - lotto: Lotto
        - bonusNumber: Integer
- Value
    - LottoRank: Enum
## 전략
1. Validation
   1. input null 확인 - ConsoleInputHandler
   2. input type 확인 - Validator
   3. value 확인 - domain

## 생각해볼 한계 및 발전 사항

1. 각 애그리거트 간 직접 참조
2. 도메인에 null 값이 있음
3. Validation origin
4. static factory method