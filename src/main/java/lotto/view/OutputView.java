package lotto.view;

import lotto.enums.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void printPurchaseAmountInputMessage() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printBonusNumberInputMessage() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printPurchaseCount(int count) {
        String message = String.format(Message.PURCHASE_SUFFIX.getMessage(), count);
        System.out.println(message);
    }

    public void printPurchasedLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> numbers = sortAscending(lottoNumbers);
        System.out.println(numbers);
    }

    public List<Integer> sortAscending(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return numbers;
    }
}
