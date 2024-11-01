package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_HAVE_BONUS_NUM;

import lotto.domain.LottoList;
import lotto.domain.WinnerCountList;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.dto.WinnerStatusDto;
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
    public WinnerStatusDto calculate() {
        WinnerLotto winnerLotto = winnerLottoRepository.get()
                .orElseThrow(() -> new NullPointerException("당첨 번호를 입력하지 않았습니다!"));

        if (!winnerLotto.hasBonusNum()) {
            throw new IllegalStateException(NOT_HAVE_BONUS_NUM.getMessage());
        }

        LottoList lottoList = lottoListRepository.get()
                .orElseThrow(() -> new NullPointerException("로또 번호들이 저장되지 않았습니다!"));

        WinnerCountList winnerCountList = WinnerCountList.of(lottoList, winnerLotto);
        WinnerStatus winnerStatus = WinnerStatus.create(winnerCountList);
        winnerStatusRepository.save(winnerStatus);

        return winnerStatus.toDto();
    }
}
