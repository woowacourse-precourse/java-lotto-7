package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

import static lotto.domain.PurchasePrice.LOTTO_PRICE;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.SIZE_OF_LOTTO;

public class LottoGenerator {
    List<Lotto> generatedLottoNumbers = new ArrayList<>();

    public List<Lotto> generate(PurchasePrice purchasePrice) {
        int numberOfLotto = purchasePrice.getPurchasePrice() / LOTTO_PRICE;
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        // 난수 생성
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumbers =
                    Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, SIZE_OF_LOTTO);

            try {
                Lotto lotto = new Lotto(lottoNumbers);
                generatedLottoNumbers.add(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }

        return generatedLottoNumbers; // 생성된 로또 리스트
    }
}
