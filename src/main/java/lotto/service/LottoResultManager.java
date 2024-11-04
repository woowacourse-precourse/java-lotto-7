package lotto.service;

import lotto.exception.InputValidation;
import lotto.exception.ValidateValues;
import lotto.model.Lotto;
import lotto.model.LottoWinningResult;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LottoResultManager {

    public Lotto getWinningNumbers() {
        String inputWinningNumbers = InputView.getWinningNumbers();
        List<Integer> winningNumbers = new ArrayList<>();

        if(InputValidation.NOT_BLANK.validate(inputWinningNumbers)){
            StringTokenizer tokenizer = new StringTokenizer(inputWinningNumbers,",");
            while(tokenizer.hasMoreTokens()){
                String winnerNumber = tokenizer.nextToken();
                if(ValidateValues.winningNumberOrBonusNumber(winnerNumber)){
                    winningNumbers.add(Integer.parseInt(winnerNumber));
                }
            }
        }
        return new Lotto(winningNumbers);
    }

    public int getBonusNumbers() {
        String inputBonusNumber = InputView.getBonusNumbers();
        int bonusNumber = 0;
        if(InputValidation.NOT_BLANK.validate(inputBonusNumber)){
            if(ValidateValues.winningNumberOrBonusNumber(inputBonusNumber)){
                bonusNumber = Integer.parseInt(inputBonusNumber);
            }
        }
        return bonusNumber;
    }

    public int compareLottoNumber(List<Integer> lotto, Lotto winningLotto, int bonusNumber) {
        int matches = 0;
        boolean checkBonusNumber = false;
        for (Integer integer : lotto) {
            if (winningLotto.getNumbers().contains(integer)) {
                matches++;
            }
        }
        if(lotto.contains(bonusNumber)){
            checkBonusNumber = true;
        }
        int result = 0;
        if(matches == 3) result = 1;
        if(matches == 4) result = 2;
        if(matches == 5 && !checkBonusNumber) result = 3;
        if(matches == 5 && checkBonusNumber) result = 4;
        if(matches == 6) result = 5;

        return result;
    }

    public int[] saveLottoWinningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int result = 0;
        int[] saveResult = new int[5];
        for (Lotto lotto : lottos) {
            result = compareLottoNumber(lotto.getNumbers(), winningLotto, bonusNumber);
            if (result == 0) continue;
            if (result == 1) saveResult[0]++;
            if (result == 2) saveResult[1]++;
            if (result == 3) saveResult[2]++;
            if (result == 4) saveResult[3]++;
            if (result == 5) saveResult[4]++;
        }
        return saveResult;
    }

    public void printResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] saveResult = saveLottoWinningResult(lottos, winningLotto, bonusNumber);
        System.out.println(LottoWinningResult.THREE_MATCHES.print(saveResult[0]));
        System.out.println(LottoWinningResult.FOUR_MATCHES.print(saveResult[1]));
        System.out.println(LottoWinningResult.FIVE_MATCHES.print(saveResult[2]));
        System.out.println(LottoWinningResult.FIVE_AND_BONUS_MATCHES.print(saveResult[3]));
        System.out.println(LottoWinningResult.SIX_MATCHES.print(saveResult[4]));
    }

    public void printProfitRate(List<Lotto> lottos, Lotto winningLotto, int bonusNumber, int purchaseAmount) {
        int[] saveResult = saveLottoWinningResult(lottos, winningLotto, bonusNumber);
        int profit = 0;
        profit += saveResult[0] * LottoWinningResult.THREE_MATCHES.getAmount();
        profit += saveResult[1] * LottoWinningResult.FOUR_MATCHES.getAmount();
        profit += saveResult[2] * LottoWinningResult.FIVE_MATCHES.getAmount();
        profit += saveResult[3] * LottoWinningResult.FIVE_AND_BONUS_MATCHES.getAmount();
        profit += saveResult[4] * LottoWinningResult.SIX_MATCHES.getAmount();

        double profitRate = (double) profit / purchaseAmount *100;
        System.out.println("총 수익률은 " + Math.round(profitRate*10)/10.0 + "%입니다.");
    }

}
