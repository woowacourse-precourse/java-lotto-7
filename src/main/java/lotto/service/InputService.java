package lotto.service;

import camp.nextstep.edu.missionutils.Console;

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
}
