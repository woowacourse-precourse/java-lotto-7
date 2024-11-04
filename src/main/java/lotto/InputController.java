package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputController {

    LottoController lottoController = new LottoController();

    public int inputPurchaseNumber() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요");
                String purchaseNumber = Console.readLine();
                return lottoController.parsePurchaseNumber(purchaseNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winNumber = Console.readLine();
                return lottoController.parseWinNumber(winNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();
                int parseBonusNumber = lottoController.parseBonusNumber(bonusNumber);
                Validator.validateBonusNumber(winNumbers, parseBonusNumber);
                return parseBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
