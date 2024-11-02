package lotto.item.itemFactory;

import lotto.item.Item;
import lotto.item.Lotto;
import lotto.numberSelector.NumberSelector;

public class LottoFactory implements ItemFactory<Lotto> {

    private final NumberSelector selector;

    public LottoFactory(NumberSelector selector) {
        this.selector = selector;
    }

    @Override
    public Lotto createItem() {
        return new Lotto(selector.selectNumbers());
    }
}
