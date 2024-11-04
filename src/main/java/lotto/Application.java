package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        int quntity;
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String purchaseInput = Console.readLine();
                quntity = InputValidator.validatePurchaseInput(purchaseInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        List<Lotto> lottos = lottoMachine.generateLottos(quntity);

        List<Integer> numbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String userPickedNumbersInput = Console.readLine();
                numbers = InputValidator.validateUserPickedNumbersInput(userPickedNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        int bonus;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요");
                String bonusInput = Console.readLine();
                bonus = InputValidator.validateBonusInput(bonusInput);
                InputValidator.validateUniqueNumbers(numbers, bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
