package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoRunner {
    public static void start() {
        int money = 1;
        while (money % 1000 != 0) {
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.parseInt(Console.readLine());
            try {
                validate(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validate(int money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 단위의 숫자로 입력해주세요.");
        }
    }
}
