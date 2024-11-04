# 도메인 객체 및 기능 목록

### 💸 로또 구입 금액 `LottoMoney`
- [x] 로또 구입 금액과 로또 구입 수량을 가진다.
- [x] 1,000원 단위의 돈이어야 한다.

### 🔢 로또 번호 `LottoNumber`
- [x] 값으로 동등성을 비교할 수 있다.
- [x] 1~45 사이의 숫자

### 🎫 로또 `Lotto`
- [x] 로또 번호 리스트 `List<LottoNumber>`를 가진다.
- [x] 크기를 6으로 제한한다.
- [x] LottoNumber 는 중복되지 않아야 한다.

### 🥇 당첨 로또 `WinningLotto`
- [x] 1~45 사이의 중복되지 않은 정수 6개 + 보너스 번호
- [x] 보너스 번호는 당첨 번호와 중복되지 않아야 한다.

### 🎟️ 로또 티켓 `Lottoticket`
- [x] 로또 리스트 `List<Lotto>`를 가진다.

### 🧑‍🏭 로또 생성기 `LottoCreator`
- [x] 로또 한 장을 생성한다.

### 🏭 로또 티켓 생성기 `LottoTicketCreator`
- [x] 다양한 로또 발행기로 로또를 발행한다.
- [x] 발행할 로또 개수 `lottoCount` 만큼 로또를 발행한다.

### 🏧 로또 발매기 `LottoGenerator`
- [x] 로또 발매기 인터페이스
- [x] 다양한 로또 발매기가 있을 수 있다. 예) 랜덤 로또 발매기, . . .

### 🎰 랜덤 로또 발매기 `RandomLottoGenerator`
- [x] 1~45 사이의 중복되지 않은 정수 6개를 반환한다.
- [x] 반환된 6개의 정수를 LottoCreator에 넣어 Lotto를 발행한다.

### 🧑‍⚖️ 로또 티켓 당첨 확인 `LottoTicketMatcher`
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.

### 🪙 수익 `Revenue`
- [x] 수익과 수익률을 계산한다.

### ❓ 로또 당첨 결과 `LottoResult`
- [x] 로또 상금별 당첨 개수를 가진다.


# 고민 및 PR의 중요한 내용

## 🖍️ 에러 메시지

에러 메시지를 일관성 있게 작성하기 위해 enum으로 한 곳에서 관리했습니다. 각 예외 클래스 내부에 메시지를 정의하는 것과 비교했을 때, 통일성 있는 에러 메시지를 작성하기 위한 더 좋은 방법이라고 판단했습니다.

## 🏓 방어적 복사, Arrays.copyOf(), getter 지양

`int` 타입의 필드가 `final`로 선언된 경우 절대 값을 변경할 수 없습니다. `int`는 기본 타입이기 때문에 참조가 아닌 값 자체를 저장하며, `final`로 선언하면 재할당이 불가능해집니다.

이와 반면, 컬렉션(List, Set, Map, . . )이나 가변 객체(Date)의 경우 외부에서 컬렉션의 내용을 변경할 수 있는 경우 불변성을 보장하기 위해 방어적 복사를 사용할 수 있습니다. 특히 Getter 성격의 메서드가 있을 경우, 외부에서 리스트 등을 변경할 가능성이 있습니다. 이를 방지하기 위해 Arrays.copyOf()나 unmodifiableList 등의 방법을 사용할 수 있습니다.

```java
public List<LottoNumber> getLottoNumbers() {
		return Collections.unmodifiableList(lottoNumbers);
}
```

## 🎳 여러 조건을 테스트하고 싶다면, assertAll 사용

```java
assertAll(
	() -> assertThat(lottoNumbers).hasSize(Constants.LOTTO_SIZE),
  () -> assertThat(lottoNumbers)
		  .allMatch(number -> number.getLottoNumber() >= Constants.MIN_LOTTO_NUMBER
		      && number.getLottoNumber() <= Constants.MAX_LOTTO_NUMBER)
);
```

