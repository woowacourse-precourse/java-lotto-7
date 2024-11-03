package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.InputDTO;
import lotto.dto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberService {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLottos(int money) {
        int lottoCount = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(drawWinningNumbers()));
        }

        return lottos;
    }

    public List<Integer> drawWinningNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);

    }

    public int compareWithWinningNumbers(InputDTO inputDTO, Lotto lotto) {
        List<Integer> winningNumbers = inputDTO.getWinningNumbers();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        int matchCount = 0;

        for (Integer number : winningNumbers) {
            if (lottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean compareWithBonusNumber(InputDTO inputDTO, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        int bonusNumber = inputDTO.getBonusNumber();

        return lottoNumbers.contains(bonusNumber);
    }


    public int calculateWinningsInt(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return 2000000000; // 1등
        } else if (matchCount == 5 && hasBonus) {
            return 30000000; // 2등
        } else if (matchCount == 5) {
            return 1500000; // 3등
        } else if (matchCount == 4) {
            return 50000; // 4등
        } else if (matchCount == 3) {
            return 5000; // 5등
        }
        return 0; // 당첨되지 않음
    }
    public double calculateProfitRate(InputDTO inputDTO, List<Lotto> purchasedLottos, int totalInvestment) {
        int totalProfit = 0;

        for (Lotto lotto : purchasedLottos) {
            int matchCount = compareWithWinningNumbers(inputDTO, lotto);
            boolean hasBonus = compareWithBonusNumber(inputDTO, lotto);

            totalProfit += calculateWinningsInt(matchCount, hasBonus);
        }

        // 수익률 계산: (총 수익 / 투자 금액) * 100
        return ((double) totalProfit / totalInvestment) * 100;
    }
}
