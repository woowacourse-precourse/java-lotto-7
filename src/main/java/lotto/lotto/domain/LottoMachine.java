package lotto.lotto.domain;

import lotto.money.domain.Money;
import lotto.view.output.domain.PurchaseCountViewService;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private final Calculator divideThousandCalculator;
    private final NumberGenerator numberGenerator;
    private final PurchaseCountViewService purchaseCountOutput;
    public LottoMachine(Calculator divideThousandCalculator, NumberGenerator numberGenerator, PurchaseCountViewService purchaseCountOutput) {
        this.divideThousandCalculator = divideThousandCalculator;
        this.numberGenerator = numberGenerator;
        this.purchaseCountOutput =purchaseCountOutput;
    }
    public LottoTickets purchaseLottoTickets(Money money) {
        int count = purchaseCount(money);
        return LottoTickets.of(Stream.generate(this::createLotto)
                .limit(count)
                .collect(toList()));
    }
    private Lotto createLotto() {
        return new Lotto(numberGenerator.generate());
    }
    private int purchaseCount(Money money) {
        int count = divideThousandCalculator.calculate(money);
        purchaseCountOutput.view(count);
        return count;
    }
}
