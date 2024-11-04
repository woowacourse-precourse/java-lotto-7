package lotto.formatter;

import lotto.domain.lotto.Lotto;
import lotto.domain.WinningLotto.WinningLotto;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.dto.WinningLottoResultDTO;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoFormatter {
    private final WinningLottoCounter winningLottoCounter;

    public LottoFormatter(WinningLottoCounter winningLottoCounter) {
        this.winningLottoCounter = winningLottoCounter;
    }

    public List<String> formatLottoNumbers(List<Lotto> lottos) {
        List<String> formattedLottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            String formattedNumbers = formatSingleLottoNumbers(lotto.getNumbers());
            formattedLottoNumbers.add(formattedNumbers);
        }
        return formattedLottoNumbers;
    }

    public List<WinningLottoResultDTO> formatWinningLottoResults() {
        List<WinningLottoResultDTO> formatResults = new ArrayList<>();
        Map<WinningLotto, Integer> counts = winningLottoCounter.getCounts();

        for (WinningLotto winningLotto : WinningLotto.values()) {
            if (winningLotto != WinningLotto.NO_MATCH) {
                boolean hasBonus = winningLotto == WinningLotto.FIVE_MATCH_BONUS;
                formatResults.add(new WinningLottoResultDTO(
                        winningLotto.getMatchedCount(),
                        formatPrize(winningLotto.getPrize()),
                        counts.get(winningLotto),
                        hasBonus
                ));
            }
        }
        return formatResults;
    }

    public String formatPrize(long prize) {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(prize);
    }

    public double formatRounding(double rateOfReturn) {
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }

    private String formatSingleLottoNumbers(List<Integer> numbers) {
        List<String> formattedLottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            formattedLottoNumbers.add(String.valueOf(number));
        }
        return String.join(", ", formattedLottoNumbers);
    }
}
