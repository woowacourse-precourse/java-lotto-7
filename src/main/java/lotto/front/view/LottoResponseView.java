package lotto.front.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.global.status.LottoStatus;
import lotto.global.dto.response.LottoResponseDTO;
import lotto.global.dto.response.LottoResultResponseDTO;
import lotto.global.dto.response.LottoResultResponseDTOs;
import lotto.global.dto.response.PurchasedLottoResponseDTOs;

public class LottoResponseView {

    private static final String LOTTO_COUNT_RESPONSE_MESSAGE = "개를 구매했습니다.";
    private static final String PRIZE_RESULT_RESPONSE_MESSAGE = "당첨 통계";
    private static final String PRIZE_RESULT_MESSAGE_DELIMITER = "---";
    private static final String PRIZE_RESULT_RESPONSE_PREFIX_FORMAT = "%d개 일치";
    private static final String PRIZE_RESULT_RESPONSE_SECOND_PRIZE_FORMAT = ", 보너스 볼 일치";
    private static final String PRIZE_RESULT_RESPONSE_SUFFIX_FORMAT = " (%s원) - %d개";
    private static final String PROFIT_RATE_RESPONSE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final NumberFormat numberFormat = NumberFormat.getInstance();


    public static void purchaseResponse(PurchasedLottoResponseDTOs purchasedLottoResponseDTOs) {
        printLottoCount(purchasedLottoResponseDTOs.purchasedLottos().size());
        printPurchasedLottos(purchasedLottoResponseDTOs.purchasedLottos());
    }

    private static void printLottoCount(Integer count) {
        System.out.println(count.toString() + LOTTO_COUNT_RESPONSE_MESSAGE);
    }

    private static void printPurchasedLottos(List<LottoResponseDTO> purchasedLottos) {
        purchasedLottos.forEach(purchasedLotto -> System.out.println(purchasedLotto.numbers()));
        System.out.println();
    }

    public static void printPrizeResult(LottoResultResponseDTOs lottoResultResponseDTOs) {
        System.out.println(PRIZE_RESULT_RESPONSE_MESSAGE);
        System.out.println(PRIZE_RESULT_MESSAGE_DELIMITER);
        printHistory(lottoResultResponseDTOs.lottoResults());
        printProfitRate(lottoResultResponseDTOs.profitRate());
    }

    private static void printHistory(List<LottoResultResponseDTO> lottoResults) {
        Map<LottoStatus, Long> countPerPrize = lottoResults.stream().collect(Collectors.groupingBy(
                LottoResultResponseDTO::lottoStatus,
                Collectors.counting()));

        List<LottoStatus> allByAscendingPrize = LottoStatus.getAllByAscendingPrize();
        for (LottoStatus lottoStatus : allByAscendingPrize) {
            Integer matchCount = lottoStatus.getMatchCount();
            String formattedPrize = numberFormat.format(lottoStatus.getPrize());
            Long count = countPerPrize.getOrDefault(lottoStatus, 0L);

            String format = makeFormat(lottoStatus.equals(LottoStatus.SECOND), matchCount, formattedPrize, count);
            System.out.println(format);
        }
    }

    private static String makeFormat(Boolean isSecondPrize, Integer matchCount, String formattedPrize, Long count) {
        String format = PRIZE_RESULT_RESPONSE_PREFIX_FORMAT;
        if (isSecondPrize) {
            format += PRIZE_RESULT_RESPONSE_SECOND_PRIZE_FORMAT;
            format += PRIZE_RESULT_RESPONSE_SUFFIX_FORMAT;
            return String.format(format, matchCount, formattedPrize, count);
        }

        format += PRIZE_RESULT_RESPONSE_SUFFIX_FORMAT;
        return String.format(format, matchCount, formattedPrize, count);
    }

    private static void printProfitRate(Double profitRate) {
        System.out.printf(PROFIT_RATE_RESPONSE_MESSAGE + "%n", profitRate);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
