package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinLotto;
import lotto.utils.Parser;
import lotto.view.InputView;

public class LottoInputHandler {
    private static final String WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final InputView inputView;

    public LottoInputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public WinLotto initializeWinLotto() {
        Lotto winNumbers = initializeWinNumbers();

        while (true) {
            try {
                int bonusNumber = initializeBonusNumber();
                return new WinLotto(winNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public Lotto initializeWinNumbers() {
        while (true) {
            try {
                String rawWinNumbers = inputView.readLine(WIN_NUMBERS_MESSAGE);
                List<Integer> winNumbers = Parser.splitNumbers(rawWinNumbers);

                return new Lotto(winNumbers);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public PurchaseAmount initializePurchaseAmount() {
        while (true) {
            try {
                String rawAmount = inputView.readLine(PURCHASE_AMOUNT_MESSAGE);
                long amount = Parser.stringToLong(rawAmount);

                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private int initializeBonusNumber() {
        String rawBonusNumber = inputView.readLine(BONUS_NUMBER_MESSAGE);

        return Parser.stringToInt(rawBonusNumber);
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }
}
