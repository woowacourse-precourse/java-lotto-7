package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;
import lotto.view.formatter.OutputFormatter;

public class OutputView {

    private OutputView() {
    }

    public static void displayLottoNumbers(List<LottoDto> lottoDtos) {
        String sizeOfLotto = OutputFormatter.formatSizeOfLotto(lottoDtos.size());
        List<String> lottoNumbers = OutputFormatter.formatLottoNumbers(lottoDtos);

        System.out.println(sizeOfLotto);
        lottoNumbers.forEach(System.out::println);
    }

    public static void displayResult(ResultDto resultDto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<String> rankCounts = OutputFormatter.formatRankCount(resultDto.rankDtos());
        rankCounts.forEach(System.out::println);

        System.out.println(OutputFormatter.formatProfitRate(resultDto.profitRate()));
    }

    public static void displayErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
