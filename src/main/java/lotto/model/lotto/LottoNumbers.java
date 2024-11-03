package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.view.OutputView;

public class LottoNumbers {
    private final List<List<Integer>> lottoNumbers;

    private LottoNumbers(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(List<List<Integer>> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public void purchaseLotto(int purchaseCount, OutputView outputView) {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
            outputView.showLottoNumbers(i, lottoNumbers);
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
