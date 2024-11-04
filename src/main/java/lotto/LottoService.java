package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class LottoService {

    private StringParser stringParser = new StringParser();

    public Map<LottoRank, Integer> calculateStatistic(String winningNumbers, int bonusNumber, List<List<Integer>> lottos) {

        List<Integer> parsedWinningNumbers = stringParser.convertStringToIntegerList(winningNumbers);
        Map<LottoRank, Integer> result = new HashMap<>();
        for (List<Integer> lotto : lottos) {
            LottoRank lottoRank = prizeWinningDiscriminationPerLotto(parsedWinningNumbers, bonusNumber, lotto);
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }
        return result;
    }

    public LottoRank prizeWinningDiscriminationPerLotto(List<Integer> winningNumbers, int bonusNumber, List<Integer> lotto) {

        int countOfMatch = 0;
        boolean isMatchBonus = false;

        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                countOfMatch++;
            }
        }

        if (lotto.contains(bonusNumber) && countOfMatch == 5) isMatchBonus = true;

        return LottoRank.valueOf(countOfMatch, isMatchBonus);
    }

    public double calculateRateOfReturnMoney(Map<LottoRank, Integer> lottoRankMap, int purchaseAmount) {
        int totalWinningMoney = 0;
        for (LottoRank lottoRank : lottoRankMap.keySet()) {
            totalWinningMoney += lottoRank.getPrize() * lottoRankMap.get(lottoRank);
        }
        double result = (double) totalWinningMoney / purchaseAmount * 100;
        return Math.round(result * 10) /10.0  ;

    }

    public List<List<Integer>> publishLotto(int numberOfLotto) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(lotto);
        }
        return lottos;
    }

    public int calCulateLottoAmount(String purchaseAmount) {
        int amount = stringParser.convertStringToInt(purchaseAmount);
        return amount / 1000;
    }






}
