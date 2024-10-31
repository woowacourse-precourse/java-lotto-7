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
    public void getWinningResult(List<Integer> winningNumbers, int bonusNumber) {
        HashMap<LottoRank, Integer> winningCounts = new HashMap<>();
        //map 초기화
        for(LottoRank rank: LottoRank.values()) {
            winningCounts.put(rank, 0);
        }

        for (Lotto lottoTicket : lottoTickets) {
            //당첨 번호와 로또 용지 번호 비교
            int matchCount = countMatchNumbers(lottoTicket, winningNumbers);
            //카운트에 따른 등수 기록
            checkRank(matchCount, lottoTicket, bonusNumber, winningCounts);
        }
        //당첨 결과 출력
        printWinningResult(winningCounts);
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

    private int countMatchNumbers(Lotto lottoTicket, List<Integer> winningNumbers) {
        int count = 0;
        for (int j = 0; j < 6; j++) {
            if (lottoTicket.getNumbers().contains(winningNumbers.get(j))) {
                count++;
            }
        }
        return count;
    }

    private void checkRank(int count, Lotto lottoTicket, int bonusNumber, HashMap<LottoRank, Integer> winningCounts) {
        //1등
        if (count == 6) {
            LottoRank key = RANK_1;
            int value = winningCounts.get(key) + 1;
            winningCounts.put(key, value);
        }
        //2등
        //당첨 번호 5개 일치 + 보너스 번호도 일치
        if (count == 5 && lottoTicket.getNumbers().contains(bonusNumber)) {
            LottoRank key = RANK_2;
            int value = winningCounts.get(key) + 1;
            winningCounts.put(key, value);
        }
        //3등
        if (count == 5) {
            LottoRank key = RANK_3;
            int value = winningCounts.get(key) + 1;
            winningCounts.put(key, value);
        }
        //4등
        if (count == 4) {
            LottoRank key = RANK_4;
            int value = winningCounts.get(key) + 1;
            winningCounts.put(key, value);
        }
        //5등
        if (count == 3) {
            LottoRank key = RANK_5;
            int value = winningCounts.get(key) + 1;
            winningCounts.put(key, value);
        }
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
