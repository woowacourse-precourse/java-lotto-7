# 로또 게임

## 과제 진행 요구사항

- 로또 저장소 포크 및 클론으로 시작
- README.md에 구현할 기능 목록 정리
- Git 커밋은 기능 목록 단위로 추가
- AngularJS Git Commit Message Conventions 참고
- 프리코스 진행 가이드 문서 참고

## 기능 요구사항

### 기본 규칙

- 로또 번호 범위: 1~45
- 1개의 로또: 중복되지 않는 6개 숫자
- 당첨 번호: 중복되지 않는 6개 숫자 + 보너스 번호 1개

### 당첨 기준 및 금액

1. 1등: 6개 번호 일치 (2,000,000,000원)
2. 2등: 5개 번호 + 보너스 번호 일치 (30,000,000원)
3. 3등: 5개 번호 일치 (1,500,000원)
4. 4등: 4개 번호 일치 (50,000원)
5. 5등: 3개 번호 일치 (5,000원)

### 구매 규칙

- 로또 1장 가격: 1,000원
- 구입 금액에 해당하는 만큼 로또 발행
- 당첨 번호와 보너스 번호 입력 후 당첨 내역 및 수익률 계산

### 예외 처리

- 잘못된 값 입력 시 IllegalArgumentException 발생
- "[ERROR]"로 시작하는 에러 메시지 출력
- 명확한 Exception 유형 처리

## 입출력 요구사항

### 입력

1. 구입 금액 입력 (1,000원 단위)
2. 당첨 번호 입력 (쉼표로 구분)
3. 보너스 번호 입력

### 출력

1. 발행 로또 수량 및 번호 (오름차순 정렬)
2. 당첨 내역
3. 수익률 (소수점 둘째 자리에서 반올림)
4. 에러 상황 시 "[ERROR]" 메시지

## 프로그래밍 요구사항

### 기본 요구사항

- JDK 21 버전 사용
- Application의 main()에서 시작
- 외부 라이브러리 사용 금지
- System.exit() 사용 금지
- 자바 코드 컨벤션 준수

### 코드 품질 요구사항

1. indent depth ≤ 2
2. 3항 연산자 사용 금지
3. 함수는 한 가지 기능만 수행
4. 함수 길이 15라인 이하
5. else 예약어 사용 금지 (switch/case 포함)
6. Java Enum 적용
7. 단위 테스트 작성 (UI 로직 제외)

### 테스트 관련

- JUnit 5와 AssertJ 사용
- 기능 목록에 대한 테스트 코드 작성

## 라이브러리 사용

### camp.nextstep.edu.missionutils

- Randoms.pickUniqueNumbersInRange() 사용
- Console.readLine() 사용

### Lotto 클래스 요구사항

```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}

```

- numbers 외 필드 추가 불가
- private 접근 제어자 변경 불가
- 패키지 변경 가능