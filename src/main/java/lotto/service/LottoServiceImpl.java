package lotto.service;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.History;
import lotto.domain.Lotto;
import lotto.domain.LottoOffice;
import lotto.domain.Player;
import lotto.domain.Winning;
import lotto.domain.dto.LottoDetail;
import lotto.domain.dto.LottoResult;
import lotto.service.dto.SellLotto;

public class LottoServiceImpl implements LottoService {

    private Player player;
    private Winning winning;
    private Bonus bonus;
    private LottoOffice lottoOffice = new LottoOffice();

    @Override
    public SellLotto sellLotto(int money) {
        List<Lotto> lottos = lottoOffice.sellTo(money);

        player = Player.create(lottos, money);

        List<LottoDetail> dtos = lottos.stream().map(Lotto::toDTO).toList();
        return new SellLotto(dtos);
    }

    @Override
    public void createWinningNumber(List<Integer> winningNumbers) {
        winning = Winning.create(winningNumbers);
    }

    @Override
    public void createBonusNumber(int bonusNumber) {
        winning.existByBonusNumber(bonusNumber);
        bonus = Bonus.create(bonusNumber);
    }

    @Override
    public LottoResult compareWinningNumbers() {
        History history = player.compareToWinning(winning, bonus);
        double returnRate = player.calculateReturnRate(history.getTotalPrizeMoney());

        return new LottoResult(returnRate, history.extractHistory());
    }
}
