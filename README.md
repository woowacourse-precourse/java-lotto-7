# 학습 목표

> 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.

> 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- <h4>🔥 함수(또는 메서드)가 `한 가지 일`만 하도록 최대한 작게 만들어라.</h4>
    - 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
    - else 예약어를 쓰지 않는다.
    - Java Enum을 적용하여 프로그램을 구현한다.
    - 구현한 기능에 대한 단위 테스트를 작성한다.
        - 단, UI(System.out, System.in, Scanner) 로직은 제외한다.

- 처음부터 큰 단위의 테스트를 만들지 않는다
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

---

# 개인 목표

- 함수 8줄 이내 작성. 메서드와 기능 1:1 매치가 되게 노력하자.

---

# java-lotto-precourse 기능 목록서

## 공용

| 도메인                  | 기능          | 세부 기능              | 상태 |
|----------------------|-------------|--------------------|----|
| Common(ThousandWons) | 천원 단위 금액 생성 | 정상적인 천원 단위 금액 생성   | ✅  |
|                      |             | 천원 단위가 아닌 금액 검증    | ✅  |
|                      |             | 음수,0 금액 검증         | ✅  |
|                      |             | 숫자가 아닌 입력값 검증      | ✅  |
|                      | 금액 비교       | 목표 금액보다 크거나 같은지 확인 | ✅  |
|                      |             | 목표 금액보다 작은지 확인     | ✅  |
|                      | 금액 나누기      | 나누어 떨어지는 경우 처리     | ✅  |
|                      |             | 나누어 떨어지지 않는 경우 처리  | ✅  |

# 유틸 기능

| 영역              | 기능        | 세부 기능                 | 상태 |
|-----------------|-----------|-----------------------|----|
| StringConverter | 문자열 trim  | 문자열 앞뒤 공백 제거          | ✅  |
|                 |           | null 값 검증             | ✅  |
|                 |           | 빈 문자열 검증              | ✅  |
|                 |           | 공백 문자열 검증             | ✅  |
|                 | 문자열 split | 쉼표로 문자열 분리            | ✅  |
|                 |           | null 값 검증             | ✅  |
|                 |           | 빈 문자열 검증              | ✅  |
|                 |           | 공백 문자열 검증             | ✅  |
|                 | 정수 리스트 변환 | 숫자 문자열 배열을 정수 리스트로 변환 | ✅  |
|                 |           | 숫자가 아닌 문자열 검증         | ✅  |
|                 |           | 빈 문자열 포함 검증           | ✅  |

---

# 1. 🎫 로또 티켓 기능 목록서

## 1. 도메인

| 도메인         | 기능                      | 세부 기능              | 상태 |
|-------------|-------------------------|--------------------|----|
| Payment 도메인 | 로또 가격(LottoPrice) 관리    | 기본 가격(1000원)으로 생성  | ✅  |
|             |                         | 구매 가능한 금액 검증       | ✅  |
|             |                         | 천원 단위 금액으로 검증      | ✅  |
|             |                         | 구매 가능 수량 계산        | ✅  |
|             | 로또 수량(LottoQuantity) 관리 | 유효한 수량(1~100) 생성   | ✅  |
|             |                         | 최소/최대 수량(1~100) 검증 | ✅  |
|             |                         | 수량값 조회             | ✅  |
|             | 결제(Payment) 처리          | 결제 정보 초기화          | ✅  |
|             |                         | 결제 가능 여부 검증        | ✅  |
|             |                         | 중복 검증 방지           | ✅  |
|             |                         | 결제 실행              | ✅  |
|             |                         | 중복 실행 방지           | ✅  |
|             |                         | 로또 수량 계산           | ✅  |
|             | 결제 결과(PaymentResult) 관리 | 결제 결과 생성           | ✅  |
|             |                         | 완료된 결제 정보 조회       | ✅  |
| Ticket 도메인  | 로또(Lotto) 관리            | 6개의 번호로 로또 생성      | ✅  |
|             |                         | 번호 범위 검증(1~45)     | ✅  |
|             |                         | 번호 개수 검증(6개)       | ✅  |
|             |                         | 중복 번호 검증           | ✅  |
|             | 로또 목록(Lottos) 관리        | 유효한 로또 목록 생성       | ✅  |
|             |                         | null 로또 목록 검증      | ✅  |
|             |                         | 빈 로또 목록 검증         | ✅  |
|             |                         | 로또 목록 불변성 보장       | ✅  |
|             | 티켓(Ticket) 관리           | 티켓 발행              | ✅  |
|             |                         | ID와 로또 목록으로 생성     | ✅  |
|             |                         | null ID 검증         | ✅  |
|             |                         | null 로또 목록 검증      | ✅  |
|             | 티켓 정보 조회                | 티켓 ID 조회           | ✅  |
|             |                         | 로또 목록 조회           | ✅  |

## 2. 도메인 외 계층

