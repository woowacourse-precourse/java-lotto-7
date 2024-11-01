package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.util.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {

    private final Validator validator = new PurchaseAmountValidator();
    private final Validator jackpotNumbersValidator = new JackpotNumbersValidator();
    public void run() {
        int totalAmount;
        while (true) {
            String inputTotalAmount = InputView.requestAmountToPurchase();
            try {
                validator.validate(inputTotalAmount);
                totalAmount = Integer.parseInt(inputTotalAmount);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        int lottoCount = totalAmount / 1000;
        List<Lotto> purchasedLottos = LottoListGenerator.generateLottos(lottoCount);
        OutputView.printPurchasedLottos(lottoCount, purchasedLottos);

        while (true) {
            String inputJackpotNumbers = InputView.requestJackpotNumbers();
            try {
                jackpotNumbersValidator.validate(inputJackpotNumbers);
                List<Integer> intList = StringParser.toIntList(inputJackpotNumbers);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

    }
}
