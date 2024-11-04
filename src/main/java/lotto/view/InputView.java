package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNER_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return Console.readLine();
    }

    public List<String> inputNumbers() {
        System.out.println(INPUT_WINNER_LOTTO_MESSAGE);
        return List.of(Console.readLine().split(","));
    }

    public String inputBonus() {
        System.out.println(INPUT_BONUS_MESSAGE);
        return Console.readLine();
    }
}