package lotto;

public interface ItemFactory<T extends Item> {
    T createItem();
}
