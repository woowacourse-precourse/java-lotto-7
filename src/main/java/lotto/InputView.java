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
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if ((amount < LOTTO_PRICE) || ((amount % LOTTO_PRICE) != 0)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.");
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
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
        Set<Integer> numbers = new HashSet<>();
        for (String numStr : splitNumbers) {
            int number = Integer.parseInt(numStr.trim());
            validateNumberRange(number);
            if (!numbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
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
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 번호는 " + LOTTO_MIN_NUMBER + "부터 " + LOTTO_MAX_NUMBER
                            + " 사이의 숫자여야 합니다.");
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
