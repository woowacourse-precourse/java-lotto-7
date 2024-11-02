package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.model.ErrorMessages;
import lotto.domain.model.WinningNumbers;

import java.util.Arrays;
import java.util.List;

//사용자 입력을 담당하는 클래스
public class LottoInputView {

    public int getPurchaseAmount() {
        System.out.println(OutputMessages.REQUEST_PURCHASE_AMOUNT.getMessage());
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.INVALID_INPUT_FORMAT.getMessage());
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public WinningNumbers getWinningNumbers() {
        System.out.println(OutputMessages.REQUEST_WINNING_NUMBERS.getMessage());
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_FORMAT.getMessage());
        }

        System.out.println(OutputMessages.REQUEST_BONUS_NUMBER.getMessage());
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_FORMAT.getMessage());
        }

        return new WinningNumbers(numbers, bonusNumber);
    }
}

