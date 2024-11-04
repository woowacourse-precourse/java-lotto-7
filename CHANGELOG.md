### 2024-11-04

#### Chores

* **.gitignore:**  .gitignore 수정 (ccb60da5)

#### Documentation Changes

* **README.md:**
  *  오타 수정 (6cc6655f)
  *  제약 조건 업데이트 (b75a4a08)
  *  기능 목록 수정 및 제약 조건 추가 (02fdb32b)
  *  기능 목록 수정 (e4c74d85)
  *  기능 목록 추가 (fdf6c596)
* **CHANGELOG.md:**
  *  Changelog 업데이트 (9e1de83d)
  *  changelog 문서 추가 (4aea1237)

#### New Features

* **ExceptionHandler:**  예외 상황 발생 시 예외를 관리할 클래스 추가 (be24494f)
* **exception:**  제약 조건 추가 (b29f7314)
* **OutputConsole:**
  *  수익률 계산을 출력하는 기능 추가 (cf14c75c)
  *  문자열 출력 기능 추가 (c759b628)
* **Statistics:**  수익률 계산 기능 추가 (82483ce5)
* **Tickets:**  당첨 여부 확인 기능 추가 (280137db)
* **README.md:**  여러 개의 로또 티켓 관리 기능 추가 (1f3fb4e1)
* **Rank,Ticket:**  당첨 여부 확인 기능 추가 (d27b0da7)
* **LottoNumberGenerator:**  로또 번호 추출 기능 추가 (f4ef6005)
* **TicketParser:**  로또 구입 금액 계산 기능 추가 (10ae5731)
* **LottoParser:**
  *  보너스 번호 변환 기능 추가 (099a540a)
  *  당첨 번호 변환 기능 추가 (06b453e8)
* **InputConsole:**  문자열 입력 기능 추가 (19e12b7f)
*  setup project (99b19647)

#### Bug Fixes

* **LottoController,LottoService:**
  *  당첨 번호와 보너스 번호가 중복임을 감지하지 않던 문제 수정 (eeb28bb3)
  *  init 메서드 수정 (d8da538b)
* **OutputConsole,Application:**  System.out 의존성 추가 및 init 메서드 삭제 (3bca75e7)
* **LottoController,LottoService,OutputConsole:**  예외 발생 시 프로그램이 다시 복구되지 않던 문제 수정 (dbd4cf04)
* **Statistics:**
  *  수익률을 정확하게 계산하지 못하던 문제 수정 (a9c20fb1)
  *  카운트되지 않았던 등수가 null로 표기되던 문제 수정 (e44c3d32)
* **Rank:**
  *  2등일 때의 결과를 제대로 출력하지 않던 문제 수정 (8af1a5bc)
  *  valueOf가 올바른 값을 리턴하지 않던 문제 수정 (ea035b9e)
* **OutputConsole:**  구매 결과 프롬프트가 요구 사항과 다르게 출력되던 문제 수정 (960464f4)
*  보너스 번호 판정 개념 수정 (58c17e29)
* **Ticket:**  올바른 등수를 반환하지 않던 문제 수정 (96b5624e)

#### Refactors

* **Application:**
  *  import 최적화 (5b2bfb56)
  *  LottoService의 인자에 BonusNumberParser를 추가 (19a928ae)
  *  main 메서드 작성 (2e48e6da)
* **LottoController:**
  *  play 메서드에서 발생한 예외를 래핑하여 전달하도록 개선 (968fd880)
  *  Controller 레이어 객체 추출 (154ba7b3)
* **DelimitedNumberFormatException:**  중복되는 예외 삭제 (074cc162)
* **Lotto:**
  *  검증 메서드 분리 (0c979fc7)
  *  getMatchCount 메서드명 수정 (9e001030)
  *  TICKET_PRICE가 Lotto에서 관리되도록 수정 (1e20a209)
  *  getter, toString 구현 (78af7776)
  *  패키지를 domain으로 변경 (b47ccee6)
