package lotto.service;

import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.service.lottoImpl.DataServiceImpl;
import lotto.service.lottoImpl.RandomNumberServiceImpl;

import java.util.List;

public class DataService implements DataServiceImpl {
    private final RandomNumberServiceImpl randomNumberServiceImpl;

    public DataService(RandomNumberServiceImpl randomNumberServiceImpl) {
        this.randomNumberServiceImpl = randomNumberServiceImpl;
    }

    @Override
    public WinningNumber createWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    @Override
    public List<Lotto> createLottos(int tickets) {
        return randomNumberServiceImpl.createRandomNumber(tickets);
    }

    @Override
    public List<Integer> readWinningNumber(WinningNumber winningNumber) {
        return winningNumber.getLottoWinningNumber();
    }

    @Override
    public int readBonusNumber(WinningNumber winningNumber) {
        return winningNumber.getBonusNumber();
    }
}
