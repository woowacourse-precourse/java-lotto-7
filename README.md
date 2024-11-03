# java-lotto-precourse

## 📖 애플리케이션 소개
### 개요
이 애플리케이션은 간단한 로또 발매기입니다. 사용자가 로또 구입 금액을 입력하면, 해당 금액에 맞게 로또를 발행합니다.  
이후 당첨 번호와 보너스 번호를 입력하면, 당첨 여부와 당첨 금액에 대한 정보를 제공합니다.  
마지막으로, 사용자의 당첨 통계와 수익률 정보를 확인할 수 있으며 애플리케이션은 종료됩니다.  

### 추가 설명
- 지불 금액은 1000원 단위로 한정됩니다.
- 1000원당 로또 한 장이 발행됩니다.
- 로또 발행 수는 입력한 금액을 1000으로 나눈 값으로 자동 결정되며 수량은 선택할 수 없습니다.
- 당첨 번호와 보너스 번호는 1에서 45 사이의 숫자입니다.
- 수익률 계산 방법은 (총 당첨 금액 ÷ 총 구매 금액) × 100 입니다.
- 1등부터 5등까지의 당첨 기준 및 당첨 금액:  
1️⃣등: 6개 번호 일치 / 2,000,000,000원  
2️⃣등: 5개 번호 + 보너스 번호 일치 / 30,000,000원  
3️⃣등: 5개 번호 일치 / 1,500,000원  
4️⃣등: 4개 번호 일치 / 50,000원  
5️⃣등: 3개 번호 일치 / 5,000원  

## 📝 기능 목록
1. 구입 금액 입력 받기
    - **예외처리**: 숫자가 아닐 경우 
    - **예외처리**: 자연수가 아닐 경우  
    - **예외처리**: 1000으로 나누어 떨어지지 않을 경우
2. 구입한 로또 수량 출력  
3. 발행한 로또 모두 차례대로 출력
4. 당첨 번호 입력 
    - **예외처리**: 숫자가 아닐 경우  
    - **예외처리**: 자연수가 아닐 경우  
    - **예외처리**: 당첨 번호의 개수가 7개 아닐 경우  
    - **예외처리**: 1과 45사이의 자연수가 아닐 경우 
    - **예외처리**: 중복이 있을 경우  
5. 보너스 번호 입력  
    - **예외처리**: 숫자가 아닐 경우  
    - **예외처리**: 자연수가 아닐 경우  
    - **예외처리**: 1과 45사이의 자연수가 아닐 경우 
    - **예외처리**: 당첨 번호들과 중복이 있을 경우   
4. 당첨 내역 출력
5. 수익률 출력 

## 🧮 Use Case 시나리오
### 기본 흐름

| **단계** | **로또 발매기 애플리케이션**                            |
|---------|------------------------------------|
| 1       | 시스템이 구입 금액을 입력 받기 위한 텍스트를 디스플레이한다. |
| 2       | 사용자가 구입 금액을 입력한다. |
| 3       | 시스템이 사용자가 구입한 로또의 수량을 디스플레이한다. |
| 4       | 시스템이 각 로또를 중복되지 않는 6개의 숫자로 발행한다. |
| 5       | 시스템이 각 로또를 오름차순으로 정렬한다. |
| 6       | 시스템이 발행한 로또 모두 차례대로 디스플레이한다. |
| 7       | 사용자가 당첨 반호를 입력한다. |
| 8       | 사용자가 보너스 반호를 입력한다. |
| 9       | 시스템이 사용자가 구매한 로또 번호와 당첨/보너스 번호를 비교한다. |
| 10      | 시스템이 사용자의 당첨 내역을 계산한다. |
| 11      | 시스템이 사용자의 당첨 내역을 디스플레이한다. |
| 12      | 시스템이 사용자의 수익률을 계산한다. |
| 13      | 시스템이 사용자의 수익률을 디스플레이한다. |


### 대체 흐름 및 예외 흐름

| **조건**                   | **시스템 반응**                                       |
|--------------------------|-----------------------------------------------------|
| 입력된 구입 금액이 자연수가 아닐 경우   | 사용자에게 구입 금액 입력을 다시 요청한다.   |
| 입력된 구입 금액이 1000으로 나누어 떨어지지 않을 경우   | 사용자에게 구입 금액 입력을 다시 요청한다.    |
| 발행된 로또 번호가 1과 45사이의 자연수가 아닐 경우   | 로또를 다시 발행한다.    |
| 발행된 로또 번호의 개수가 6개 아닐 경우   | 로또를 다시 발행한다.    |
| 발행된 로또 번호 중에 중복이 있을 경우   | 로또를 다시 발행한다.    |
| 입력된 보너스 번호를 포함한 당첨 번호가 1과 45사이의 자연수가 아닐 경우   | 사용자에게 당첨 번호부터 입력을 다시 요청한다.    |
| 입력된 보너스 번호를 포함한 당첨 번호의 개수가 7개 아닐 경우 | 사용자에게 당첨 번호부터 입력을 다시 요청한다.    |
| 입력된 보너스 번호를 포함한 당첨 번호 중에 중복이 있을 경우 | 사용자에게 당첨 번호부터 입력을 다시 요청한다.    |

## Use Case  다이어그램
<img src="https://github.com/user-attachments/assets/72a146d8-d402-49ed-b37a-74c5fa5fbf9e" alt="미션3_유스케이스_다이어그램" width="400"/>
 
## 🆙 확장 가능성 고려 사항
1. 로또 가격 변경
2. 보너스 번호 수 증가
3. 수익률 계산 방식 변경
