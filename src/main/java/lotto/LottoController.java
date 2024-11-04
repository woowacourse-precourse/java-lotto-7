package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final int purchaseAmount;
    private List<Lotto> purchasedLottos = new ArrayList<>();

    LottoController(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        createLotto();
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        if(!purchaseAmount.matches("\\d+") || Integer.parseInt(purchaseAmount)%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 숫자로 입력해야 합니다.");
        }
    }

    private void createLotto() {
        for(int i=0; i< purchaseAmount/1000; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            purchasedLottos.add(lotto);
        }
    }

}
