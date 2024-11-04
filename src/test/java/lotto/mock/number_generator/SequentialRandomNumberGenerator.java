package lotto.mock.number_generator;

import java.util.List;
import java.util.stream.IntStream;

public class SequentialRandomNumberGenerator extends MockedRandomNumberGenerator {

    private int sizeWillBeGenerated = 0;

    public SequentialRandomNumberGenerator() {
    }

    public void setSizeWillBeGenerated(int sizeWillBeGenerated) {
        this.sizeWillBeGenerated = sizeWillBeGenerated;
    }

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        lastGeneratedNumbers = IntStream.range(startInclusive, endInclusive + 1)
                .limit(sizeWillBeGenerated)
                .boxed()
                .toList();

        return lastGeneratedNumbers;
    }
}
