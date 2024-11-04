package lotto.model;

import lotto.exception.GameException;
import lotto.provider.NumbersProvider;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.exception.ErrorMessage.INVALID_MONEY_UNIT;
import static lotto.exception.ErrorMessage.NOT_ENOUGH_MONEY;
import static lotto.model.LottoOption.SALE_PRICE;

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

    private void validate(int cost) {
        if (cost < SALE_PRICE.value()) {
            throw new GameException(NOT_ENOUGH_MONEY);
        }
        if (hasRemain(cost)) {
            throw new GameException(INVALID_MONEY_UNIT);
        }
    }

    private int getAvailableQuantity() {
        return cost / SALE_PRICE.value();
    }

    private boolean hasRemain(int cost) {
        return cost % SALE_PRICE.value() != 0;
    }

}
