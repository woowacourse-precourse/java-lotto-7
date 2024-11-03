package lotto.service;

import static lotto.constant.LottoStatic.PURCHASE_AMOUNT_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;
import java.util.List;
import lotto.model.Lotto;
import lotto.repository.LottoRepositoryImpl;

public class LottoService {

    private final LottoRepositoryImpl lottoRepository;

    public LottoService(LottoRepositoryImpl lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void generateByPurchaseAmount(BigInteger purchaseAmount) {
        BigInteger count = purchaseAmount.divide(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT));

        for (BigInteger i = BigInteger.ZERO; i.compareTo(count) < 0; i = i.add(BigInteger.ONE)) {
            create(generateRandomNumbers());
        }
    }

    public void create(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lottoRepository.save(lotto);
    }

    public BigInteger count() {
        return lottoRepository.count();
    }

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
