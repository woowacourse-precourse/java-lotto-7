package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_HAVE_BONUS_NUM;

import lotto.domain.LottoList;
import lotto.domain.LottoNum;
import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerCountList;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerStatus;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;
import lotto.repository.SingleRepository;
import lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {

    private final SingleRepository<Money> moneyRepository;
    private final SingleRepository<LottoList> lottoListRepository;
    private final SingleRepository<WinnerStatus> winnerStatusRepository;
    private final SingleRepository<WinnerLotto> winnerLottoRepository;

    public LottoServiceImpl(SingleRepository<Money> moneyRepository, SingleRepository<LottoList> lottoListRepository,
                            SingleRepository<WinnerStatus> winnerStatusRepository,
                            SingleRepository<WinnerLotto> winnerLottoRepository) {
        this.moneyRepository = moneyRepository;
        this.lottoListRepository = lottoListRepository;
        this.winnerStatusRepository = winnerStatusRepository;
        this.winnerLottoRepository = winnerLottoRepository;
    }

    @Override
    public MoneyDto createMoney(String input) {
        Money money = Money.create(input);
        moneyRepository.save(money);

        return money.toDto();
    }

    @Override
    public LottoListDto generateLottoList() {
        Money money = moneyRepository.get()
                .orElseThrow(() -> new NullPointerException("돈이 저장되지 않았습니다!"));

        LottoList lottoList = LottoList.generate(money);
        lottoListRepository.save(lottoList);

        return lottoList.toDto();
    }

    @Override
    public void addWinnerLotto(String input) {
        WinnerLotto winnerLotto = WinnerLotto.create(input);

        winnerLottoRepository.save(winnerLotto);
    }

    @Override
    public void addBonusNumber(String input) {
        LottoNum bonusNumber = LottoNum.create(input);
        WinnerLotto winnerLotto = winnerLottoRepository.get()
                .orElseThrow(() -> new NullPointerException("당첨 번호를 입력하지 않았습니다!"));

        winnerLotto.addBonusNum(bonusNumber);

        winnerLottoRepository.save(winnerLotto);
    }

    @Override
    public WinnerStatusDto calculateWinnerStatus() {
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

    @Override
    public ProfitRateResultDto calculateProfitRate() {
        Money money = moneyRepository.get()
                .orElseThrow(() -> new NullPointerException("돈이 저장되지 않았습니다!"));

        WinnerStatus winnerStatus = winnerStatusRepository.get()
                .orElseThrow(() -> new NullPointerException("당첨 정보들이 저장되지 않았습니다!"));

        ProfitRate profitRate = ProfitRate.create(money, winnerStatus);
        return profitRate.toDto();
    }
}
