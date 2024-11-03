package lotto.controller;

import static lotto.constant.LottoMessage.*;
import static lotto.util.StringProcessor.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import lotto.domain.Lotto;
import lotto.domain.PurchaseLotto;
import lotto.domain.WinningLotto;

public class LottoController {
    private final PurchaseLotto purchaseLotto;
    private WinningLotto winningLotto;

    public LottoController(PurchaseLotto purchaseLotto) {
        this.purchaseLotto = purchaseLotto;
    }

    public void run() {
        purchaseLotto();
        setWinningLotto();
    }

    private void purchaseLotto() {
        try {
            String rawInput = requestInput(INPUT_PURCHASE_AMOUNT.getMessage());
            int purchaseAmount = convertInput(rawInput);
            int purchaseCount = calculatePurchaseCount(purchaseAmount);
            issueLottoTickets(purchaseCount);
            printPurchaseCount(purchaseCount);
            print(purchaseLotto.getLottoNumber());
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            purchaseLotto();
        }
    }

    private void setWinningLotto() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private int convertInput(String input) {
        validateInput(input);
        return integerConverter(removeCommas(input));
    }

    private int calculatePurchaseCount(int amount) {
        return purchaseLotto.setPurchaseCount(amount);
    }

    private void issueLottoTickets(int count) {
        purchaseLotto.issueLotto(count);
    }

    private void inputWinningNumbers() {
        try {
            String rawWinningNumberInput = requestInput(INPUT_WINNING_NUMBER.getMessage());
            validateInput(rawWinningNumberInput);
            String[] winningInput = splitInputString(rawWinningNumberInput);
            winningLotto = new WinningLotto(new Lotto(integerListConverter(winningInput)));
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            inputWinningNumbers();
        }
    }

    private void inputBonusNumber() {
        try {
            String rawBonusNumberInput = requestInput(INPUT_BONUS_NUMBER.getMessage());
            validateInput(rawBonusNumberInput);
            winningLotto.setBonusNumber(integerConverter(rawBonusNumberInput));
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            inputBonusNumber();
        }
    }
}
