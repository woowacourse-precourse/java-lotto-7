package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {

    private static final String BUYING_LOTTO_VIEW = "%d개를 구매했습니다.";

    private static final String EACH_LOTTO_NUMBERS_PREFIX = "[";
    private static final String EACH_LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String EACH_LOTTO_NUMBERS_SUFFIX = "]";

    private static final String WINNING_RESULT_START_VIEW = "당첨 통계\n---";
    private static final String RESULT_VIEW = "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n"
            + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
            + "6개 일치 (2,000,000,000원) - %d개\n";

    public static void showLottoNumbers(List<Lotto> myLottos) {
        System.out.println(BUYING_LOTTO_VIEW);

        for (Lotto lotto : myLottos) {
            List<Integer> numbers = lotto.getNumbers();
            numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(EACH_LOTTO_NUMBERS_DELIMITER,
                    EACH_LOTTO_NUMBERS_PREFIX,
                    EACH_LOTTO_NUMBERS_SUFFIX));
            System.out.println();
        }
    }

    public static void showWinningResult(int[] lottoResult) {
        System.out.println(WINNING_RESULT_START_VIEW);
        System.out.printf(RESULT_VIEW,
                lottoResult[4],
                lottoResult[3],
                lottoResult[2],
                lottoResult[1],
                lottoResult[0]);
        System.out.println();
    }
}
