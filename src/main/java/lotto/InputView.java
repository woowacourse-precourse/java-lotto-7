package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        return parsePurchaseAmount(input);
    }

    public static WinningNumbers readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNums = parseNumbers(readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = readBonusNumber();

        Lotto winningLotto = new Lotto(winningNums);
        return new WinningNumbers(winningLotto, bonus);
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private static int readBonusNumber() {
        String bonusInput = readLine();
        try {
            return Integer.parseInt(bonusInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private static String readLine() {
        String line = Console.readLine();
        if (line == null) {
            throw new IllegalStateException("[ERROR] 입력이 필요합니다.");
        }
        return line;
    }
}