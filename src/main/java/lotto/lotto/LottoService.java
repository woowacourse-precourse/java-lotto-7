package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.io.input.Input;
import lotto.random.Random;

public class LottoService {

    private final Random random;

    public LottoService(Random random) {
        this.random = random;
    }

    public List<Lotto> purchaseLottoWithAmount(int price) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < getLottoCount(price); i++) {
            List<Integer> randomNumbers = random.pickUniqueNumbersInRange();
            lottos.add(new Lotto(randomNumbers));
        }

        return lottos;
    }

    private int getLottoCount(int price) {
        return price / 1000;
    }

    public Lotto issueWinningNumbers() {
        List<Integer> winningNumbersInput = Input.getWinningNumbersInput();

        return new Lotto(winningNumbersInput);
    }
}
