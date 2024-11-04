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

    public Lotto[] purchaseLottos(int amount) {
        validatePrice(amount);
        int lottoCount = amount / PRICE;
        Lotto[] lottos = new Lotto[lottoCount];
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = genetateLottoNumbers();
            lottos[i] = new Lotto(numbers);
        }
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        return lottos;
    }
    private List<Integer> genetateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
