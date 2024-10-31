package lotto;

import java.util.ArrayList;
import java.util.List;

public class Selling {
    private static final int PRICE = 1000;

    public void validatePrice(int purchase) {
        if(purchase%PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    public List<Lotto> purchaseLottos(int purchase){
        validatePrice(purchase);
        int lottoCount = purchase/PRICE;
        List<Lotto> lottos = new ArrayList<Lotto>(lottoCount);
        for(int i =0;i<lottoCount;i++){
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
    }
}
