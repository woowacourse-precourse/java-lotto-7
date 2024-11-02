package lotto.infrastructures;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.constant.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generateLotto() {
        List<Integer> randomNumbers = makeRandomNumber();
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(randomNumbers);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_SIZE);
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .map(LottoNumber::new)
                .toList();
    }
}
