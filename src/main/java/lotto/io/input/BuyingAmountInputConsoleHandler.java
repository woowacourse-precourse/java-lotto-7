package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class BuyingAmountInputConsoleHandler {
    public void showBuyingAmountGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int askBuyingAmount() {
        String rawBuyingAmount = Console.readLine();

        try {
            return Integer.parseInt(rawBuyingAmount);
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액의 형식이 잘못되었습니다.");
        }
    }
}
