package lotto.lotto.domain;

import lotto.buyer.domain.Money;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private final Calculator calculator;
    private final NumberGenerator numberGenerator;
    public LottoMachine(Calculator calculator, NumberGenerator numberGenerator) {
        this.calculator = calculator;
        this.numberGenerator = numberGenerator;
    }
    public LottoTickets purchaseLottoTickets(Money money) {
        int count = calculator.divideByThousand(money);
        return LottoTickets.of(Stream.generate(this::createLotto)
                .limit(count)
                .collect(toList()));
    }
    private Lotto createLotto() {
        return new Lotto(numberGenerator.generate());
    }
}
