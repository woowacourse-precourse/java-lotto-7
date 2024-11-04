package lotto.view;

import lotto.Validator.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchasePrice = Console.readLine();
        try {
            Validator.validatePurchasePrice(purchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchasePrice();
        }
        return Integer.parseInt(purchasePrice);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        List<String> winningNumbers = Arrays.asList(winningNumber.split(LOTTO_NUMBER_DELIMITER));
        try {
            Validator.validateLottoNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumbers();
        }
        return Arrays.stream(winningNumber.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = Integer.parseInt(Console.readLine());
        try {
            Validator.validateBonusNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }
}
