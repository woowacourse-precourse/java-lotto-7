package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.List;

public class ConsoleInputView implements InputView {

    public int readCost(int lottoPrice) {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                checkBlank(input);
                return validateCost(input, lottoPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto readWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                checkBlank(input);
                return validateLotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLotto readBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                checkBlank(input);
                int bonusNumber = validateBonusNumber(input);
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void terminate() {
        Console.close();
    }

    private void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열이 입력되었습니다.");
        }
    }

    private int validateCost(String input, int lottoPrice) {
        try {
            int cost = Integer.parseInt(input.trim());
            if (cost <= 0) {
                throw new NumberFormatException();
            }
            validateRange(cost, lottoPrice);
            return cost;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0 이상의 정수로 입력되어야 합니다.");
        }
    }

    private int validateBonusNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 정수여야 합니다.");
        }
    }

    private void validateRange(int cost, int lottoPrice) {
        if (cost < lottoPrice || cost % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + formatNumber(lottoPrice) + "원 단위로 입력되어야 합니다.");
        }
    }

    private String formatNumber(int number) {
        return String.format("%,d", number);
    }

    private Lotto validateLotto(String input) {
        try {
            List<String> inputSplit = List.of(input.split(","));
            List<Integer> numbers = inputSplit.stream()
                .map(number -> Integer.parseInt(number.trim()))
                .toList();
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 정수여야 합니다.");
        }
    }
}
