package lotto.controller;

import lotto.domain.JackpotNumbers;
import lotto.domain.Lotto;
import lotto.util.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {

    private final Validator inputPurchaseAmountValidator = new InputPurchaseAmountValidator();
    private final Validator inputJackpotNumbersValidator = new InputJackpotNumbersValidator();

    public void run() {
        int totalAmount;
        while (true) {
            String inputTotalAmount = InputView.requestAmountToPurchase();
            try {
                inputPurchaseAmountValidator.validate(inputTotalAmount);
                totalAmount = Integer.parseInt(inputTotalAmount);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        int lottoCount = totalAmount / 1000;
        List<Lotto> purchasedLottos = LottoListGenerator.generateLottos(lottoCount);
        OutputView.printPurchasedLottos(lottoCount, purchasedLottos);

        JackpotNumbers jackpotNumbers = new JackpotNumbers();
        while (true) {
            String inputJackpotNumbers = InputView.requestJackpotNumbers();
            try {
                inputJackpotNumbersValidator.validate(inputJackpotNumbers);
                List<Integer> intList = StringParser.toIntList(inputJackpotNumbers);
                Lotto jackpot = new Lotto(intList);
                jackpotNumbers.setLotto(jackpot);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            String inputBonusNumber = InputView.requestBonusNumber();
            try {
                int bonusNumber = StringParser.toInt(inputBonusNumber);
                jackpotNumbers.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
