package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoGameIllegalArgumentException;

public class InputHandler {
    public static int handleAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String amountInput = Console.readLine().trim();
        try {
            Validator.validateAmountInput(amountInput);
        } catch (IllegalArgumentException e) {
            return handleAmountInput();
        }
        return Integer.parseInt(amountInput);
    }

    public static List<Integer> handleWinningLottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningLotto = null;

        while (winningLotto == null) {
            String[] winningLottoInput = Console.readLine()
                    .trim()
                    .split(",");

            winningLotto = convertWinningLottoInputToIntArray(winningLottoInput);
        }

        return winningLotto;
    }

    private static List<Integer> convertWinningLottoInputToIntArray(String[] winningLottoInput) {
        try {
            Validator.validateWinningLottoInputLength(winningLottoInput);
            List<Integer> winningLotto = convertWinningLottoInput(winningLottoInput);
            Validator.validateWinningLottoRange(winningLotto);

            return winningLotto;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static List<Integer> convertWinningLottoInput(String[] winningLottoInput) {
        List<Integer> winningLotto = new ArrayList<>();

        for (String eachWinningLottoNumber : winningLottoInput) {
            try {
                winningLotto.add(Integer.parseInt(eachWinningLottoNumber.trim()));
            } catch (NumberFormatException e) {
                throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_TYPE);
            }
        }

        return winningLotto;
    }

    public static int handleBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine().trim();
        boolean bonusNumberValid = false;

        while (!bonusNumberValid) {
            try {
                Validator.validateBonusNumberInput(bonusNumberInput);
                bonusNumberValid = true;
            } catch (IllegalArgumentException e) {
                bonusNumberInput = Console.readLine().trim();
            }
        }

        return Integer.parseInt(bonusNumberInput);
    }
}
