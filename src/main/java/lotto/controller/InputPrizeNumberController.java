package lotto.controller;

import static lotto.constants.NumberConstants.LOTTO_RANGE_END;
import static lotto.constants.NumberConstants.LOTTO_RANGE_START;
import static lotto.constants.RegExpConstants.COMMA_REGEX;
import static lotto.constants.RegExpConstants.INT_REGEX;
import static lotto.message.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_EXCEPTION;

import java.util.ArrayList;
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
        Lotto prizeNumberLotto = getSixNumbers();
        int bonusNumber = getBonusNumber(prizeNumberLotto);

        return new PrizeLotto(prizeNumberLotto, bonusNumber);
    }

    private Lotto getSixNumbers() {
        while (true) {
            try {
                String[] inputNumbers = inputPrizeNumberView.getSixPrizeNumber().split(COMMA_REGEX);
                checkNumberListFormat(inputNumbers);
                List<Integer> prizeNumbers = Arrays.stream(inputNumbers)
                        .mapToInt(Integer::parseInt).boxed()
                        .toList();

                ViewUtil.printEmptyLine();
                return new Lotto(prizeNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                ViewUtil.printEmptyLine();
            }
        }
    }

    private int getBonusNumber(Lotto lottoNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputPrizeNumberView.getBonusNumber();
                checkNumberFormat(inputBonusNumber);

                int bonusNumber = Integer.parseInt(inputBonusNumber);
                checkNumberRange(bonusNumber);

                List<Integer> prizeNumbers = new ArrayList<>(lottoNumbers.getNumbers());
                prizeNumbers.add(bonusNumber);
                checkNumbersDuplicate(prizeNumbers);

                ViewUtil.printEmptyLine();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                ViewUtil.printEmptyLine();
            }
        }

    }

    private void checkNumberListFormat(final String[] numbers) {
        for (String number : numbers) {
            checkNumberFormat(number);
        }
    }

    private void checkNumberFormat(final String number) {
        if (!number.matches(INT_REGEX)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void checkNumberRange(final int number) {
        if (number < LOTTO_RANGE_START || number > LOTTO_RANGE_END) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void checkNumbersDuplicate(final List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (final int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
            }
        }
    }
}
