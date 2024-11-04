package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    private static final String ERROR_INVALID_PURCHASE_COST = "[ERROR] 구입 금액은 0원이나 음수가 될 수 없습니다.";
    private static final String ERROR_INVALID_COST_UNIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    private static final String ERROR_INVALID_NUMBER_FORMAT_PURCHASE = "[ERROR] 숫자 형식이 올바르지 않습니다. 구입 금액을 숫자로 입력해 주세요.";
    private static final String ERROR_INVALID_NUMBER_FORMAT_WINNING = "[ERROR] 숫자 형식이 올바르지 않습니다. 당첨 번호를 숫자로 입력해주세요.";
    private static final String ERROR_INVALID_NUMBER_FORMAT_BONUS = "[ERROR] 숫자 형식이 올바르지 않습니다. 보너스 번호를 숫자로 입력해주세요.";

    public long getPurchaseCost() {
        try {
            long purchaseCost = Long.parseLong(Console.readLine());

            if (purchaseCost <= 0) {
                throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_COST);
            }

            if (purchaseCost % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_INVALID_COST_UNIT);
            }

            return purchaseCost;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT_PURCHASE);
        }
    }

    public List<Integer> getWinningLottoInput() {
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(number -> {
                    try {
                        return Integer.parseInt(number.trim());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT_WINNING);
                    }
                })
                .collect(Collectors.toList());
    }

    public Integer getWinningLottoBonusNumberInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT_BONUS);
        }
    }
}
