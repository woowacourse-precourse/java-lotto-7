package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final int START_INDEX = 1;
    private final int END_INDEX = 45;
    private final int NUMBER_OF_DRAW = 6;
    private final int WON = 1000;

    public List<Lotto> sellLotto(Integer money) {
        int purchaseQuantity = moneyToQuantity(money);
        return generateLottos(purchaseQuantity);
    }

    private List<Lotto> generateLottos(int quantity) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto =new Lotto(Randoms.pickUniqueNumbersInRange(START_INDEX, END_INDEX, NUMBER_OF_DRAW));
            System.out.println(lotto.getIssuedLottoNumbers());
            issuedLottos.add(lotto);
        }
        return issuedLottos;
    }

    private Integer moneyToQuantity(Integer money) {
        if (money % WON != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1,000원 단위여야 합니다.");
        }
        return money / WON;
    }
}