* **ExceptionHandler:**  handleException 메서드 삭제 (aebeabcf)
* **DelimitedNumberParser,LottoException:**  중복되는 검증 및 예외 삭제 (e77274d4)
* **BonusNumberFormatException:**  팩토리 생성 메서드들을 public으로 변경 (eb66d96b)
* **BonusNumberParser,LottoService:**  보너스 번호 파싱 클래스 분리 및 적용 (27dc7572)
* **InputConsole:**  원인 예외 적용 (8b712c9d)
* **InputException:**  예외명 변경 (1943cbe1)
* **LottoNumberGenerator:**
  *  상수들의 접근 제어자를 public으로 변경 (19766861)
  *  generateBonusNumber가 List를 반환하지 않음 (9de8742c)
* **MoneyParser:**
  *  변환값 검증 메서드 분리 (74204fd0)
  *  클래스명 변경 (69ef9475)
* **StringParser:**
  *  isNumeric 메서드를 부정형으로 변경 (34c9ca34)
  *  validateNumeric 공통 메서드 삭제 (e1e57f10)
  *  Parser 객체들에서 StringParser 인터페이스 추출 (d39f6c7f)
* **LottoService:**  Service 레이어 객체 추출 (90d16982)
* **OutputConsole:**  System.out 의존성 제거 (f3e62dbb)
* **Lotteries:**
  *  불필요한 import 제거 (472442ae)
  *  size 메서드 추가 (433681d1)
  *  toString 메서드 수정 (55fe1539)
* **Lotteries,Statistics:**  당첨 여부 확인 기능을 Statistics에서 수행하도록 이관 (e52c96f5)
* **DelimitedNumberParser,MoneyParser:**  StringParser를 구현하도록 변경 (bef3cdca)
* **DelimitedNumberParser:**  용도에 더 부합하도록 클래스명 변경 (c0cde5d6)
* **LottoParser:**
  *  parseBallNumbers, parseBonusBall 메서드명 변경 (490f2321)
  *  final class로 변경 (4e387f46)
  *  상수들의 접근 제어자를 public으로 수정 (241e4661)
* **Statistics:**  toString 메서드 추가 (eb2b06ff)
* **Rank:**  toString 메서드 추가 (adec7a3e)
*  프로젝트 폴더 구조 변경 (f7506c9d)
*  프로젝트 폴더 구조 변경 (00313a87)
* **TicketParser:**
  *  final class로 변경 (268b9c27)
  *  TICKET_PRICE 상수의 접근 제어자를 public으로 수정 (9a767a18)
* **Ticket:**
  *  check 메서드가 Ticket을 전달받도록 수정 (ead99dbd)
  *  getter 추가 (79b8fbd9)

#### Code Style Changes

* **DelimitedNumberParser:**  줄바꿈 수정 (cee94f30)
* **DelimitedNumberParser,MoneyParser:**  오버라이딩 된 메서드에 어노테이션 추가 (dcfefccb)
* **LottoParser:**  줄바꿈 변경 (a9a3b82e)
* **StringParser:**  import 오타 수정 (fc5d3e13)
* **Tickets:**  메서드명 오타 수정 (791df4fd)

#### Tests

* **Application:**  import 최적화 (445025b4)
* **MoneyParser:**
  *  단위 테스트 추가 (1e5c55b8)
  *  클래스명 변경에 따른 테스트 코드 변경 (90df8e6b)
* **DelimitedNumberParser:**
  *  단위 테스트 추가 (648a08be)
  *  클래스명 변경에 따른 테스트 코드 변경 (3ed0f4ec)
* **Lotto:**
  *  단위 테스트 추가 및 원인 예외 검증 (a92e6530)
  *  패키지를 domain으로 변경 (aec50033)
* **LottoService:**  단위 테스트 추가 (03554dc1)
* **Lotteries:**
  *  기능 이관에 따른 테스트 삭제 (52e027ed)
  *  println 구문 삭제 (4e8a5922)
* **DelimitedNumberParser,MoneyParser:**
  *  폴더 위치 변경에 따른 테스트 코드 변경 (0155f516)
  *  싱글턴 클래스로 변경함에 따라 테스트 코드 변경 (275ed433)
* **LottoParser:**
  *  parseBallNumbers, parseBonusBall 메서드명 변경에 따른 수정 (ab2bc0e2)
  *  단위 테스트 추가 (ca0fff01)
