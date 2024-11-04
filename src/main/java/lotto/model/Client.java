package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoGenerator;

public class Client {
    private final Budget budget;
    private final List<Lotto> lottos;

    public Client(int budget) {
        this.budget = new Budget(budget);
        this.lottos = new ArrayList<>();
    }

    public void buyLotto() {
        while (budget.buyLotto()) {
            var randomNumbers = LottoGenerator.generateLotto();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
