package lotto.mock.number_generator;

import lotto.model.number_generator.RandomNumberGenerator;

import java.util.List;

public abstract class MockedRandomNumberGenerator implements RandomNumberGenerator {

    protected List<Integer> lastGeneratedNumbers;

    public List<Integer> getLastGeneratedNumbers() {
        return lastGeneratedNumbers;
    }
}
