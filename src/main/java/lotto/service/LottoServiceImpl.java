package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoOffice;
import lotto.domain.Player;
import lotto.domain.dto.LottoDetail;
import lotto.service.dto.SellLotto;

public class LottoServiceImpl implements LottoService {

    private Player player;

    @Override
    public SellLotto sellLotto(int money) {
        LottoOffice lottoOffice = new LottoOffice();
        List<Lotto> lottos = lottoOffice.sellTo(money);

        player = Player.create(lottos);

        List<LottoDetail> dtos = lottos.stream().map(Lotto::toDTO).toList();
        return new SellLotto(dtos);
    }

    @Override
    public void createWinningNumber(List<Integer> winningNumbers) {

    }

    @Override
    public void createBonusNumber(int bonusNumber) {

    }

    @Override
    public List<String> compareWinningNumbers() {
        return List.of();
    }
}
