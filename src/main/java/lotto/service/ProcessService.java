package lotto.service;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningNumber;
import lotto.service.lottoImpl.ProcessServiceImpl;

import java.util.List;
import java.util.Map;

public class ProcessService implements ProcessServiceImpl {
    private List<Integer> winningLottoNumber;
    private int winningBonusNumber;

    private int[] count(List<Integer> lotto) {
        int[] count = new int[]{0, 0};

        for (int number : lotto) {
            if (winningLottoNumber.contains(number)) {
                count[0]++;
                continue;
            }
            if (winningBonusNumber == number) {
                count[1]++;
            }
        }

        return count;
    }

    private int key(List<Integer> lotto) {
        int[] count = this.count(lotto);

        if (count[0] == 3) {
            return 5000;
        }
        if (count[0] == 4) {
            return 50000;
        }
        if (count[1] == 1 && count[0] == 5) {
            return 30000000;
        }
        if (count[0] == 5) {
            return 1500000;
        }
        if (count[0] == 6) {
            return 2000000000;
        }

        return 0;
    }

    @Override
    public Result matchNumber(List<Lotto> lottos, WinningNumber winningNumbers) {
        this.winningLottoNumber = winningNumbers.getLottoWinningNumber();
        this.winningBonusNumber = winningNumbers.getBonusNumber();

        Result result = new Result();
        for (Lotto lotto : lottos) {
            result.setResult(this.key(lotto.getNumbers()));
        }

        return result;
    }

    @Override
    public String calculateRate(int tickets, Result result) {
        Map<Integer, Integer> lottoResult = result.getLottoResult();

        double sum = 0;
        for (int key : lottoResult.keySet()) {
            sum += key * lottoResult.get(key);
        }

        return String.format("%.1f", sum / (tickets * 1000) * 100.0);
    }
}
