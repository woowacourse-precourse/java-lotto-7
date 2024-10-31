package lotto.support;

import lotto.strategy.IssueStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManualIssueStrategy implements IssueStrategy {

    private static final int INIT_INDEX = 0;

    private final List<List<Integer>> numbers = new ArrayList<>();
    private final int size;
    private int index = INIT_INDEX;

    private ManualIssueStrategy(List<List<Integer>> numbers) {
        numbers.forEach(this::addNumbers);
        this.size = numbers.size();
    }

    @SafeVarargs
    public static ManualIssueStrategy ofList(List<Integer> ... numbers) {
        return new ManualIssueStrategy(Arrays.asList(numbers));
    }

    @Override
    public List<Integer> issue() {
        return numbers.get(getIndex());
    }

    private void addNumbers(List<Integer> numbers) {
        this.numbers.add(numbers);
    }

    private int getIndex() {
        return index++ % size;
    }
}
