package lotto.mock.number_generator;

import java.util.List;

public class ChoosableRandomNumberMaker extends MockedRandomNumberGenerator {

    private final List<Integer> numbers;

    public ChoosableRandomNumberMaker(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        lastGeneratedNumbers = numbers;
        return lastGeneratedNumbers;
    }
}
