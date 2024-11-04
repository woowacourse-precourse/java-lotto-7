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
        int result = LottoPrize.NONE_PRIZE.getPrize();

        for ( LottoPrize lottoPrize : LottoPrize.values() ) {
            if ( getFlagCount() == lottoPrize.getFlagCount() ) {
                result = getNstPrize(lottoPrize);
            }
        }

        return result;
    }

    private int getNstPrize(LottoPrize lottoPrize) {
        if ( lottoPrize.equals(LottoPrize.THIRD_PRIZE) ) {
            if ( bonusNumberMatchFlag ) {
                return LottoPrize.SECOND_PRIZE.getNstPrize();
            }
        }
        return lottoPrize.getNstPrize();
    }

    private int getFlagCount() {
        int res = 0;
        for ( Boolean flag : winningNumberMatchFlag) {
            if ( flag ) {
                res ++;
            }
        }

        return res;
    }
}
