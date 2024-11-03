package lotto.controller;

import lotto.model.LottoCreator;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    InputView inputView = new InputView();

    public void purchaseLottos() {
        LottoCreator lottoCreator = new LottoCreator();
        int numberOfLotto;
        while (true) {
            int purchasePrice = inputView.inputPurchasePrice();
            numberOfLotto = lottoCreator.chooseNumberOfLotto(purchasePrice);
            if (numberOfLotto != LottoCreator.INITIAL_NUMBER_OF_LOTTO) break;
        }
        Lottos lottos = new Lottos(numberOfLotto);
    }

    private static List<Integer> convertToIntegerList(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void createWinningLotto(){
        String winningNumbersBeforeConvert = inputView.inputWinningNumbers();
        List<Integer> winningNumbers = convertToIntegerList(winningNumbersBeforeConvert);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        int bonusNumber = inputView.inputBonusNumber();
        winningLotto.settingBonusNumber(bonusNumber);
    }
}
