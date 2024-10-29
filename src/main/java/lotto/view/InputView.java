package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {
    public static int Purchase(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = getPurchaseAmount();
        validatePurchaseAmount(amount);
        return amount;
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static List<Integer> WinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        new Lotto(winNumbers);
        return winNumbers;
    }

    public static int BonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
