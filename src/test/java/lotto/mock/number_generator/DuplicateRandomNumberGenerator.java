package lotto.mock.number_generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuplicateRandomNumberGenerator extends MockedRandomNumberGenerator {

    public DuplicateRandomNumberGenerator() {
    }

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        lastGeneratedNumbers = new ArrayList<>(Collections.nCopies(count, startInclusive));

        return lastGeneratedNumbers;
    }
}
