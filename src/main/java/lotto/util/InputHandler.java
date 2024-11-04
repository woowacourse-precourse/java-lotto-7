package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoGame;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputHandler {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int WINNING_NUMBERS_COUNT = 6;
    private static final String MONEY_REGEX = "^[1-9]\\d*$";
    private static final String NUMBER_REGEX = "^(1?[0-9]|[2-3][0-9]|4[0-5])$";

    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateNumericInput(MONEY_REGEX, input);
                int money = Integer.parseInt(input);
                if (money % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위어야 합니다.");
                }
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static LottoGame getWinningNumbers() {
        Set<Integer> winningNumbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] inputs = Console.readLine().split(",");
                validateNumericInput(NUMBER_REGEX, inputs);
                winningNumbers = Arrays.stream(inputs)
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
                validateWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateNumericInput(NUMBER_REGEX, input);
                bonusNumber = Integer.parseInt(input);
                validateBonusNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new LottoGame(winningNumbers, bonusNumber);
    }

    private static void validateNumericInput(String regex, String... inputs) {
        for (String input : inputs) {
            if (!input.matches(regex)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumber(Set<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
