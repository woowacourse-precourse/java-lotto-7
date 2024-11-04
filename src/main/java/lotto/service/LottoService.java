package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class LottoService {

    public LottoService() {
    }

    public Lottos buyLottos(InputMoney inputMoney) {
        long buyAmount = inputMoney.getBuyAmount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<buyAmount;i++) {
            Lotto newLotto = Lotto.create();
            lottos.add(newLotto);
        }
        return Lottos.create(lottos);
    }

    public LottoResult findAnswer(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber,InputMoney inputMoney) {
        long buyAmount = inputMoney.getBuyAmount();
        long totalEarning = 0;
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for(int i=0;i<buyAmount;i++){
            Lotto lotto = lottos.getElement(i);
            int matchCount = winningNumbers.countMatchingNumbers(lotto);
            boolean containBonus = lotto.containBonusNumber(bonusNumber);
            LottoPrize lottoPrize = LottoPrize.valueOf(matchCount,containBonus);
            if(lottoPrize == LottoPrize.NONE) {
                continue;
            }
            lottoPrizes.add(lottoPrize);
            totalEarning += lottoPrize.getPrize();
        }
        return LottoResult.of(lottoPrizes,totalEarning,inputMoney);
    }
}
