package lotto.model;

import lotto.model.enums.LottoPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private final List<Boolean> winningNumberMatchFlag;
    private final boolean bonusNumberMatchFlag;

    public LottoResult(Lotto myLotto, WinningLotto winningLotto) {
        this.winningNumberMatchFlag = new ArrayList<>();
        for ( int myLottoNumber : myLotto.getNumbers() ) {
            boolean matched = winningLotto.getWinningLotto().getNumbers().contains(myLottoNumber);
            winningNumberMatchFlag.add(matched);
        }
        this.bonusNumberMatchFlag = myLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public int getPrize() {
        for ( LottoPrize lottoPrize : LottoPrize.values() ) {
            if ( lottoPrize.getFlagCount() == getFlagCount() &&
                    lottoPrize.isBonusNumberMatchFlag() == bonusNumberMatchFlag ) {
                return lottoPrize.getNstPrize();
            }
        }

        return 0;
    }

    public int getFlagCount() {
        int res = 0;
        for ( Boolean flag : winningNumberMatchFlag) {
            if ( flag ) {
                res ++;
            }
        }

        return res;
    }
}
