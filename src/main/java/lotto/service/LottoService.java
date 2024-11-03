package lotto.service;

import static lotto.constant.LottoStatic.LOTTO_NUMBER_COUNTS;
import static lotto.constant.LottoStatic.PURCHASE_AMOUNT_UNIT;
import static lotto.constant.LottoStatic.RANDOM_END_NUMBER;
import static lotto.constant.LottoStatic.RANDOM_START_NUMBER;

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
        lottoRepository.save(new Lotto(numbers));
    }

    public BigInteger count() {
        return lottoRepository.count();
    }

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER, LOTTO_NUMBER_COUNTS);
    }
}
