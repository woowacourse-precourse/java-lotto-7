package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    public List<Lotto> buyLottos(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
    public Prize checkPrize(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return Prize.valueOf(matchCount, matchBonus);
    }
}