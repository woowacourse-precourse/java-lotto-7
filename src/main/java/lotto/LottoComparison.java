package lotto;

import java.util.List;

public class LottoComparison {
    public List<Grade> compare(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<Grade> grades = null;

        for (Lotto lotto : lottos) {
            grades.add(lotto.compare(winningLotto, bonusNumber));
        }
        return grades;
    }
}
