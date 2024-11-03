# java-lotto-precourse

3주차 미션 : 로또

### 기능 목록

1. ✅ 구입 금액 입력 기능
    - [x] 금액을 입력받는다
    - [ ] 숫자가 아닐 경우 예외다
    - [ ] 공백 또는 빈 문자열이 입력되면 예외다
    - [ ] 구매 단위가 아닐 경우 예외다

2. ✅ 로또 번호 입력 기능
    - [x] 당첨 번호를 입력 받는다
    - [ ] 기준 구분자 외의 구분자로 입력했을 경우 예외다

3. ✅ 보너스 번호 입력 기능
    - [ ] 보너스 번호를 입력받는다

4. ✅ 로또&보너스 번호 공통 검증 기능
    - [ ] 공백 또는 빈 문자열이 입력되면 예외다
    - [ ] 숫자를 입력하지 않았을 경우 예외다
    - [ ] 허용 범위(1-45)를 벗어난 숫자일 경우 예외다

5. ✅ 예외 출력 기능
    - [ ] 문구는 `[ERROR]`로 시작한다

6. ✅ 재입력 기능
    - [ ] 예외가 발생한 부분부터 다시 입력을 받는다

7. ✅ 무작위 로또 번호 생성 기능(LottoMaker)
    - [x] 구매한 로또의 갯수를 구한다
    - [x] 지정한 범위 내의 `중복되지 않는` 숫자를 `지정된 갯수`만큼 무작위로 뽑는다
    - [x] 무작위 번호는 오름차순으로 정렬한다

8. ✅ 랜덤 로또 생성 기능
    - [x] 구매한 갯수만큼의 로또를 생성한다

9. ✅ 사용자 당첨 번호 로또 생성 기능
    - [x] 입력한 당첨 번호를 로또로 만든다

10. ✅ 로또 공통 검증 기능
    - [x] 번호가 지정한 갯수가 아니라면 예외다
    - [x] 중복되는 번호가 존재하면 예외다

11. ✅ 로또 당첨 계산 기능
    - [ ] 당첨된 로또의 갯수를 계산한다
    - [ ] 수익률을 계산한다

12. ✅ 결과 출력 기능
    - [x] 구매한 갯수와 발행된 로또 숫자를 출력한다
    - [ ] 수익률은 `소수점 둘째 자리`에서 반올림한다
