package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.PublishLotto;

public class PublishLottoRepository {

    private static final PublishLottoRepository INSTANCE = new PublishLottoRepository();
    private final List<PublishLotto> publishedLottos;

    private PublishLottoRepository() {
        this.publishedLottos = new ArrayList<>();
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

}
