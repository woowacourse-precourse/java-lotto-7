package lotto;

import java.util.Set;

public class InputHandler {
    private static final int TICKET_PRICE = 1000;

    public static int getPurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public static int getTicketPrice() {
        return TICKET_PRICE;
    }

    public static void validateWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != 6 || winningNumbers.stream().anyMatch(InputHandler::isValidLottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 숫자 6개여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        if (isValidLottoNumber(bonusNumber) || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 숫자여야 합니다.");
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number < 1 || number > 45;
    }
}
