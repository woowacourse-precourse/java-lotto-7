package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public final int lottoCount;
    public final List<Lotto> totalLotto = new ArrayList<>();
    public LottoGenerator(int amount) {
        validateAmount(amount);
        lottoCount = amount / 1000;
    }
    private void validateAmount(int amount){
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }
    private Lotto generateLotto() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45,6));
        randomNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomNumbers);
    }
    public List<Lotto> generateTotalLotto() {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            totalLotto.add(lotto);
        }
        return totalLotto;
    }
}
