package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_HAVE_BONUS_NUM;
import static lotto.utils.ErrorMessage.NOT_SAVE_LOTTO_LIST;
import static lotto.utils.ErrorMessage.NOT_SAVE_WINNER_LOTTO;

import lotto.domain.LottoTickets;
import lotto.domain.CountResults;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.dto.WinnerStatusDto;
import lotto.exception.EntityNotFoundException;
import lotto.repository.SingleRepository;
import lotto.service.StatusService;

public class StatusServiceImpl implements StatusService {

    private final SingleRepository<WinnerLotto> winnerLottoRepository;
    private final SingleRepository<LottoTickets> lottoListRepository;
    private final SingleRepository<WinnerStatus> winnerStatusRepository;

    public StatusServiceImpl(SingleRepository<WinnerLotto> winnerLottoRepository,
                             SingleRepository<LottoTickets> lottoListRepository,
                             SingleRepository<WinnerStatus> winnerStatusRepository) {
        this.winnerLottoRepository = winnerLottoRepository;
        this.lottoListRepository = lottoListRepository;
        this.winnerStatusRepository = winnerStatusRepository;
    }

    @Override
    public WinnerStatusDto calculateStatus() {
        WinnerLotto winnerLotto = winnerLottoRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_WINNER_LOTTO.getMessage()));

        validHasBonusNumber(winnerLotto);

        LottoTickets lottoTickets = lottoListRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_LOTTO_LIST.getMessage()));

        CountResults countResults = CountResults.of(lottoTickets, winnerLotto);
        WinnerStatus winnerStatus = WinnerStatus.create(countResults);

        return winnerStatusRepository.save(winnerStatus)
                .toDto();
    }

    private void validHasBonusNumber(WinnerLotto winnerLotto) {
        if (!winnerLotto.hasBonusNumber()) {
            throw new IllegalStateException(NOT_HAVE_BONUS_NUM.getMessage());
        }
    }
}
