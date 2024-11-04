package lotto.presentation.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.presentation.view.View;
import lotto.common.util.StringParser;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.WinningNumbers;

public class Input {
    private static final String INPUT_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";
    private final View view;

    public Input(View view) {
        this.view = view;
    }

    public LottoPurchase promptLottoPurchase() {
        view.printGuide(INPUT_AMOUNT_GUIDE);
        return new LottoPurchase(getAmount());
    }

    private Integer getAmount() {
        return StringParser.toInteger(Console.readLine());
    }

    public Lotto promptWinningNumbers() {
        view.printGuide(INPUT_WINNING_NUMBERS_GUIDE);
        return new Lotto(getWinNumbers());
    }

    private List<Integer> getWinNumbers() {
        return StringParser.splitByDelimiter(Console.readLine());
    }

    public WinningNumbers promptBonusNumber(Lotto lotto) {
        view.printGuide(INPUT_BONUS_NUMBER_GUIDE);
        return new WinningNumbers(lotto, getBonusNumber());
    }

    private Bonus getBonusNumber() {
        return new Bonus(StringParser.toInteger(Console.readLine()));
    }
}
