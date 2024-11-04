package lotto.service;

import lotto.model.LottoModel;
import lotto.validation.Constant;

import java.math.BigDecimal;
import java.util.List;

public class LottoService {
    private final LottoModel lottoModel;

    public LottoService(LottoModel lottoModel) {
        this.lottoModel = lottoModel;
    }

    public void generateLottos(int lottoCount) {
        lottoModel.generateLottos(lottoCount);
    }

    public void winningCount(List<Integer> winningNumber, int index, int[] winningCount, int bonusNumber) {
        int total = 0;
        List<Integer> lottoNumbers = lottoModel.getLottoNumbers(index);

        for (Integer winVal : winningNumber) {
            if (lottoNumbers.contains(winVal)) total++;
        }
        updateWinningCount(winningCount, bonusNumber, total, lottoNumbers);
    }

    private static void updateWinningCount(int[] winningCount, int bonusNumber, int total, List<Integer> lottoNumbers) {
        if (total == 3) winningCount[Constant.WIN_THREE]++;
        if (total == 4) winningCount[Constant.WIN_FOUR]++;
        if (total == 5 && lottoNumbers.contains(bonusNumber)) winningCount[Constant.WIN_FIVE_BONUS]++;
        if (total == 5) winningCount[Constant.WIN_FIVE]++;
        if (total == 6) winningCount[Constant.WIN_SIX]++;
    }

    public double getRate(int lottoCount, int[] winningCount) {
        int price = lottoCount * Constant.LOTTO_PRICE;
        long sum = winningCount[Constant.WIN_THREE] * 5000L + winningCount[Constant.WIN_FOUR] * 50000L
                + winningCount[Constant.WIN_FIVE] * 1500000L + winningCount[Constant.WIN_FIVE_BONUS] * 30000000L
                + winningCount[Constant.WIN_SIX] * 2000000000L;

        return ((double) sum / price) * 100;
    }
}
