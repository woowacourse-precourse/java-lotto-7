package lotto.domain;

import lotto.domain.Lotto.Lotto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoFormatter {

    public List<String> formatLottoNumbers(List<Lotto> lottos) {
        List<String> formattedLottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            String formattedNumbers = formatSingleLottoNumbers(lotto.getNumbers());
            formattedLottoNumbers.add(formattedNumbers);
        }
        return formattedLottoNumbers;
    }

    public String formatPrize(long prize) {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(prize);
    }

    private String formatSingleLottoNumbers(List<Integer> numbers) {
        List<String> formattedLottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            formattedLottoNumbers.add(String.valueOf(number));
        }
        return String.join(",", formattedLottoNumbers);
    }
}
