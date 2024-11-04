package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % 1000 != 0) {
                throw new LottoException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new LottoException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (numbers.size() != 6) {
                throw new LottoException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new LottoException("[ERROR] 당첨 번호는 숫자이어야 합니다.");
        }
    }

    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new LottoException("[ERROR] 보너스 번호는 숫자이어야 합니다.");
        }
    }
}
