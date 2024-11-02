package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {
    }

    public static int readUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        return validateUserMoney(userInput);
    }

    private static int validateUserMoney(String userInput) {
        int userMoney;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                userMoney = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
            }
        }
        return userMoney;
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}