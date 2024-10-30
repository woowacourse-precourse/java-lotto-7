# java-lotto-precourse
간단한 로또 발매기입니다.

## 구현할 기능 목록

간단한 로또 발매기에 필요한 기능 목록입니다.

### 입력

- 구입 금액 입력받기
  - 숫자가 아닌 경우 예외 처리
  - 천원으로 나누어 떨어지지 않는 경우 예외 처리
- 당첨 번호 입력받기
- 6개로 숫자 나누기
  - 구분된 번호가 6개가 아닌 경우 예외 처리
  - 로또 번호가 1 이상 45 이하가 아닌 경우 예외처리
  - 중복된 번호가 있는 경우 예외처리
- 당첨 번호를 오름차순으로 정렬하기
- 보너스 번호 입력받기
  - 숫자가 아닌 경우 예외처리
  - 보너스 번호와 당첨번호가 같은 경우 예외처리
  - 보너스 번호가 1이상 45 이하가 아닌 경우 예외처리

### 출력

- 로또 구매 개수 출력
- 각각의 로또 번호 출력
  - 로또 번호는 오름차순으로 정렬
- 당첨 내역을 출력
- 총 수익률을 출력
  - 수익률은 소수점 둘째 자리에서 반올림

### 숫자 생성[README.md](README.md)

- 6개의 숫자를 생성
  - 중복된 번호가 있는 경우 예외 처리
- 숫자를 오름차순으로 정렬

### 당첨 판정

- 각 등수별 당첨 판단 메서드
  - 일치하는 번호 개수 계산
  - 보너스 번호 일치 여부 확인
- 당첨 결과 집계 기능
  - 등수별 당첨 개수 집계
  
### 수익률 계산

- 총 당첨 수익 / 구입금액 을 통해 수익률 계산
- 소숫점 반올림 기능

### 상수 관리

- 로또 가격
- 로또 번호 범위 (최소값, 최대값)
- 로또 번호 개수
- 각 등수별 당첨금액