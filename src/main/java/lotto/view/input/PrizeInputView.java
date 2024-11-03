package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.StringConverter.split;
import static lotto.util.StringConverter.toInts;
import static lotto.util.StringConverter.trim;

import java.util.List;

public class PrizeInputView {

    private final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    public void initialize() {
        System.out.println(INPUT_PRIZE_NUMBER);
        List<Integer> prizeNumber = toInts(split(trim(readLine())));

    }

}
