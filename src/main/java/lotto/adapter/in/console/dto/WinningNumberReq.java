package lotto.adapter.in.console.dto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.config.validation.exception.ValidationException;
import lotto.domain.WinningNumber;

/**
 * 당첨 번호를 입력받는 DTO 클래스
 */
public class WinningNumberReq {

    private static final String CONSOLE_MESSAGE = "당첨 번호를 입력해 주세요.";

    private WinningNumberReq() {
    }

    public static WinningNumber read() {
        System.out.println(CONSOLE_MESSAGE);

        while (true) {
            try {
                String input = Console.readLine().trim();
                int[] winningNumber = Arrays.stream(input.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                return new WinningNumber(winningNumber);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + e.getMessage());
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
