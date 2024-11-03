package lotto.controller;

import lotto.Consumer;
import lotto.Lotto;
import lotto.WinningNumber;
import lotto.constant.CompareInteger;
import lotto.constant.LottoGuide;
import lotto.constant.PriceRule;
import lotto.validator.NumberValidator;
import lotto.validator.PriceValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.CompareInteger.PRICE_MAXIMUM;
import static lotto.constant.CompareInteger.PRICE_MINIMUM;
import static lotto.constant.PriceRule.SCOPE;

public class LottoController {
    public void run() {
        OutputView.printPriceGuide();
        Consumer consumer = new Consumer(getLottoPrice());
        printLottoTicket(consumer);
        List<Integer> mainNumber = getWinningNumber();
        Integer bonusNumber = getBonusNumber(mainNumber);
        WinningNumber winningNumber = new WinningNumber(mainNumber, bonusNumber);
    }

    private int getLottoPrice() {
        String inputPrice = InputView.readInput();
        int price = inputToInt(inputPrice);
        try {
            validatePrice(price);
            return price / CompareInteger.PRICE_LOTTO.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoPrice();
        }
    }

    private int inputToInt(String input) throws IllegalArgumentException {
        NumberValidator.validateOnlyInteger(input, PriceRule.ONLY_INTEGER.getMessage());
        return Integer.parseInt(input);
    }

    private void validatePrice(int price) {
        NumberValidator.validateScope(PRICE_MINIMUM.getNumber(), PRICE_MAXIMUM.getNumber(), price, SCOPE.getMessage());
        PriceValidator.validatePriceUnit(price);
    }

    private void printLottoTicket(Consumer consumer) {
        OutputView.changeLine();
        OutputView.printPurchaseCount(consumer.getLottoTicket().size());

        for (Lotto lotto : consumer.getLottoTicket()) {
            OutputView.printLottoTicket(lotto.getNumbers());
        }
    }

    private List<Integer> getWinningNumber() {
        OutputView.printWinningNumberGuide();
        String input = InputView.readInput();

        try {
            WinningNumberValidator.validateInputComma(input);
            List<String> inputWinningNumber = Arrays.asList(input.split(","));
            return WinningNumberValidator.validateInputWinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private Integer getBonusNumber(List<Integer> mainNumber) {
        Integer bonusNumber = CompareInteger.ZERO.getNumber();
        OutputView.printBonusNumberGuide();
        String inputBonus = InputView.readInput();

        try {
            bonusNumber = WinningNumberValidator.getValidatedNumber(inputBonus);
            mainNumber.add(bonusNumber);
            WinningNumberValidator.validateDuplication(mainNumber);
            mainNumber.remove(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            mainNumber.remove(bonusNumber);
            return getBonusNumber(mainNumber);
        }
    }
}