package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_HAVE_BONUS_NUM;
import static lotto.utils.ErrorMessage.NOT_SAVE_LOTTO_LIST;
import static lotto.utils.ErrorMessage.NOT_SAVE_WINNER_LOTTO;

import lotto.domain.LottoList;
import lotto.domain.LottoNum;
import lotto.domain.WinnerCountList;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.dto.WinnerStatusDto;
import lotto.repository.SingleRepository;
import lotto.service.WinnerLottoService;

public class WinnerLottoServiceImpl implements WinnerLottoService {

    private final SingleRepository<WinnerLotto> winnerLottoRepository;
    private final SingleRepository<LottoList> lottoListRepository;
    private final SingleRepository<WinnerStatus> winnerStatusRepository;


    public WinnerLottoServiceImpl(SingleRepository<WinnerLotto> winnerLottoRepository,
                                  SingleRepository<LottoList> lottoListRepository,
                                  SingleRepository<WinnerStatus> winnerStatusRepository) {
        this.winnerLottoRepository = winnerLottoRepository;
        this.lottoListRepository = lottoListRepository;
        this.winnerStatusRepository = winnerStatusRepository;
    }

    @Override
    public void addWinnerLotto(String winnerNumber) {
        WinnerLotto winnerLotto = WinnerLotto.create(winnerNumber);

        winnerLottoRepository.save(winnerLotto);
    }

    @Override
    public void addBonusNumber(String bonusNumber) {
        LottoNum lottoBonusNum = LottoNum.create(bonusNumber);

        WinnerLotto winnerLotto = winnerLottoRepository.get()
                .orElseThrow(() -> new NullPointerException(NOT_SAVE_WINNER_LOTTO.getMessage()));

        winnerLotto.addBonusNum(lottoBonusNum);

        winnerLottoRepository.save(winnerLotto);
    }

    @Override
    public WinnerStatusDto calculateStatus() {
        WinnerLotto winnerLotto = winnerLottoRepository.get()
                .orElseThrow(() -> new NullPointerException(NOT_SAVE_WINNER_LOTTO.getMessage()));

        if (!winnerLotto.hasBonusNum()) {
            throw new IllegalStateException(NOT_HAVE_BONUS_NUM.getMessage());
        }

        LottoList lottoList = lottoListRepository.get()
                .orElseThrow(() -> new NullPointerException(NOT_SAVE_LOTTO_LIST.getMessage()));

        WinnerCountList winnerCountList = WinnerCountList.of(lottoList, winnerLotto);
        WinnerStatus winnerStatus = WinnerStatus.create(winnerCountList);
        winnerStatusRepository.save(winnerStatus);

        return winnerStatus.toDto();
    }
}
