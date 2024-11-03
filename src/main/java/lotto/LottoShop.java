package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoShop implements Shop<Lotto>{

    private Map<Class<? extends Item>, Integer> menu = new HashMap<>();
    private NumberSelector selector = new RandomSelector();
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;
    public static final int LOTTO_SIZE = 6;

    public LottoShop() {
        setItem(Lotto.class, LOTTO_PRICE);
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
