package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.model.BuyLotto;
import lotto.item.Money;

public class OutViewLotto {
    public void viewLottoList(Money money, BuyLotto buyLotto) {
        int times = money.getMoneyValue() / 1000;
        System.out.println(times + "개를 구매했습니다.");
        for (List<Integer> lot : buyLotto.getDataUserLotto()) {
            System.out.println(lot);
        }
    }
    public void ViewResultDetail(HashMap<Integer, Integer> result){
        HashMap<Integer, String> resultMap = new HashMap<>();
        resultMap.put(5000, "3개 일치 (5,000원)");
        resultMap.put(50000, "4개 일치 (50,000원)");
        resultMap.put(1500000, "5개 일치 (1,500,000원)");
        resultMap.put(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        resultMap.put(2000000000, "6개 일치 (2,000,000,000원)");

        for(int price:resultMap.keySet()){
            System.out.println(resultMap.get(price) + " - " + result.get(price) + "개");
        }
    }
    public void ViewResultPrice(float rewordRatio){
        String reword = String.format("%.1f", rewordRatio*100);
        System.out.println("총 수익률은 " + (reword) + "%입니다.");
    }
}
