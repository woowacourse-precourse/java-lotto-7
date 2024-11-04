package lotto.view;

import java.text.NumberFormat;
import java.util.stream.Collectors;
import lotto.constant.LottoRank;
import lotto.model.Lottos;

public class OutputView {
    private static final String INPUT_MONEY_PROMPT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNTS_PROMPT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATICS_PROMPT = "당첨통계\n---";
    private static final String WINNING_LOTTO_COUNT_FORMAT = "%d개\n";
    private static final String WINNING_LOTTO_YIELD_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    private final NumberFormat numberFormat = NumberFormat.getInstance();

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printInputTicketCountPrompt() {
        System.out.println(INPUT_MONEY_PROMPT);
    }

    public void printBoughtLottoTicketCount(int lottoTicketCount) {
        System.out.println(lottoTicketCount + LOTTO_COUNTS_PROMPT);
    }

    public void printBoughtLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto ->
                System.out.println(lotto.getLottoNumbers().stream()
                        .sorted()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ", "[", "]"))
                )
        );
        System.out.println();
    }

    public void printInputWinningNumbersPrompt() {
        System.out.println(INPUT_WINNING_NUMBERS_PROMPT);
    }

    public void printInputBonusNumberPrompt() {
        System.out.println(INPUT_BONUS_NUMBER_PROMPT);
    }

    public void printLottoResults(int[] winLottoCount) {
        System.out.println(WINNING_STATICS_PROMPT);
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.isPrint()) {
                int count = winLottoCount[Integer.parseInt(lottoRank.getRank())];
                System.out.printf(lottoRank.getScript() + WINNING_LOTTO_COUNT_FORMAT, count);
            }
        }
    }

    public void printLottoStatics(double yield) {
        System.out.printf(WINNING_LOTTO_YIELD_FORMAT, yield);
    }
}