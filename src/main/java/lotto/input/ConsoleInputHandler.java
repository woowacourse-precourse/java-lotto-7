package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class ConsoleInputHandler implements InputHandler {

    @Override
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        InputValidator.validateAmount(input);
        return Integer.parseInt(input);
    }

    @Override
    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        InputValidator.validateWinningNumbers(input);
        return parseWinningNumbers(input);
    }

    @Override
    public int readBonusNumber(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        InputValidator.validateBonusNumber(input, winningLotto);
        return Integer.parseInt(input);
    }

    public List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty()) // ','가 연속으로 입력된 경우 빈 문자열이 생성되는 것을 방지
                .map(Integer::parseInt)
                .toList();
    }
}
