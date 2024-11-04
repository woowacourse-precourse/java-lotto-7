# java-lotto-precourse

## 🎯 구현할 기능 목록

### 입력

- [X] 로또 구입 가격 입력
    - [X] "구입금액을 입력해 주세요." 을 출력 후 입력
- [X] 당첨 번호 입력
    - [X] "당첨 번호를 입력해 주세요."을 출력 후 입력
- [X] 보너스 번호 입력
    - [X] "보너스 번호를 입력해 주세요."을 출력 후 입력
- [ ] 잘못된 입력의 경우 재입력

### 출력

- [X] 구매 내역 출력
    - [X] "8개를 구매했습니다."와 같이 구매한 갯수를 출력
    - [X] "[8, 21, 23, 41, 42, 43] "와 같이 줄마다 구매한 로또의 번호를 출력 (번호는 오름차순으로 출력)
- [X] 당첨 통계 출력
    - [X] "당첨 통계" 출력 후 다음줄에 "---"를 출력 후 통계 출력
    - [X] "일치 개수 (상금) - 일치한 로또 개수" 형식으로 출력
- [ ] 수익률 출력
    - [ ] "총 수익률은 62.5%입니다."와 같이 소수점 둘째자리에서 반올림 하여 표현
- [ ] 에러메세지 출력
    - [ ] [ERROR]로 시작하는 에러메세지 출력

### 로또

- [X] 로또 추첨 설정
    - [X] 로또 추첨시 기준이 될 숫자 할당
    - [X] 보너스 숫자 할당
- [X] 로또 발행
    - [X] 가격에 따라 로또 발행
    - [X] 개수 만큼 로또 발행
    - [X] 1~45 중 중복되지 않은 숫자 6개 생성
- [X] 로또 추첨
    - [X] 맞춘 개수 확인
    - [X] 보너스 번호 당첨 여부 확인
- [X] 상금 수여
    - [X] 맟춘 개수에 따라 등수 확인
    - [X] 등수에 따라 상금 수여

### 예외사항

- [X] 로또 번호의 개수가 잘못된 경우
- [X] 로또 번호에 중복이 있는 경우
- [ ] 로또 번호가 숫자가 아닌 경우
- [X] 로또 번호가 잘못된 범위의 숫자인 경우
- [X] 보너스 번호가 당첨 번호와 겹치는 경우
- [X] 보너스 번호가 잘못된 범위의 숫자인 경우
- [X] 구입 가격이 잘못된 단위인 경우
- [X] 구입 가격이 0인 경우
- [ ] 구입 가격이 숫자가 아닌 경우