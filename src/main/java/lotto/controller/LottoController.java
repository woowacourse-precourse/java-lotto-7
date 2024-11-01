package lotto.controller;

import lotto.validation.ErrorMessage;
import lotto.model.LottoModel;
import lotto.validation.Validator;
import lotto.view.LottoView;

import java.util.*;

public class LottoController {
    private final LottoModel lottoModel = new LottoModel();
    private final LottoView lottoView = new LottoView();


    public void start() {
        int lottoCount = getLottoCount();
        lottoView.output.lottoCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottoModel.makeRandomLottoNumbers();
            lottoView.output.lottoNumber(lottoModel.getLottoNumbers(i));
        }

        List<Integer> winningNumber = getWinningNumber();

        int bonusNumber = getBonusNumber(winningNumber);

        //당첨 로직 구현
        int[] ans = new int[5];
        for (int i = 0; i < lottoCount; i++) {
            int total = 0;
            for (Integer winVal : winningNumber) {
                if (lottoModel.getLottoNumbers(i).contains(winVal)) {
                    total++;
                }
            }
            if (total == 3) {
                ans[0]++;
            }
            if (total == 4) {
                ans[1]++;
            }
            if (total == 5) {
                if (lottoModel.getLottoNumbers(i).contains(bonusNumber)) {
                    ans[3]++;
                    continue;
                }
                ans[2]++;
            }
            if (total == 6) {
                ans[4]++;
            }
        }

        lottoView.output.winningResult(ans, getRate(lottoCount, ans));
    }

    private static double getRate(int lottoCount, int[] ans) {
        int price = lottoCount * 1000;
        long sum = 0;
        sum = ans[0] * 5000L + ans[1] * 50000L + ans[2] * 1500000L
                + ans[3] * 30000000L + ans[4] * 2000000000L;
        double rate = ((double)sum / price) * 100;
        return rate;
    }

    int getLottoCount() {
        while (true) {
            try {
                return Validator.validateLottoCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    List<Integer> getWinningNumber() {
        while (true) {
            try {
                String[] inputWinningNumber = lottoView.input.winningNumber().split(",");
                return Validator.validateWinningNumber(inputWinningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                return Validator.validateBonusNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
