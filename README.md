# 3. 로또

## 📝 프로젝트 소개
로또 게임을 구현한 프로그램입니다. 사용자로부터 구입 금액을 입력받아 로또를 발행하고, 당첨 번호와 보너스 번호를 입력받아 당첨 내역과 수익률을 계산합니다.

## 🎯 기능 요구 사항
### 1. 로또 구매
- 구입 금액 입력
    - [x] 구입 금액을 입력받는다
    - [x] 입력이 숫자가 아닌 경우 예외 처리
    - [x] 입력이 1,000원 미만인 경우 예외 처리
    - [x] 입력이 1,000원 단위가 아닌 경우 예외 처리

### 2. 로또 발행
- 자동 로또 생성
    - [x] 구매 금액만큼 로또 자동 생성 (1장당 1,000원)
    - [x] 각 로또는 1-45 사이의 서로 다른 숫자 6개로 구성
    - [x] 발행된 로또의 숫자들은 오름차순으로 정렬

### 3. 당첨 번호 입력
- 당첨 번호 입력
    - [x] 당첨 번호 6개를 입력받음 (쉼표 기준으로 구분)
    - [x] 입력값이 숫자가 아닌 경우 예외 처리
    - [x] 입력값이 1-45 범위를 벗어난 경우 예외 처리
    - [x] 중복된 숫자가 있는 경우 예외 처리
    - [x] 숫자가 6개가 아닌 경우 예외 처리

- 보너스 번호 입력
    - [x] 보너스 번호 1개를 입력받음
    - [x] 입력값이 숫자가 아닌 경우 예외 처리
    - [x] 입력값이 1-45 범위를 벗어난 경우 예외 처리
    - [x] 당첨 번호와 중복되는 경우 예외 처리

### 4. 당첨 확인
- 당첨 내역 계산
    - [x] 각 로또의 당첨 번호 일치 개수 확인
    - [x] 5개 일치 시 보너스 번호 일치 여부 확인
    - [x] 당첨 등수별 개수 계산
        - 1등: 6개 번호 일치 (2,000,000,000원)
        - 2등: 5개 번호 + 보너스 번호 일치 (30,000,000원)
        - 3등: 5개 번호 일치 (1,500,000원)
        - 4등: 4개 번호 일치 (50,000원)
        - 5등: 3개 번호 일치 (5,000원)
    - [x] 수익률 계산 (당첨금 총액 / 구매 금액 * 100)

### 5. 결과 출력
- [x] 발행한 로또 수량과 번호들 출력
- [x] 당첨 통계 출력 (등수별 당첨 개수)
- [x] 총 수익률 출력 (소수점 둘째 자리에서 반올림)
