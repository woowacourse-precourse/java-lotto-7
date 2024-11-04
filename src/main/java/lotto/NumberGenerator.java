package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public int countPurchases(int price){
        if(priceCheck(price)){
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닙니다.");
        }
        return price/1000;
    }

    private static boolean priceCheck(int price){
        return price % 1000 != 0 || price < 1000;
    }

    public List<Lotto> setLottoNumber(int price) {
        int countPurchase = countPurchases(price);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < countPurchase; i++) {
            List<Integer> numberList = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numberList);
            Lotto lotto = new Lotto(numberList);
            lottoList.add(lotto);
        }
        return lottoList;
    }


}
