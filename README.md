# 로또 발매기 기능 명세서

## 입력

- 로또 구매 금액 안내 메세지를 출력하고 콘솔 입력을 받는다.
- 당첨 번호 안내 메세지를 출력하고 콘솔 입력을 받는다.
- 보너스 번호 안내 메세지를 출력하고 콘솔 입력을 받는다.

## 입력 처리

- 로또 구매 금액을 유효성 검사 및 형변환을 진행한다.
    - 입력이 숫자 인지 확인한다.
    - 숫자가 아니면 에러를 발생시킨다.
    - 문자열 -> 숫자 형변환한다.
- 당첨 번호 입력을 유효성 검사 및 형변환을 진행한다.
    - `,` 구분자로 숫자를 분리한다.
    - 구분자 사이 문자가 숫자가 아니면 에러 발생시킨다.
- 보너스 번호 입력을 유효성 검사 및 형변환을 진행한다.
    - 입력이 숫자 인지 확인한다.
    - 숫자가 아니면 에러를 발생 시킨다.
    - 문자열 -> 숫자 형변환한다.

## 돈

- 유효성 검사를 진행한다.
    - 티켓 가격으로 나누어지지 않으면 에러를 발생 시킨다.
    - 티켓 가격 이하의 금액이면 에러를 발생 시킨다.
    - 10만원 이상 입력 시 에러를 발생 시킨다.

## 로또

- 유효성 검사를 진행한다.
    - 번호 갯수가 로또 숫자 개수와 일치하지 않으면 에러를 발생시킨다.
    - 중복된 숫자가 있다면 에러를 발생시킨다.
    - 로또 숫자 범위 외 숫자가 있다면 에러를 발생시킨다.
- 숫자 오름차순 정렬로 정렬하여 저장한다.

## 보너스 번호

- 유효성 검사를 진행한다.
    - 로또 숫자 범위 외 숫자라면 에러를 발생시킨다.

## 승리 로또

- 입력 받은 로또 번호와 보너스 번호로 생성한다.
- 유효성 검사
    - 보너스 번호가 입력 받은 로또 번호 6자리 중 하나라도 겹치면 에러를 발생시킨다.

## 로또 기계

- 입력 받은 금액만큼 랜덤 로또를 생성한다.
- 중복되지 않은 로또를 입력한 금액에 따라 리턴한다.
- 중복된 숫자가 나오면 다시 뽑는다.

## 랭크

- 순위에 따라 일치하는 번호 개수, 보너스 번호 필요 유무, 보상 금액을 저장한다.
- 승리 로또와 로또 기계에서 뽑은 로또를 비교하여 각 랭크 개수를 리턴한다.

## 결과

- 구매 금액, 승리 로또, 구매한 로또로 생성한다.
- 각 랭크 당 당첨된 로또 개수를 리턴한다.
- 수익률 계산하여 리턴한다.

## 출력 처리

- 구매한 로또의 개수를 리턴한다.
- 구매한 로또의 번호를 문자열로 리턴한다.
- 당첨 통계를 요구사항에 맞게 문자열로 리턴한다.
- 수익율을 리턴한다.

## 출력

- 구매한 로또 개수와 번호를 메세지와 함께 출력한다.
- 당첨 통계와 수익률을 출력한다.
    - 수익률은 소수점 첫째자리까지만 출력한다.

## 상수

- 로또 구성
    - 로또 번호 숫자 범위 (1 ~ 45)
    - 로또 번호 개수
    - 로또 가격
    - 최소 지불 금액
    - 최대 지불 금액
- 에러 메세지
    - 잘못된 형식의 입력을 알려주는 메세지
    - 번호가 6개 이상일 경우 알려주는 메세지
    - 로또의 번호가 범위 밖의 숫자이면 알려주는 메시지
    - 최소 금액보다 낮은 금액이 입력되면 알려주는 메세지
    - 보너스 번호가 범위 밖의 숫자이면 알려주는 메세지