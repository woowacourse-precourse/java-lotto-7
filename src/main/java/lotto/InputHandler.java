package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static String handleAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String amountInput = Console.readLine().trim();
        try {
            validateAmountInput(amountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handleAmountInput();
        }
        return amountInput;
    }

    public static List<Integer> handleWinningLottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningLottoInput = Console.readLine()
                .trim()
                .split(",");

        validateWinningLottoInput(winningLottoInput);
        List<Integer> winningLotto = convertWinningLottoInputToIntArray(winningLottoInput);
        validateWinningLotto(winningLotto);

        return winningLotto;
    }

    public static int handleBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine().trim();
        return validateBonusNumberInput(bonusNumberInput);
    }

    private static void validateAmountInput(String amountInput) {
        if (!amountInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        if (Integer.parseInt(amountInput) % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 단위는 1000원 단위 이상이어야 합니다.");
        }
    }

    private static void validateWinningLottoInput(String[] winningLottoInput) {
        if (winningLottoInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private static void validateWinningLotto(List<Integer> winningLotto) {
        for (int lottoNumber : winningLotto) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45사이여야 합니다.");
            }
        }
    }

    private static List<Integer> convertWinningLottoInputToIntArray(String[] winningLottoInput) {
        List<Integer> winningLotto = new ArrayList<>();
        try {
            for (String eachWinningLottoNumber : winningLottoInput) {
                winningLotto.add(Integer.parseInt(eachWinningLottoNumber.trim()));
            }
            return winningLotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private static int validateBonusNumberInput(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
