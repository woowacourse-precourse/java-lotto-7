package lotto.application.prize.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.application.util.StringConverter.split;
import static lotto.application.util.StringConverter.toInt;
import static lotto.application.util.StringConverter.toInts;
import static lotto.application.util.StringConverter.trim;

import java.util.List;

public class PrizeInputView {

    private final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public PrizeViewRequest initialize() {
        System.out.println(INPUT_PRIZE_NUMBER);
        List<Integer> prizeNumber = toInts(split(trim(readLine())));

        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNumber = toInt(trim(readLine()));

        return new PrizeViewRequest(prizeNumber, bonusNumber);
    }

}
