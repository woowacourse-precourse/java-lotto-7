package lotto.lotto.domain;

import lotto.buyer.domain.Money;
import lotto.view.output.domain.PurchaseCountViewService;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private final Calculator calculator;
    private final NumberGenerator numberGenerator;
    private final PurchaseCountViewService purchaseCountOutput;
    public LottoMachine(Calculator calculator, NumberGenerator numberGenerator, PurchaseCountViewService purchaseCountOutput) {
        this.calculator = calculator;
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
        int count = calculator.divideByThousand(money);
        purchaseCountOutput.view(count);
        return count;
    }
}
