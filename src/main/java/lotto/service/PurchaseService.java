package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

public class PurchaseService {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;
    private final LottoRepository lottoRepositoryImpl;

    public PurchaseService(LottoRepository lottoRepositoryImpl) {
        this.lottoRepositoryImpl = lottoRepositoryImpl;
    }

    public List<Lotto> purchase(Money money){
        int amount = money.getAmount();

        for (int i = 0; i < amount; i++){
            lottoRepositoryImpl.save(makeNewLotto());
        }

        return lottoRepositoryImpl.findAll();
    }

    private Lotto makeNewLotto(){
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
        return new Lotto(lotto);
    }
}

