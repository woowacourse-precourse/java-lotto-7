# java-lotto-precourse

# 프로젝트 개요

간단한 로또 발매기를 구현한다.
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


# 구현 흐름

1. 사용자 입력 받기
    - [x] 로또 구입 금액 입력
        - [x] 로또 구입 금액은 1,000원 단위로 입력
            - [x] 1,000원 단위가 아니면 예외 발생
        - [x] 예외 처리
            - [x] 로또 구입 금액이 1,000원 미만이면 예외 발생
            - [x] 로또 구입 금액이 숫자가 아니면 예외 발생
            - [x] 로또 구입 금액이 100,000,000원을 초과하면 예외 발생
    - [x] 당첨 번호 입력
        - [x] 당첨 번호는 쉼표(,)로 구분
        - [x] 당첨 번호는 6개의 숫자로 구성
            - [x] 6개의 숫자가 아니면 예외 발생
        - [x] 로또 번호는 1~45 사이의 숫자만 입력 가능
            - [x] 1~45 사이의 숫자가 아니면 예외 발생
        - [x] 예외 처리
            - [x] 당첨 번호가 숫자가 아니면 예외 발생
            - [x] 당첨 번호가 중복되면 예외 발생
    - [x] 보너스 번호 입력
        - [x] 보너스 번호는 1~45 사이의 숫자만 입력 가능
            - [x] 1~45 사이의 숫자가 아니면 예외 발생
        - [x] 예외 처리
            - [x] 보너스 번호가 숫자가 아니면 예외 발생
            - [x] 보너스 번호가 당첨 번호와 중복되면 예외 발생  

2. 로또 시작하기
    - [x] 로또 구입 금액에 해당하는 만큼 로또를 발행
        - [x] 로또 번호는 중복되지 않는 6개의 숫자로 구성
        - [x] 로또 번호는 오름차순으로 정렬
        - [x] 로또 번호는 1~45 사이의 숫자만 입력 가능
    - [x] 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률 출력 
    - [x] 당첨 내역 및 수익률 출력
        - [x] 당첨 내역은 3개 일치부터 6개 일치까지 출력
        - [x] 수익률은 소수점 첫째 자리까지 출력

# 세부적인 구현 목록

### 세부적인 구현 목록

- **도메인 계층**
  - [x] Lotto 클래스 구현
    - [x] 로또 번호 리스트 저장
    - [x] 로또 번호 유효성 검사
  - [x] LottoNumber 클래스 구현
    - [x] 개별 로또 번호 저장
    - [x] 번호 유효성 검사 (1~45)
  - [x] LottoResult 클래스 구현
    - [x] 당첨 등수 저장
    - [x] 당첨 금액 저장
  - [x] LottoGame 클래스 구현
    - [x] 구매한 로또 리스트 저장
    - [x] 당첨 번호 저장
    - [x] 보너스 번호 저장
    - [x] 게임 결과 계산

- **서비스 계층**
  - [x] LottoService 클래스 구현
    - [x] 로또 구매 로직 구현
    - [x] 중복되지 않는 6개의 번호 생성
    - [x] 게임 결과 계산 로직 구현

- **프레젠테이션 계층**
  - [x] LottoController 클래스 구현
    - [x] LottoService 호출
    - [x] 결과 반환

- **입출력**
  - [x] LottoConsole 클래스 구현
    - [x] 사용자 입력 받기
    - [x] 결과 출력

- **애플리케이션 실행**
  - [x] Application 클래스에 main 메서드 구현
  - [x] LottoConsole 생성 및 실행

        

# 추가 체크 목록
- [ ] 스프링 프레임워크 흉내 내보기
    - [ ] 스프링 컨테이너
    - [ ] @Autowired, @Component 사용




