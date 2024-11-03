package lotto.view.formatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto.RankDto;

public class OutputFormatter {
    private OutputFormatter() {
    }

    public static String formatSizeOfLotto(int sizeOfLotto) {
        return sizeOfLotto + "개를 구매했습니다.";
    }

    public static List<String> formatLottoNumbers(List<LottoDto> lottoDtos) {
        List<String> parsedLottoNumbers = new ArrayList<>();

        for (LottoDto lottoDto : lottoDtos) {
            List<Integer> sortedNumbers = sortNumbers(lottoDto.numbers());

            String result = String.join(", ", sortedNumbers.stream().map(String::valueOf).toList());
            parsedLottoNumbers.add("[" + result + "]");
        }

        return parsedLottoNumbers;
    }

    private static List<Integer> sortNumbers(List<Integer> originNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(originNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public static List<String> formatRankCount(List<RankDto> rankDtos) {
        List<String> parsedRankCounts = new ArrayList<>();

        for (RankDto rankDto : rankDtos) {
            parsedRankCounts.add(rankDto.description() + " - " + rankDto.count() + "개");
        }

        return parsedRankCounts;
    }

    public static String formatProfitRate(double profitRate) {
        return String.format("총 수익률은 %.1f%%입니다.", Math.round(profitRate * 10) / 10.0);
    }

}
