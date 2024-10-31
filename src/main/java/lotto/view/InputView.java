package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.util.InputValidate;

public class InputView {
    private final InputValidate inputValidate = new InputValidate();
    private OutputView outputView = new OutputView();

    private String userInput() {
        return Console.readLine();
    }

    public int inputBonus() {
        outputView.bonusInputMessage();
        String input = userInput();
        inputValidate.bonusRangeValidate(input);
        int bonus = Integer.parseInt(input);
        return bonus;
    }

    public List<Integer> inputLotto() {
        outputView.lottoInputMessage();
        List<Integer> lotto = new ArrayList<>();
        String[] input = userInput().split(",");
        for (String num : input) {
            inputValidate.blankValidate(num);
            inputValidate.isDigitValidate(num);
            int lottoNum = Integer.parseInt(num);
            lotto.add(lottoNum);
        }
        return lotto;
    }
}
