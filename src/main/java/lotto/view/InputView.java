package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessages;
import lotto.domain.LottoConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateWinningNumbers(numbers);
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_AMOUNT);
        }
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_PRICE);
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_COUNT);
        }
        if (numbers.stream().anyMatch(num -> num < LottoConstants.LOTTO_MIN_NUMBER || num > LottoConstants.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
        if (numbers.stream().distinct().count() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_DUPLICATE_NUMBER);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
    }
}
