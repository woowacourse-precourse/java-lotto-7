package lotto.prompt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Amount;

public class LottoPurchasePrompt {

    private static final String AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요.\n";
    private static final String PURCHASE_OUTPUT_MSG = "%d개를 구매했습니다.\n";

    public Amount enterAmount() {
        while (true) {
            try {
                System.out.print(AMOUNT_INPUT_MSG);
                Amount amount = Amount.parse(Console.readLine());
                System.out.println();
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printPurchased(List<String> lottoNumbers) {
        System.out.printf(PURCHASE_OUTPUT_MSG, lottoNumbers.size());
        for (String lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
        System.out.println();
    }
}