* **TicketParser:**
  *  TICKET_PRICE가 Lotto에서 관리되도록 수정 (423c84e5)
  *  단위 테스트 추가 (32f04b48)
*  테스트 코드 폴더 구조 변경 (264375a1)
*  보너스 번호 판정 개념 수정에 따른 테스트 수정 (bee6b499)
*  폴더 구조 변경 (8612929b)
* **Tickets:**  단위 테스트 추가 (2f20b603)
* **Ticket:**  단위 테스트 추가 (38224506)
* **LottoNumbersTestCase:**  테스트 케이스 추가 (641723b8)

### 2024-11-04

#### Chores

* **.gitignore:**  .gitignore 수정 (ccb60da5)

#### Documentation Changes

* **README.md:**
  *  오타 수정 (6cc6655f)
  *  제약 조건 업데이트 (b75a4a08)
  *  기능 목록 수정 및 제약 조건 추가 (02fdb32b)
  *  기능 목록 수정 (e4c74d85)
  *  기능 목록 추가 (fdf6c596)
* **CHANGELOG.md:**
  *  Changelog 업데이트 (9e1de83d)
  *  changelog 문서 추가 (4aea1237)

#### New Features

* **ExceptionHandler:**  예외 상황 발생 시 예외를 관리할 클래스 추가 (be24494f)
* **exception:**  제약 조건 추가 (b29f7314)
* **OutputConsole:**
  *  수익률 계산을 출력하는 기능 추가 (cf14c75c)
  *  문자열 출력 기능 추가 (c759b628)
* **Statistics:**  수익률 계산 기능 추가 (82483ce5)
* **Tickets:**  당첨 여부 확인 기능 추가 (280137db)
* **README.md:**  여러 개의 로또 티켓 관리 기능 추가 (1f3fb4e1)
* **Rank,Ticket:**  당첨 여부 확인 기능 추가 (d27b0da7)
* **LottoNumberGenerator:**  로또 번호 추출 기능 추가 (f4ef6005)
* **TicketParser:**  로또 구입 금액 계산 기능 추가 (10ae5731)
* **LottoParser:**
  *  보너스 번호 변환 기능 추가 (099a540a)
  *  당첨 번호 변환 기능 추가 (06b453e8)
* **InputConsole:**  문자열 입력 기능 추가 (19e12b7f)
*  setup project (99b19647)

#### Bug Fixes

* **LottoController,LottoService:**
  *  당첨 번호와 보너스 번호가 중복임을 감지하지 않던 문제 수정 (eeb28bb3)
  *  init 메서드 수정 (d8da538b)
* **OutputConsole,Application:**  System.out 의존성 추가 및 init 메서드 삭제 (3bca75e7)
* **LottoController,LottoService,OutputConsole:**  예외 발생 시 프로그램이 다시 복구되지 않던 문제 수정 (dbd4cf04)
* **Statistics:**
  *  수익률을 정확하게 계산하지 못하던 문제 수정 (a9c20fb1)
  *  카운트되지 않았던 등수가 null로 표기되던 문제 수정 (e44c3d32)
* **Rank:**
  *  2등일 때의 결과를 제대로 출력하지 않던 문제 수정 (8af1a5bc)
  *  valueOf가 올바른 값을 리턴하지 않던 문제 수정 (ea035b9e)
* **OutputConsole:**  구매 결과 프롬프트가 요구 사항과 다르게 출력되던 문제 수정 (960464f4)
*  보너스 번호 판정 개념 수정 (58c17e29)
* **Ticket:**  올바른 등수를 반환하지 않던 문제 수정 (96b5624e)

#### Refactors

* **Application:**
  *  import 최적화 (5b2bfb56)
  *  LottoService의 인자에 BonusNumberParser를 추가 (19a928ae)
  *  main 메서드 작성 (2e48e6da)
* **LottoController:**
  *  play 메서드에서 발생한 예외를 래핑하여 전달하도록 개선 (968fd880)
  *  Controller 레이어 객체 추출 (154ba7b3)
