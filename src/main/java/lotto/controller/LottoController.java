package lotto.controller;

import lotto.model.Consumer;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.constant.CompareInteger;
import lotto.constant.LottoGuide;
import lotto.constant.PriceRule;
import lotto.constant.WinningNumberRule;
import lotto.validator.NumberValidator;
import lotto.validator.PriceValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    public void run() {
        OutputView.printPriceGuide();
        Consumer consumer = new Consumer(getLottoPrice());
        printLottoTicket(consumer);
        List<Integer> mainNumber = getWinningNumber();
        Integer bonusNumber = getBonusNumber(mainNumber);
        WinningNumber winningNumber = new WinningNumber(mainNumber, bonusNumber);
        consumer.setLottoResult(winningNumber);
        OutputView.printResult(consumer.getLottoResult(), consumer.getSecondPlace());
    }

    private int getLottoPrice() {
        String inputPrice = InputView.readInput();
        int price = NumberValidator.stringToInteger(inputPrice, LottoGuide.ERROR.getMessage() + PriceRule.ONLY_INTEGER.getMessage());
        try {
            PriceValidator.validatePrice(price);
            return price / CompareInteger.PRICE_LOTTO.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoPrice();
        }
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
            List<String> inputWinningNumber = Arrays.asList(input.split(WinningNumberRule.SEPARATOR.getMessage()));
            return WinningNumberValidator.validateInputWinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private Integer getBonusNumber(List<Integer> mainNumber) {
        OutputView.printBonusNumberGuide();
        String inputBonus = InputView.readInput();

        try {
            Integer bonusNumber = WinningNumberValidator.getValidatedNumber(inputBonus);
            WinningNumberValidator.validateBonusDuplication(mainNumber, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(mainNumber);
        }
    }
}