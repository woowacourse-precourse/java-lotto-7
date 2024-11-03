package lotto.service;

import java.math.BigInteger;
import java.util.List;
import lotto.repository.LottoRepositoryImpl;

public class LottoService {

    private final LottoRepositoryImpl lottoRepository;

    public LottoService(LottoRepositoryImpl lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void generateByPurchaseAmount(BigInteger purchaseAmount) {
        //TODO: 입력한 금액을 1000원으로 나눈 만큼 생성을 호출한다
    }

    public void create(List<Integer> numbers) {
        //TODO: 생성한 로또 객체를 저장한다
    }

    public BigInteger count() {
        return lottoRepository.count();
    }

    public List<Integer> generateRandomNumbers() {
        //TODO: 중복이 없는 6개의 숫자 반환

        return null;
    }
}
