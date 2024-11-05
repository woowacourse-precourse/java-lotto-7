package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.constant.MatchMessage;
import lotto.model.BuyLotto;
import lotto.item.Money;

public class OutputViewLotto {
    public void viewLottoList(Money money, BuyLotto buyLotto) {
        int times = money.getMoneyValue() / 1000;
        System.out.println(times + "개를 구매했습니다.");
        for (List<Integer> lot : buyLotto.getDataUserLotto()) {
            System.out.println(lot);
        }
    }
    public void ViewResultDetail(HashMap<Integer, Integer> result){
        HashMap<Integer, String> resultMap = new HashMap<>();
        resultMap.put(5000, MatchMessage.MessageThree.getMessage());
        resultMap.put(50000, MatchMessage.MessageFour.getMessage());
        resultMap.put(1500000, MatchMessage.MessageFive.getMessage());
        resultMap.put(30000000, MatchMessage.MessageFiveWithAddition.getMessage());
        resultMap.put(2000000000, MatchMessage.MessageSix.getMessage());

        for(int price:resultMap.keySet()){
            System.out.println(resultMap.get(price) + " - " + result.get(price) + "개");
        }
    }
    public void ViewResultPrice(float rewordRatio){
        String reword = String.format("%.1f", rewordRatio*100);
        System.out.println("총 수익률은 " + (reword) + "%입니다.");
    }
}
