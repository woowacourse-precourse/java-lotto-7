package lotto.controller;

import lotto.model.*;

import java.util.List;

import static lotto.Constant.LottoRule.UNIT_CASH;
import static lotto.Exception.Money.MoneyInputErrorCode.NOT_IN_THOUSANDS;

public class LottoFactory {
    private LottoRateCalculator lottoRateCalculator;
    private LottoGenerator lottoGenerator;
    private LottoWinningChecker lottoWinningChecker;
    private List<Lotto> drawLotto;
    private Lotto userLotto;
    private int bonusBall;
    private int inputCash;

    public LottoFactory(LottoRateCalculator lottoRateCalculator, LottoGenerator lottoGenerator, LottoWinningChecker lottoWinningChecker) {
        this.lottoRateCalculator = lottoRateCalculator;
        this.lottoGenerator = lottoGenerator;
        this.lottoWinningChecker = lottoWinningChecker;
    }

    public int convertCashToLottTicket(int cash){
        this.inputCash=cash;
        return validateUnitCash(cash);
    }

    public List<Lotto> createLottoByFactory (int lottoCount){
        this.drawLotto =lottoGenerator.generateLottoByFactory(lottoCount);
        return drawLotto;
    }

    public Lotto createLottoByUser(List<Integer> lottoNumber, int bonusBall) {
        this.bonusBall=bonusBall;
        this.userLotto=lottoGenerator.generateLottoByUser(lottoNumber, bonusBall);
        return userLotto;
    }

    public List<PrizeType> checkWinningLotto() {
        List<PrizeType> prizes = lottoWinningChecker.checkWinning(drawLotto, userLotto, bonusBall);
        return prizes;
    }

    public double calculateRateOfReturn( List<PrizeType> prize){
        return lottoRateCalculator.calculateRateOfReturn(prize, inputCash);
    }

    private int validateUnitCash(int inputCash) {
        int count = inputCash%UNIT_CASH;
        if(count != 0) {
            throw new IllegalArgumentException(NOT_IN_THOUSANDS.getArgsErrorMessage(UNIT_CASH));
        }
        return inputCash/UNIT_CASH;
    }


}
