package lotto.service;

import lotto.model.LottoModel;
import lotto.validation.Constant;

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
        for (Integer winVal : winningNumber) {
            if (lottoModel.getLottoNumbers(index).contains(winVal)) total++;
        }

        if (total == 3) winningCount[Constant.WIN_THREE]++;
        if (total == 4) winningCount[Constant.WIN_FOUR]++;
        if (total == 5) {
            if (lottoModel.getLottoNumbers(index).contains(bonusNumber)) {
                winningCount[Constant.WIN_FIVE_BONUS]++;
                return;
            }
            winningCount[Constant.WIN_FIVE]++;
        }
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
