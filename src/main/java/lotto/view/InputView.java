package lotto.view;

import static lotto.domain.AutoLottos.LOTTO_PRICE_PER_PIECE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;

public class InputView {

    private static String WINNING_NUMBER_DELIMETER = ",";

    public static int inputLottoPurchaseAmount() {
        String input = Console.readLine();
        validateInputIsNumber(input);

        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmountIsDivisible(purchaseAmount, LOTTO_PRICE_PER_PIECE);
        validatePurchaseAmountIsNotZero(purchaseAmount);

        return purchaseAmount;
    }

    public static Lotto inputLottoWinningNumbers() {
        try {
            List<Integer> winningNumbers = Stream.of(Console.readLine().split(WINNING_NUMBER_DELIMETER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            return new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    public static int inputBonusNumber() {
        String input = Console.readLine();
        validateInputIsNumber(input);

        return Integer.parseInt(input);
    }

    private static void validateInputIsNumber(String input) {
        if (!input.matches("-?[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmountIsDivisible(int purchaseAmount, int divisor) {
        if (purchaseAmount % divisor != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    private static void validatePurchaseAmountIsNotZero(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다.");
        }
    }
}
