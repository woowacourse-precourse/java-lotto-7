package lotto.view;

import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.LottoRank;
import lotto.dto.LottoPurchaseResponseDto;
import lotto.dto.LottoResultResponseDto;

public class OutputView {

    private static final StringBuilder BUFFER = new StringBuilder();
    private static final String NEW_LINE = "\n";

    public static void displayErrorMessage(String message) {
        System.out.println(message);
    }

    public static void displayLottoPurchase(LottoPurchaseResponseDto lottoPurchaseResponseDto) {
        appendPurchaseCount(lottoPurchaseResponseDto);
        appendLottoNumbers(lottoPurchaseResponseDto);
        clearBuffer();
    }

    public static void displayLottoResult(LottoResultResponseDto resultDto) {
        appendHeader();
        appendRankDetails(resultDto.getRankCounts());
        appendYield(resultDto.getYield());
        clearBuffer();
    }

    private static void appendPurchaseCount(LottoPurchaseResponseDto lottoPurchaseResponseDto) {
        BUFFER.append(lottoPurchaseResponseDto.getPurchaseCount())
                .append("개를 구매했습니다.")
                .append(NEW_LINE);
    }

    private static void appendLottoNumbers(LottoPurchaseResponseDto lottoPurchaseResponseDto) {
        lottoPurchaseResponseDto.getLottoBundle().forEach(lotto ->
                BUFFER.append(lotto).append(NEW_LINE)
        );
    }

    private static void appendHeader() {
        BUFFER.append("당첨 통계").append(NEW_LINE)
                .append("---").append(NEW_LINE);
    }

    private static void appendRankDetails(Map<LottoRank, Integer> rankCounts) {
        Stream.of(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .forEach(rank -> appendRankDetail(rank, rankCounts.getOrDefault(rank, 0)));
    }

    private static void appendRankDetail(LottoRank rank, int count) {
        BUFFER.append(rank.getMatchingCount())
                .append("개 일치");

        if (rank == LottoRank.SECOND) {
            BUFFER.append(", 보너스 볼 일치");
        }

        BUFFER.append(" (")
                .append(String.format("%,d", rank.getPrize()))
                .append("원) - ")
                .append(count)
                .append("개")
                .append(NEW_LINE);
    }

    private static void appendYield(String yield) {
        BUFFER.append("총 수익률은 ")
                .append(yield)
                .append("%입니다.")
                .append(NEW_LINE);
    }

    private static void clearBuffer() {
        System.out.print(BUFFER);
        BUFFER.setLength(0);
    }
}
