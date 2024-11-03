package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.MonetaryUnit;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String WINNING_LOTTO_DELIMITER = ",";

    private InputView() {
    }

    public static int readUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        int userMoney = validateNumberFormatOfUserMoney(userInput);
        validateDivisibilityByThousand(userMoney);

        return userMoney;
    }

    private static int validateNumberFormatOfUserMoney(String userInput) {
        int userMoney;
        try {
            userMoney = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }

        return userMoney;
    }

    private static void validateDivisibilityByThousand(int userMoney) {
        if (userMoney % MonetaryUnit.USER_MONEY_PRICE.getUnit() != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위로 나누어 떨어지지 않습니다.");
        }
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return Arrays.stream(Console.readLine().split(WINNING_LOTTO_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        return Integer.parseInt(Console.readLine());
    }
}