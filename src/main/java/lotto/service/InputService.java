package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;

import java.util.List;

public class InputService {
    private final Validator validator = new Validator();
    public int inputPaidMoney() {
        while(true) {
            try {
                String input = Console.readLine();
                validator.validateEmptyInput(input);
                int money = validator.validateFormatInput(input);
                validator.validateThousandUnitInput(money);
                validator.validatePositiveInput(money);
                return money;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers inputWinningNumbers() {
        while(true) {
            try {
                String input = Console.readLine();
                validator.validateEmptyInput(input);
                return new WinningNumbers(input);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
