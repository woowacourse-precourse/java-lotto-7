package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (hasInvalidSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (isNotBetween(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }

    private static boolean hasInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_SIZE;
    }

    private static boolean isNotBetween(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n < Lotto.LOTTO_NUMBER_MIN || n > Lotto.LOTTO_NUMBER_MAX);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public void print() {
        System.out.print("[");
        System.out.print(getJoinedNumbers());
        System.out.println("]");
    }

    private String getJoinedNumbers() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public long getMatchCount(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // TODO: 추가 기능 구현
}
