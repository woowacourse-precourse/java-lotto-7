package lotto.winning;

import lotto.donghang.WinningLotto;
import lotto.vendingmachine.Lotto;
import lotto.vendingmachine.VendingMachineRepository;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DrawServiceImpl implements DrawService {

    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    private final VendingMachineRepository vendingMachineRepository;

    public DrawServiceImpl(VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    @Override
    public Map<Rank, Integer> checkLotto(WinningLotto winningLotto) {
        Map<Rank, Integer> result = setInitialValue();


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

    private Map<Rank, Integer> setInitialValue() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.LOSING_TICKET) {
                result.put(rank, 0);
            }
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
        double totalAmount = vendingMachineRepository.getStoredLottoTickets().size() * 1000;
        double totalEarning = 0.0;

        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            totalEarning += entry.getKey().getProfit(entry.getValue());
        }

        double earningRate = Math.round((totalEarning / totalAmount) * 1000) / 10.0;

        return earningRate;
    }

}
