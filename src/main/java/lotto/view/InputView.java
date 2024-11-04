package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;

import static lotto.util.ConstantVariables.*;
import static lotto.util.CustomStringUtils.printStringLineFeed;

public class InputView {
    public static Money moneyInput() {
        while (true) {
            printStringLineFeed(LOTTO_MONEY_INPUT.value());
            String money = Console.readLine();

            try {
                validateMoneyInput(money);
                return Money.from(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateMoneyInput(String money) {
        if (money == null) {
            throw new IllegalArgumentException("[ERROR] 입력이 null입니다.");
        }

        if (!money.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }

        if (money.length() < 4) {
            throw new IllegalArgumentException("[ERROR] 입력 사이즈가 맞지 않습니다.");
        }

        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 가능합니다.");
        }
    }

    public static Lotto lottoAnswerNumInput() {
        printStringLineFeed(LOTTO_ANSWER_NUM_INPUT.value());
        String lottoAnswerNum = Console.readLine();

        return Lotto.from(lottoAnswerNum);
    }

    public static int lottoBonusNumInput() {
        printStringLineFeed(LOTTO_BONUS_NUM_INPUT.value());
        return Integer.parseInt(Console.readLine());
    }
}