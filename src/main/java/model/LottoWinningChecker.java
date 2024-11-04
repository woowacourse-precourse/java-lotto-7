package model;

import enums.LottoRank;

public class LottoWinningChecker {
    static final Integer LOTTO_START_INDEX = 1;
    static final Integer LOTTO_END_INDEX = 6;
    private final LottoWinningNumbers winningNumbers;

    public LottoWinningChecker(LottoWinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoRank getCheckResult(Lotto lotto) {
        return LottoRank.getLottoRank(countingMatchingNumber(lotto), hasBonusNumber(lotto));
    }

    private Integer countingMatchingNumber(Lotto lotto) {
        int hitCount = 0;
        for (int index = LOTTO_START_INDEX; index <= LOTTO_END_INDEX; index++) {
           if(isMatchWinningNumber(lotto.getNumber(index))){
               hitCount++;
           }
        }
        return hitCount;
    }

    private Boolean isMatchWinningNumber(int lottoNumber){
        for(int index = LOTTO_START_INDEX; index <= LOTTO_END_INDEX; index++){
            if(lottoNumber == winningNumbers.getNumber(index)){
                return true;
            }
        }
        return false;
    }

    private Boolean hasBonusNumber(Lotto lotto) {
        for (int index = LOTTO_START_INDEX; index <= LOTTO_END_INDEX; index++) {
            if (lotto.getNumber(index).equals(winningNumbers.getBonusNumber())) {
                return true;
            }
        }
        return false;
    }
}
