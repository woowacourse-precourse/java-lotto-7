# java-lotto-precourse

## Diagrams

### System Sequence

```mermaid
sequenceDiagram
    actor U as User
    participant S as LottoShop
    rect rgb(1, 1, 0, 0.2)
        note right of U: Step 1 - 로또 구매
        U ->>+ S: sell_lotto
        S -->> U: money_asking_message
        U -->> S: money
        S -->>- U: issued_lotteries
    end

    rect rgb(1, 1, 0, 0.2)
        note right of U: Step 2 - 결과 추첨
        U ->>+ S: draw
        S -->> U: winning_numbers_asking_message
        U -->> S: winning_numbers
        S -->> U: bonus_number_asking_message
        U -->> S: bonus_number
        S -->> U: lotteries_result
        S -->>- U: profit_rate
    end
```

### Domain Architecture

![domain_architecuture.png](https://private-user-images.githubusercontent.com/33625132/382645625-a5df0b00-a895-4432-bc69-2cd9080e4182.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MzA2OTcwODAsIm5iZiI6MTczMDY5Njc4MCwicGF0aCI6Ii8zMzYyNTEzMi8zODI2NDU2MjUtYTVkZjBiMDAtYTg5NS00NDMyLWJjNjktMmNkOTA4MGU0MTgyLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDExMDQlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQxMTA0VDA1MDYyMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTA4NzFjMGVmMWViZmJjYTNlNzVkYzM1ZTU4NWI1ZjE5NzQ3YzA4ZjIzZGI2NmUxOGE5NzQ3ZmU4YjQ3ZmZhZjkmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.S5EkKXZC19QmaHCTTOy9XPOKnoBpmxz4qgHQSXDjoqM)

### Composition

![composition.png](https://private-user-images.githubusercontent.com/33625132/382642987-e45fa7d2-b224-4154-aea8-c10923bacaff.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MzA2OTY1NTMsIm5iZiI6MTczMDY5NjI1MywicGF0aCI6Ii8zMzYyNTEzMi8zODI2NDI5ODctZTQ1ZmE3ZDItYjIyNC00MTU0LWFlYTgtYzEwOTIzYmFjYWZmLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDExMDQlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQxMTA0VDA0NTczM1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTM4ODIyYTZmZDA2Yzg2NDQ2MDYwNDg2MWE0MWFkNTY1MWJlZjNmNmExYzY1ZDUwYjE2NTAzMTYwNWU5ZWY0NDcmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.o7L-YO5JHRAeyTFhaiqi59PUGby2HUUpGq1yD7BrB9M)

## 기능 요구사항

> 입력에 문제가 있으면 **해당 지점**부터 다시 입력받는다.

### 로또 구매 및 발행

- [x] 로또 숫자는 [1, 45] 범위만 가능하다.
- [x] 로또는 6개의 숫자로 이루어진다.
- [x] 로또는 중복 숫자를 가지지 않는다.
- [x] 로또는 숫자를 정렬하여 저장한다.
- [x] 로또 가격은 1,000원이다.
- [x] 지불한 금액만큼 로또를 발급한다.

### 로또 추첨

- [x] 로또 당첨 번호는 [1, 45] 범위만 가능하다.
- [x] 로또 당첨 번호는 6개의 숫자로 이루어진다.
- [x] 로또 당첨 번호는 중복 숫자를 가지지 않는다.
- [x] 보너스 번호는 [1, 45] 범위만 가능하다.
- [x] 보너스 번호는 당첨 번호와 중복되지 않는다.

### 상금 및 수익률 계산

- [x] 로또 당첨 번호와 보너스 번호를 비교하여 등수를 계산한다.
- [x] 상금은 다음과 같다.
    - 1등: 6개 일치
    - 2등: 5개 일치 + 보너스 번호 일치
    - 3등: 5개 일치
    - 4등: 4개 일치
    - 5등: 3개 일치
    - 꽝: 그 외
- [x] 수익률은 다음과 같다.
    - 수익률 = 총 상금 / 총 구매 금액
- [x] 수익률은 소수점 둘째 자리에서 반올림하여 첫째자리까지 표시한다.
