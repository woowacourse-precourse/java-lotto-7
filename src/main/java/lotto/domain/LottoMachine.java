package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomPicker;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoTickets;

    public LottoMachine(int amount) {
        amountValid(amount);
        this.lottoTickets = generateLotto(amount);
    }

    private void amountValid(int amount) {
        canBuyLotto(amount);
        checkDivisible(amount);
    }

    private void canBuyLotto(int amount) {
        if (!(amount >= LOTTO_PRICE)) {
            throw new IllegalArgumentException("canBuyLotto");
        }
    }

    private void checkDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Lotto> generateLotto(int amount) {
        lottoTickets = new ArrayList<>();

        int createLotto = amount / LOTTO_PRICE;
        for (int i = 0; i < createLotto; i++) {
            Lotto lotto = new Lotto(RandomPicker.getRandomNumbers());
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }
}
