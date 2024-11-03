package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                int moneyInput = Integer.parseInt(Console.readLine());
                if (moneyInput % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
                return moneyInput;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위를 입력하세요.");
            }
        }
    }

    public WinningNumbers getWinningNumbers() {
        Lotto prizeNumber = getPrizeNumber();
        int bonusNumber = getBonusNumber();

        return new WinningNumbers(prizeNumber, bonusNumber);
    }

    private Lotto getPrizeNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                String numbersInput = Console.readLine();
                List<Integer> numbers = Arrays.stream(numbersInput.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed().toList();

                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 6개 숫자여야 합니다.");
            }
        }
    }

    private int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                return Integer.parseInt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이 숫자이며 당첨 번호와 중복되지 않는 숫자여야 합니다.");
            }
        }
    }
}
