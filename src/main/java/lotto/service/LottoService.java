package lotto.service;

import lotto.domain.CustomLotto;
import lotto.domain.LottoGame;
import lotto.util.Parse;
import lotto.util.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoService {

    public LottoGame constructLottoGame(String budget) {
        try{
            int money = Parse.parseInteger(budget);
            return LottoGame.of(money);
        }catch(IllegalArgumentException err){
            throw err;
        }
    }

    public void validateBudgetMoney(String budget){
        Validator.validateBudget(budget);
    }

    public void validateLottoNumbers(String lottoNumbers, String bonusNumber) {
        try{
            Validator.validateLottoNumbers(lottoNumbers);
            int parseNumber = Parse.parseInteger(bonusNumber);
            Validator.validateIntegerRange(parseNumber);
        }catch (IllegalArgumentException err){
            throw err;
        }
    }
    public CustomLotto makeCustomLotto(String lottoNumbers, Integer bonus) {
        List<Integer> parseNumbers = Parse.parseLottoStringToInteger(lottoNumbers);
        return new CustomLotto(parseNumbers, bonus);
    }

    public BigDecimal calculateProfit(LottoGame lottoGame) {
        List<Integer> rank = lottoGame.getRank();
        Integer seed = lottoGame.getSeedMoney();
        List<Integer> prizeMoney = List.of(5000,50000,1500000,30000000,2000000000);
        Integer sumMoney = sumPrizeMoney(rank,prizeMoney);
        return calculate(seed,sumMoney);
    }

    private BigDecimal calculate(Integer seed, Integer profit ){
        BigDecimal seedMoney = new BigDecimal(seed);
        BigDecimal pureProfit = new BigDecimal(profit);
        BigDecimal divide = pureProfit.divide(seedMoney, 3, RoundingMode.HALF_UP);
        return divide.multiply(BigDecimal.valueOf(100));
    }

    private Integer sumPrizeMoney(List<Integer> rank, List<Integer> prize){
        Integer sum = 0;
        for(int i =0;i<rank.size();i++){
            sum+=(rank.get(i)*prize.get(i));
        }
        return sum;
    }

    public void calculateLottoRank(LottoGame lottoGame) {
        lottoGame.calculateLottoRank();
    }
}
