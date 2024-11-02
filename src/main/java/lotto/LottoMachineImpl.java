package lotto;

import static lotto.LottoRank.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoMachineImpl implements LottoMachine {
    @Override
    public List<Lotto> purchaseLottoTickets(String inputMoney) {
        int money = InputValidator.validateMoney(inputMoney);
        int count = money / 1000;

        return createLottoTickets(count);
    }

    @Override
    public HashMap<LottoRank, Integer> getWinningResult(List<Lotto> lottoTickets, String inputWinningNumbers, String inputBonusNumber) {
        List<Integer> winningNumbers = InputValidator.validateWiningNumbers(inputWinningNumbers);
        int bonusNumber = InputValidator.validateBonusNumber(winningNumbers, inputBonusNumber);

        return countWinningTickets(lottoTickets, winningNumbers, bonusNumber);
    }

    @Override
    public Double calculateProfitRate(HashMap<LottoRank, Integer> winningResult, int purchaseNumber) {
        int totalSpent = purchaseNumber * 1000;

        int totalPrizeMoney = 0;
        for (LottoRank rank : values()) {
            totalPrizeMoney += rank.getPrizeMoney() * winningResult.get(rank);
        }

        double profitRate = ((double) totalPrizeMoney / totalSpent) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

    private List<Lotto> createLottoTickets(int purchaseCount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            Lotto newLottoTicket = new Lotto(pickLottoNumbers());
            lottoTickets.add(newLottoTicket);
        }
        return lottoTickets;
    }

    private HashMap<LottoRank, Integer> countWinningTickets(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<LottoRank, Integer> winningResult = initWinningResult();

        for (Lotto lottoTicket : lottoTickets) {
            //당첨 개수를 센다.
            int matchCount = getMatchNumbers(lottoTicket, winningNumbers);
            //등수를 확인하고 업데이트 한다.
            if (matchCount >= 3) {
                updateWinningResult(matchCount, lottoTicket, bonusNumber, winningResult);
            }
        }
        return winningResult;
    }

    private List<Integer> pickLottoNumbers() {
        List<Integer> pickedNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(pickedNumbers);
        return pickedNumbers;
    }

    private int getMatchNumbers(Lotto lottoTicket, List<Integer> winningNumbers) {
        int count = 0;
        for (int j = 0; j < 6; j++) {
            if (lottoTicket.getNumbers().contains(winningNumbers.get(j))) {
                count++;
            }
        }
        return count;
    }

    private void updateWinningResult(int matchCount, Lotto lottoTicket, int bonusNumber,
                                     HashMap<LottoRank, Integer> winningResult) {
        boolean isBonusNumber = isMatchBonusNumber(lottoTicket, bonusNumber);
        LottoRank key = getRank(matchCount, isBonusNumber);
        int value = winningResult.get(key) + 1;
        winningResult.put(key, value);
    }

    private boolean isMatchBonusNumber(Lotto lottoTicket, int bonusNumber) {
        return lottoTicket.getNumbers().contains(bonusNumber);
    }

    private HashMap<LottoRank, Integer> initWinningResult() {
        HashMap<LottoRank, Integer> winningResult = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningResult.put(rank, 0);
        }
        return winningResult;
    }
}
