package lotto.model;

import lotto.entity.BonusNumber;
import lotto.entity.Lotto;
import lotto.entity.Price;
import lotto.entity.WinningNumber;
import lotto.enums.LottoPrize;
import lotto.validator.model.LottoResultValidator;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final LottoResultValidator validator;
    private final Price price;
    private final List<Lotto> lottoList;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;
    private final HashMap<LottoPrize, Integer> winningHistory;
    private long totalPrizeMoney;
    private double rateOfReturn;

    public LottoResult(Price price, List<Lotto> lottoList, WinningNumber winningNumber, BonusNumber bonusNumber){
        this.validator = new LottoResultValidator(winningNumber, bonusNumber);

        validate();

        this.price  = price;
        this.lottoList = lottoList;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningHistory = new HashMap<>();

        calculateResult();
    }

    public HashMap<LottoPrize, Integer> getWinningHistory() {
        return winningHistory;
    }

    public double getRateOfReturn(){
        return rateOfReturn;
    }

    private void validate(){
        validator.validate();
    }

    private void calculateResult(){
        for(Lotto lotto: lottoList){
            int correctCount = calculateCorrectCount(lotto);
            boolean bonus = isCorrectBonus(lotto);

            LottoPrize prize = calculateRank(correctCount, bonus);

            logWinningHistory(prize);
            addPrizeMoney(prize);
            calculateRateOfReturn();
        }
    }

    private LottoPrize calculateRank(int correctCount, boolean bonus){
        if(correctCount < 3){
            return LottoPrize.getFromCorrectCountAndBonus(0, bonus);
        }

        return LottoPrize.getFromCorrectCountAndBonus(correctCount, bonus);
    }

    private int calculateCorrectCount(Lotto lotto){
        int count = 0;

        for(int number : lotto.getNumbers()){
            count += isCorrectNumber(number);
        }

        return count;
    }

    private int isCorrectNumber(int number){
        if(!winningNumber.getValue().getNumbers().contains(number)){
            return 0;
        }

        return 1;
    }

    private boolean isCorrectBonus(Lotto lotto){
        return lotto.getNumbers().contains(bonusNumber.getValue());
    }

    private void logWinningHistory(LottoPrize prize){
        winningHistory.put(prize, winningHistory.getOrDefault(prize, 0) + 1);
    }

    private void addPrizeMoney(LottoPrize prize){
        totalPrizeMoney += prize.getPrizeMoney();
    }

    private void calculateRateOfReturn(){
        rateOfReturn =  totalPrizeMoney / (double)price.getValue() * 100;
    }
}
