package lotto;

import static lotto.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.LottoMachineConstants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    private int purchaseAmount;
    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public void inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_PROMPT);
                String inputAmount = Console.readLine();
                purchaseAmount = Integer.parseInt(inputAmount);
                validatePurchaseAmount(purchaseAmount);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.PURCHASE_AMOUNT_NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT);
        }
    }

    public void inputWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println(WINNING_NUMBERS_PROMPT);
                String input = Console.readLine();
                winningNumbers = parseWinningNumbers(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
                winningNumbers = new HashSet<>();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers = new HashSet<>();
            }
        }
    }

    private Set<Integer> parseWinningNumbers(String input) {
        String[] splitNumbers = input.split(",");
        if (splitNumbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
        }
        Set<Integer> numbers = new HashSet<>();
        for (String numStr : splitNumbers) {
            int number = Integer.parseInt(numStr.trim());
            validateNumberRange(number);
            if (!numbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER);
            }
        }
        return numbers;
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println(BONUS_NUMBER_PROMPT);
                String input = Console.readLine();
                bonusNumber = Integer.parseInt(input.trim());
                validateBonusNumber(bonusNumber, winningNumbers);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.BONUS_NUMBER_NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE);
        }
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
