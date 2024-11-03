package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.OutputView.printEachLotto;

public class LottoGenerator {
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoGenerator(int amount) {
        generateLottos(amount);
        printLottos(lottos);
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printEachLotto(lotto);
        }
    }

    private void generateLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Lotto.generateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
