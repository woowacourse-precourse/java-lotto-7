package lotto.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.dto.LottoResultDto;

public final class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다." + "\n";
    private static final String SEPARATOR = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    private static final String LOTTO_RESULT_NOTICE = "당첨 통계" + "\n" + "---";
    private static final String LOTTO_RESULT_INFORMATION = "%d개 일치 (%,d원) - %d개" + "\n";
    private static final String LOTTO_RESULT_INFORMATION_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개" + "\n";
    private static final String LOTTO_EARNING_RATE_INFORMATION = "총 수익률은 %.1f%%입니다.";

    public static void printLotto(List<Lotto> lottos) {
        printPurchasedResultHeader(lottos);
        printPurchasedResultInformation(lottos);
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        printLottoResultHeader();
        printLottoResultInformation(lottoResultDto);
    }

    // 로또 구매 결과 관련 private 메서드
    private static void printPurchasedResultHeader(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(LOTTO_COUNT_MESSAGE, lottos.size());
    }

    private static void printPurchasedResultInformation(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.print(PREFIX);
            String result = lotto.getSortedNumbers().stream().map(String::valueOf).collect(joining(SEPARATOR));
            System.out.print(result);
            System.out.println(SUFFIX);
        }
    }

    // 전체 로또 결과 관련 private 메서드
    private static void printLottoResultHeader() {
        System.out.println();
        System.out.println(LOTTO_RESULT_NOTICE);
    }

    private static void printLottoResultInformation(LottoResultDto resultDto) {
        Map<LottoResult, Integer> result = resultDto.result();
        for (LottoResult lottoResult : result.keySet()) {
            int matchedCount = lottoResult.getMatchedCount();
            int rewardAmount = lottoResult.getRewardAmount();
            int winningCount = resultDto.result().get(lottoResult);
            String resultInformation = getResultInformation(lottoResult);
            System.out.printf(resultInformation, matchedCount, rewardAmount, winningCount);
        }
        System.out.printf(LOTTO_EARNING_RATE_INFORMATION, resultDto.profitRate());
    }

    private static String getResultInformation(LottoResult lottoResult) {
        if (lottoResult.isBonusMatched()) {
            return LOTTO_RESULT_INFORMATION_WITH_BONUS;
        }
        return LOTTO_RESULT_INFORMATION;
    }
}
