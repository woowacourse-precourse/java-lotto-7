package lotto.service;

import lotto.constant.LottoConstant;
import lotto.model.Lotto;
import lotto.utils.LottoNumberGenerator;

import java.util.List;

public class LottoService {

    public Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        return LottoNumberGenerator.responseLottoNumbers();
    }
}
