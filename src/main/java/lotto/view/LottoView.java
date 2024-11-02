package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class LottoView {

    private static final String BUY_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String FIRST_RANK_LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    protected LottoView() {
    }

    public static String inputBuyAmount() {
        return inputWithMessage(BUY_AMOUNT_INPUT_MESSAGE);
    }

    public static void announceBoughtLotto(List<Lotto> lottos) {
        int lottoCount = lottos.size();
        String lottosInfo = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));

        System.out.println(lottoCount + "개를 구매했습니다.");
        System.out.println(lottosInfo + "\n");
    }

    public static String inputFirstRankNumbers() {
        return inputWithMessage(FIRST_RANK_LOTTO_NUMBERS_INPUT_MESSAGE);
    }

    public static String inputBonusNumber() {
        return inputWithMessage(BONUS_NUMBER_INPUT_MESSAGE);
    }

    private static String inputWithMessage(String message) {
        System.out.println(message);
        String input = Console.readLine();

        System.out.print("\n");
        return input;
    }
}
