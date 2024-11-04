package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;

public class InputService {
    private final Validator validator = new Validator();
    public int inputPaidMoney() {
        while(true) {
            try {
                String input = inputAndValidate();
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
                String input = inputAndValidate();
                return new WinningNumbers(input);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        while(true) {
            try {
                String input = inputAndValidate();
                int number = validator.validateFormatInput(input);
                return new BonusNumber(number, winningNumbers.getNumbers());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputAndValidate() {
        String input = Console.readLine();
        validator.validateEmptyInput(input);
        return input;
    }
}
