package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class InMemoryLottoRepository implements LottoRepository {

    // 상수 & 클래스 변수
    private final List<Lotto> repository = new ArrayList<>();
    private static final InMemoryLottoRepository instance = new InMemoryLottoRepository();

    // 생성자
    private InMemoryLottoRepository() {

    }

    // 메서드
    public static InMemoryLottoRepository getInstance() {
        return instance;
    }

    @Override
    public void save(Lotto lotto) {
        repository.add(lotto);
    }

    @Override
    public List<Lotto> findAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public void deleteAll() {
        repository.clear();
    }

    @Override
    public int count() {
        return repository.size();
    }
}
