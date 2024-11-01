### 2024-11-01

#### Chores

* **.gitignore:**  .gitignore 수정 (e404ad64)

#### Documentation Changes

* **CHANGELOG.md:**  changelog 문서 추가 (f4517fbe)
* **README.md:**
  *  기능 목록 수정 (c23b5677)
  *  기능 목록 추가 (fdf6c596)

#### New Features

* **OutputConsole:**  문자열 출력 기능 추가 (341a5b44)
* **Statistics:**  수익률 계산 기능 추가 (1d61f67b)
* **Tickets:**  당첨 여부 확인 기능 추가 (eb48b41b)
* **README.md:**  여러 개의 로또 티켓 관리 기능 추가 (a19dd56f)
*  당첨 여부 확인 기능 추가 (f9c4be36)
*  setup project (99b19647)
* **LottoNumberGenerator:**  로또 번호 추출 기능 추가 (f4ef6005)
* **TicketParser:**  로또 구입 금액 계산 기능 추가 (10ae5731)
* **LottoParser:**
  *  보너스 번호 변환 기능 추가 (099a540a)
  *  당첨 번호 변환 기능 추가 (06b453e8)
* **InputConsole:**  문자열 입력 기능 추가 (19e12b7f)

#### Bug Fixes

*  보너스 번호 판정 개념 수정 (5964338c)
* **Ticket:**  올바른 등수를 반환하지 않던 문제 수정 (0ead4eb4)
* **Rank:**  valueOf가 올바른 값을 리턴하지 않던 문제 수정 (6c1de63d)

#### Refactors

* **LottoParser:**
  *  parseBallNumbers, parseBonusBall 메서드명 변경 (acb5ad20)
  *  final class로 변경 (0c144166)
  *  상수들의 접근 제어자를 public으로 수정 (241e4661)
* **Statistics:**  toString 메서드 추가 (d83c299f)
* **Rank:**  toString 메서드 추가 (aaa9a157)
* **Lotteries:**
  *  size 메서드 추가 (a4375052)
  *  toString 메서드 수정 (bb75f16e)
* **Lotto:**
  *  getMatchCount 메서드명 수정 (ca3112ce)
  *  TICKET_PRICE가 Lotto에서 관리되도록 수정 (f6d9a786)
  *  getter, toString 구현 (89485503)
  *  패키지를 domain으로 변경 (b47ccee6)
*  프로젝트 폴더 구조 변경 (b5ad46d8)
*  프로젝트 폴더 구조 변경 (f99567ba)
* **TicketParser:**
  *  final class로 변경 (db0ff760)
  *  TICKET_PRICE 상수의 접근 제어자를 public으로 수정 (9a767a18)
* **Ticket:**
  *  check 메서드가 Ticket을 전달받도록 수정 (22e3c163)
  *  getter 추가 (f8501835)
* **LottoNumberGenerator:**  generateBonusNumber가 List를 반환하지 않음 (9de8742c)

#### Code Style Changes

*  import 오타 수정 (781c7712)
* **Tickets:**  메서드명 오타 수정 (0707bd3e)

#### Tests

* **LottoParser:**
  *  parseBallNumbers, parseBonusBall 메서드명 변경에 따른 수정 (cc1da0ca)
  *  단위 테스트 추가 (ca0fff01)
* **Lotteries:**  println 구문 삭제 (733cb0d3)
* **TicketParser:**
  *  TICKET_PRICE가 Lotto에서 관리되도록 수정 (1782fb6a)
  *  단위 테스트 추가 (32f04b48)
*  테스트 코드 폴더 구조 변경 (9c631b34)
*  보너스 번호 판정 개념 수정에 따른 테스트 수정 (c2cfb2d5)
*  폴더 구조 변경 (9c9bc344)
* **Tickets:**  단위 테스트 추가 (10f80acf)
* **Ticket:**  단위 테스트 추가 (58ffc56a)
* **LottoNumbersTestCase:**  테스트 케이스 추가 (3d539f38)
* **Lotto:**  패키지를 domain으로 변경 (aec50033)

### 2024-10-29

#### Documentation Changes

* **README.md:**
  *  기능 목록 수정 (1ec2637e)
  *  기능 목록 추가 (fdf6c596)

#### New Features

* **README.md:**  여러 개의 로또 티켓 관리 기능 추가 (9a929358)
*  당첨 여부 확인 기능 추가 (cd603a02)
*  setup project (99b19647)
* **LottoNumberGenerator:**  로또 번호 추출 기능 추가 (f4ef6005)
* **TicketParser:**  로또 구입 금액 계산 기능 추가 (10ae5731)
* **LottoParser:**
  *  보너스 번호 변환 기능 추가 (099a540a)
  *  당첨 번호 변환 기능 추가 (06b453e8)
* **InputConsole:**  문자열 입력 기능 추가 (19e12b7f)

#### Refactors

* **Lotto:**
  *  getter, toString 구현 (893dba14)
  *  패키지를 domain으로 변경 (b47ccee6)
* **TicketParser:**  TICKET_PRICE 상수의 접근 제어자를 public으로 수정 (a74a476a)
* **LottoParser:**  상수들의 접근 제어자를 public으로 수정 (2faa4a88)
* **LottoNumberGenerator:**  generateBonusNumber()가 List를 반환하지 않음 (6f73c3de)

#### Tests

* **TicketParser:**  단위 테스트 추가 (32f04b48)
* **LottoParser:**  단위 테스트 추가 (ca0fff01)
* **Lotto:**  패키지를 domain으로 변경 (aec50033)

