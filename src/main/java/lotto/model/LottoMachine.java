package lotto.model;

import static lotto.utils.ErrorMessage.CAN_BUY;
import static lotto.utils.ErrorMessage.INVALID_MONEY;

import java.util.ArrayList;
import java.util.Collections;
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
        canBuy(amount);
        checkDivisible(amount);
    }

    private void canBuy(int amount) {
        if (!(amount >= LOTTO_PRICE)) {
            throw new IllegalArgumentException(CAN_BUY);
        }
    }

    private void checkDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }

    private List<Lotto> generateLotto(int amount) {
        lottoTickets = new ArrayList<>();

        int createLotto = amount / LOTTO_PRICE;
        for (int i = 0; i < createLotto; i++) {
            Lotto lotto = new Lotto(sort(RandomPicker.getRandomNumbers()));
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

    public int getLottoTicketSize() {
        return lottoTickets.size();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
