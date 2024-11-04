# java-lotto-precourse

## 기능 목록
### 입력
- [x] 구입 금액 입력 기능
  - [x] 구입 금액 입력 메시지 출력 <br>
    ➡️ "구입금액을 입력해 주세요."
  - [x] 예외 처리
    - [x] 1,000으로 나누어 떨어지지 않으면 오류 발생 <br>
      ➡️ "[Error] 로또 구입 금액은 1000원 단위로 입력해주세요."
    - [x] 구입 금액이 숫자가 아닐 때 오류 발생 <br>
      ➡️ "[Error] 로또 구입 금액은 숫자로 입력해주세요."
    - [x] 구입 금액이 양수가 아닐 때 오류 발생 <br>
      ➡️ "[Error] 로또 구입 금액은 양수로 입력해주세요."
    - [x] 구입 금액을 입력 하지 않았을 때 오류 발생 <br>
      ➡️ "[Error] 구입금액을 입력해 주세요."
- [x] 당첨 번호 입력 기능
    - [x] 당첨 번호 입력 메시지 출력 <br>
    ➡️ "당첨 번호를 입력해 주세요."
    - [x] 당첨 번호가 모두 숫자인지 검증 <br>
    ➡️ "[Error] 로또 구입 금액은 숫자로 입력해주세요."
- [x] 보너스 번호 입력 기능
  - [x] 보너스 번호 입력 메시지 출력 <br>
    ➡️ "보너스 번호를 입력해 주세요."
  - [x] 보너스 번호가 숫자인지 검증
### 로또
- [x] 중복 되지 않은 6개의 숫자 생성 기능
  - 중복 시 예외발생
  - 6개가 아닐 때 예외발생
- [x] 로또 수량 구하기 기능
- [x] 로또 생성 기능
- [x] 로또 번호 오름차순으로 정렬 기능
### 당첨 번호
- [x] 당첨 번호 생성 기능
  - [x] 당첨 번호 검증 기능
    - [x] 당첨 번호가 6개인지 검증
    - [x] 6개의 숫자가 중복되지 않은 숫자인지 검증
- [x] 로또 번호와 당첨 번호 비교 기능
- [x] 당첨 내역 개수 구하기 기능
- [x] 수익률 구하기 기능
  - 소수점 둘째 자리에서 반올림
### 출력
- [x] 구매 개수 출력 기능 <br>
  ➡️ "구입금액을 입력해 주세요." 
- [x] 로또 번호 출력 기능
  - 로또 개수만큼 출력
- [ ] 당첨 통계 출력 기능
- [ ] 일치 항목 출력 기능
- [ ] 총 수익률 출력 기능
