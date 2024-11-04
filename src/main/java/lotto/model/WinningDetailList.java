package lotto.model;

import static lotto.constants.NumberConstants.GET_3;
import static lotto.constants.NumberConstants.GET_4;
import static lotto.constants.NumberConstants.GET_5;
import static lotto.constants.NumberConstants.GET_6;

import java.util.ArrayList;
import java.util.List;

public class WinningDetailList {

    private final List<WinningPriceStore> priceStoreList;

    public WinningDetailList() {
        this.priceStoreList = new ArrayList<>();
        priceStoreList.add(new WinningPriceStore(GET_3, false));
        priceStoreList.add(new WinningPriceStore(GET_4, false));
        priceStoreList.add(new WinningPriceStore(GET_5, false));
        priceStoreList.add(new WinningPriceStore(GET_5, true));
        priceStoreList.add(new WinningPriceStore(GET_6, false));
    }

    public List<WinningPriceStore> getPriceStoreList() {
        return this.priceStoreList;
    }

    public WinningPriceStore getPriceStore(int numberMatchCount, boolean isBonus) {
        if (numberMatchCount == GET_3) {
            return this.priceStoreList.get(0);
        }
        if (numberMatchCount == GET_4) {
            return this.priceStoreList.get(1);
        }
        if (numberMatchCount == GET_5 && isBonus) {
            return this.priceStoreList.get(3);
        }
        if (numberMatchCount == GET_5) {
            return this.priceStoreList.get(2);
        }
        if (numberMatchCount == GET_6) {
            return this.priceStoreList.get(4);
        }
        return null;
    }

    public void addSuccessLotto(int numberMatchCount, boolean isBonus) {
        WinningPriceStore winningPriceStore = getPriceStore(numberMatchCount, isBonus);
        winningPriceStore.addMatchLotto();
    }
}
