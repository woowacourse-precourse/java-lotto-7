package lotto.domain;

import static lotto.constant.LottoValueConstant.MAX_NUMBER_LOTTO;
import static lotto.constant.LottoValueConstant.MIN_NUMBER_LOTTO;
import static lotto.constant.LottoValueConstant.NUMBER_OF_LOTTO;

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
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_LOTTO, MAX_NUMBER_LOTTO, NUMBER_OF_LOTTO);
    }

}



