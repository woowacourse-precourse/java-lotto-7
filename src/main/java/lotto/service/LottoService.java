package lotto.service;

import static lotto.constant.LottoStatic.LOTTO_END_NUMBER;
import static lotto.constant.LottoStatic.LOTTO_NUMBER_COUNTS;
import static lotto.constant.LottoStatic.LOTTO_START_NUMBER;
import static lotto.constant.LottoStatic.PURCHASE_AMOUNT_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.repository.LottoRepositoryImpl;
import store.service.StoreService;

public class LottoService {

    private final StoreService storeService;
    private final LottoRepositoryImpl lottoRepository;

    public LottoService(StoreService storeService, LottoRepositoryImpl lottoRepository) {
        this.storeService = storeService;
        this.lottoRepository = lottoRepository;
    }

    public void generateByPurchaseAmount(BigInteger purchaseAmount) {
        BigInteger count = purchaseAmount.divide(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT));

        for (BigInteger i = BigInteger.ZERO; i.compareTo(count) < 0; i = i.add(BigInteger.ONE)) {
            create(sortingNumbers(generateRandomNumbers()));
        }
    }

    public void create(List<Integer> numbers) {
        lottoRepository.save(new Lotto(numbers));
    }

    public BigInteger count() {
        return lottoRepository.count();
    }

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNTS);
    }

    public List<Lotto> getAll() {
        return lottoRepository.findAll();
    }

    //TODO: 1. 정렬하는거 까지 여기에 둬야하나? 2. 생성과 정렬을 같이 하면 별로일까? => TREE SET
    private List<Integer> sortingNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public Map<String, Integer> requestCheckLottoResult() {
        //TODO: 본인이 가진 로또 전부를 가지고 상점에게 당첨 결과 조회를 요청한다.
    }
}
