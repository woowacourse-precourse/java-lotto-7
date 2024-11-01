package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPurchase;

public class InputReader {

    public LottoPurchase purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return LottoPurchase.from(Console.readLine());
    }
}
