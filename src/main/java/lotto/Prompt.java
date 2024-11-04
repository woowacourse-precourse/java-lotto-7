package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Prompt {
    public static BonusNumber promptBonusNumber() {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String bonusNumberInput = readLine();
            try {
                return BonusNumber.from(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto promptWinningLotto() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String winningLottoInput = readLine();
            try {
                List<Integer> winningLottoNumbers = Arrays.stream(winningLottoInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
                return new Lotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static LottoPurchaser promptPurchaseAmount() {
        while (true){
            System.out.println("\n구입금액을 입력해 주세요.");
            String purchaseAmountInput = readLine();
            try {
                return new LottoPurchaser(purchaseAmountInput);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
