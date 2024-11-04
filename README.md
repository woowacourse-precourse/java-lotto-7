<p align="center">
    <img src="./woowacourse.png" alt="우아한테크코스" width="250px">
</p>

# 프리코스 3주차 미션 - 로또 게임

![Generic badge](https://img.shields.io/badge/precourse-week3-green.svg)
![Generic badge](https://img.shields.io/badge/test-0_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.0-brightgreen.svg)

> 우아한테크코스 7기 3주차 미션, 로또 게임을 구현한 저장소입니다.


## 기능 목록

### 입력
- 구입 금액을 입력받는다.
  - 구입 금액은 1000원 단위
- 당첨 번호를 입력 받는다. 번호는 쉼표(,) 기준으로 구분한다.
- 보너스 번호를 입력 받는다.

### 출력
- 안내 멘트 출력
- 구매한 로또 번호 오름차순으로 출력
- 당첨 통계 출력
### 유저
- 구입 금액 및 발행받은 로또 상태 관리
### 로또 발행기 
- 구입 금액에 따른 로또 발행 기능
### 로또 당첨 판별기
- 발행된 로또와 당첨 번호 비교 기능
### 로또 통계기
- 당첨 내역 계산
- 수익률 계산


### 예외 사항
  - 구입 금액은 1000원 단위로 나누어 떨어져야 함.
  - 로또 번호와 보너스 번호는 1~45 사이 중복되지 않는 숫자여야 함.
  - 구입 금액이 매우 큰 경우
  - 입력이 음수이거나 숫자가 아닌 경우
  - 로또는 번호 6개, 당첨 로또는 번호 6개와 보너스 번호 1개로 이루어져야만 한다.