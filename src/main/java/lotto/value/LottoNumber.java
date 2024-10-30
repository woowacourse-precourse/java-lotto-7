package lotto.value;

public record LottoNumber(Integer number) implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public LottoNumber {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber other) {
        if (other == null) {
            throw new IllegalArgumentException("[ERROR] null과 비교할 수 없습니다.");
        }
        return number.compareTo(other.number());
    }

}
