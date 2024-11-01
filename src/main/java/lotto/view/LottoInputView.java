package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.error.LottoError;

public class LottoInputView {
    private static final String NUMBERS_DELIMITER = ",";
    private final LottoInputValidator lottoInputValidator;

    public LottoInputView(LottoInputValidator lottoInputValidator) {
        this.lottoInputValidator = lottoInputValidator;
    }

    public int readLottoPurchasePrice() {
        String lottoPurchasePrice = readInput();
        lottoInputValidator.validateLottoPurchasePrice(lottoPurchasePrice);
        return parseInt(lottoPurchasePrice);
    }

    public List<Integer> readLottoWinningNumbers() {
        String winningNumbers = readInput();
        lottoInputValidator.validateLottoWinningNumbers(winningNumbers);
        return parseNumbers(winningNumbers);
    }

    public int readLottoBonusNumber() {
        String bonusNumber = readInput();
        lottoInputValidator.validateLottoBonusNumber(bonusNumber);
        return parseInt(bonusNumber);
    }


    private String readInput() {
        return Console.readLine();
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER.getMessage());
        }
    }

    private List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(NUMBERS_DELIMITER))
                .map(this::parseInt)
                .collect(Collectors.toList());
    }

}
