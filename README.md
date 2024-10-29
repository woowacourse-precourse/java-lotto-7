# 🎲 로또 발매기 프로젝트

## 프로젝트 개요
**로또 발매기 프로젝트**는 Java를 활용해 개발한 **로또 발매기 프로그램**입니다. 사용자가 금액을 입력하여 로또 티켓을 구입하고, 당첨 번호와 비교하여 당첨 내역과 수익률을 확인할 수 있습니다. 이 프로그램은 **로또 발행, 당첨 번호 추첨, 당첨 확인, 수익률 계산**까지 로또 발매기의 핵심 기능을 포함하고 있습니다.

---

## 📌 기능 요구 사항

### 1. 사용자 입력

- **로또 구입 금액 입력**  
- **당첨 번호 6개 입력**
- **보너스 번호 1개 입력**

### 2. 로또 발매기
- **발행 수량 계산**: 사용자가 입력한 금액에 따라 발행할 로또 장 수를 계산합니다.  
- **로또 티켓 발행**: 계산된 수량에 맞춰 로또 티켓을 발행합니다.

### 3. 로또 티켓
- **번호 생성**: 로또 한 장당 1~45 범위의 중복되지 않는 6개의 번호를 생성합니다.

### 4. 수익률 계산기
- **당첨 내역을 통해 수익 계산 및 수익률 계산**

### 5. 출력
- **발행한 로또 수량 및 번호 출력**
- **당첨 내역 출력**
- **총 수익률 출력**

---

## ⚠️ 예외 처리

1. **로또 구입 금액**  
    - 1,000원 단위로 입력받으며, 1,000으로 나누어 떨어지지 않으면 예외 발생  
    - 숫자로만 이루어져야 함

2. **로또 번호 및 보너스 번호**  
    - 숫자 범위: 1~45  
    - 중복 번호 금지  
    - 소수점 포함 불가  
    - 공백 또는 null 값 허용하지 않음  
    - 문자가 포함될 수 없음  

---
