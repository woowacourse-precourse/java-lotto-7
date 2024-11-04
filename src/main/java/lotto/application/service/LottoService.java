package lotto.application.service;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import lotto.application.model.Lotto;
import lotto.application.model.WinningRanking;

public class LottoService {

    private final LottoMachine lottoMachine;
    private final LottoAnchor lottoAnchor;

    public LottoService(LottoMachine lottoMachine, LottoAnchor lottoAnchor) {
        this.lottoMachine = lottoMachine;
        this.lottoAnchor = lottoAnchor;
    }

    public Set<Lotto> buyLotto(int amount){
        return lottoMachine.purchaseLotto(amount);
    }

    public void setWinningNumbers(List<Integer> winningNumbers){
        lottoAnchor.setWinningNumbers(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber){
        lottoAnchor.setBonusNumber(bonusNumber);
    }

    public EnumMap<WinningRanking, Integer> getResult(Collection<Lotto> lottos){
        return lottoAnchor.announce(lottos);
    }
}
