package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

public class OutputView {
    private static final String PRINT_INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_BUY_LOTTO_COUNT = "%d개를 구매했습니다.\n";

    public static void printInputPrice() {
        System.out.println(PRINT_INPUT_PRICE);
    }

    public static void printLottoGames(LottoGame lottoGame) {
        printBuyLottoCount(lottoGame.getLottoCount());
        for (Lotto lotto : lottoGame.getLottos()) {
            printLottoNumbers(lotto);
        }
        System.out.println();
    }

    private static void printBuyLottoCount(int lottoCount) {
        System.out.printf(PRINT_BUY_LOTTO_COUNT, lottoCount);
    }

    private static void printLottoNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        String value = "[" + lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
        System.out.println(value);
    }
}
