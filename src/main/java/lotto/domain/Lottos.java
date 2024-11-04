package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.generator.LottoGenerator;
import lotto.util.ExceptionMessages;

public class Lottos {
    private final int amounts;
    private final List<Lotto> lottos;

    private Lottos(final int budgets) {
        validate(budgets);
        this.amounts = setAmounts(budgets);
        this.lottos = setLottos(amounts);
    }

    public static Lottos from(final int budgets) {
        return new Lottos(budgets);
    }

    private void validate(int budgets) {
        if (budgets % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessages.BUDGETS_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
        if (budgets > 100000000 || budgets < 1000) {
            throw new IllegalArgumentException(ExceptionMessages.EXTEND_MAXIMUM_BUDGETS.getMessage());
        }
    }

    private int setAmounts(int budgets) {
        return budgets / 1000;
    }

    private List<Lotto> setLottos(int purchaseCount) {
        LottoGenerator generator = new LottoGenerator();
        return IntStream.range(0, purchaseCount)
                .mapToObj(count -> new Lotto(generator.generateLotto()))
                .collect(Collectors.toList());
    }

    public int getAmounts() {
        return amounts;
    }

    public List<String> getPurchaseLotto() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
