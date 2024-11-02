package lotto.adapter.in.console.dto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.validation.exception.ValidationException;
import lotto.domain.PurchaseAmount;

/**
 * 구입금액을 입력받는 DTO 클래스
 */
public class PurchaseAmountReq {

    private static final String CONSOLE_MESSAGE = "구입금액을 입력해 주세요.";

    private PurchaseAmountReq() {
    }

    public static PurchaseAmount read() {
        System.out.println(CONSOLE_MESSAGE);

        while (true) {
            try {
                String input = Console.readLine().trim();
                int purchaseAmount = Integer.parseInt(input);

                return new PurchaseAmount(purchaseAmount);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + e.getMessage());
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
