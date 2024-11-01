package lotto.service.impl;

import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.repository.SingleRepository;
import lotto.service.LottoBuyService;

public class LottoBuyServiceImpl implements LottoBuyService {

    private final SingleRepository<Money> moneyRepository;
    private final SingleRepository<LottoList> lottoListRepository;

    public LottoBuyServiceImpl(SingleRepository<Money> moneyRepository,
                               SingleRepository<LottoList> lottoListRepository) {
        this.moneyRepository = moneyRepository;
        this.lottoListRepository = lottoListRepository;
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
}
