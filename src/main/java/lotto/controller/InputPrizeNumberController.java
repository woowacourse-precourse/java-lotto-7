package lotto.controller;

import static lotto.message.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_EXCEPTION;
import static lotto.util.MoneyValidator.INT_REGEX;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.PrizeLotto;
import lotto.util.ViewUtil;
import lotto.view.InputPrizeNumberView;

public class InputPrizeNumberController {

    private final InputPrizeNumberView inputPrizeNumberView;

    public InputPrizeNumberController(final InputPrizeNumberView inputPrizeNumberView) {
        this.inputPrizeNumberView = inputPrizeNumberView;
    }

    public PrizeLotto getPrizeNumbers() {
        while (true) {
            try {
                String[] inputNumbers = inputPrizeNumberView.getSixPrizeNumber().split(",");
                checkNumberFormat(inputNumbers);
                List<Integer> prizeNumbers = Arrays.stream(inputNumbers)
                        .mapToInt(Integer::parseInt).boxed()
                        .toList();
                checkDuplicate(prizeNumbers);

                Lotto prizeNumberLotto = new Lotto(prizeNumbers);

                int bonusNumber = Integer.parseInt(inputPrizeNumberView.getBonusNumber());

                return new PrizeLotto(prizeNumberLotto, bonusNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                ViewUtil.printEmptyLine();
            }
        }
    }

    private void checkNumberFormat(final String[] numbers) {
        if (!Arrays.stream(numbers).allMatch(number -> number.matches(INT_REGEX))) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void checkDuplicate(final List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
            }
        }
    }
}
