package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;
import lotto.exception.LottoErrorMessages;
import lotto.generator.LottoGenerator;
import lotto.view.LottoInfoMessages;

public class ValidationService {
    LottoGenerator lottoGenerator = LottoGenerator.createLottoGenerator();
    private ValidationService() {

    }

    public static ValidationService createValidationService() {
        return new ValidationService();
    }

    public int validatePayInput() {
        try {
            System.out.println(LottoInfoMessages.INSERT_PAY.text());
            String payInput = Console.readLine();
            int pay = validateUnderThousand(payInput);
            return pay;
        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessages.PAY_INPUT_ERROR.addErrorText());
            return validatePayInput();
        }
    }

    private int validateUnderThousand(String payInput) {
        if (Integer.parseInt(payInput) < 1000) {
            System.out.println(LottoErrorMessages.NOT_THOUSAND.addErrorText());
            return validatePayInput();
        }
        return Integer.parseInt(payInput);
    }

    public int validateManualAmountIsInteger(int enableAmount) {
        try {
            System.out.println(LottoInfoMessages.INSERT_MANUAL_AMOUNT_START.text() + enableAmount
                    + LottoInfoMessages.INSERT_MANUAL_AMOUNT_END.text());
            int amount = Integer.parseInt(Console.readLine());
            amount = validateOverManualAmount(amount, enableAmount);
            return amount;
        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessages.PAY_INPUT_ERROR.addErrorText());
            return validateManualAmountIsInteger(enableAmount);
        }
    }

    public int validateOverManualAmount(int amount, int enableAmount) {
        if (amount > enableAmount || amount < 0) {
            System.out.println(LottoErrorMessages.NOT_ENABLE_AMOUNT_START.addErrorText()
                    + enableAmount + LottoErrorMessages.NOT_ENABLE_AMOUNT_END.text());
            return validateManualAmountIsInteger(enableAmount);
        }
        return amount;
    }

    public Set<Integer> validateCorrectManualNumber(int manualAmount) {
        if (manualAmount != 0) {
            System.out.println(LottoInfoMessages.INSERT_MANUAL_NUMBERS_START.text()
                    + manualAmount + LottoInfoMessages.INSERT_MANUAL_NUMBERS_END.text());
            String numbers = Console.readLine();
            if (numbers.isEmpty()) {
                return new HashSet<>(lottoGenerator.getLottoNumbers());
            }
            return validateCorrectPattern(numbers, manualAmount);
        }
        return new HashSet<>();
    }

    private Set<Integer> validateCorrectPattern(String numbers, int manualAmount) {
        try {
            String[] numberList = numbers.split(",");
            return validateDuplicatedNumbers(numberList, manualAmount);
        } catch (PatternSyntaxException e) {
            System.out.println(LottoErrorMessages.SYNTAX_NUMBER_ERROR.text());
            return validateCorrectManualNumber(manualAmount);
        }
    }

    private Set<Integer> validateDuplicatedNumbers(String[] numberList, int manualAmount) {
        try {
            List<Integer> newNumberList = new ArrayList<>();
            for (String s : numberList) {
                newNumberList.add(Integer.parseInt(s));
            }
            if (newNumberList.size() != 6) {
                throw new IllegalArgumentException();
            }
            Set<Integer> newNumberSet = new HashSet<>(newNumberList);
            if (newNumberSet.size() != numberList.length) {
                throw new IllegalArgumentException();
            }
            return newNumberSet;
        } catch (IllegalArgumentException e) {
            return validateCorrectManualNumber(manualAmount);
        }
    }
}

