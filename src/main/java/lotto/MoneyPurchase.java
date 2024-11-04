package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MoneyPurchase {
    final int lotoPrice = 1000;
    private int money;

    public MoneyPurchase(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자 형식이 아닙니다.");
        }

        this.money = Integer.parseInt(inputMoney);
    }

    private boolean isMinumPrice() {
        if (money < lotoPrice) {
            return false;
        }
        return true;
    }

    private boolean isAmountValid() {
        if (money % lotoPrice != 0) {
            return false;
        }
        return true;
    }

    public int getLotoCount() {
        int lotoCount;
        // 음수 + 1000원 보다 작은 값 입력 시 오류 발생
        if (!isMinumPrice()) {
            throw new IllegalArgumentException("[ERROR] 1000원 이하의 금액 입니다.");
            // 1,000원 이하의 단위 처림
        }
        if (!isAmountValid()) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력하세요.");
        }

        lotoCount = money / lotoPrice;
        System.out.println(lotoCount + "개를 구입했습니다.");
        return lotoCount;
    }
//    public ArrayList<List> getlotoProduct(int count) {
//        ArrayList<List> buyLoto = new ArrayList<>();
//
//        for (int i = 0; i < count ; i++) {
//            List<Integer> lotoProduct = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            buyLoto.add(lotoProduct);
//
//        }
//
//        return buyLoto;
//    }
//
}
