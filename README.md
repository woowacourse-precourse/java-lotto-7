# java-lotto-precourse
___
## 📍기능 목록
- 로또 구입 금액 입력
- 당첨 번호 입력
- 보너스 번호 입력
- 발행한 로또 수량 및 번호 출력
- 당첨 내역 출력
- 수익률 출력
- 예외 상황시 에러 문구 출력
___
## 📍구현 사항 목록
-[X] 로또 구입 금액 입력 받기
    - [X] 1,000원 단위로 입력 받기
    - [X] 1,000원으로 나누어 떨어지지 않는 경우예외 처리
- [X] 당첨 번호 입력 받기
    - [X] 숫자 6개 입력 받기
    - [X] 1~45 사이의 숫자만 입력 받기
    - [X] 중복된 숫자 입력 시 예외 처리
- [X] 보너스 번호 입력 받기
    - [X] 1개의 숫자 입력 받기
    - [X] 1~45 사이의 숫자만 입력 받기
    - [X] 당첨 번호와 중복된 숫자 입력 시 예외 처리
- [X] 구입 금액에 맞춰 발행 수량 계산
    - [X] 구입 금액을 1,000으로 나누어 계산
- [X] 발행 수량 만큼 로또 발행
    - [X] 1~45 사이의 숫자 6개를 랜덤으로 발행
    - [X] 하나의 로또 내에서 중복된 숫자 발행 시 예외 처리
    - [X] 발행된 로또를 오름차순으로 정렬
    - [X] 발행된 로또를 출력
- [X] 당첨 번호와 로또 비교
    - [X] 당첨 번호와 로또 번호 비교
    - [X] 당첨 번호와 보너스 번호 비교
    - [X] 당첨 번호와 일치하는 번호 개수 출력
    - [X] 당첨 번호와 보너스 번호 일치 여부 출력
    - [X] 당첨 번호와 일치하는 번호 개수에 따른 당첨 금액 출력
- [X] 수익률 계산
    - [X] 당첨 금액과 구입 금액을 비교하여 수익률 계산
- [X] 에러 문구는 [ERROR]로 시작