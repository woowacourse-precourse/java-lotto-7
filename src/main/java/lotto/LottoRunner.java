package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoRunner {
    public static void start() {
        int money = 1;
        while (money % 1000 != 0) {
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.parseInt(Console.readLine());
        }
    }
}
