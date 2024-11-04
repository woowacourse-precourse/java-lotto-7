package lotto;

import java.util.EnumMap;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int betAmount = GetAttempts.validateBetAmount();
            int attempts = GetAttempts.getAttempts(betAmount);
            List<List<Integer>> entryLists = GetAttempts.printEntries(attempts);
            List<Integer> lottoNumbers = GetEntries.enterLottoNumbers();
            int bonusNumber = GetEntries.enterBonusNumber(lottoNumbers);
            EnumMap<LottoResults, Integer> calculator = LottoResults.resetEnumMap();
            GetResults.printResults(entryLists, lottoNumbers, bonusNumber, attempts, calculator);
            GetResults.printReturnRate(betAmount, calculator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}