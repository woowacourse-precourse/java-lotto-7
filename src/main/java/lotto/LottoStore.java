package lotto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LottoStore {

    private final int purchasePrice;
    private final int LOTTO_PRICE = 1000;

    public LottoStore(int purchaseAmount) {
        this.purchasePrice = purchaseAmount;
    }


    public int getNumberOfLotto() {
        return purchasePrice / LOTTO_PRICE;
    }


    
}
