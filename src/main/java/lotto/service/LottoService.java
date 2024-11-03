package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.component.Lotto;
import lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static LottoService instance;
    private LottoService() {
    }
    public static LottoService getInstance(){
        if(instance == null){
            instance = new LottoService();
        }
        return instance;
    }
    public Lotto generateRandomLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_RANGE_NUMBER,
                LottoConstants.MAX_RANGE_NUMBER,
                LottoConstants.LOTTO_NUMBERS_COUNT));
        return lotto;
    }

    public List<Lotto> createRandomLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++){
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }
}
