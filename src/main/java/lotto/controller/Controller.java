package lotto.controller;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.PrintHandler;
import lotto.lotto.LottoStore;

public class Controller {
    InputHandler inputHandler;
    PrintHandler printHandler;
    Lotto lotto;
    LottoStore lottoStore;
    int index = 0;

    public Controller() {
        inputHandler = new InputHandler();
        printHandler = new PrintHandler();
        lottoStore = new LottoStore();
    }

    public void run() {
        printHandler.PrintBuyMoneyAmount();
        inputHandler.setInputMoney();
        int money = inputHandler.getInputMoney();
        lottoStore.calculateNumberOfPurchases(money);
        int lottoNumberOfPurchases = lottoStore.getLottoNumberOfPurchases();
        printHandler.PrintBuyLottoNumbersOfPurchases(lottoNumberOfPurchases);
        createLotto(lottoNumberOfPurchases);
    }

    private void createLotto(int lottoNumberOfPurchases) {
        while (index != lottoNumberOfPurchases) {
            List<Integer> numbers = lottoStore.createLottoNumbers();
            lotto = new Lotto(numbers);
            index++;
        }
    }
}
