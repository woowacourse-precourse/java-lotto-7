# 로또
간단한 로또 발매기
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
   - 1등: 6개 번호 일치 / 2,000,000,000원
   - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
   - 3등: 5개 번호 일치 / 1,500,000원
   - 4등: 4개 번호 일치 / 50,000원
   - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 기능목록
1. 로또 구입
   - 출력 : 안내 문구
   - 입력 : 구입금액 입력, 오류시 [ERROR] 메시지 출력 후 다시 입력
      - 1,000원 단위가 아닌 경우
      - 1,000원 미만인 경우
      - 숫자가 아닌 경우
2. 로또 발행
   - pickUniqueNumbersInRange()로 1~45 범위의 숫자 6개를 뽑는다
   - 출력: 로또 목록
3. 당첨 번호 입력
   - 출력 : 당첨번호 안내 문구
   - 입력 : 당첨 번호 6개 입력 오류시 [ERROR] 메시지 출력 후 다시 입력
      - 1~45 범위가 아닌 경우
      - 중복된 번호가 있는 경우
      - 숫자가 아닌 경우
      - ,로 구분되지 않는 경우
      - 6개의 숫자가 아닌 경우
      - 공백이 포함된 경우
   - 출력 : 보너스 번호 안내 문구
   - 입력 : 보너스 번호 입력 오류시 [ERROR] 메시지 출력 후 다시 입력
      - 1~45 범위가 아닌 경우
      - 중복된 번호가 있는 경우
      - 숫자가 아닌 경우
      - 당첨번호에 포함된 번호인 경우
4. 당첨 확인
    - 1등~5등 당첨 개수 확인
5. 수익률 계산
   - 당첨 개수로 수익률 계산
6. 당첨 내역 출력
   - 4,5에서 계산한 수익률과 당첨 개수 출력


<img width="573" alt="image" src="https://github.com/user-attachments/assets/af536661-fbcc-4d21-814c-9a42636d1bff">
