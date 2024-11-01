package lotto.prompt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Amount;

public class LottoPurchasePrompt {

    public Amount enterAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return Amount.parseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printPurchased(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
