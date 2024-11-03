package lotto.domain;

public record LottoNumber(int number) implements Comparable<LottoNumber> {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public LottoNumber {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            String message = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_VALUE, MAX_VALUE);
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

}
