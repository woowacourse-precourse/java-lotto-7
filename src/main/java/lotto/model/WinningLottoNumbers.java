package lotto.model;

import static lotto.view.InputView.getStrInput;
import static lotto.view.OutputView.printErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorCode;

public class WinningLottoNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

//    public WinningLottoNumbers(String winningNumber, int bonusNumber) {
//
//        this.winningNumbers = winningNumbers;
//        this.bonusNumber = bonusNumber;
//    }

    public WinningLottoNumbers() {

    }

    public List<Integer> getWinningNumber() {
        while (true) {
            String input = getStrInput();

            try {
                return splitWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Integer> splitWinningNumbers(String input) {
        validateCommaDelimitedNumbers(input);
        String[] tokens = input.split(",");
        List<Integer> winningNumber = Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateLottoNumber(winningNumber);
        setWinningNumbers(winningNumber);

        return winningNumbers;
    }

    private void validateInputs(List<Integer> numbers, int bonus) {

    }

    public void validatePositiveInteger(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] " + ErrorCode.INVALID_NEGATIVE_NUMBER.getMessage());
            }
        }
    }

    private void validateCommaDelimitedNumbers(String input) {
        if (!input.matches("^(\\d{1,2},){5}\\d{1,2}$")) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DELIMITER.getMessage());
        }
    }

    private void validateLottoNumber(List<Integer> winningNumber){
        for (int number : winningNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER.getMessage());
            }
        }
    }

    private void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

//    public LottoRank match(Lotto lotto) {
//
//    }
}
