package lotto.adapter.in.console.dto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.validation.exception.ValidationException;
import lotto.domain.input.BonusNumber;

/**
 * 보너스 번호를 입력받는 DTO 클래스
 */
public class BonusNumberReq {

    private static final String CONSOLE_MESSAGE = "보너스 번호를 입력해 주세요.";

    private BonusNumberReq() {
    }

    public static BonusNumber read() {
        System.out.println(CONSOLE_MESSAGE);

        while (true) {
            try {
                String input = Console.readLine().trim();
                int bonusNumber = Integer.parseInt(input);

                return new BonusNumber(bonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + e.getMessage());
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
