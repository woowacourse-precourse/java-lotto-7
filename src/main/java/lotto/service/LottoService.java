package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.enums.Prize;

import java.util.*;

import static lotto.service.ConverterService.convertLottoResultDtoToPrize;

public class LottoService {

    public List<Lotto> generateLottoNumbers(int purchaseAmount) {
        List<Lotto> generatedLotto = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> generatedLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(generatedLottoNumber);
            generatedLotto.add(new Lotto(generatedLottoNumber));
        }
        return generatedLotto;
    }

    public Map<Prize, Integer> calculateMathLotto(int[] winningNumbers, int bonusNumber, List<Lotto> lottos) {
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        Map<Prize, Integer> prizeCount = new HashMap<>();

        for (Lotto lotto : lottos) {
            Prize prize = convertLottoResultDtoToPrize(lotto.countNumberOfWinnings(winningNumber));
            if (prize.getPrizeMoney() == 0) {
                continue;
            }
            prizeCount.putIfAbsent(prize, 0);
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }

        return prizeCount;
    }

    public long calculatePrizeMoney(Map<Prize, Integer> prizeCount) {
        long prizeMoney = 0L;
        for (Prize prize : prizeCount.keySet()) {
            prizeMoney += (long) prize.getPrizeMoney() * prizeCount.get(prize);
        }
        return prizeMoney;
    }
}
