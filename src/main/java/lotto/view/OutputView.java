package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Ranking;

public class OutputView {

    private static final String PURCHASE_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_MESSAGE_FORMAT = "[%s]%n";
    private static final String LOTTO_RESULT_NOTICE_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_INFO_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String LOTTO_INFO_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static final String LOTTO_REVENUE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public void printPurchaseLottos(List<Lotto> lottos) {
        printEmptyLine();
        printPurchaseCount(lottos.size());
        lottos.forEach(this::printLotto);
        printEmptyLine();
    }

    public void printLottoResults(LottoResult lottoResult) {
        printEmptyLine();
        printLottoResultsNoticeMessage();
        printLottoResult(lottoResult);
        printRevenue(lottoResult);
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    private void printPurchaseCount(int lottoCount) {
        System.out.printf(PURCHASE_COUNT_MESSAGE_FORMAT, lottoCount);
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers().stream()
                .sorted()
                .toList();
        System.out.printf(LOTTO_NUMBER_MESSAGE_FORMAT, createOutputNumbers(numbers));
    }

    private String createOutputNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private void printLottoResultsNoticeMessage() {
        System.out.println(LOTTO_RESULT_NOTICE_MESSAGE);
    }

    private void printLottoResult(LottoResult lottoResult) {
        Arrays.stream(Ranking.values())
                .filter(ranking -> ranking != Ranking.MISS)
                .sorted(Comparator.comparingInt(Ranking::getGrade).reversed())
                .forEach(ranking -> printLottoResultInfo(lottoResult.getResults(), ranking));
    }

    private void printLottoResultInfo(Map<Ranking, Integer> lottoResults, Ranking ranking) {
        printLottoResultInfo(ranking, lottoResults.getOrDefault(ranking, 0));
    }

    private void printLottoResultInfo(Ranking ranking, int count) {
        if (ranking.isRequireMatchBonus()) {
            System.out.printf(LOTTO_INFO_WITH_BONUS_FORMAT, ranking.getMatchCount(), ranking.getPrize(), count);
            return;
        }

        System.out.printf(LOTTO_INFO_FORMAT, ranking.getMatchCount(), ranking.getPrize(), count);
    }

    private void printRevenue(LottoResult lottoResult) {
        System.out.printf(LOTTO_REVENUE_FORMAT, lottoResult.getRevenue());
    }
}
