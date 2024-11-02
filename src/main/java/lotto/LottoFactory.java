package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    public static Lotto[] createLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / Application.LOTTO_PRICE;
        Lotto[] lottos = new Lotto[numberOfLottos];
        for (int i = 0; i < numberOfLottos; i++) {
            lottos[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottos;
    }
}
