package lotto.service;

import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoProvideService {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public LottoBundle buyLottoBundle(Cash cash) {
        List<Lotto> lottoBundle = new ArrayList<>();
        int lottoCount = cash.getPurchasableLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.add(new Lotto(lottoNumberGenerator.generateLottoNumbers()));
        }
        return new LottoBundle(lottoBundle);
    }

    public Lotto publishWinningLotto(String winningLottoNumbers) {
        List<Integer> winningNumbers = Arrays.stream(winningLottoNumbers.split(","))
                .map(this::parseNumber)
                .toList();
        return new Lotto(winningNumbers);
    }

    private Integer parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1,2,3,4,5,6 과 같이 1 ~ 45 사이의 중복되지 않은 자연수 6개여야 합니다.");
        }
    }
}
