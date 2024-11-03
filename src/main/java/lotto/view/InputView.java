package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {

    public static int Purchase(){
        int amount = getPurchaseAmount();
        validatePurchaseAmount(amount);
        System.out.println();
        return amount;
    }

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void validatePurchaseAmount(int amount) {
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
        System.out.println();
        return winNumbers;
    }

    public static int BonusNumber(List<Integer> winningNumbers){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        Lotto winningLotto = new Lotto(winningNumbers);
        if (winningLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        System.out.println();
        return bonusNumber;
    }
}
