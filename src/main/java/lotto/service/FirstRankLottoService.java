package lotto.service;

import java.util.List;
import lotto.validator.FirstRankLottoValidator;

public class FirstRankLottoService {

    private static final FirstRankLottoValidator FIRST_RANK_LOTTO_VALIDATOR = new FirstRankLottoValidator();

    private final LottoService lottoService;

    public FirstRankLottoService() {
        this.lottoService = new LottoService();
    }

    public void validateNumbers(List<Integer> numbers) {
        lottoService.validateNumbers(numbers);
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        FIRST_RANK_LOTTO_VALIDATOR.validateBonusNumber(numbers, bonusNumber);
    }
}
