package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.*;
import lotto.view.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private String amount;
    private int numberOfLottoPurchased;
    private List<Lotto> userLottoNumbers;
    private List<Integer> winnerLottoNumbers;
    private Lotto winnerLottoNumber;
    private int bonusNumber;
    private int prize = 0;

    public void play() {
        try {
            getAmount();
            printNumberOfLottoPurchased();
            generateLotto();
            getWinnerNumber();
            getBonusNumber();
            getPrize();
            printPrize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void getAmount() {
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

    private void getWinnerNumber() {
        while (true) {
            try {
                String winnerNumber = InputView.LOTTO_NUMBER.getInput();
                String[] winnerNumberItems = winnerNumber.split(",");
                winnerLottoNumbers = Arrays.stream(winnerNumberItems).map(Integer::parseInt).collect(Collectors.toList());
                winnerLottoNumber = new Lotto(winnerLottoNumbers);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }

    private void getBonusNumber() {
        while (true) {
            try {
                String bonusNumberItem = InputView.BONUS_NUMBER.getInput();
                bonusNumber = Integer.parseInt(bonusNumberItem);
                Validator.validateBonusNumber(winnerLottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }

    private void getPrize() {
        for (Lotto userNumber : userLottoNumbers) {
            prize += LottoCalculator.calculatePrize(userNumber.getNumbers(), winnerLottoNumber.getNumbers(), bonusNumber);
        }
    }

    private void printPrize() {
        OutputView.printStatics(LottoCalculator.getFinalMatchNumbers(), RateOfReturnCalculator.calculateRateOfReturn(Integer.parseInt(amount), prize));
    }
}