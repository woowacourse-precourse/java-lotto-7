package lotto.support;

import lotto.strategy.IssueStrategy;

import java.util.List;

public class ManualIssueStrategy implements IssueStrategy {

    private final List<Integer> numbers;

    private ManualIssueStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ManualIssueStrategy of(Integer ... numbers) {
        return new ManualIssueStrategy(List.of(numbers));
    }

    @Override
    public List<Integer> issue() {
        return numbers;
    }
}
