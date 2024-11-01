package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.validator.Validator;

public class LottoService {
    private final Validator validator;

    public LottoService() {
        this.validator = new Validator();
    }

    public int getPayment(String input) {
        try {
            int payment = Integer.parseInt(input);
            validator.validatePayment(payment);
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }
    }

    public List<Integer> getWinningNumbers(String input) {
        String[] splitNumbers = input.split(",");

        try {
            List<Integer> winningNumbers = Arrays.stream(splitNumbers)
                    .map(Integer::parseInt)
                    .toList();
            validator.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }
    }

    public int getBonus(String input) {
        try {
            int bonus = Integer.parseInt(input);
            validator.validateLottoNumber(bonus);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }
    }

    public List<Lotto> issueLottos(int payment) {
        int lottoCount = payment / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> rawLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> lottoNumbers = new ArrayList<>(rawLottoNumbers);
            lottoNumbers.sort(Integer::compareTo);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public Map<Winning, Integer> getWinnings(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        Map<Winning, Integer> countWinnings = new HashMap<>();
        for (Lotto lotto : lottos) {
            Winning winning = lotto.checkWinnings(winningNumbers, bonus);
            countWinnings.put(winning, countWinnings.getOrDefault(winning, 0) + 1);
        }

        return countWinnings;
    }

    public double getYield(int payment, Map<Winning, Integer> winnings) {
        Set<Winning> winningSet = winnings.keySet();
        int totalWinnings = 0;
        for (Winning winning : winningSet) {
            int count = winnings.get(winning);
            totalWinnings += count * winning.getWinnings();
        }

        double yield = totalWinnings / (double) payment;

        return Math.round(yield * 1000) / 10.0;
    }
}
