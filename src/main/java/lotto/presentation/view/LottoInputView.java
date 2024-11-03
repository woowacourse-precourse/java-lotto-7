package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;
import lotto.domain.model.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import lotto.domain.service.ValidationService;

public class LottoInputView {

    public int getPurchaseAmount() {
        System.out.println(OutputMessages.REQUEST_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();
        return ValidationService.validatePurchaseAmount(input);
    }

    public WinningNumbers getWinningNumbers() {
        System.out.println(OutputMessages.REQUEST_WINNING_NUMBERS.getMessage());

        List<Integer> numbers = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        ValidationService.validateWinningNumbers(numbers);

        System.out.println(OutputMessages.REQUEST_BONUS_NUMBER.getMessage());
        String bonusInput = Console.readLine();
        int bonusNumber = ValidationService.validateBonusNumber(bonusInput, numbers);

        return new WinningNumbers(numbers, bonusNumber);
    }
}