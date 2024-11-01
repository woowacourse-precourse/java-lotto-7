package lotto.service;

import lotto.model.LottoModel;

import java.util.List;

public class LottoService {
    private final LottoModel lottoModel;

    public LottoService(LottoModel lottoModel) {
        this.lottoModel = lottoModel;
    }

    public void generateLottos(int lottoCount) {
        lottoModel.generateLottos(lottoCount);
    }

    public void winningCount(List<Integer> winningNumber, int i, int[] ans, int bonusNumber) {
        int total = 0;
        for (Integer winVal : winningNumber) {
            if (lottoModel.getLottoNumbers(i).contains(winVal)) {
                total++;
            }
        }
        if (total == 3) ans[0]++;
        if (total == 4) ans[1]++;
        if (total == 5) {
            if (lottoModel.getLottoNumbers(i).contains(bonusNumber)) {
                ans[3]++;
                return;
            }
            ans[2]++;
        }
        if (total == 6) ans[4]++;
    }

    public double getRate(int lottoCount, int[] ans) {
        int price = lottoCount * 1000;
        long sum = 0;
        sum = ans[0] * 5000L + ans[1] * 50000L + ans[2] * 1500000L
                + ans[3] * 30000000L + ans[4] * 2000000000L;
        double rate = ((double)sum / price) * 100;
        return rate;
    }
}
