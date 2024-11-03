package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
    private final static Integer LOTTO_NUMBER_SIZE = 6;
    private final static Integer LOTTO_RANGE_START = 1;
    private final static Integer LOTTO_RANGE_END = 45;

    private List<Lotto> publishedLottos = new ArrayList<>();


    public List<Integer> publishLotto(){
        Lotto newLotto = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMBER_SIZE));
        publishedLottos.add(newLotto);

        return newLotto.getSortedNumbers();
    }

}