## 🎫 로또 티켓 일급 컬렉션

단순하게 값을 감싸며, 로직을 포함하지 않는 일급 컬렉션은 지양해야 합니다. 다만, 로또 티켓의 경우 List<Lotto> 를 필드로 가지며, 별다른 행위나 상태를 가지고 있지 않습니다.

로또 티켓이 가질 수 있는 상태나 행위에는 어떤 것들이 있을까요? (미해결)

## 💫 검증의 책임을 분리하기

값에 대한 검증은 여러 곳에서 수행할 수 있습니다. 사용자로부터 값을 입력 받을 때 1차적으로 타입 또는 null 값에 대한 검증을 할 수 있고, VO 와 같은 객체를 사용한다면 그 내부에서도 검증하는 로직을 포함합니다. 또 필요하다면 비즈니스 로직에서도 값을 검증할 수 있습니다. 이에 돈에 대한 검증은 아래와 같이 실시했습니다.

1. Input 에서 숫자인지, int 타입으로 변환 가능한지를 확인한다.
2. 1000원 단위로 나누어 떨어지는지 여부를 Money VO 내부에서 확인한다.

## ✋ 로또 구입 금액 int 로 제한

로또 한 장의 가격이 예를 들어 1,000원이라고 가정할 때, `Integer.MAX_VALUE` (약 21억 원) 이하의 금액으로 **2천만 장 이상**을 구매할 수 있습니다.

## 🚙 DTO는 값 전달만, 출력 형식은 OutputHandler에서 담당

지난주 미션에서 DTO를 출력 메시지 전달용으로 사용했습니다. 다만, 출력 형식은 언제든지 달라질 수 있으며, 이에 따라 도메인의 값을 전달하는 DTO에 변경의 영향이 가서는 안된다고 판단했습니다. 따라서 DTO는 도메인의 값을 전달하기만 하며, 출력 형식은 OutputHandler가 책임을 가지도록 했습니다.

## 💸 로또 수량과 로또 구입 금액은 어느 객체에 있어야 할까?

LottoTicket 내부에 둘까 고민하다가 LottoMoney를 따로 구현했습니다. 지역 또는 로또 회사에 따라 Lotto 의 가격이 달라질 것이라고 생각했습니다.

## 🧷 로또를 로또 번호 기준으로 정렬하다가 발생한 문제 해결 과정

```java
public Lotto(List<LottoNumber> lottoNumbers) {
    validate(lottoNumbers);
    Collections.sort(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
}
```

`UnsupportedOperationException`

`ImmutableCollections`

위와 같은 예외가 발생했습니다.

```java
Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
	at java.base/java.util.ImmutableCollections$AbstractImmutableList.sort(ImmutableCollections.java:263)
	at java.base/java.util.Collections.sort(Collections.java:145)
```

```java
public Lotto createLotto(List<Integer> lottoNumbers) {
        List<LottoNumber> numbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(numbers);
}
```

`toList()` 는 `unmodifiableList` 를 반환합니다.

```java
default List<T> toList() {
      return (List<T>) Collections.unmodifiableList(new ArrayList<>(Arrays.asList(this.toArray())));
}
```

`lottoNumbers`는 변경이 불가능한 리스트인데, `Collections.sort` 메서드는 해당 리스트를 직접적으로 변경하려고 합니다.

```java
public static <T extends Comparable<? super T>> void sort(List<T> list) {
      list.sort(null);
}
```

이를 아래와 같이 수정했습니다. 새로운 리스트를 만들어 반환합니다.

```java
public Lotto(List<LottoNumber> lottoNumbers) {
     validate(lottoNumbers);
     this.lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());;
}
```

또는 아래와 같이 수정 가능합니다.

```java
public Lotto(List<LottoNumber> lottoNumbers) {
    validate(lottoNumbers);
    List<LottoNumber> newLotto = new ArrayList<>(lottoNumbers);
    Collections.sort(newLotto);
    this.lottoNumbers = newLotto;
}
```