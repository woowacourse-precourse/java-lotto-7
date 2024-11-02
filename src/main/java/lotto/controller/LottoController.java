package lotto.controller;

import lotto.Consumer;
import lotto.Lotto;
import lotto.constant.CompareInteger;
import lotto.constant.PriceRule;
import lotto.constant.WinningNumberRule;
import lotto.validator.NumberValidator;
import lotto.validator.PriceValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
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
    }

    private int getLottoPrice() {
        try {
            String inputPrice = InputView.readInput();
            int price = inputToInt(inputPrice);
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

    private void printLottoTicket(Consumer consumer){
        OutputView.changeLine();
        OutputView.printPurchaseCount(consumer.getLottoTicket().size());
        for (Lotto lotto : consumer.getLottoTicket()){
            OutputView.printLottoTicket(lotto.getNumbers());
        }
    }

    private void getWinningNumber(){
        OutputView.printWinningNumberGuide();
        String input = InputView.readInput();
        try {
            WinningNumberValidator.validateInputComma(input);
            List<String> inputWinningNumber = Arrays.asList(input.split(","));
            validateWinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void validateWinningNumber(List<String> inputWinningNumber){
        for(String inputNumber : inputWinningNumber){
            NumberValidator.validateOnlyInteger(inputNumber, WinningNumberRule.ONLY_COMMA_INTEGER.getMessage());
            Integer number = inputToInt(inputNumber);
        }
    }
}