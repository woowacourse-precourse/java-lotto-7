package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public List<Lotto> lottos = new ArrayList<>();
    LottoGameValidator lottoGameValidate = new LottoGameValidator();

    int amount;
    int lottoQuantity;

    public void inputAmount() {
        // 로또 구매액 설정
        this.amount = lottoGameValidate.readAmount(LOTTO_PRICE);
        this.lottoQuantity = amount / LOTTO_PRICE;
    }

    public void buyLotto() {
        // 로또 구매
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> ref = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(ref); // 오름차순 정렬
            Lotto lotto = new Lotto(ref);
            lottos.add(lotto);
        }
    }

}