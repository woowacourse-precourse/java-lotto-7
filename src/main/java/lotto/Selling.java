package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Selling {
    private static final int PRICE = 1000;

    public void validatePrice(int purchase) {
        if(purchase%PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    public Lotto[] purchaseLottos(int purchase){
        validatePrice(purchase);
        int lottoCount = purchase/PRICE;
        Lotto[] lottos = new Lotto[lottoCount];
        for(int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottos[i] = new Lotto(numbers);
        }
        return lottos;
    }
}
