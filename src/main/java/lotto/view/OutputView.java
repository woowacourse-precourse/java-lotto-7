package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printLottoNumbers(List<Lotto> generatedLottoNumbers) {
        for(Lotto generatedLottoNumber: generatedLottoNumbers) {
            List<Integer> sortedLottoNumbers = new ArrayList<>(generatedLottoNumber.getLottoNumbers());

            // 오름차순
            Collections.sort(sortedLottoNumbers);
            System.out.println(sortedLottoNumbers);
        }

    }
}
