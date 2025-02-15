package lotto.purchase;

import lotto.domain.Lotto;
import lotto.service.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchase {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public LottoPurchase(int numberOfLottos) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int i = 0; i < numberOfLottos; i++) {
            purchasedLottos.add(new Lotto(lottoGenerator.getLottoGeneratorNumbers()));
        }
    }

    public void printLottos() {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getLottoNums());
            Collections.sort(numbers);
            System.out.println(lotto.getLottoNums());
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

}
