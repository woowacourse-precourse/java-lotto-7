# java-lotto-precourse
## 프로젝트 개요 및 목표
우아한테크코스 웹 백엔드 7기 3주차, 로또 문제를 해결한다.
로또 구매 가격과 당첨번호를 입력하면, 당첨 내역과 수익률을 출력하는 간단한 로또 발매기를 구현한다.

## 프로그램 프로세스
1. 로또 구입 금액을 입력받은 후, 구입 금액에 맞는 개수만큼의 로또를 발행하여 출력한다. 이떄, 로또의 번호는 중복되지 않은 6개의 무작위 수이다.
2. 당첨 번호 및 보너스 번호를 입력받는다. 발행한 로또의 적중률과 그에 따른 수익률을 계산한다.
3. 계산한 적중률과 수익률을 토대로 당첨 내역과 수익률을 출력한다.

## 기능
### 공통 사항 - 예외 상황 처리
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
* 각 예외 사항은 각 기능별로 처리하며, 가능한 예외 사항 역시 같이 기재한다.

#### 입출력
* 출력 : 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

### 기능 1 : 로또 구매
* 로또 1장의 가격은 1,000원이다.
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
    * 로또 번호의 숫자 범위는 1~45까지이다.

#### 입출력 
* 입력 : 구입 금액을 입력받는다.
    구입금액을 입력해 주세요.
    8000
* 출력 : 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43] 
    [3, 5, 11, 16, 32, 38] 
    [7, 11, 16, 35, 36, 44] 
    [1, 8, 11, 31, 41, 42] 
    [13, 14, 16, 38, 42, 45] 
    [7, 11, 30, 40, 42, 43] 
    [2, 13, 22, 32, 38, 45] 
    [1, 3, 5, 14, 22, 45]

#### 예외 상황
1. [Done]1개의 로또 번호가 6개가 아니다
2. [Done]로또 번호가 중복된다.
3. [Done]로또 번호의 숫자 범위가 1~45를 만족하지 않는다.
4. [Done]구입 금액이 로또 가격의 배수가 아니거나, 로또 가격보다 적다.
5. [Done]구입 금액이 Integer 값이 아니다.

### 기능 2 : 로또 당첨 및 수익률 계산
* 당첨 번호와 보너스 번호를 입력받는다.
    * 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    * 1등: 6개 번호 일치 / 2,000,000,000원
    * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    * 3등: 5개 번호 일치 / 1,500,000원
    * 4등: 4개 번호 일치 / 50,000원
    * 5등: 3개 번호 일치 / 5,000원
* 당첨 금액에 비례한 수익률을 계산한다.

#### 입출력 
* 입력 : 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다. 그 후, 보너스 번호를 입력 받는다.

    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6

    보너스 번호를 입력해 주세요.
    7

#### 예외 상황
1. [To-Do]당첨 번호의 범위가 1~45를 만족하지 않는다.
2. [To-Do]보너스 번호의 범위가 1~45를 만족하지 않는다.
3. [To-Do]당첨 번호에 중복이 있다.
4. [To-Do]보너스 번호가 당첨 번호와 중복이 있다.
5. [To-Do]당첨 번호가 ','(쉼표)와 숫자로 이루어지지 않는다.

### 기능 3 : 당첨 통계 내기 - 적중률 및 수익률
* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

#### 입출력 
* 출력 : 당첨 내역을 출력하고, 수익률을 출력한다. 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.

#### 예외 상황
현재까지는 보이지 않음.

## 입출력 예시
### 전체 실행 결과
    구입금액을 입력해 주세요.
    8000

    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43] 
    [3, 5, 11, 16, 32, 38] 
    [7, 11, 16, 35, 36, 44] 
    [1, 8, 11, 31, 41, 42] 
    [13, 14, 16, 38, 42, 45] 
    [7, 11, 30, 40, 42, 43] 
    [2, 13, 22, 32, 38, 45] 
    [1, 3, 5, 14, 22, 45]

    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6

    보너스 번호를 입력해 주세요.
    7

    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.

