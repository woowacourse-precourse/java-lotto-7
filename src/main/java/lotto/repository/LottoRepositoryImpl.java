package lotto.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoRepositoryImpl implements LottoRepository {

    private List<Lotto> storage = new ArrayList<>();

    @Override
    public void create(List<Integer> numbers) {
        //TODO: 로또를 생성하는 메서드
    }

    @Override
    public void save(Lotto lotto) {
        //TODO: 로또를 저장소에 저장하는 메서드
    }

    @Override
    public BigInteger count() {
        //FIXME: storage.size의 반환 값이 int인 것에 대해
        return BigInteger.valueOf(storage.size());
    }
}
