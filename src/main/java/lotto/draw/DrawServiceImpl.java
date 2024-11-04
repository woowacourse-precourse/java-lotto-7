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

    private int countMatchingNumber(Lotto lotto) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < 6 && j < 6) {
            if (lotto.getNumbers().get(i) < winningLottoNumbers.get(j)) {
                i++;
                continue;
            }
            if (lotto.getNumbers().get(i) > winningLottoNumbers.get(j)) {
                j++;
                continue;
            }

            i++;
            j++;
            count++;
        }
        return count;
    }

    private boolean checkBonusMatch(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }

        return false;
    }

    @Override
    public void saveStatistics(Map<Rank, Integer> result) {
        vendingMachineRepository.saveWinningStatistics(result);
        double earningRate = calculateEarningRate(result);
        vendingMachineRepository.saveEarningRate(earningRate);
    }

    private double calculateEarningRate(Map<Rank, Integer> result) {

    }

}
