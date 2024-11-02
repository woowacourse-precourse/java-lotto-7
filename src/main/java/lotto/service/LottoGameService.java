package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.ResultLotto;
import lotto.domain.WinningLotto;
import lotto.dto.LottoGameDto;

import java.util.Objects;

import static lotto.domain.Lotto.LOTTO_BONUS_COUNT;
import static lotto.viewHandler.exception.MyExceptionConstant.ZERO;

public class LottoGameService {
    public LottoGameService() {
    }

    public void game(LottoGameDto dto) {
        matchLottos(dto);
    }

    private void matchLottos(LottoGameDto dto) {
        WinningLotto winningLotto = dto.getWinningLotto();
        dto.getLottos().forEach(oneLotto -> {
            findWinLotto(oneLotto, winningLotto);
        });
    }

    private void findWinLotto(Lotto lotto, WinningLotto winningLotto) {
        long count = lotto.getNumbers().stream()
                .filter(winningLotto.getWinLotto().getNumbers()::contains)
                .count();

        Integer bonus = matchBonusNumber(lotto, winningLotto);

        ResultLotto.winLotto((int) count, bonus);
    }

    private Integer matchBonusNumber(Lotto lotto, WinningLotto winningLotto) {
        if(lotto.getNumbers().stream().anyMatch(oneNumber -> Objects.equals(oneNumber, winningLotto.getBonusNumber()))) {
            return LOTTO_BONUS_COUNT;
        }
        return ZERO;
    }
}
