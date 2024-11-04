# Day 05 (2024.11.04.) (Last)

## 목차
* [예외 메시지 Enum 추가](./day_05.md#예외-메시지-enum-추가)
* [오류 반환 전까지 메서드 반복 실행](./day_05.md#오류-반환-전까지-메서드-반복-실행)
    * [Supplier?](./day_05.md#supplier)


## [예외 메시지 Enum 추가](./day_05.md#목차)

```java
public enum ErrorCode {
    OUT_OF_BOUNDS_LOTTO_NUMBER("[Error] 범위 밖의 수가 입력되었습니다. 1 이상 45 이하의 수만 가능합니다."),
    NOT_NUMBERS_INPUT("[Error] 수가 아닌 값을 입력받았습니다."),
    MINUS_ISSUE_COST("[Error] 구입 금액은 0 이상의 정수이어야 합니다."),
    INVALID_UNIT_ISSUE_COST("[Error] 구입 금액의 단위는 1,000원입니다. 단위에 맞게 금액을 입력해주시기 바랍니다."),
    MISMATCH_LOTTO_NUMBERS_COUNT("[Error] 로또 번호는 중복되지 않는 6개의 수로 이루어져야 합니다."),
    ALREADY_EXISTS_BONUS_NUMBER("[Error] 보너스 번호로 이미 존재하는 수가 입력되었습니다.");

    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```

<br>

## [오류 반환 전까지 메서드 반복 실행](./day_05.md#목차)
```java
private static void executeUntilNoException(Supplier<Void> method) {
    while (true) {
        try {
            method.get();
            break;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
```

<br>

### [Supplier?](./day_05.md#목차)
Java 8에서 추가된 **함수형 인터페이스.**<br>
매개변수는 없고 값 하나를 반환하는 함수형 인터페이스이다.<br>
어떤 값을 지연 생성하거나 동적으로 생성할 필요가 있을 때 사용된다.

#### 특징
1. 입력 값 없음, 출력 있음<br>
입력 매개변수를 받지 않고, 대신 하나의 값을 반환한다.

2. 제네릭 타입<br>
반환하는 값의 타입을 제네릭 타입 ```<T>```로 정의하여 다양한 타입을 반환할 수 있다.

3. 함수형 인터페이스<br>
```@FunctionalInterface```로 선언되어 있어 람다 표현식 또는 메서드 참조를 사용할 수 있다.

<br>

#### Supplier 구조
```java
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
```

* ```get()``` 메서드: 호출될 때마다 새로운 값을 생성하여 반환한다.

