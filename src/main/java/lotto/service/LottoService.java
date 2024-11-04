package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.enums.LottoRank;

public class LottoService {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    public int calculateLottoTickets(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getMoney() / 1000;
    }

    public List<Lotto> generateTotalLottoNumbers(int ticketCount) {
        List<Lotto> totalLottoNumbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto newLotto = generateLottoNumbers();
            totalLottoNumbers.add(newLotto);
        }
        return totalLottoNumbers;
    }

    public Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, 6);
        return new Lotto(sortedLottoNumber(numbers));
    }

    private List<Integer> sortedLottoNumber(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    public HashMap<LottoRank, Integer> getWinningResults(List<Lotto> lotto, Lotto winningLotto,
                                                         BonusNumber bonusNumber) {
        HashMap<LottoRank, Integer> winningResult = new HashMap<>();
        for (int rank = 0; rank <= 5; rank++) {
            winningResult.putIfAbsent(LottoRank.getEnumsValue(rank), 0);
        }
        for (Lotto curLotto : lotto) {
            LottoRank curLottoRank = calculateLottoRank(curLotto.getNumbers(), winningLotto.getNumbers(), bonusNumber);
            winningResult.putIfAbsent(curLottoRank, 0);
            winningResult.put(curLottoRank, winningResult.get(curLottoRank) + 1);
        }
        return winningResult;
    }

    private LottoRank calculateLottoRank(List<Integer> lotto, List<Integer> winningLotto, BonusNumber bonusNumber) {
        int correctCount = 0;
        boolean correctBonusNumber = false;
        for (int winningNumber : winningLotto) {
            if (lotto.contains(winningNumber)) {
                correctCount++;
            }
        }
        if (lotto.contains(bonusNumber.getBonusNumber())) {
            correctCount++;
            correctBonusNumber = true;
        }
        return convertCountToRank(correctCount, correctBonusNumber);
    }

    private LottoRank convertCountToRank(int count, boolean rightBonusNumber) {
        if (count == 6) {
            if (rightBonusNumber) {
                return LottoRank.SECOND_RANK;
            }
            return LottoRank.FIRST_RANK;
        }
        if (count < 3) {
            return LottoRank.NONE_RANK;
        }
        return LottoRank.getEnumsValue(8 - count);
    }

    public double calculateRateOfReturn(HashMap<LottoRank, Integer> results, PurchaseAmount purchaseAmount) {
        long sum = 0;
        for (int rank = 1; rank <= 5; rank++) {
            LottoRank lottoRank = LottoRank.getEnumsValue(rank);
            int count = results.get(lottoRank);
            sum += (long)lottoRank.getPrize() * count;
        }
        return sum / (double)purchaseAmount.getMoney();
    }
}
