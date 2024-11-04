package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.Util;
import lotto.validator.Validator;

public class LottoService {
    public int extractLottoCount(String price) {
        Validator.validatePurchaseAmount(price);
        return Integer.parseInt(price) / 1000;
    }

    public List<Integer> extractWinningNumbers(String lottoNumbers) {
        Validator.validateWinningNumbers(lottoNumbers);
        List<String> numbers = Arrays.asList(lottoNumbers.replaceAll(" ", "").split(","));
        List<Integer> extractWinningNumbers = new ArrayList<>();

        for (String number : numbers) {
            extractWinningNumbers.add(Util.checkValidInteger(number));
        }
        return extractWinningNumbers;
    }

    public int extractBonusNumber(String bonusNumber) {
        return Util.checkValidInteger(bonusNumber);
    }
}
