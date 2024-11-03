package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.*;

public class LottoService {
    private static final List<Integer> WINNING_PRIZES = List.of(0, 0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);


    public int calculateLottoQuantities(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public List<Integer> generateLottonumbers() {
        while (true) {
            List<Integer> lottoNumbers = new ArrayList<>((Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            if (hasDuplicates(lottoNumbers)) {
                return lottoNumbers;
            }
        }
    }

    private Boolean hasDuplicates(List<Integer> lottoNumbers) {
        Set<Integer> NoDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (NoDuplicateLottoNumbers.size() < 6) {
            return false;
        }
        return true;
    }

    public List<Lotto> issueLottos(int purchaseAmount) {
        int lottoQunatities = calculateLottoQuantities(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQunatities; i++) {
            List<Integer> lottonumbers = sortLottoNumbersAscending(generateLottonumbers());
            System.out.println(lottonumbers);
            Lotto lotto = new Lotto(lottonumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> sortLottoNumbersAscending(List<Integer> lottoNumber) {
        for (int i = 0; i < lottoNumber.size() - 1; i++) {
            for (int j = 0; j < lottoNumber.size() - i - 1; j++) {
                lottoNumber = swap(j, j + 1, lottoNumber);
            }
        }
        return lottoNumber;
    }

    private List<Integer> swap(int idx1, int idx2, List<Integer> arr) {
        if (arr.get(idx1) > arr.get(idx2)) {
            int tmp = arr.get(idx1);
            arr.set(idx1, arr.get(idx2));
            arr.set(idx2, tmp);
        }
        return arr;
    }

    public List<Rank> getRanks(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.getRank(winningNumbers, bonusNumber);
            ranks.add(rank);
        }
        return ranks;
    }

    public Map<Rank, Integer> matchingWinningNumbers(List<Rank> ranks) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        for (Rank rank : ranks) {
            result.put(rank, result.get(rank) + 1);
        }
        return  result;
    }

    public double calculateReturn(List<Rank> ranks, int purchaseAmount) {
        double sum = 0.0;
        for (Rank rank : ranks) {
            sum += rank.getPrize();
        }
        return sum / purchaseAmount * 100;
    }
}
