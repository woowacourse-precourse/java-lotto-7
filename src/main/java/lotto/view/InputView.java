package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    // 구입금액의 유효성 검증
    public static int inputPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int purchase = Integer.parseInt(Console.readLine());
            if (purchase < 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다.");
            }
            if (purchase % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
            }
            return purchase;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자값이어야 합니다.");
        }
    }

    public static String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