* **DelimitedNumberFormatException:**  중복되는 예외 삭제 (074cc162)
* **Lotto:**
  *  검증 메서드 분리 (0c979fc7)
  *  getMatchCount 메서드명 수정 (9e001030)
  *  TICKET_PRICE가 Lotto에서 관리되도록 수정 (1e20a209)
  *  getter, toString 구현 (78af7776)
  *  패키지를 domain으로 변경 (b47ccee6)
* **ExceptionHandler:**  handleException 메서드 삭제 (aebeabcf)
* **DelimitedNumberParser,LottoException:**  중복되는 검증 및 예외 삭제 (e77274d4)
* **BonusNumberFormatException:**  팩토리 생성 메서드들을 public으로 변경 (eb66d96b)
* **BonusNumberParser,LottoService:**  보너스 번호 파싱 클래스 분리 및 적용 (27dc7572)
* **InputConsole:**  원인 예외 적용 (8b712c9d)
* **InputException:**  예외명 변경 (1943cbe1)
* **LottoNumberGenerator:**
  *  상수들의 접근 제어자를 public으로 변경 (19766861)
  *  generateBonusNumber가 List를 반환하지 않음 (9de8742c)
* **MoneyParser:**
  *  변환값 검증 메서드 분리 (74204fd0)
  *  클래스명 변경 (69ef9475)
* **StringParser:**
  *  isNumeric 메서드를 부정형으로 변경 (34c9ca34)
  *  validateNumeric 공통 메서드 삭제 (e1e57f10)
  *  Parser 객체들에서 StringParser 인터페이스 추출 (d39f6c7f)
* **LottoService:**  Service 레이어 객체 추출 (90d16982)
* **OutputConsole:**  System.out 의존성 제거 (f3e62dbb)
* **Lotteries:**
  *  불필요한 import 제거 (472442ae)
  *  size 메서드 추가 (433681d1)
  *  toString 메서드 수정 (55fe1539)
* **Lotteries,Statistics:**  당첨 여부 확인 기능을 Statistics에서 수행하도록 이관 (e52c96f5)
* **DelimitedNumberParser,MoneyParser:**  StringParser를 구현하도록 변경 (bef3cdca)
* **DelimitedNumberParser:**  용도에 더 부합하도록 클래스명 변경 (c0cde5d6)
* **LottoParser:**
  *  parseBallNumbers, parseBonusBall 메서드명 변경 (490f2321)
  *  final class로 변경 (4e387f46)
  *  상수들의 접근 제어자를 public으로 수정 (241e4661)
* **Statistics:**  toString 메서드 추가 (eb2b06ff)
* **Rank:**  toString 메서드 추가 (adec7a3e)
*  프로젝트 폴더 구조 변경 (f7506c9d)
*  프로젝트 폴더 구조 변경 (00313a87)
* **TicketParser:**
  *  final class로 변경 (268b9c27)
  *  TICKET_PRICE 상수의 접근 제어자를 public으로 수정 (9a767a18)
* **Ticket:**
  *  check 메서드가 Ticket을 전달받도록 수정 (ead99dbd)
  *  getter 추가 (79b8fbd9)

#### Code Style Changes

* **DelimitedNumberParser,MoneyParser:**  오버라이딩 된 메서드에 어노테이션 추가 (dcfefccb)
* **LottoParser:**  줄바꿈 변경 (a9a3b82e)
* **StringParser:**  import 오타 수정 (fc5d3e13)
* **Tickets:**  메서드명 오타 수정 (791df4fd)

#### Tests

* **Application:**  import 최적화 (445025b4)
* **MoneyParser:**
  *  단위 테스트 추가 (1e5c55b8)
  *  클래스명 변경에 따른 테스트 코드 변경 (90df8e6b)
* **DelimitedNumberParser:**
  *  단위 테스트 추가 (648a08be)
  *  클래스명 변경에 따른 테스트 코드 변경 (3ed0f4ec)
* **Lotto:**
  *  단위 테스트 추가 및 원인 예외 검증 (a92e6530)
  *  패키지를 domain으로 변경 (aec50033)
* **LottoService:**  단위 테스트 추가 (03554dc1)
* **Lotteries:**
  *  기능 이관에 따른 테스트 삭제 (52e027ed)
  *  println 구문 삭제 (4e8a5922)
