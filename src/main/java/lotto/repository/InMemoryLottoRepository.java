package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class InMemoryLottoRepository implements LottoRepository{
    private final List<Lotto> lottoStore;

    private InMemoryLottoRepository() {
        lottoStore = new ArrayList<>();
    }

    private static class Holder {
        private static final InMemoryLottoRepository INSTANCE = new InMemoryLottoRepository();
    }

    public static InMemoryLottoRepository getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void generateRandomLottos(int purchaseAmount) {
        lottoStore.addAll(Lotto.buyLottos(purchaseAmount));
    }
}
