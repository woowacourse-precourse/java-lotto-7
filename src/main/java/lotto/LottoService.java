package lotto;

import lotto.enums.OutputMessage;
import lotto.model.Lotto;
import lotto.model.Money;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    public Lotto[] LottoIssuer(Money money) {
        int lottoCount = money.getPurchaseAmount() / 1000;
        System.out.println("\n" + lottoCount + OutputMessage.NOTICE_PURCHASE_COUNT.getMessage());
        Lotto[] issuedLottos = new Lotto[lottoCount];

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            issuedLottos[i] = new Lotto(numbers);
        }

        return issuedLottos;
    }

    public void showLottoNumbers(Lotto[] issuedLottos) {
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
