# java-lotto-precourse

# 구현할 기능 목록
- Model
    - [x] 로또 생성기
        - [x] 6개의 서로 다른 로또 번호를 가지는 로또 생성
        - [x] 당첨 로또 생성
    - [x] 로또 묶음
        - [x] 구입 금액의 개수만큼 로또 생성
    - [x] 구입금액
        - [x] 구입금액이 1000으로 나누어 떨어지지 않을 시, 예외 처리
        - [x] 구입금액이 0 이하일 시, 예외 처리
        - [x] 수익률 계산 및 문자열 파싱
    - [x] 로또
        - [x] 로또 번호 리스트의 크기가 6이 아닐 시, 예외 처리
        - [x] 로또 번호 리스트의 수에 중복이 존재할 시, 예외 처리
    - [x] 로또 번호
        - [x] 번호의 범위가 [1,  45]가 아닐 시, 예외 처리
    - [x] 당첨 번호 로또
        - [x] 당첨 로또 생성
        - [x] 로또 추첨 결과 반환
    - [x] 당첨 정보
        - [x] 당첨 결과 초기 설정
        - [x] 추첨 결과 반환
        - [x] 총 상금 계산 및 반환
- View
    - [x] 입력
        - [x] 구입금액 입력
        - [x] 당첨 관련 번호 입력
            - [x] 숫자가 아닐 시, 예외 처리
    - [x] 출력
        - [x] 로또 수량 및 번호 출력
        - [x] 당첨 내역 및 수익률 출력
- Controller
    - [x] 로또 (간단한 로또 발매기)
    - [x] 로또 생성
    - [x] 로또 추첨
- Dto
    - [x] 구매 로또 결과 (구매 로또 결과 출력 생성기 기능 위임 예정)
    - [x] 모든 등수의 로또 추첨 결과
    - [x] 단일 등수의 로또 추첨 결과
- Test
    - [x] 로또 생성기 테스트
        - [x] 생성된 로또의 로또 번호가 6개인지 테스트
        - [x] 생성된 로또의 로또 번호가 서로 다른지 테스트
        - [x] 전달 받은 정수 리스트를 토대로 로또 생성되는지 테스트
    - [x] 로또 묶음
        - [x] 구입 금액에 따라 정확한 수량의 로또를 생성하는지 테스트
    - [x] 구입금액
        - [x] 1000으로 나누어 떨어지면서 구입금액이 1000원을 넘는지 테스트
        - [x] 구입금액이 1000으로 나누어 떨어지지 않을 시, 예외 처리되는지 테스트
        - [x] 구입금액이 0 이하일 시, 예외 처리되는지 테스트
    - [x] 로또
        - [x] 로또 생성 테스트
        - [x] 로또 번호 리스트의 크기가 6이 아닐 시, 예외 처리되는지 테스트
        - [x] 로또 번호 리스트에 중복이 존재할 시, 예외 처리되는지 테스트
    - [x] 로또 번호
        - [x] 번호가 같다면 같은 객체인지 테스트
        - [x] 번호의 범위가 [1, 45]일 때, 생성되는지 테스트
        - [x] 번호의 범위가 [1,  45]가 아닐 시, 예외 처리되는지 테스트
    - [x] 당첨 정보 로또
        - [x] 로또 추첨 테스트 (등수마다)
    - [x] 당첨 정보
        - [x] 등수에 맞게 추첨되는지 테스트
        - [x] 총 상금이 정확하게 반환되는지 테스트

# 기능 동작 순서
1. 구입금액 입력 메세지를 출력한다.
2. 구입금액을 입력받는다.
    - 숫자가 아니라면 예외를 터뜨리고 2로 돌아간다.
3. 구입금액을 검증한다.
    - 1000으로 나누어 떨어지지 않는다면 예외를 터뜨리고 2로 돌아간다.
    - 1000보다 작다면 예외를 터뜨리고 2로 돌아간다.
4. 로또 개수만큼 로또 객체를 생성한다.
5. 발행한 로또 수량 및 번호를 출력한다.
6. 당첨 번호 입력 메세지를 출력한다.
7. 당첨 번호를 입력받는다.
    - ,를 기준으로 분리한다.
    - 번호가 숫자가 아니라면 예외를 터뜨리고 7로 돌아간다.
9. 보너스 번호 입력 메세지를 출력한다.
10. 보너스 번호를 입력받는다.
11. 당첨 번호와 보너스 번호를 검증한다.
    - 당첨 번호가 1 미만 또는 45 초과라면 예외를 터뜨리고 7로 돌아간다.
    - 당첨 번호의 개수가 6개가 아니라면 예외를 터뜨리고 7로 돌아간다.
    - 당첨 번호에 중복이 존재한다면 예외를 터뜨리고 7로 돌아간다.
    - 보너스 번호가 1 미만 또는 45 초과라면 예외를 터뜨리고 7로 돌아간다.
12. 당첨 번호를 토대로 로또를 추첨한다.
13. 수익률을 계산한다.
14. 당첨 통계 메시지를 출력한다.
15. 당첨 내역을 출력한다.
16. 총 수익률을 출력한다.