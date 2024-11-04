# java-lotto-precourse

---

<br/>

## 프로그램 소개

---

이 프로그램은 **간단한 로또 발매기** 입니다!  
각 로또는 **1000**원이며, 입력한 금액 만큼의 로또를 발매하실 수 있습니다.  
당첨 번호와 보너스 번호를 직접 입력하여 발매된 로또의 당첨 통계와 총 수익률을 확인하실 수 있습니다.  
만약 잘못된 입력을 하셨을 경우 그 이유에 대한 메시지를 확인하시고 다시 입력해주시기 바랍니다.


<br/>

## 기능 목록

---

#### 로또 구매

- 구입 금액 입력
    - 구입 금액 입력 안내 문장 출력
    - 구입 금액 입력
    - 사용자가 입력한 금액 검증
- 구매 가능한 로또 갯수 계산
    - 사용자가 구입한 금액으로 구매 가능한 로또의 갯수 계산
- 구매한 갯수만큼 로또 저장
    - 구매한 갯수만큼 로또 번호 생성
    - 생성된 로또 저장
- 구매한 로또 번호 출력
    - 구매한 로또 번호 전체 출력

#### 당첨 번호 등록

- 당첨 번호 입력
    - 당첨 번호 입력 안내 문장 출력
    - 당첨 번호 입력
    - 당첨 번호 검증
- 보너스 번호 입력
    - 보너스 번호 입력 안내 문장 출력
    - 보너스 번호 입력
    - 보너스 번호 검증
- 당첨 번호 저장
    - 당첨 번호에 보너스 번호 추가
    - 당첨 번호 저장

#### 당첨 내역 확인

- 당첨 등수 계산
    - 구매한 각 로또의 당첨 등수 계산
- 구매한 로또의 당첨 통계 출력
    - 구매한 모든 로또의 당첨 금액 통계
    - 당첨 통계 출력
- 총 수익률 출력
    - 구매한 로또의 총 수익률 계산
    - 총 수익률 출력

<br/>

### 예외 상황

---

- 입력
    - 구입 금액
        - 입력된 값이 양의 정수가 아닌 경우
        - 최소 입력 단위보다 작은 단위가 입력된 경우
        - 최대 입력 금액보다 큰 값인 경우
        - 입력 금액이 로또 가격보다 작은 값인 경우
    - 당첨 번호
        - 구분자를 기준으로 구분된 값이 양의 정수가 아닌 경우
        - 입력된 번호가 로또 번호의 범위에서 벗어난 경우
        - 입력된 번호의 수가 가능한 로또 번호의 수와 다른 경우
        - 입력된 번호 중 중복된 번호가 있는 경우
    - 보너스 번호
        - 입력된 값이 양의 정수가 아닌 경우
        - 입력된 번호가 로또 번호의 범위에서 벗어난 경우

<br/>