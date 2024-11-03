package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.dto.CountMatchNumbers;
import lotto.dto.GeneratedNumbers;
import lotto.dto.InputNumbers;

public class LottoNumbersComparison {

    public List<CountMatchNumbers> countingWinning(GeneratedNumbers generatedNumbers, InputNumbers inputNumbers){
        List<CountMatchNumbers> countMatchNumbers = new ArrayList<>();
        for (Lotto lotto : generatedNumbers.getGeneratedNumbers()) {
            countMatchNumbers.add(new CountMatchNumbers(countingWinningNumbers(lotto, inputNumbers),
                    countingWinningBonus(lotto, inputNumbers)));
        }
        return countMatchNumbers;
    }

    private int countingWinningNumbers(Lotto lotto, InputNumbers inputNumbers) {
        int matchMainNumber = 0;
        for (Integer inputNumber : inputNumbers.getMainNumbers()) {
            if (lotto.getNumbers().contains(inputNumber)) {
                matchMainNumber++;
            }
        }
        return matchMainNumber;
    }

    private int countingWinningBonus(Lotto lotto, InputNumbers inputNumbers) {
        int matchBonusNumber = 0;
        if (lotto.getNumbers().contains(inputNumbers.getBonusNumber())) {
            matchBonusNumber++;
        }
        return matchBonusNumber;
    }
}
