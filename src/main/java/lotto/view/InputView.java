package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.utils.Utils;

public class InputView {
    private static final String INPUT_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public Budget inputBudget(){
        System.out.println(INPUT_BUDGET_MESSAGE);
        String input = Console.readLine().replace(" ", "");
        int money = Utils.parseNumber(input);
        return new Budget(money);
    }

    public Lotto inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine().replace(" ", "");
        Utils.validateInputWinningNumbers(input);
        List<Integer> numbers = Arrays.stream(input.split(",")).mapToInt(Utils::parseNumber).boxed().toList();
        return new Lotto(numbers);
    }

    public Bonus inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        int bonusNumber = Utils.parseNumber(input);
        return new Bonus(bonusNumber);
    }


}
