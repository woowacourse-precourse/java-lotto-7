# java-lotto-precourse

## 흐름 정리
1. 로또의 가격을 인풋 한다. ex) 14000 (사용자 입력)
   * 검증
2. 관리자로 부터 로또 자동 상품을 구매 요청
3. 관리자는 클라이언트의 가격을 받아온다.
4. 관리자는 클라이언트로 부터 받은 로또의 가격으로 몇 개의 로또를 샀는지 처리한다. ex) 14
   * 검증
5. 관리자는 로또의 개수만 큼 랜덤 로또 출력기능을 통해 랜덤으로 6개의 번호를 각각 생성한다.
6. 생성된 로또 번호를 클라이언트에게 보내준다.
7. 클라이언트는 받은 로또 번호를 저장하고 view로 넘겨 출력한다. ex) [1, 4, 5, 6, 8, 28], [2, 5, 6, 10, 23, 25] (오름차순)
8. 관리자는 로또의 번호, 보너스 번호를 인풋 한다. ex) 로또 번호: 1, 23, 42, 5, 7, 13 보너스 번호: 27 (관리자 입력)
9. 클라이언트는 관리자에게 로또의 당첨 통계 및 총 수익률을 요청한다. (이전에 구매한 클라이언트의 로또 번호를 포함)
10. 관리자는 넘겨받은 번호를 통해 당첨 통계를 계산하고 총 수익률을 계산한고 클라이언트에게 응답한다.

## 프로그래밍 요구 사항
* indent depth는 3이 넘지 않도록 구현한다.
* 3항 연산자 사용 금지
* 15라인 넘어가지 않도록
* 메서드는 한 가지 일만 하도록 구현
* else문, switch/case문은 허용하지 않음
* 구현한 기능에 대한 단위 테스트를 작성, UI 로직은 제외
* 상수화의 경우 Java Enum을 적용하여 프로그램을 구현한다.

<hr>

## 기능 목록

### 시스템 기능
#### LottoMember
* 구입한 로또 번호를 저장
* 당첨 통계를 저장
* 총 수익률을 저장
#### LottoManager
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는 기능
* 요청한 로또 상품 가격 만큼 로또 상품을 출력한다.
    * 1000원 단위만을 허용한다.
    * 1000원보다 작은 경우에는 허용하지 않는다.
* 당첨 번호와 보너스 번호 예외처리
  * 보너스 번호는 1~45까지의 숫자만 허용한다.
  * 당첨 번호와 중복되어서는 안된다.
* 요청한 사용자의 로또 번호들을 받고 당첨을 확인하는 기능
* 당첨된 내역들의 당첨 통계를 계산하는 기능
* 당첨된 통계를 통해 총 수익률을 계산하는 가능
#### Lotto
* 로또의 번호를 저장
* 로또 번호 유효성 검사
    * 1~45까지의 숫자만 허용한다.
    * 중복된 번호를 허용하지 않는다.
* 로또 본연의 역활만 가진다.

### 입력 기능
* 로또를 구매할 가격을 입력한다.
* 로또 번호를 입력한다.
    * 음수의 값은 허용하지 않는다.
    * 문자를 허용하지 않는다.
* 로또 보너스 번호를 입력한다.
  * 위와 같다.

### 출력 기능
* 구매한 자동 로또 번호를 출력한다.
* 당첨 통계와 총 수익률을 출력한다.

### 예외처리 사항

* Input:
  * 문자를 허용하지 않는다.
  * 음수의 경우를 허락하지 않는다.
  * 띄어쓰기의 경우 맨 앞은 허용한다.
  * ex1) 1 9, 1, 4, 5, 6, 10 -> x
  * ex2) 12 ,14, 21 , 12 ,4, 42 ->x
  * ex2) 1, 3, 4,5,6,8 -> O
* Lotto:
  * 로또 번호의 개수는 6개 이어야 한다.
    * ex1) 12, 4, 5, 6 -> X
    * ex2) 12, 43, 25, 3, 46, 13, 22
  * 로또 번호의 범위는 1 ~ 45 까지이다.
    * ex) 48, 0, 1, 3, 45, 2
  * 로또 가격의 경우 1000원 단위만을 허용한다.
    * ex) 12999
  * 로또의 가격이 1000원 보다 작은 경우 허용하지 않는다.
      * ex) 985
