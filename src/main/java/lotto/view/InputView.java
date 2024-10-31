package lotto.view;

import static lotto.exception.ExceptionMessage.DUPLICATE_BONUS_NUMBER;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validation.AmountValidator;
import lotto.util.validation.LottoNumberValidator;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int readAmount() {
        while (true) {
            System.out.println(AMOUNT_MESSAGE);
            try {
                String inputAmount = Console.readLine();
                validateAmount(inputAmount);

                return Integer.parseInt(inputAmount);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void validateAmount(String inputAmount) {
        AmountValidator validator = new AmountValidator();

        validator.validate(inputAmount);
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println(BONUS_NUMBER_MESSAGE);
            try {
                String inputBonusNumber = Console.readLine();
                validateLottoNumber(inputBonusNumber);
                int bonusNumber = Integer.parseInt(inputBonusNumber);
                validateBonusNumber(bonusNumber, winningNumbers);

                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.format());
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            System.out.println(WINNING_NUMBER_MESSAGE);
            try {
                String inputWinningNumber = Console.readLine();
                List<Integer> winningNumbers = convertToIntegerList(inputWinningNumber.split(DELIMITER));

                validateLottoNumbers(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        LottoNumberValidator validator = new LottoNumberValidator();
        validator.validateLottoNumberCount(lottoNumbers);
        lottoNumbers.forEach(number -> validator.validate(String.valueOf(number)));
    }

    private void validateLottoNumber(String lottoNumber) {
        LottoNumberValidator validator = new LottoNumberValidator();
        validator.validate(lottoNumber);
    }

    private List<Integer> convertToIntegerList(String[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .toList();
    }
}