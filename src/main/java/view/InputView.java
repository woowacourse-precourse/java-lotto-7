package view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import validator.LottoValidator;

public class InputView {
    public static Integer inputCost() {
        String cost = Console.readLine();

        Integer parsedCost = LottoValidator.isNumber(cost);

        return LottoValidator.isDivisibleByThousand(parsedCost);
    }
}
