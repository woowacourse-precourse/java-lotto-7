package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.repository.BonusNumberRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumbersRepository;
import lotto.view.OutputView;

import java.util.List;

import static lotto.domain.WinningStatistics.*;

public class StatisticsService {

    private final WinningNumbersRepository winningNumbersRepository = WinningNumbersRepository.getInstance();
    private final BonusNumberRepository bonusNumberRepository = BonusNumberRepository.getInstance();
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public void start() {
        List<Lotto> lottos = lottoRepository.findAll();
        WinningNumbers winningNumbers = winningNumbersRepository.find();
        BonusNumber bonusNumber = bonusNumberRepository.find();
        findMatchingNumber(lottos, winningNumbers, bonusNumber);
        showStatistics();
    }

    private void findMatchingNumber(final List<Lotto> lottos, final WinningNumbers winningNumbers,
                                    final BonusNumber bonusNumber) {
        for(Lotto lotto : lottos) {
            Check check = matchCount(lotto, winningNumbers, bonusNumber);
            updateCount(check.cnt, check.bonusNumberCheck);
        }
    }

    private Check matchCount(final Lotto lotto, final WinningNumbers winningNumbers,
                                               final BonusNumber bonusNumber) {
        int cnt = 0;
        boolean bonusNumberCheck = false;
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int number: winningNumbers.getNumbers()) {
            if (lottoNumbers.contains(number)) {
                cnt++;
            }
        }

        if(cnt == SECOND.getMatchValue() && lottoNumbers.contains(bonusNumber.getValue())) {
            bonusNumberCheck = true;
        }

        return new Check(cnt, bonusNumberCheck);
    }

    private void showStatistics() {
        for(WinningStatistics statistics : values()) {
            if(statistics.getPrice() == SECOND.getPrice()) {
                OutputView.printSecondPrize(statistics);
                continue;
            }

            OutputView.printNotSecondPrize(statistics);
        }
    }

    private record Check(int cnt, boolean bonusNumberCheck){}
}
