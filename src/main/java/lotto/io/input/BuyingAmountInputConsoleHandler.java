package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class BuyingAmountInputConsoleHandler {
    public void showBuyingAmountGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoPurchasingResult(int numOFLotto) {
        System.out.println();
        System.out.println(
                String.format("%d개를 구매했습니다.", numOFLotto)
        );
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
