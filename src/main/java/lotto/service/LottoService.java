package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.dto.request.LottoAmountRequest;
import lotto.dto.response.LottoesResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private List<Integer> lottoNumbers = new ArrayList<>();
    private List<Lotto> lottoes = new ArrayList<>();

    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_SIZE = 6;

    public LottoesResponse makeLottoes(LottoAmountRequest request) {
        for (int i = 0; i < request.amount(); i++) {
            lottoes.add(makeLotto());
        }

        return LottoesResponse.from(lottoes);
    }

    private Lotto makeLotto() {
        return new Lotto(setRandomNumbers());
    }

    private List<Integer> setRandomNumbers() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
