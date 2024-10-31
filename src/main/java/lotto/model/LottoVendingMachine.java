package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.GameException;
import lotto.provider.NumbersProvider;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.model.LottoOption.*;

public class LottoVendingMachine {

    private final int cost;

    public LottoVendingMachine(int cost) {
        validate(cost);
        this.cost = cost;
    }

    public List<Lotto> purchaseAll(NumbersProvider numbersProvider) {
        return IntStream.range(0, getAvailableQuantity())
            .mapToObj(i -> new Lotto(numbersProvider.getNumbers()))
            .toList();
    }

    public int getAvailableQuantity() {
        return cost / SALE_PRICE.value();
    }

    private void validate(int cost) {
        if (cost < SALE_PRICE.value()) {
            throw new GameException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
        if (hasRemain(cost)) {
            throw new GameException(ErrorMessage.INVALID_MONEY_UNIT);
        }
    }

    private boolean hasRemain(int cost) {
        return cost % SALE_PRICE.value() != 0;
    }

}
