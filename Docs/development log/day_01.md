# Day 01 (2024.10.29.)

## 목차

* [기능 정의](./day_01.md#기능-정의)
* [Java Enum 학습](./day_01.md#java-enum-학습)
    * [Enum이란?](./day_01.md#enum이란)
    * [Enum 선언하기](./day_01.md#enum-선언하기)
    * [Enum의 특징](./day_01.md#enum의-특징)
    * [Enum 메서드](./day_01.md#enum-메서드)
    * [Enum 필드와 메서드](./day_01.md#enum-필드와-메서드)
    * [Enum을 활용한 Switch 문](./day_01.md#enum을-활용한-switch-문)
    * [Enum과 인터페이스 구현](./day_01.md#enum과-인터페이스-구현)

* [기능 개발](./day_01.md#기능-개발)
    * [로또 발행 개수 확인 기능](./day_01.md#로또-발행-개수-확인-기능)

* [To do List](./day_01.md#to-do-list)

<br>

## [기능 정의](./day_01.md#목차)
요구사항에 따라 필요한 기능들을 정리해보았다.

* 로또 발행하기
    * 로또 발급 개수 확인하기
    * 중복되지 않는 6개의 숫자 뽑기
* 사용자 입력 받기
    * 로또 구입 금액 입력받기
    * 로또 당첨 번호 입력받기
    * 로또 보너스 번호 입력받기
* 로또 당첨 기준 적용하기
* 로또 당첨 여부 체크하기
* 커스텀 Exception 생성하기
* 에러 메시지 출력하기
* Enum 정의하기
* 수익률 계산하기


## [Java Enum 학습](./day_01.md#목차)

### [Enum이란?](./day_01.md#목차)
**열거형 상수를 정의**하기 위해 사용되는 특별한 데이터 타입이다.<br>
고정된 상수 집합을 선언하는 데 유용하며, 주로 상태나 종류를 표현할 때 활용된다.

ex) ```요일```, ```방향```, ```상태``` 등을 정의할 때 Enum을 사용하면 가독성과 유지 보수성이 높아진다.

### [Enum 선언하기](./day_01.md#목차)
```enum``` 키워드를 사용하며, 기본적으로 클래스와 비슷한 방식으로 정의한다.<br>각 상수는 인스턴스처럼 사용할 수 있다.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```
```Day.MONDAY```와 같은 방식으로 접근할 수 있다.

### [Enum의 특징](./day_01.md#목차)
* **타입 안정성**<br>
Enum을 사용하면 컴파일러가 타입을 검사하기 때문에 코드에서 유효하지 않은 값을 사용하는 실수를 방지할 수 있다.

<br>

* **내부적으로 클래스**<br>
내부적으로 클래스처럼 동작한다.<br>
```static final```필드로 간주되며, ```Enum```은 상수들을 포함하는 특수한 클래스이다.

<br>

* **상속 불가능**<br>
암묵적으로 ```java.lang.Enum``` 클래스를 상속받으며, 추가 상속은 불가능하다.

<br>

* **열거된 상수의 순서**<br>
각 상수는 정의된 순서에 따라 고유의 인덱스(ordinal 값)을 가진다.<br>
이를 통해 ```Enum```의 순서 및 배열 형태의 처리가 가능하다.

<br><br>

### [Enum 메서드](./day_01.md#목차)
* ```values()```: 모든 열거형 상수를 배열로 반환.
* ```valueOf(String name)```: 주어진 이름에 해당하는 Enum 상수를 반환.
* ```ordinal()```: Enum 상수가 정의된 순서를 반환. (0부터 시작)

<br>

```java
for (Day day : Day.values()) {
    System.out.println(day); // 모든 요일이 출력됩니다.
}
Day myDay = Day.valueOf("MONDAY");
System.out.println(myDay); // MONDAY 출력
System.out.println(myDay.ordinal()); // 0 출력
```

<br>

### [Enum 필드와 메서드](./day_01.md#목차)
Enum에 생성자, 필드 및 메서드를 추가하여 각 상수에 값을 설정할 수 있다.
<br>

```java
public enum Day {
    MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"),
    THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일"), SUNDAY("일요일");

    private final String koreanName;

    Day(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
```

위 예제에서 ```koreanName```이라는 필드를 추가하고 각 요일마다 한글 이름을 설정했다.<br>
```getKoreanName()``` 메서드를 통해 한글 이름을 얻을 수 있다.


```java
System.out.println(Day.MONDAY.getKoreanName()); // 월요일
```

<br>

### [Enum을 활용한 Switch 문](./day_01.md#목차)
```Enum```의 각 상수에 따라 다른 처리가 가능하므로 코드가 더 간결해진다.

<br>

```java
public static void printMessage(Day day) {
    switch (day) {
        case MONDAY:
            System.out.println("새로운 주의 시작입니다!");
            break;
        case FRIDAY:
            System.out.println("주말이 곧 시작됩니다!");
            break;
        default:
            System.out.println("평범한 날입니다.");
            break;
    }
}
```

<br>

### [Enum과 인터페이스 구현](./day_01.md#목차)
```Enum```은 인터페이스를 구현할 수 있다.<br>
이를 통해 Enum 내에 일관된 동작을 정의할 수 있다.

<br>

```java
interface Displayable {
    void display();
}

public enum Day implements Displayable {
    MONDAY, TUESDAY, WEDNESDAY;

    @Override
    public void display() {
        System.out.println("오늘은 " + this + "입니다.");
    }
}
```

## [기능 개발](./day_01.md#목차)

### [로또 발행 개수 확인 기능](./day_01.md#목차)

#### Test Code
```java
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoServiceTest {

    private static LottoService lottoService;

    @Test
    void 로또_발행_개수_테스트() {
        int cost = 8000;
        int expectedCount = cost / lottoService.getLottoCost();
        assertEquals(expectedCount, lottoService.issueRottoCount(cost));
    }


    @Test
    void 로또_발행_개수_예외_테스트() {
        int cost = 1799;
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.issueRottoCount(cost);
        });
    }

    @BeforeAll
    static void beforeAll() {
        lottoService = new LottoService();
    }
}
```

<br>


#### Production Code

```java
public class LottoService {
    private final int lottoCost = 1_000;

    public int getLottoCost() {
        return lottoCost;
    }

    public int issueRottoCount(int cost) throws IllegalArgumentException {
        if (cost % lottoCost > 0) {
            throw new IllegalArgumentException("[Error] 구입 금액은 " + lottoCost + "원 단위이어야 합니다.");
        }

        return cost / lottoCost;
    }
}
```

#### 이후 해야할 것들
* Custom Exception 생성 및 적용하기


<br>

## [To do List](./day_01.md#목차)

- [ ] 로또 발행하기
    - [x] 로또 발급 개수 확인하기
    - [ ] 중복되지 않는 6개의 숫자 뽑기
- [ ] 사용자 입력 받기
    - [ ] 로또 구입 금액 입력받기
    - [ ] 로또 당첨 번호 입력받기
    - [ ] 로또 보너스 번호 입력받기
- [ ] 로또 당첨 기준 적용하기
- [ ] 로또 당첨 여부 체크하기
- [ ] 커스텀 Exception 생성하기
- [ ] 에러 메시지 출력하기
- [ ] Enum 정의하기
- [ ] 수익률 계산하기