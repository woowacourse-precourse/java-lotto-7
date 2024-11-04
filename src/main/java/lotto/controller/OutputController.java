package lotto.controller;

import java.util.List;

public class OutputController {
    public static String formatLottoNumbers(List<Integer> lottoNumbers) {
        StringBuilder formattedNumbers = new StringBuilder("[");
        for (int i = 0; i < lottoNumbers.size(); i++) {
            formattedNumbers.append(lottoNumbers.get(i));
            if (i < lottoNumbers.size() - 1) {
                formattedNumbers.append(", ");
            }
        }
        formattedNumbers.append("]");
        return formattedNumbers.toString();
    }
}
