package lotto.back.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.global.enums.LottoConstant;
import lotto.global.exception.InvalidLottoPriceUnitException;

public class LottoIssuer {

    public List<Lotto> issueByPrice(Integer lottoPrice) {
        validate(lottoPrice);
        Integer lottoCount = calculateLottoCount(lottoPrice);
        // 구입한 개수만큼 로또를 발행
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoCount).forEach(count -> {
            List<Integer> lottoNumbers = generateLottoNumbers().stream().sorted().toList();
            lottos.add(new Lotto(lottoNumbers));
        });

        return lottos.stream().toList();
    }

    private void validate(Integer lottoPrice) {
        if (lottoPrice < 0 || lottoPrice % LottoConstant.LOTTO_PRICE.getNumber() != 0) {
            throw new InvalidLottoPriceUnitException();
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_LOTTO_NUMBER.getNumber(),
                LottoConstant.MAX_LOTTO_NUMBER.getNumber(), LottoConstant.LOTTO_NUMBER_COUNT.getNumber());
    }

    private Integer calculateLottoCount(Integer lottoPrice) {
        return lottoPrice / LottoConstant.LOTTO_PRICE.getNumber();
    }
}
