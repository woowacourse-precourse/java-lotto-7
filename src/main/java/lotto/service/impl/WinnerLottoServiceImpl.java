package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_SAVE_WINNER_LOTTO;

import lotto.domain.LottoNumber;
import lotto.domain.WinnerLotto;
import lotto.exception.EntityNotFoundException;
import lotto.repository.SingleRepository;
import lotto.service.WinnerLottoService;

public class WinnerLottoServiceImpl implements WinnerLottoService {

    private final SingleRepository<WinnerLotto> winnerLottoRepository;

    public WinnerLottoServiceImpl(SingleRepository<WinnerLotto> winnerLottoRepository) {
        this.winnerLottoRepository = winnerLottoRepository;
    }

    @Override
    public void addWinnerNumber(String winnerNumber) {
        WinnerLotto winnerLotto = WinnerLotto.create(winnerNumber);

        winnerLottoRepository.save(winnerLotto);
    }

    @Override
    public void addBonusNumber(String bonusNumber) {
        LottoNumber lottoBonusNum = LottoNumber.create(bonusNumber);

        WinnerLotto winnerLotto = winnerLottoRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_WINNER_LOTTO.getMessage()));

        winnerLotto.addBonusNumber(lottoBonusNum);

        winnerLottoRepository.save(winnerLotto);
    }
}
