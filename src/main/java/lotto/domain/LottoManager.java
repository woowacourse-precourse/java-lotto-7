package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;


    private static Lotto createLotto() {
        List<Integer> numbers = pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        return new Lotto(sortedNumbers);
    }

    public static ArrayList<Lotto> createLottos(int money) {
        int lottoCount = money / LOTTO_PRICE;
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public static LottoPrize matchLotto(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = winningLotto.matchCount(lotto);
        boolean matchBonus = lotto.contains(winningLotto.getBonusNumber());

        return LottoPrize.valueOf(matchCount, matchBonus);
    }

    public static List<LottoPrize> matchLottos(WinningLotto winningLotto, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> matchLotto(winningLotto, lotto))
                .toList();
    }

    public static Float calculateProfit(List<LottoPrize> prizes, int money) {
        int totalPrize = prizes.stream()
                .mapToInt(LottoPrize::getPrize)
                .sum();

        return (float) totalPrize / money * 100;
    }
}
