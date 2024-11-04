package lotto.basic;

import java.util.List;

public class NumbersGeneratorStub extends NumbersGenerator {
    private List<Integer> testRandomNumbers;

    public void setTestRandomNumbers(List<Integer> testRandomNumbers) {
        this.testRandomNumbers = testRandomNumbers;
    }

    @Override
    public List<Integer> random(int start, int end, int size) {
        return testRandomNumbers;
    }
}
