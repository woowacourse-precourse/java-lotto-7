package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.util.Parse;
import lotto.view.InputView;

public class InputController {

    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final Parse parse;

    public InputController(InputView inputView) {
        this.inputView = inputView;
        this.parse = new Parse();
    }

    public Payment getPayment() {
        return retryOnException(this::readPayment);
    }

    public WinningLotto getWinningLotto() {
        Lotto lotto = retryOnException(this::readWinningNumber);
        BonusNumber bonusNumber = retryOnException(this::readBonusNumber);
        return retryOnException(() -> WinningLotto.createWinningLotto(lotto, bonusNumber));
    }

    private Payment readPayment() {
        int purchaseAmount = parse.StringToInteger(inputView.readPurchaseAmount());
        return Payment.from(purchaseAmount);
    }

    private Lotto readWinningNumber() {
        List<Integer> numbers = Arrays.stream(inputView.readWinningNumber().split(DELIMITER))
                .map(parse::StringToInteger)
                .toList();
        return new Lotto(numbers);
    }

    private BonusNumber readBonusNumber() {
        int bonusNumber = parse.StringToInteger(inputView.readBonusNumber());
        return new BonusNumber(bonusNumber);
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                inputView.printException(exception);
            }
        }
    }

}
