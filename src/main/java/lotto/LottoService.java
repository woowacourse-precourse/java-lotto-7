package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static List<Lotto> createLottos(int inputPrice) {
        int totalLottoCount = inputPrice / 1000;
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < totalLottoCount; i++) {
            List<Integer> lottoNumbers = generator.generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public static int[] calculateMatchCounts(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[7];

        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int matchCount = lotto.matchCount(winningNumbers);
            updateMatchCounts(matchCounts, matchCount, lotto.hasBonusNumber(bonusNumber));
        }
        return matchCounts;
    }

    private static void updateMatchCounts(int[] matchCounts, int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            matchCounts[6]++;
            return;
        }
        if (matchCount == 5) {
            if (hasBonus) {
                matchCounts[5]++;
            } else {
                matchCounts[4]++;
            }
            return;
        }
        if (matchCount >= 3) {
            matchCounts[matchCount - 1]++;
        }
    }
}
