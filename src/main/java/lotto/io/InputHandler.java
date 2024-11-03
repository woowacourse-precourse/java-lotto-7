package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BuyingPrice;
import lotto.dto.Buyer;
import lotto.dto.WinningNumbers;
import lotto.validation.Validator;

public class InputHandler {
    public BuyingPrice getLottoPrice() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                Validator.validateEmptyInput(input);
                Validator.validateNumber(input);
                int price = Integer.parseInt(input);
                return new BuyingPrice(price);
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    public Buyer getBuyer() {
        WinningNumbers winningNumbers = getWinningNumbers();
        while (true) {
            try {
                String input = getBonusNumber();
                Validator.validateEmptyInput(input);
                Validator.validateNumber(input);
                int bonusNumber = Integer.parseInt(input);
                return new Buyer(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                Validator.validateEmptyInput(input);
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    private String getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
