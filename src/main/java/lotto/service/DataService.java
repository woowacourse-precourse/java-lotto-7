package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoWinningNumber;
import lotto.service.lottoImpl.DataServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DataService implements DataServiceImpl {
    @Override
    public LottoWinningNumber createWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoWinningNumber(winningNumbers, bonusNumber);
    }

    @Override
    public List<Lotto> createLottos(int tickets) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    @Override
    public List<Integer> readWinningNumber(LottoWinningNumber winningNumber) {
        return winningNumber.getLottoWinningNumber();
    }

    @Override
    public int readBonusNumber(LottoWinningNumber winningNumber) {
        return winningNumber.getBonusNumber();
    }
}
