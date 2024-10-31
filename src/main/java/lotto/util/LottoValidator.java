package lotto.util;

import lotto.exception.ValidatorException;

import java.util.List;

public class LottoValidator {

    public static void run(List<Integer> lottoTickets) {
        validateLotto(lottoTickets);
    }

    private static void validateLotto(List<Integer> lottoTickets) {
        ValidatorException.throwIfLottoNumberCountIsMismatch(lottoTickets);
        ValidatorException.throwIfLottoNumberIsDuplicate(lottoTickets);
    }
}
