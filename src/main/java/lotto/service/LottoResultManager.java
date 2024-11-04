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

    public int compareLottoNumber(List<Integer> lotto, Lotto winningLotto, int bonusNumber) {
        int matches = 0;
        boolean checkBonusNumber = false;
        for (Integer integer : lotto) {
            if (winningLotto.getNumbers().contains(integer)) matches++;
        }
        if(lotto.contains(bonusNumber)) checkBonusNumber = true;
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

}
