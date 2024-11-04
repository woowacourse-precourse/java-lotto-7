package lotto.controller;

import java.util.Arrays;
import java.util.List;
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
        while (true) {
            try {
                return readPayment();
            } catch (IllegalArgumentException exception) {
                inputView.printException(exception);
            }
        }
    }

    public WinningLotto getWinningLotto() {
        Lotto lotto = getWinningNumber();
        while (true) {
            try {
                BonusNumber bonusNumber = getBonusNumber();
                return WinningLotto.createWinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException exception) {
                inputView.printException(exception);
            }
        }
    }

    private Lotto getWinningNumber() {
        while (true) {
            try {
                return readWinningNumber();
            } catch (IllegalArgumentException exception) {
                inputView.printException(exception);
            }
        }
    }

    private BonusNumber getBonusNumber() {
        while (true) {
            try {
                return readBonusNumber();
            } catch (IllegalArgumentException exception) {
                inputView.printException(exception);
            }
        }

    }

    private Payment readPayment() {
        Integer purchaseAmount = parse.StringToInteger(inputView.readPurchaseAmount());
        return Payment.from(purchaseAmount);
    }

    private Lotto readWinningNumber() {
        List<Integer> numbers = Arrays.stream(inputView.readWinningNumber().split(DELIMITER))
                .map(parse::StringToInteger)
                .toList();
        return new Lotto(numbers);
    }

    private BonusNumber readBonusNumber() {
        Integer bonusNumber = parse.StringToInteger(inputView.readBonusNumber());
        return new BonusNumber(bonusNumber);
    }

}
