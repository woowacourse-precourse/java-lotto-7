package global.utils;

import static global.utils.StringUtil.BonusNumber.parsingBonusNumber;
import static global.utils.StringUtil.PurchaseAmount.parsingPurchaseAmount;
import static global.utils.StringUtil.WeeklyNumber.parsingWeeklyNumbers;
import static global.utils.StringUtil.WeeklyNumber.splitWeeklyNumberWithSeparator;

import global.exception.ErrorCode;
import global.view.OutputView;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import global.constant.GlobalStatic;

public class Validator {

    public static void validateLottoNumbers(List<Integer> numbers) {
        lottoNumberCountValidate(numbers);
        numbersDuplicateValidate(numbers);
    }

    private static void lottoNumberCountValidate(List<Integer> numbers) {
        if (numbers.size() != GlobalStatic.LOTTO_NUMBER_COUNTS) {
            OutputView.printErrorMsgWithReason(ErrorCode.LOTTO_NUMBER_COUNT_MISMATCH, String.valueOf(numbers));
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_COUNT_MISMATCH.getMsg());
        }
    }

    private static void numbersDuplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);    //Set 자료구조는 중복이 허용되지 않음
        if (uniqueNumbers.size() != numbers.size()) {
            OutputView.printErrorMsgWithReason(ErrorCode.LOTTO_NUMBER_CANNOT_BE_DUPLICATE, numbers.toString());
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_CANNOT_BE_DUPLICATE.getMsg());
        }
    }

    public static void validatePurchaseAmount(String inputPurchaseAmount) {
        plusSignValidate(inputPurchaseAmount);
        blankValidate(inputPurchaseAmount);
        decimalValidate(inputPurchaseAmount);
        notStartWithZeroValidate(inputPurchaseAmount);
        BigInteger parsedPurchaseAmount = parsingPurchaseAmount(inputPurchaseAmount);
        greaterThanZeroValidate(parsedPurchaseAmount);
        purchaseAmountUnitValidate(parsedPurchaseAmount);
    }

    private static void purchaseAmountUnitValidate(BigInteger purchaseAmount) {
        if (!purchaseAmount.remainder(BigInteger.valueOf(GlobalStatic.PURCHASE_AMOUNT_UNIT)).equals(BigInteger.ZERO)) {
            OutputView.printErrorMsgWithReason(ErrorCode.PURCHASE_AMOUNT_UNIT_MISMATCH, purchaseAmount.toString());
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_UNIT_MISMATCH.getMsg());
        }
    }

    public static void validateWeeklyNumbers(String inputWeeklyNumbers) {
        separatorAtStartOrEndValidate(inputWeeklyNumbers);
        List<String> splitInput = splitWeeklyNumberWithSeparator(inputWeeklyNumbers);
        validateSplitWeeklyNumbers(splitInput);
        List<Integer> weeklyNumbers = parsingWeeklyNumbers(splitInput);
        validateParsedWeeklyNumbers(weeklyNumbers);
    }

    private static void validateSplitWeeklyNumbers(List<String> splitWeeklyNumbers) {
        for (String input : splitWeeklyNumbers) {
            blankValidate(input);
            decimalValidate(input);
            plusSignValidate(input);
            notStartWithZeroValidate(input);
        }
        splitWeeklyNumbersCountValidate(splitWeeklyNumbers);
    }

    private static void splitWeeklyNumbersCountValidate(List<String> splitWeeklyNumbers) {
        if (splitWeeklyNumbers.size() != GlobalStatic.LOTTO_NUMBER_COUNTS) {
            OutputView.printErrorMsgWithReason(ErrorCode.WEEKLY_NUMBERS_COUNT_MISMATCH,
                    String.valueOf(splitWeeklyNumbers.size()));
            throw new IllegalArgumentException(ErrorCode.WEEKLY_NUMBERS_COUNT_MISMATCH.getMsg());
        }
    }

    private static void validateParsedWeeklyNumbers(List<Integer> parsedWeeklyNumbers) {
        numbersDuplicateValidate(parsedWeeklyNumbers);
        for (int num : parsedWeeklyNumbers) {
            greaterThanZeroValidate(BigInteger.valueOf(num));
            lottoNumberRangeValidate(num);
        }
    }

    private static void separatorAtStartOrEndValidate(String input) {
        if (input.startsWith(GlobalStatic.WEEKLY_NUMBER_SEPARATOR) ||
                input.endsWith(GlobalStatic.WEEKLY_NUMBER_SEPARATOR)) {
            OutputView.printErrorMsgWithReason(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK, input);
            throw new IllegalArgumentException(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK.getMsg());
        }
    }

    public static void validateBonusNumber(String inputBonusNumber, List<Integer> weeklyNumbers) {
        plusSignValidate(inputBonusNumber);
        blankValidate(inputBonusNumber);
        decimalValidate(inputBonusNumber);
        notStartWithZeroValidate(inputBonusNumber);
        int bonusNumber = parsingBonusNumber(inputBonusNumber);
        greaterThanZeroValidate(BigInteger.valueOf(bonusNumber));
        lottoNumberRangeValidate(bonusNumber);
        weeklyAndBonusNumbersDuplicateValidate(bonusNumber, weeklyNumbers);
    }

    private static void notStartWithZeroValidate(String input) {
        if (input.startsWith("0") && input.length() > 1) {
            OutputView.printErrorMsgWithReason(ErrorCode.INPUT_CANNOT_START_WITH_ZERO, input);
            throw new IllegalArgumentException(ErrorCode.INPUT_CANNOT_START_WITH_ZERO.getMsg());
        }
    }

    private static void plusSignValidate(String input) {
        if (input.contains("+")) {
            OutputView.printErrorMsgWithReason(ErrorCode.INPUT_CANNOT_INCLUDE_PLUS_SIGN, input);
            throw new IllegalArgumentException(ErrorCode.INPUT_CANNOT_INCLUDE_PLUS_SIGN.getMsg());
        }
    }

    private static void blankValidate(String input) {
        if (input.contains(" ") || input.isBlank()) {
            OutputView.printErrorMsgWithReason(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK, input);
            throw new IllegalArgumentException(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK.getMsg());
        }
    }

    private static void decimalValidate(String input) {
        if (input.contains(".")) {
            OutputView.printErrorMsgWithReason(ErrorCode.INPUT_CANNOT_BE_DECIMAL, input);
            throw new IllegalArgumentException(ErrorCode.INPUT_CANNOT_BE_DECIMAL.getMsg());
        }
    }

    private static void greaterThanZeroValidate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            OutputView.printErrorMsgWithReason(ErrorCode.INPUT_MUST_BE_POSITIVE, value.toString());
            throw new IllegalArgumentException(ErrorCode.INPUT_MUST_BE_POSITIVE.getMsg());
        }
    }

    private static void lottoNumberRangeValidate(int number) {
        if (number < GlobalStatic.LOTTO_START_NUMBER || number > GlobalStatic.LOTTO_END_NUMBER) {
            OutputView.printErrorMsgWithReason(ErrorCode.LOTTO_NUMBER_RANGE_MISMATCH, String.valueOf(number));
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_RANGE_MISMATCH.getMsg());
        }
    }

    private static void weeklyAndBonusNumbersDuplicateValidate(int bonusNumber, List<Integer> weeklyNumbers) {
        if (weeklyNumbers.contains(bonusNumber)) {
            OutputView.printErrorMsgWithReason(ErrorCode.BONUS_NUMBER_CANNOT_BE_DUPLICATE, String.valueOf(bonusNumber));
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_CANNOT_BE_DUPLICATE.getMsg());
        }
    }
}
