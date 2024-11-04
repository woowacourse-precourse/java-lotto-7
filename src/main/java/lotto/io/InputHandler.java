package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.Buyer;
import lotto.dto.BuyingPrice;
import lotto.dto.WinningNumbers;
import lotto.validation.Validator;

public class InputHandler {
    public BuyingPrice getPrice() {
        while (true) {
            try {
                String input = inputPrice();
                validateNumberInput(input);
                return new BuyingPrice(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    public Buyer getBuyer() {
        WinningNumbers winningNumbers = getWinningNumbers();
        while (true) {
            try {
                String input = inputBonusNumber();
                validateNumberInput(input);
                return new Buyer(winningNumbers, Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = inputWinningNumbers();
                Validator.validateEmptyInput(input);
                Validator.validateIsAllNumber(input);
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    private String inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    private String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private void validateNumberInput(String input) {
        Validator.validateEmptyInput(input);
        Validator.validateNumber(input);
    }
}
