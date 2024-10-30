package lotto.controller;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.PrintHandler;
import lotto.lotto.LottoStore;
import lotto.lotto.LottoWinningNumbers;

public class Controller {
    InputHandler inputHandler;
    PrintHandler printHandler;
    Lotto lotto;
    LottoStore lottoStore;
    LottoWinningNumbers lottoWinningNumbers;
    int index = 0;

    public Controller() {
        inputHandler = new InputHandler();
        printHandler = new PrintHandler();
        lottoStore = new LottoStore();
    }

    public void run() {
        printHandler.printBuyMoneyAmount();
        int money = inputHandler.setInputMoney();
        lottoStore.calculateNumberOfPurchases(money);
        int lottoNumberOfPurchases = lottoStore.getLottoNumberOfPurchases();
        printHandler.printBuyLottoNumbersOfPurchases(lottoNumberOfPurchases);
        createLotto(lottoNumberOfPurchases);
        printHandler.printWinningNumbersPrompt();
        List<Integer> lottoNumbers = inputHandler.setInputLottoNumbers();
        lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);
        printHandler.printBonusNumberPrompt();
        int bonusNumber = inputHandler.setBonusNumber();
        lottoWinningNumbers.validateLottoWinningNumbersCon(lottoNumbers, bonusNumber);
    }

    private void createLotto(int lottoNumberOfPurchases) {
        while (index != lottoNumberOfPurchases) {
            List<Integer> numbers = lottoStore.createLottoNumbers();
            lotto = new Lotto(numbers);
            index++;
        }
    }
}
