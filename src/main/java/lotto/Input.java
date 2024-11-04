package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int price = Integer.parseInt(input);
        validatePrice(price);
        return price;
    }

    private static void validatePrice(int price) {
        if (price < 0 || price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 올바르지 않습니다.");
        }
    }
}
