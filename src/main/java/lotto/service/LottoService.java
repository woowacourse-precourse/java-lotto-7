package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoVendor;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import lotto.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> issueLotto(int amount) {
        LottoVendor lottoVendor = new LottoVendor();
        return lottoVendor.issue(amount);
    }
    public Result runLottoGame(List<Integer> numbers,int bonusNumber,List<Lotto> issued) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(numbers)),bonusNumber);
        List<Ranking> winningRanks = winningLotto.getWinningResult(issued);
        return new Result(winningRanks);
    }

}
