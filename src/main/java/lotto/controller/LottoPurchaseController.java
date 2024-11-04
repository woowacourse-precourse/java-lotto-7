package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.*;
import lotto.view.*;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseController {
    private String amount;
    private int numberOfLottoPurchased;
    private List<Lotto> userLottoNumbers;

    public void purchaseLotto() {
        getsAmount();
        printNumberOfLottoPurchased();
        generateLotto();
    }

    private void getsAmount() {
        while (true) {
            try {
                amount = InputView.AMOUNT.getInput();
                Validator.validateAmount(amount);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        AmountCalculator amountCalculator = new AmountCalculator(Integer.parseInt(amount));
        numberOfLottoPurchased = amountCalculator.getNumberOfLottoPurchased();
    }

    private void printNumberOfLottoPurchased() {
        OutputView.printNumberOfLottoPurchased(numberOfLottoPurchased);
    }

    private void generateLotto() {
        userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLottoPurchased; i++) {
            LottoMachine lottoMachine = new LottoMachine();
            userLottoNumbers.add(new Lotto(lottoMachine.getRandomNumbers()));
        }
        OutputView.printLottos(userLottoNumbers);
        System.out.println();
    }

    public List<Lotto> getUserLottoNumbers() {
        return userLottoNumbers;
    }

    public String getAmount() {
        return amount;
    }
}