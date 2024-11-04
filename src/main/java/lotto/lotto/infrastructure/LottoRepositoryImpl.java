package lotto.lotto.infrastructure;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.service.port.LottoRepository;

public class LottoRepositoryImpl implements LottoRepository {

    private static LottoRepository instance;
    private final Map<String, LottoResults> lottoResultsMap = new ConcurrentHashMap<>();

    private LottoRepositoryImpl() {
    }

    public static LottoRepository getInstance() {
        if (instance == null) {
            synchronized (LottoRepositoryImpl.class) {
                if (instance == null) {
                    instance = new LottoRepositoryImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public LottoResults save(LottoResults lottoResults) {
        lottoResultsMap.put(lottoResults.getId(), lottoResults);
        return lottoResults;
    }

    @Override
    public LottoResults findById(String id) {
        try {
            return Optional.ofNullable(lottoResultsMap.get(id))
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 id 값이 존재하지 않습니다."));
        } catch (NullPointerException e) {
            throw new IllegalStateException("[ERROR] id는 null이 될 수 없습니다.");
        }
    }

}
