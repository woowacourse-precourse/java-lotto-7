package lotto.draw;

import lotto.donghang.WinningLotto;
import lotto.vendingmachine.Lotto;
import lotto.vendingmachine.VendingMachineRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrawServiceImpl implements DrawService {

    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    private final VendingMachineRepository vendingMachineRepository;

    public DrawServiceImpl(VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    @Override
    public Map<Rank, Integer> checkLotto(WinningLotto winningLotto) {
        Map<Rank, Integer> result = Stream.of(Rank.values())
                .filter(rank -> rank != Rank.LOSING_TICKET)
                .collect(Collectors.toMap(rank -> rank, rank -> 0));

        winningLottoNumbers = winningLotto.lottoNumbers.getNumbers();
        bonusNumber = winningLotto.bonus;

        List<Lotto> lottos = vendingMachineRepository.getStoredLottoTickets();
        for (Lotto lotto : lottos) {
            int cnt = countMatchingNumber(lotto);
            if (cnt < 3) {
                continue;
            }

            boolean isBonusMatch = false;
            if (cnt == 5) {
                isBonusMatch = checkBonusMatch(lotto);
            }

            result.put(Rank.getWinningRank(cnt, isBonusMatch), result.get(Rank.getWinningRank(cnt, isBonusMatch)) + 1);
        }

        return result;
    }

    @Override
    public void saveStatistics(Map<Rank, Integer> result) {

    }


}
