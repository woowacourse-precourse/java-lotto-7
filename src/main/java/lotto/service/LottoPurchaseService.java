package lotto.service;

public class LottoPurchaseService {

    public int getPurchaseCost(int cost){
        if(cost%1000 != 0){
           throw new IllegalArgumentException("[ERROR] 구매할 금액이 1000원 단위로 나누어 떨어져야 합니다.확인 후 다시 구매금액을 입력해 주세요.");
        }
        return cost/1000;
    }


}