| 영역         | 기능        | 세부 기능                    | 상태 |
|------------|-----------|--------------------------|----|
| UseCase    | 티켓 생성 관리  | 구매 금액 입력 받기              | ✅  |
|            |           | 티켓 생성 요청                 | ✅  |
|            |           | 생성된 티켓 조회                | ✅  |
|            |           | 결과 출력                    | ✅  |
| Controller | API 관리    | 구매 금액으로 티켓 생성            | ✅  |
|            |           | ID로 티켓 조회                | ✅  |
| Service    | 결제 쓰기 서비스 | 결제 정보 초기화                | ✅  |
|            |           | 결제 검증 및 실행               | ✅  |
|            |           | 결제 정보 저장                 | ✅  |
|            |           | 로또 수량 반환                 | ✅  |
|            | 티켓 쓰기 서비스 | 로또 번호 생성                 | ✅  |
|            |           | 티켓 발행                    | ✅  |
|            |           | 티켓 저장                    | ✅  |
|            | 티켓 읽기 서비스 | ID로 티켓 조회                | ✅  |
|            |           | 존재하지 않는 티켓 예외 처리         | ✅  |
|            |           | 응답 DTO 변환                | ✅  |
|            | ID 자동 생성  | 결제 ID 자동 생성              | ✅  |
|            |           | 티켓 ID 자동 생성              | ✅  |
|            | 유니크 번호 생성 | 유니크 번호 생성                | ✅  |
| Repository | 결제 저장소 관리 | ConcurrentHashMap 저장소 생성 | ✅  |
|            |           | 결제 정보 저장                 | ✅  |
|            |           | ID로 저장 결과 반환             | ✅  |
|            |           | 결제 저장소 초기화               | ✅  |
|            | 티켓 저장소 관리 | ConcurrentHashMap 저장소 생성 | ✅  |
|            |           | 티켓 저장                    | ✅  |
|            |           | ID로 저장 결과 반환             | ✅  |
|            |           | ID로 티켓 조회                | ✅  |
|            |           | 티켓 저장소 초기화               | ✅  |

## 3. View 계층

| 영역          | 기능       | 세부 기능                  | 상태 |
|-------------|----------|------------------------|----|
| Ticket View | 구매 금액 입력 | 콘솔에 구매 금액 입력 안내 메시지 출력 | ✅  |
|             |          | 금액 문자열 입력 받기           | ✅  |
|             |          | ThousandWons 객체로 변환    | ✅  |
|             | 구매 결과 출력 | 구매한 로또 수량 메시지 포맷팅      | ✅  |
|             |          | 구매 수량 출력               | ✅  |
|             |          | 로또 번호 목록 포맷팅           | ✅  |
|             |          | 각 로또 번호 출력             | ✅  |
|             | 출력 포맷 관리 | 구매 메시지 형식 지정           | ✅  |
|             |          | 로또 번호 형식 지정            | ✅  |
|             | 출력 처리    | 메시지 라인 추가              | ✅  |
|             |          | 최종 출력 실행               | ✅  |

---

# 2. 💵 당첨 기능 목록서

## 1. 도메인 계층

| 도메인   | 기능                          | 세부 기능                             | 상태 |
|-------|-----------------------------|-----------------------------------|----|
| Prize | Prize(당첨) 관리                | ID와 PrizeNumber로 당첨 생성            | ✅  |
|       |                             | 당첨 결과 조회                          | ✅  |
|       | Prize 번호(PrizeNumber) 관리    | WinnerNumbers 객체로 당첨 번호 설정        | ✅  |
|       |                             | BonusNumber 객체로 보너스 번호 설정         | ✅  |
|       |                             | 당첨 정보를 DTO(PrizeNumberResult)로 조회 | ✅️ |
|       | 당첨 번호(WinnerNumbers) 관리     | Lotto 객체로 당첨 번호 설정                | ✅  |
|       | 보너스 번호(BonusNumber) 관리      | 보너스 번호 생성                         | ✅️ |
|       |                             | 보너스 번호 범위 검증(1~45)                | ✅  |
|       |                             | 당첨 번호와의 중복 검증                     | ✅  |
|       |                             | 보너스 번호 값 반환                       | ✅  |
|       | 당첨 결과(PrizeNumberResult) 관리 | 보너스 번호와 당첨 번호 조합                  | ✅  |
|       |                             | 결과 객체 생성 및 반환                     | ✅  |

## 2. 도메인 외 계층