* **DelimitedNumberParser,MoneyParser:**
  *  폴더 위치 변경에 따른 테스트 코드 변경 (0155f516)
  *  싱글턴 클래스로 변경함에 따라 테스트 코드 변경 (275ed433)
* **LottoParser:**
  *  parseBallNumbers, parseBonusBall 메서드명 변경에 따른 수정 (ab2bc0e2)
  *  단위 테스트 추가 (ca0fff01)
* **TicketParser:**
  *  TICKET_PRICE가 Lotto에서 관리되도록 수정 (423c84e5)
  *  단위 테스트 추가 (32f04b48)
*  테스트 코드 폴더 구조 변경 (264375a1)
*  보너스 번호 판정 개념 수정에 따른 테스트 수정 (bee6b499)
*  폴더 구조 변경 (8612929b)
* **Tickets:**  단위 테스트 추가 (2f20b603)
* **Ticket:**  단위 테스트 추가 (38224506)
* **LottoNumbersTestCase:**  테스트 케이스 추가 (641723b8)

### 2024-11-03

#### Chores

* **.gitignore:**  .gitignore 수정 (e404ad64)

#### Documentation Changes

* **CHANGELOG.md:**
  *  Changelog 업데이트 (585034c2)
  *  changelog 문서 추가 (f4517fbe)
* **README.md:**
  *  기능 목록 수정 (c23b5677)
  *  기능 목록 추가 (fdf6c596)

#### New Features

* **OutputConsole:**
  *  수익률 계산을 출력하는 기능 추가 (f366b82c)
  *  문자열 출력 기능 추가 (341a5b44)
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

* **Lotteries,Statistics:**  당첨 여부 확인 기능을 Statistics에서 수행하도록 이관 (89c418c3)
* **DelimitedNumberParser,MoneyParser:**  StringParser를 구현하도록 변경 (89d3fea8)
* **StringParser:**  Parser 객체들에서 StringParser 인터페이스 추출 (8a629f34)
* **DelimitedNumberParser:**  용도에 더 부합하도록 클래스명 변경 (628f468f)
* **MoneyParser:**  클래스명 변경 (638aec60)
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

* **LottoParser:**  줄바꿈 변경 (d38cc1bd)
*  import 오타 수정 (781c7712)
* **Tickets:**  메서드명 오타 수정 (0707bd3e)

#### Tests

* **DelimitedNumberParser,MoneyParser:**
  *  폴더 위치 변경에 따른 테스트 코드 변경 (d16967f8)
  *  싱글턴 클래스로 변경함에 따라 테스트 코드 변경 (5f940538)
* **DelimitedNumberParser:**  클래스명 변경에 따른 테스트 코드 변경 (cd4a7024)
* **MoneyParser:**  클래스명 변경에 따른 테스트 코드 변경 (0588f270)
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

### 2024-11-02

#### Chores

* **.gitignore:**  .gitignore 수정 (e404ad64)

#### Documentation Changes

* **CHANGELOG.md:**
  *  Changelog 업데이트 (585034c2)
  *  changelog 문서 추가 (f4517fbe)
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

* **DelimitedNumberParser,MoneyParser:**  StringParser를 구현하도록 변경 (89d3fea8)
* **StringParser:**  Parser 객체들에서 StringParser 인터페이스 추출 (8a629f34)
* **DelimitedNumberParser:**  용도에 더 부합하도록 클래스명 변경 (628f468f)
* **MoneyParser:**  클래스명 변경 (638aec60)
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

* **LottoParser:**  줄바꿈 변경 (d38cc1bd)
*  import 오타 수정 (781c7712)
* **Tickets:**  메서드명 오타 수정 (0707bd3e)

#### Tests

* **DelimitedNumberParser,MoneyParser:**  싱글턴 클래스로 변경함에 따라 테스트 코드 변경 (5f940538)
* **DelimitedNumberParser:**  클래스명 변경에 따른 테스트 코드 변경 (cd4a7024)
* **MoneyParser:**  클래스명 변경에 따른 테스트 코드 변경 (0588f270)
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

