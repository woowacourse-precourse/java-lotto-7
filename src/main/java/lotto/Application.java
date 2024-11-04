package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        try {
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            int ticketCount = purchaseAmount / 1000;
            System.out.println(ticketCount + "개를 구매했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

