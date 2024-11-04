package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.LottoException;
import lotto.util.LottoUtils;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;

    private InputController() {
        inputView = InputView.getInstance();
    }

    private static class SingletonHelper {
        private static final InputController INSTANCE = new InputController();
    }

    public static InputController getInstance() {
        return InputController.SingletonHelper.INSTANCE;
    }


    public int inputPurchaseAmount() {
        return LottoUtils.inputLoop(() -> {
            String purchaseAmountString = inputView.inputPurchaseAmount();

            LottoException.checkInteger(purchaseAmountString);
            int purchaseAmount = Integer.parseInt(purchaseAmountString);

            LottoException.checkPurchaseRange(purchaseAmount);
            LottoException.checkRoundThousand(purchaseAmount);

            return purchaseAmount;
        });
    }

    public Lotto inputLotto() {
        return LottoUtils.inputLoop(() -> {
            String lottoString = inputView.inputNumbers();

            List<Integer> inputNumbers = Arrays.stream(lottoString.split(",", -1))
                    .peek(LottoException::checkInteger)
                    .map(Integer::parseInt)
                    .peek(LottoException::checkNumberRange)
                    .toList();

            return new Lotto(inputNumbers);
        });
    }

    public int inputBonus(Lotto lotto) {
        return LottoUtils.inputLoop(() -> {
            String bonusString = inputView.inputBonus();

            LottoException.checkInteger(bonusString);
            int bonus = Integer.parseInt(bonusString);

            LottoException.checkNumberRange(bonus);
            LottoException.checkContainBonus(lotto, bonus);

            return bonus;
        });
    }
}
