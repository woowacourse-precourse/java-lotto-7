package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_SAVE_LOTTO_LIST;
import static lotto.utils.ErrorMessage.NOT_SAVE_WINNER_LOTTO;

import lotto.domain.LottoTickets;
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

        winnerLotto.validBonusNumber();

        LottoTickets lottoTickets = lottoListRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_LOTTO_LIST.getMessage()));

        WinnerStatus winnerStatus = WinnerStatus.create(lottoTickets, winnerLotto);

        return winnerStatusRepository.save(winnerStatus)
                .toDto();
    }


}
