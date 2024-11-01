package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static List<Lotto> generateLottos(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            lottos.add(generateLottoNumbers());
        }
        return lottos;
    }

    private static Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static int calculateMatchCount(Lotto userLotto, Lotto winningLotto) {
        int matchCount = 0;

        for (int number : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public static boolean checkBonusNumberMatch(Lotto userLotto, int bonusNumber) {
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        return userLottoNumbers.contains(bonusNumber);
    }
}
