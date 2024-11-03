package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerater {
    List<List<Integer>> lotto = new ArrayList<>();

    public List<List<Integer>> generateLottoTickets(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> generatedNumbers = new ArrayList<>(numberGenerate());
            Collections.sort(generatedNumbers);
            lotto.add(generatedNumbers);
        }
        return lotto;
    }

    private List<Integer> numberGenerate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}



