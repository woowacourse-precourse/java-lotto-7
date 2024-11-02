package lotto.controller;

import java.util.List;
import java.util.function.Predicate;
import lotto.model.Lotto;

public class JudgeController {
    private final List<Lotto> lottos;
    private final Lotto winning;

    public JudgeController(List<Lotto> lottos, Lotto winning) {
        this.lottos = lottos;
        this.winning = winning;
    }

    public int countMatchingDigits(Lotto compareLotto) {
        return compareLotto.getNumbers().stream()
                .filter(num -> winning.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(num)))
                .toList()
                .size();
    }
}
