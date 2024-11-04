package lotto.lotto.infrastructure;

import static lotto.common.exception.ExceptionName.REPOSITORY_ID_NULL;
import static lotto.common.exception.ExceptionName.REPOSITORY_NOT_FOUND;
import static lotto.common.exception.ExceptionName.REPOSITORY_VALUE_NULL;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.service.port.LottoRepository;

public class FakeLottoRepository implements LottoRepository {

    private final Map<String, LottoResults> fakeLottoCache;

    public FakeLottoRepository() {
        this.fakeLottoCache = new ConcurrentHashMap<>();
    }

    @Override
    public LottoResults findById(String id) {
        try {
            return Optional.ofNullable(fakeLottoCache.get(id))
                    .orElseThrow(() -> new IllegalArgumentException(REPOSITORY_NOT_FOUND));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(REPOSITORY_ID_NULL);
        }
    }

    @Override
    public LottoResults save(LottoResults results) {
        if (results == null) {
            throw new IllegalArgumentException(REPOSITORY_VALUE_NULL);
        }
        if (results.getId() == null) {
            throw new IllegalArgumentException(REPOSITORY_ID_NULL);
        }
        fakeLottoCache.put(results.getId(), results);
        return results;
    }
}
