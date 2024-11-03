package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoComparison {
    public static List<Grade> compare(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<Grade> grades = new ArrayList<>();

        for (Lotto lotto : lottos) {
            grades.add(lotto.compare(winningLotto, bonusNumber));
        }
        return grades;
    }
}
