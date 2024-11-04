package lotto.mock.number_generator;

import java.util.List;

public class ChoosableRandomNumberMaker extends MockedRandomNumberGenerator {

    private final List<Integer> numbers;
    private final int offSet;
    private int index;

    public ChoosableRandomNumberMaker() {
        this(List.of(), 0);
    }

    public ChoosableRandomNumberMaker(List<Integer> numbers, int offSet) {
        this.numbers = numbers;
        this.offSet = offSet;
        this.index = 0;
    }

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        List<Integer> numbers = this.numbers.subList(index, index + offSet);
        index += count;
        lastGeneratedNumbers = numbers;
        return numbers;
    }
}
