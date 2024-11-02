package lotto.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.PublishLotto;

public class PublishLottoRepository {

    private static final PublishLottoRepository INSTANCE = new PublishLottoRepository();
    private final Set<PublishLotto> publishedLottos;

    private PublishLottoRepository() {
        this.publishedLottos = new HashSet<>();
    }

    public static PublishLottoRepository getInstance() {
        return INSTANCE;
    }

    public void save(PublishLotto publishLotto) {
        publishedLottos.add(publishLotto);
    }

    public List<PublishLotto> findAll() {
        return new ArrayList<>(publishedLottos);
    }

    public void clear() {
        publishedLottos.clear();
    }
}
