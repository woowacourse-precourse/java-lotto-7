package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.enums.Constants;
import lotto.util.Util;
import lotto.validator.Validator;

public class LottoService {
    private final Validator validator = new Validator();

    public int extractLottoCount(String price) {
        validator.validatePurchaseAmount(price);
        return Integer.parseInt(price) / 1000;
    }

    public List<Integer> extractRandomNumbers() {
        int startRange = Constants.LOTTO_START_RANGE.getValue();
        int finishRange = Constants.LOTTO_FINISH_RANGE.getValue();
        int lottoCount = Constants.LOTTO_COUNT.getValue();
        return Randoms.pickUniqueNumbersInRange(startRange, finishRange, lottoCount).stream().sorted().toList();
    }

    public List<Integer> extractWinningNumbers(String lottoNumbers) {
        validator.validateWinningNumbers(lottoNumbers);
        List<String> numbers = Arrays.asList(lottoNumbers.split(","));
        List<Integer> extractWinningNumbers = new ArrayList<>();

        for (String number : numbers) {
            extractWinningNumbers.add(Util.checkValidInteger(number));
        }
        return extractWinningNumbers;
    }

    public int extractBonusNumber(String bonusNumber) {
        return Util.checkValidInteger(bonusNumber);
    }

    public LottoCount matchLottoNumbers(List<Integer> winningNumbers, int bonusNumber, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = 0;
        boolean hasBonusNumber = false;
        for (int i = 0; i < 6; i++) {
            if (winningNumbers.contains(lottoNumbers.get(i))) {
                matchCount++;
            }
        }
        if (winningNumbers.contains(bonusNumber)) {
            hasBonusNumber = true;
        }
        return new LottoCount(matchCount, hasBonusNumber);
    }

    public void updateWinningResult(LottoCount lottoCount, LottoResult lottoResult) {
        int matchCount = lottoCount.getMatchCount();
        boolean hasBonusNumber = lottoCount.isHasBonusNumber();
        if (matchCount == 6) {
            lottoResult.addResult("six");
        } else if (matchCount == 5 && hasBonusNumber) {
            lottoResult.addResult("fiveBonus");
        } else if (matchCount == 5) {
            lottoResult.addResult("five");
        } else if (matchCount == 4) {
            lottoResult.addResult("four");
        } else if (matchCount == 3) {
            lottoResult.addResult("three");
        }
    }
}
