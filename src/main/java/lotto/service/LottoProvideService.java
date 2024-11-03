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
        if (winningLottoNumbers == null) {
            throw new IllegalArgumentException("로또 번호 입력값이 null입니다. 1 ~ 45 사이의 중복되지 않은 자연수 6개여야 합니다.");
        }
        List<Integer> winningNumbers = Arrays.stream(winningLottoNumbers.split(","))
                .map(this::parseNumber)
                .toList();
        return new Lotto(winningNumbers);
    }

    private Integer parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다. 1 ~ 45 사이의 중복되지 않은 자연수 6개여야 합니다.");
        }
    }
}
