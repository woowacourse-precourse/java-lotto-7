package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ExceptionMessage;
import lotto.common.IOMessage;
import lotto.common.Limit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final Set<Integer> winningNumbers = new HashSet<>();

    public static int inputPurchaseAmount() {
        System.out.println(IOMessage.PURCHASE_AMOUNT_PROMPT);
        String amount = Console.readLine();
        validatePurchaseAmount(amount);
        return Integer.parseInt(amount);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(IOMessage.WINNING_NUMBERS_PROMPT);

        while (winningNumbers.size() < Limit.LOTTO_NUMBER_COUNT) {
            try {
                String numString = Console.readLine();
                parseAndValidateInput(numString);
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("[ERROR] 중복된 숫자가 있습니다. %d번째 숫자부터 다시 입력해주세요.", calculateRemainNum()));
            }
        }

        return convertAndSortSet(winningNumbers);
    }

    public static int inputBonusNumber() {
        System.out.println(IOMessage.BONUS_NUMBER_PROMPT);
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < Limit.LOTTO_MIN_NUMBER || bonusNumber > Limit.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
        return bonusNumber;
    }

    public static void validatePurchaseAmount(String amount) {
        checkIsNumber(amount);
        validatePurchaseAmountIsRightPrice(Integer.parseInt(amount));
    }

    public static void validatePurchaseAmountIsRightPrice(int amount) {
        if (amount % Limit.LOTTO_PRICE != 0 || amount < Limit.LOTTO_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT);
        }
    }

    public static List<Integer> parseAndValidateInput(String input) {
        List<Integer> newNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(number -> {
                    checkIsNumber(number);
                    int num = Integer.parseInt(number);
                    checkIsRangeIn(num);

                    if (!winningNumbers.add(num)) {
                        throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER + num);
                    }
                    return num;
                })
                .collect(Collectors.toList());

        if (winningNumbers.size() < Limit.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INSUFFICIENT_NUMBERS);
        }

        return newNumbers;
    }

    public static int calculateRemainNum() {
        return Limit.LOTTO_NUMBER_COUNT - winningNumbers.size();
    }

    private static void checkIsNumber(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private static void checkIsRangeIn(int num) {
        if (num < Limit.LOTTO_MIN_NUMBER || num > Limit.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER + num);
        }
    }

    private static List<Integer> convertAndSortSet(Set<Integer> numberSet) {
        List<Integer> sortedList = new ArrayList<>(numberSet);
        Collections.sort(sortedList);
        return sortedList;
    }
}
