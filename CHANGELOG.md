#### 2024-10-29

##### Documentation Changes

* **README.md:**
  *  기능 목록 수정 (1ec2637e)
  *  기능 목록 추가 (fdf6c596)

##### New Features

* **README.md:**  여러 개의 로또 티켓 관리 기능 추가 (9a929358)
*  당첨 여부 확인 기능 추가 (cd603a02)
*  setup project (99b19647)
* **LottoNumberGenerator:**  로또 번호 추출 기능 추가 (f4ef6005)
* **TicketParser:**  로또 구입 금액 계산 기능 추가 (10ae5731)
* **LottoParser:**
  *  보너스 번호 변환 기능 추가 (099a540a)
  *  당첨 번호 변환 기능 추가 (06b453e8)
* **InputConsole:**  문자열 입력 기능 추가 (19e12b7f)

##### Refactors

* **Lotto:**
  *  getter, toString 구현 (893dba14)
  *  패키지를 domain으로 변경 (b47ccee6)
* **TicketParser:**  TICKET_PRICE 상수의 접근 제어자를 public으로 수정 (a74a476a)
* **LottoParser:**  상수들의 접근 제어자를 public으로 수정 (2faa4a88)
* **LottoNumberGenerator:**  generateBonusNumber()가 List를 반환하지 않음 (6f73c3de)

##### Tests

* **TicketParser:**  단위 테스트 추가 (32f04b48)
* **LottoParser:**  단위 테스트 추가 (ca0fff01)
* **Lotto:**  패키지를 domain으로 변경 (aec50033)

