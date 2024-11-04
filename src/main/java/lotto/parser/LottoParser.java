package lotto.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.validation.LottoContextValidator;

public class LottoParser {
    public static int getPurchaseMoney(String sentence) {
        return LottoTokenizer.getPurchaseMoney(sentence);
    }

    public static List<Integer> getWinningNumbers(String sentence) {
        StringTokenizer tkn = new StringTokenizer(sentence, ",");
        List<Integer> winningNumbers = new ArrayList<>();

        while (tkn.hasMoreTokens()) {
            String token = tkn.nextToken();
            int lottoNumber = LottoTokenizer.getLottoNumber(token);
            winningNumbers.add(lottoNumber);
        }
        LottoContextValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int getBonusNumber(String sentence, List<Integer> winningNumbers) {
        int bonusNumber = LottoTokenizer.getLottoNumber(sentence);
        LottoContextValidator.validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }
}