| 영역         | 기능       | 세부 기능                      | 상태 |
|------------|----------|----------------------------|----|
| UseCase    | 당첨 생성 관리 | 당첨번호 입력 뷰에서 요청 정보 받기       | ✅️ |
|            |          | 컨트롤러를 통한 당첨번호 저장           | ✅  |
|            |          | 저장된 당첨번호 정보 조회             | ✅  |
| Controller | API 관리   | 당첨번호와 보너스번호로 저장            | ✅  |
|            |          | ID로 당첨 정보 조회               | ✅  |
| Service    | 생성 관리    | Prize 생성 서비스               | ✅  |
|            |          | ID 생성                      | ✅  |
|            |          | Prize 저장                   | ✅  |
|            |          | Prize 번호 생성 서비스            | ✅  |
|            |          | WinnerNumbers 생성           | ✅  |
|            |          | BonusNumber 생성             | ✅  |
|            |          | Prize Id 자동 생성기 생성         | ✅  |
|            | 조회 관리    | Prize ID로 당첨 정보 조회         | ✅  |
|            |          | 존재하지 않는 ID 예외 처리           | ✅  |
|            |          | 조회 결과 DTO 변환               | ✅  |
| Repository | 저장소 관리   | ConcurrentHashMap으로 저장소 생성 | ✅  |
|            |          | Prize 객체 저장                | ✅  |
|            |          | ID로 저장 결과 반환               | ✅  |
|            |          | Prize Id로 단건 조회            | ✅  |

## 3. View 계층

| 영역         | 기능        | 세부 기능                   | 상태 |
|------------|-----------|-------------------------|----|
| Prize View | 당첨 번호 입력  | 콘솔에 당첨 번호 입력 안내 메시지 출력  | ✅  |
|            |           | 쉼표로 구분된 당첨 번호 입력 받기     | ✅  |
|            |           | 입력값 공백 제거               | ✅  |
|            |           | 숫자 리스트로 변환              | ✅  |
|            | 보너스 번호 입력 | 콘솔에 보너스 번호 입력 안내 메시지 출력 | ✅  |
|            |           | 보너스 번호 입력 받기            | ✅  |
|            |           | 입력값 공백 제거               | ✅  |
|            |           | 숫자로 변환                  | ✅  |
|            | 입력값 전달    | 당첨 번호와 보너스 번호를 DTO로 변환  | ✅  |

---

# 3. 📊 통계 기능 목록서

## 1. 도메인 계층

| 도메인        | 기능       | 세부 기능                | 상태 |
|------------|----------|----------------------|----|
| Statistics | 당첨 결과 계산 | 구매한 로또와 당첨번호 비교      | ⬜️ |
|            |          | 일치하는 번호 개수 확인        | ⬜️ |
|            |          | 보너스 번호 일치 여부 확인      | ⬜️ |
|            | 당첨 등수 관리 | 1등(6개 일치) 확인         | ⬜️ |
|            |          | 2등(5개+보너스) 확인        | ⬜️ |
|            |          | 3등(5개) 확인            | ⬜️ |
|            |          | 4등(4개) 확인            | ⬜️ |
|            |          | 5등(3개) 확인            | ⬜️ |
|            | 당첨금 계산   | 등수별 당첨금액 계산          | ⬜️ |
|            |          | 총 당첨금액 계산            | ⬜️ |
|            | 수익률 계산   | 수익률 계산(소수점 둘째자리 반올림) | ⬜️ |
|            | 통계 정보 관리 | 당첨 통계 생성             | ⬜️ |
|            |          | 당첨 통계 조회             | ⬜️ |
|            |          | 등수별 당첨 내역 포맷팅        | ⬜️ |

## 2. 도메인 외 계층

| 영역         | 기능       | 세부 기능        | 상태 |
|------------|----------|--------------|----|
| Service    | 통계 관리    | 당첨 결과 집계     | ⬜️ |
|            |          | 통계 결과 DTO 변환 | ⬜️ |
| Controller | API 관리   | 통계 집계 요청 처리  | ⬜️ |
|            |          | 집계 결과 응답 반환  | ⬜️ |
| UseCase    | 통계 흐름 관리 | 티켓과 당첨 정보 전달 | ⬜️ |
|            |          | 통계 결과 출력 요청  | ⬜️ |

## 3. VIEW 계층

| 영역              | 기능       | 세부 기능                              | 상태 |
|-----------------|----------|------------------------------------|----|
| Statistics View | 당첨 통계 출력 | 당첨 통계 시작 구분선 출력 ("---")            | ⬜️ |
|                 |          | 당첨 통계 제목 출력                        | ⬜️ |
|                 | 당첨 내역 출력 | 3개 일치 (5,000원) - n개                | ⬜️ |
|                 |          | 4개 일치 (50,000원) - n개               | ⬜️ |
|                 |          | 5개 일치 (1,500,000원) - n개            | ⬜️ |
|                 |          | 5개 일치, 보너스 볼 일치 (30,000,000원) - n개 | ⬜️ |
|                 |          | 6개 일치 (2,000,000,000원) - n개        | ⬜️ |
|                 | 수익률 출력   | 총 수익률 계산 결과 포맷팅                    | ⬜️ |
|                 |          | 수익률 메시지 출력 (소수점 둘째자리까지)            | ⬜️ |
|                 | 출력 포맷 관리 | 당첨 내역별 메시지 형식 지정                   | ⬜️ |
|                 |          | 수익률 형식 지정                          | ⬜️ |
|                 | 출력 처리    | 메시지 라인 추가                          | ⬜️ |
|                 |          | 최종 출력 실행                           | ⬜️ |
