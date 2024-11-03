package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.ValidatorOfView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class LottoService {
    private static final String DELIMITER_COMMA = ",";

    public static List<Integer> parseWinningNumber(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers.split(DELIMITER_COMMA)) {
            winningNumbers.add(Integer.parseInt(number));
        }
        ValidatorOfView.isValidWinningNumber(winningNumbers);

        return winningNumbers.stream().toList();
    }

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public LottoResult addRankResult(LottoArchive lottoArchive, WinningLotto winningLotto) {
        LottoResult result = new LottoResult(new LinkedHashMap<>());
        for (Lotto lotto : lottoArchive.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int count = compareNumbers(lottoNumbers, winningLotto.getWinningNumbers().getNumbers());
            boolean isBonus = checkBonusNumber(lottoNumbers, winningLotto.getBonusNumber());
            if (count >= 3) {
                LottoPolicy key = LottoPolicy.valueOf(count, isBonus);
                result.getResults().put(key, result.getResults().getOrDefault(key, 0) + 1);
            }
        }
        return result;
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    private int compareNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                count += 1;
            }
        }
        return count;
    }


}
