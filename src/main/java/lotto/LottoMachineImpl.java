package lotto;

import static lotto.LottoRank.*;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoMachineImpl implements LottoMachine {
    private static final List<Lotto> lottoTickets = new ArrayList<>();

    @Override
    public List<Lotto> createLottoTickets(int count) {
        for (int i = 0; i < count; i++) {
            Lotto newLottoTicket = new Lotto(pickLottoNumbers());
            lottoTickets.add(newLottoTicket);
        }
        showCreateLottoTickets(count);

        return lottoTickets;
    }

    @Override
    public HashMap<LottoRank, Integer> getWinningResult(List<Lotto> lottoTickets, String inputWinningNumbers, int bonusNumber) {
        List<Integer> winningNumbers = InputValidater.validateWiningNumbers(inputWinningNumbers);

        HashMap<LottoRank, Integer> winningResult = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningResult.put(rank, 0);
        }

        for (Lotto lottoTicket : lottoTickets) {
            //당첨 개수를 센다.
            int matchCount = getMatchNumbers(lottoTicket, winningNumbers);
            //등수를 확인하고 업데이트 한다.
            if (matchCount >= 3) {
                updateWinningResult(matchCount, lottoTicket, bonusNumber, winningResult);
            }
        }
        //당첨 결과를 출력한다.
        printWinningResult(winningResult);
        return winningResult;
    }

    @Override
    public Double calculateProfitRate(HashMap<LottoRank, Integer> winningResult, int purchaseNumber) {
        int totalPrizeMoney = 0;
        for (LottoRank rank: values()) {
            totalPrizeMoney += rank.getPrizeMoney() * winningResult.get(rank);
        }
        int totalSpent = purchaseNumber * 1000;

        return  ((double)totalPrizeMoney / totalSpent) * 100;
    }

    private List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void showCreateLottoTickets(int count) {
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto);
        }
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

    private void updateWinningResult(int matchCount, Lotto lottoTicket, int bonusNumber, HashMap<LottoRank, Integer> winningResult) {
        boolean isBonusNumber = isMatchBonusNumber(lottoTicket, bonusNumber);
        LottoRank key = getRank(matchCount, isBonusNumber);
        int value = winningResult.get(key) + 1;
        winningResult.put(key, value);
    }

    private boolean isMatchBonusNumber(Lotto lottoTicket, int bonusNumber) {
        return lottoTicket.getNumbers().contains(bonusNumber);
    }

    private void printWinningResult(HashMap<LottoRank, Integer> winningCounts) {
        System.out.println();
        System.out.println("3개 일치 (5,000원) - " + winningCounts.get(RANK_5) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCounts.get(RANK_4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCounts.get(RANK_3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCounts.get(RANK_2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCounts.get(RANK_1) + "개");
    }
}
