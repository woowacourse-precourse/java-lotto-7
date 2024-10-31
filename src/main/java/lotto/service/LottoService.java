package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class LottoService {

    public LottoService() {
    }

    public Lottos buyLottos(long userInputMoney) {
        InputMoney inputMoney = new InputMoney(userInputMoney);
        long buyAmount = inputMoney.getBuyAmount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<buyAmount;i++) {
            List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randoms);
            Lotto lotto = new Lotto(randoms);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public void findAnswer(WinningNumbers winningNumbers, BonusNumber bonusNumber) {

    }
}
