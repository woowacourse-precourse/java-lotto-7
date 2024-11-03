package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputService {
    private final Validator validator = new Validator();
    public int inputPaidMoney() {
        while(true) {
            try {
                String input = Console.readLine();
                validator.validateEmptyInput(input);
                int money = validator.validateNumericInput(input);
                validator.validateThousandUnitInput(money);
                return money;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
