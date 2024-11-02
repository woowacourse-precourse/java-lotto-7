package lotto.item.itemFactory;

import lotto.item.Item;

public interface ItemFactory<T extends Item> {
    T createItem();
}
