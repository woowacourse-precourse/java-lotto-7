package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.util.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;

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

    private static Lotto genereteNewLotto(){
        return new Lotto(pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUM_COUNT));
    }

    public static ArrayList<Integer> generateWinnerLotto(String winnerLottoInput){
        ArrayList<Integer> winnerLotto = new ArrayList<>();
        for (String s : winnerLottoInput.split(",")) {
            winnerLotto.add(Integer.parseInt(s));
        }
        return winnerLotto;
    }

}
