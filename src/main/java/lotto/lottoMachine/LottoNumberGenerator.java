package lotto.lottoMachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.lottoMachine.utils.StaticFinalMessages;

public class LottoNumberGenerator {
    public List<Integer> generateLottoNumbers() {
        // 새로운 ArrayList를 생성하여 수정 가능한 리스트로 만듦
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        StaticFinalMessages.MINIMUM_LOTTO_NUMBER,
                        StaticFinalMessages.MAXIMUM_LOTTO_NUMBER,
                        StaticFinalMessages.AMOUNT_OF_LOTTO_NUMBERS
                )
        );

        Collections.sort(numbers);

        return numbers;
    }
}