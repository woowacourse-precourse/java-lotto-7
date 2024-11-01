package lotto.store;

import lotto.basic.NumbersGenerator;

import java.util.List;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    protected Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto generate(NumbersGenerator numbersGenerator) {
        List<Integer> randomNumbers = numbersGenerator.random(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);

        if(isInvalidSize(randomNumbers))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        if(hasDuplicatedNumbers(randomNumbers))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개는 유니크해야 합니다.");
        if(hasNumbersOutOfRange(randomNumbers))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");

        return new Lotto(randomNumbers);
    }

    private static boolean hasNumbersOutOfRange(List<Integer> numbers) {
        return countNumbersInRange(numbers) != numbers.size();
    }

    private static long countNumbersInRange(List<Integer> numbers) {
        return numbers.stream().filter(Lotto::isWithinLottoRange).count();
    }

    private static boolean isWithinLottoRange(Integer num) {
        return MIN_LOTTO_NUMBER <= num && num <= MAX_LOTTO_NUMBER;
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private static boolean hasDuplicatedNumbers(List<Integer> numbers) {
        return countUniqueNumber(numbers) != numbers.size();
    }

    private static long countUniqueNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
