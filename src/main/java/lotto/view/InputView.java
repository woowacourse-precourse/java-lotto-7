package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import validator.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE_NUMBER_FORMAT = "[ERROR] %s은(는) 숫자여야 합니다.";

    public static int inputPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(Console.readLine());
            LottoValidator.validatePurchaseAmount(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE_NUMBER_FORMAT, "구입 금액"));
        }
        return purchaseAmount;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(MESSAGE_WINNING_NUMBERS);
        try {
            return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE_NUMBER_FORMAT, "당첨 번호"));
        }
    }

    public static int inputBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE_NUMBER_FORMAT, "당첨 번호"));
        }
    }
}