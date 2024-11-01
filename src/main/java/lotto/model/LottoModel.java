package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoModel {
    // 복수의 로또를 발행하는 함수
    public List<Lotto> issueLottos(int issueNumber) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueNumber; i++) {
            lottos.add(issueOneLotto());
        }
        return lottos;
    }

    // 로또 1개 를 1~45중 중복 없이 6개 뽑아서 발행하는 함수
    public Lotto issueOneLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    // 각 로또의 번호를 정렬하여 반환
    public List<List<Integer>> sortLottos(List<Lotto> lottos) {
        List<List<Integer>> sortedNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            sortedNumbers.add(lotto.sortedNumbers());
        }
        return sortedNumbers;
    }

    // 로또 리스트로 로또별 당첨 랭크를 저장
    public int[] countRank(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        // 등수별 당첨 횟수 저장
        int[] countRank = new int[6];
        for (Lotto lotto : lottos) {
            countRank[lotto.checkRank(lotto.countWinningNumbers(winningNumbers), bonusNumber)]++;
        }
        return countRank;
    }


    // 수익률 계산, cost계산과 profit계산도 분리하자.
    public double calculateEarningRate(int[] countRank) {
        int cost = 0;
        int profit = 0;

        for (int i = 0; i < countRank.length; i++) {
            cost += countRank[i] * 1000;
        }

        // 총 당첨금 계산
        // int 범위 벗어나는거 아니야?
        profit += countRank[1] * 2000000000;
        profit += countRank[2] * 30000000;
        profit += countRank[3] * 1500000;
        profit += countRank[4] * 50000;
        profit += countRank[5] * 5000;

        // 수익률 반환
        return Math.round(((float) profit / cost) * 1000) / 10.0;
    }

}
