package lotto.domain.lottomachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.constant.LottoRule.*;

public class AutoNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getNumber(),
                MAX_NUMBER.getNumber(),
                LOTTO_SIZE.getNumber()
        );
        return lottoNumbers.stream()
                .sorted()
                .toList();
    }
}
