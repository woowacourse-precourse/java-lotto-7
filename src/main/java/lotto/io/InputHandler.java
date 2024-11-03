package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BuyingPrice;
import lotto.validation.Validator;

public class InputHandler {
    public BuyingPrice getLottoPrice() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                validateInput(input);
                int price = Integer.parseInt(input);
                return new BuyingPrice(price);
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }

    public String getSelectedNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validateInput(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public void validateInput(String input) {
        Validator.validateEmptyInput(input);
        Validator.validateNumber(input);
    }
}
