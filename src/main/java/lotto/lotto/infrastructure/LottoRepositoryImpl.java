package lotto.lotto.infrastructure;

import static lotto.common.exception.ExceptionName.REPOSITORY_ID_NULL;
import static lotto.common.exception.ExceptionName.REPOSITORY_NOT_FOUND;
import static lotto.common.exception.ExceptionName.REPOSITORY_VALUE_NULL;

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
        if (lottoResults == null) {
            throw new IllegalArgumentException(REPOSITORY_VALUE_NULL);
        }
        if (lottoResults.getId() == null) {
            throw new IllegalArgumentException(REPOSITORY_ID_NULL);
        }
        lottoResultsMap.put(lottoResults.getId(), lottoResults);
        return lottoResults;
    }

    @Override
    public LottoResults findById(String id) {
        try {
            return Optional.ofNullable(lottoResultsMap.get(id))
                    .orElseThrow(() -> new IllegalArgumentException(REPOSITORY_NOT_FOUND));
        } catch (NullPointerException e) {
            throw new IllegalStateException(REPOSITORY_ID_NULL);
        }
    }

}
