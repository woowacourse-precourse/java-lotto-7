#  우아한 L💰TT💰 💲ervice


## ➡️ 프로젝트 개요

### 우아한 Lotto Service 소개

> * 우아한 로또 서비스는 프로그램을 통해 간편하게 로또를 구매할 수 있습니다.  
> * 사용자는 우아한 로또 서비스를 통해 로또를 구매할 수 있으며, 한 번에 여러개도 구매할 수 있습니다.  
> * 이 때, 자동 로또 생성기를 통해 사용자에게 로또가 제공됩니다.  
> * 사용자는 로또를 구매하면 구매한 로또 정보가 기록됩니다.  
> * 사용자는 당첨 시간이 되면 당첨 통계에 대해 조회할 수 있습니다.
> * 우아한 로또 서비스는 사용자가 직접 로또 번호를 추첨하는 기능을 미래에 추가하자고 기획했습니다.

###  우아한 Lotto Service Scenario

> 때는, 2025년 10월 29일(화)  
> dot는 로또를 구매하기 위해 `우아한 로또 서비스`를 이용하기로 결심한다.  
> dot는 인터넷에서 8000원의 금액을 결제하고, 자동 추첨기를 통해 8장의 로또를 구매한다.  
> 
> 시간이 흘러, 11월 2일(토) 약, 오후 8시 30분
> 우아한 로또 서비스는 당첨자를 선발하기 위해 당첨 번호와 보너스 번호를 정한다.
> 
> dot는 오후 8시 35분 쯤, 당첨 통계를 조회하면서 본인의 당첨 내역과 수익 정보를 확인할 수 있다.

---

### 🗞️️🗞️️ 기능 구현 목록 🗞️️🗞️️

- 번호 6개를 자동으로 생성하는 기능
    - camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
        - 우테코에서 검증된 기능이므로 따로 테스트를 하지 않아도 된다.


- 예외처리를 하는 기능
  - 각 도메인 별로 발생하는 예외가 다르다.
    - 명확하게 구분할 수 있게, 도메인 별로 예외를 관리
    - 예외는 메세지를 포함함
  - 모든 예외 메세지는 공통적으로 [ERROR] 라는 prefix를 가짐.
 

- 로또를 발행하는 기능
  - 1부터 45까지 숫자로 구성되어야 한다.
    - 아니라면, 예외가 발생한다.
  - 생성되는 숫자는 유니크하다.
    - 중복되는 숫자가 있다면 예외가 발생한다.
  - 숫자는 6개여야 한다.
    - 아니라면 예외가 발생한다.


- 로또를 구매하는 기능
  - 금액이 투입되면 금액만큼 티켓을 생성한다.
    - 금액이 1000원 미만이라면 예외가 발생한다. 
    - 금액이 1000원 단위가 아니라면 예외가 발생한다.
  - 티켓의 개수만큼 로또를 발행한다.
    - 티켓이 없는데 발행하면 예외가 발생한다.


- 당첨 번호를 생성하는 기능
  - 로또 번호 정보와 보너스 번호 정보를 가지고 있다.
  - 보너스 번호는 생성된 로또 번호와 다른 번호이다.
    - 중복되는 번호가 있다면 예외가 발생한다.


- 로또 당첨을 조회하는 기능

- 입/출력 기능