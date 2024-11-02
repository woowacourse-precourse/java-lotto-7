package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_HAVE_BONUS_NUM;
import static lotto.utils.ErrorMessage.NOT_SAVE_LOTTO_LIST;
import static lotto.utils.ErrorMessage.NOT_SAVE_WINNER_LOTTO;

import lotto.domain.LottoList;
import lotto.domain.WinnerCountList;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.dto.WinnerStatusDto;
import lotto.exception.EntityNotFoundException;
import lotto.repository.SingleRepository;
import lotto.service.StatusService;

public class StatusServiceImpl implements StatusService {

    private final SingleRepository<WinnerLotto> winnerLottoRepository;
    private final SingleRepository<LottoList> lottoListRepository;
    private final SingleRepository<WinnerStatus> winnerStatusRepository;

    public StatusServiceImpl(SingleRepository<WinnerLotto> winnerLottoRepository,
                             SingleRepository<LottoList> lottoListRepository,
                             SingleRepository<WinnerStatus> winnerStatusRepository) {
        this.winnerLottoRepository = winnerLottoRepository;
        this.lottoListRepository = lottoListRepository;
        this.winnerStatusRepository = winnerStatusRepository;
    }

    @Override
    public WinnerStatusDto calculateStatus() {
        WinnerLotto winnerLotto = winnerLottoRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_WINNER_LOTTO.getMessage()));

        validHasBonusNum(winnerLotto);

        LottoList lottoList = lottoListRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_LOTTO_LIST.getMessage()));

        WinnerCountList winnerCountList = WinnerCountList.of(lottoList, winnerLotto);
        WinnerStatus winnerStatus = WinnerStatus.create(winnerCountList);
        winnerStatusRepository.save(winnerStatus);

        return winnerStatus.toDto();
    }

    private void validHasBonusNum(WinnerLotto winnerLotto) {
        if (!winnerLotto.hasBonusNum()) {
            throw new IllegalStateException(NOT_HAVE_BONUS_NUM.getMessage());
        }
    }
}
