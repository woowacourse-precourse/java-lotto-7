package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.SoldLotto;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;

import java.util.List;

public class LottoService {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final SoldLotto soldLotto;
    private final WinningLotto winningLotto;

    public LottoService(SoldLotto soldLotto, WinningLotto winningLotto){
        this.soldLotto = soldLotto;
        this.winningLotto = winningLotto;
    }

    public String buyLotto(int lottoCount) {
        for (int index = 0; index < lottoCount; index++) {
            soldLotto.addLottoSold(Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER_COUNT).stream().sorted().toList());
        }

        return soldLotto.getLottoDetails().toString();
    }

    public void saveWinningNumbers(List<Integer> winningNumbers){
        winningLotto.addWinningLotto(winningNumbers);
    }

    public void validateBonusNumber(int bonusNumber){
        winningLotto.validateBonusNumber(bonusNumber, MAX_NUM, MIN_NUM);
    }

    public List<Integer> winningResult(){
        WinningResult winningResult = new WinningResult();
        winningResult.calculateResult(soldLotto.getSoldLotto(), winningLotto.getWinningLotto(), winningLotto.getBonusNumber());
        return null;
    }
}
