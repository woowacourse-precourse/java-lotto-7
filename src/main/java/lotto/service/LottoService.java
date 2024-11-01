package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGrade;

public class LottoService {

    public static List<Integer> makeLottoNumber() {
        int LOTTO_NUMBER_COUNT = 6;
        int LOTTO_NUMBER_START = 1;
        int LOTTO_NUMBER_END = 45;

        List<Integer> lottoNumbers = new ArrayList<Integer>();
        while (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            int number = Randoms.pickNumberInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END);
            if (!lottoNumbers.contains(number)) {
                lottoNumbers.add(number);
            }
        }
        return lottoNumbers;
    }

    public static LottoGrade checkLottoGrade(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int correctCount = lotto.getCorrectNumberCount(winningLotto);
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber);
        return LottoGrade.getGrade(correctCount, hasBonusNumber);
    }

}
