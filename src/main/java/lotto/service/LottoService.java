package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.util.constant.LottoConstants.*;

public class LottoService {

    public static ArrayList<Lotto> generateNewLottoNumbers(int numOfLotto) {
        ArrayList<Lotto> newLotto = new ArrayList<>();
        for (int i = ZERO; i < numOfLotto; i++) {
            newLotto.add(LottoService.genereteNewLotto());
        }
        return newLotto;
    }

    public static Lotto genereteNewLotto(){
        return new Lotto(pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUM_COUNT));
    }
}
