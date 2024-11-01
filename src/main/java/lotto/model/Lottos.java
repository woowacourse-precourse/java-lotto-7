package lotto.model;

import lotto.util.LottoOperator;

import java.util.ArrayList;
import java.util.List;

import static lotto.validation.BonusNumberValidation.bonusNumber;
import static lotto.validation.WinningNumberValidation.parsedWinningNumbers;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public void addLotto(Lotto lotto){
        this.lottoList.add(lotto);
    }

    public void getMatchCount(){
        lottoList.forEach(lotto -> {
            boolean isMatchBonusNumber = lotto.getNumbers().stream()
                    .anyMatch(number -> number == bonusNumber);

            long matchCount = parsedWinningNumbers.stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            LottoOperator.addCount(isMatchBonusNumber, matchCount);
        });
    }
}
