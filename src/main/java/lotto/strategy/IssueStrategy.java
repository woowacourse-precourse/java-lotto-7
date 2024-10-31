package lotto.strategy;

import java.util.List;

@FunctionalInterface
public interface IssueStrategy {

    List<Integer> issue();
}
