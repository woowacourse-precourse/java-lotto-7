package lotto.service.impl;

import lotto.domain.LottoNum;
import lotto.domain.WinnerLotto;
import lotto.repository.SingleRepository;
import lotto.service.WinnerLottoService;

public class WinnerLottoServiceImpl implements WinnerLottoService {

    private final SingleRepository<WinnerLotto> winnerLottoRepository;

    public WinnerLottoServiceImpl(SingleRepository<WinnerLotto> winnerLottoRepository) {
        this.winnerLottoRepository = winnerLottoRepository;
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
                .orElseThrow(() -> new NullPointerException("당첨 번호를 입력하지 않았습니다!"));

        winnerLotto.addBonusNum(lottoBonusNum);

        winnerLottoRepository.save(winnerLotto);
    }
}
