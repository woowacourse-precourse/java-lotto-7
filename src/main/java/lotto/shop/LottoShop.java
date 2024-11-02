package lotto.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.item.Item;
import lotto.item.Lotto;
import lotto.item.itemFactory.LottoFactory;
import lotto.numberSelector.NumberSelector;
import lotto.numberSelector.RandomSelector;

public class LottoShop implements Shop<Lotto>{

    Map<Class<? extends Item>, Integer> menu = new HashMap<>();
    NumberSelector selector = new RandomSelector();

    public LottoShop() {
        setItem(Lotto.class, 1000);
    }

    @Override
    public void setItem(Class<? extends Item> itemType, int price) {
        menu.put(itemType, price);
    }

    @Override
    public int getPrice(Class<? extends Item> itemType) {
        return menu.get(itemType);
    }

    @Override
    public List<Lotto> buy(Class<? extends Item> itemType, int money) {
        LottoFactory lottoFactory = new LottoFactory(selector);
        List<Lotto> items = new ArrayList<>();
        for (int i = 0; i < getQuantity(menu.get(itemType), money); i++) {
            Lotto lotto = lottoFactory.createItem();
            System.out.println(lotto);
            items.add(lotto);
        }
        return items;
    }

    private int getQuantity(int price, int money) {
        int quantity = money / price;
        System.out.println(quantity + "개를 구매했습니다.");
        return quantity;
    }

    public void setSelector(NumberSelector numberSelector) {
        selector = numberSelector;
    }


}
