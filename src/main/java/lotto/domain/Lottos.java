package lotto.domain;

import lotto.domain.lottoForm.Lotto;
import lotto.domain.lottoForm.WinningNumbers;
import lotto.domain.number.BonusNumber;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public long getLottoCount(){
        return lottos.size();
    }

    public void showInfo(){
        lottos.stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }

    public void compare(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchingNumber = lotto.getMatchingNumbers(winningNumbers);
            boolean bonus = lotto.hasBonusNumber(bonusNumber);
            Result.update(matchingNumber, bonus);
        }
    }

}
