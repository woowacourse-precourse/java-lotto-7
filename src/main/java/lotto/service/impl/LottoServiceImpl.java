package lotto.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;

import java.util.*;

public class LottoServiceImpl implements LottoService {
    private Map<Rank, Integer> rankCount = new HashMap<>();
    private List<Lotto> lottos;
    Integer purchaseAmount;

    public LottoServiceImpl(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public void generateLotto() {
        int lottoCount = purchaseAmount / 1_000;
        lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateSingleLotto();
            lottos.add(lotto);
        }
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        printLottos(lottos);
    }

    @Override
    public void printLottos(List<Lotto> lottos) {
        for (Lotto l : lottos) {
            System.out.println(l.getNumbers());
        }
        System.out.println();
    }

    @Override
    public void printWinningStatistics(List<Integer> winningNumbers) {
        int bonusNumber = winningNumbers.getLast();
        winningNumbers.removeLast();
        this.rankCount = countRanks(lottos, winningNumbers, bonusNumber);
        printStatistics(rankCount);
    }

    @Override
    public void printRateOfReturn() {
        Long totalPrize = 0L;

        for (Rank rank : Rank.values()) {
            Integer count = rankCount.get(rank);
            Long prize = (long) rank.getPrize() * count;
            totalPrize += prize;
        }

        double rateOfReturn = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

    private Map<Rank, Integer> countRanks(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(new HashSet<>(lotto.getNumbers()), winningNumbers, bonusNumber);
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }
        return rankCountMap;
    }

    // 등수별 당첨 횟수를 계산하여 반환하는 메소드
    private Rank calculateRank(Set<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }

    private void printStatistics(Map<Rank, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), rankCount.get(rank));
            }

            if (rank != Rank.NONE && rank != Rank.SECOND) {
                System.out.printf("%d개 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), rankCount.get(rank));
            }
        }
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(new ArrayList<>(numbers));
    }
}