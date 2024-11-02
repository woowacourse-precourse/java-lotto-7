package lotto.lotto.infrastructure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.service.port.LottoRepository;

public class LottoRepositoryImpl implements LottoRepository {

    private static LottoRepository instance;
    private final Map<String, LottoResults> lottoResultsMap = new ConcurrentHashMap<>();

    private LottoRepositoryImpl() {}

    public static LottoRepository getInstance() {
        if(instance == null) {
            instance = new LottoRepositoryImpl();
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
            return lottoResultsMap.get(id);
        } catch (Exception e) {
            throw new RuntimeException("[ERROR] 해당 id 값이 존재하지 않습니다");
        }
    }

}
