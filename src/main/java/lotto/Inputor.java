package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoApplication.INCORRECT_MONEY;

public class Inputor {
    public static int getMoney() {
        System.out.println("구입 금액을 입력해 주세요");
        int money = Integer.parseInt(readLine());

        try {
            validateMinus(money);
            validatThousandMultiple(money);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            money = INCORRECT_MONEY;
        }
        return money;
    }

    private static void validatThousandMultiple(int money) throws IllegalArgumentException {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 단위로 입력해 주세요.");
        }
    }

    private static void validateMinus(int money) throws IllegalArgumentException {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
        }
    }
}
