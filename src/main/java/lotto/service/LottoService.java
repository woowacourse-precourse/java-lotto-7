package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.common.constants.Constants;
import lotto.common.constants.ErrorMessages;
import lotto.common.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.common.Winning;
import lotto.validator.Validator;

public class LottoService {
    private final Validator validator;

    public LottoService() {
        this.validator = new Validator();
    }

    public int parsePayment(String input) {
        try {
            int payment = Integer.parseInt(input);
            validator.validatePayment(payment);
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_FORMAT);
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
        String[] splitNumbers = split(input);
        try {
            List<Integer> winningNumbers = Arrays.stream(splitNumbers)
                    .map(Integer::parseInt)
                    .toList();
            validator.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_FORMAT);
        }
    }

    public int parseBonus(String input) {
        try {
            int bonus = Integer.parseInt(input);
            validator.validateLottoNumber(bonus);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_FORMAT);
        }
    }

    public List<Lotto> issueLottos(int payment) {
        int lottoCount = payment / LottoConstants.PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.NUMBER_START,
                    LottoConstants.NUMBER_END,
                    LottoConstants.SIZE);

            List<Integer> lottoNumbers = new ArrayList<>(randomNumbers);
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

    public double calculateYield(int payment, int totalWinnings) {
        double yield = totalWinnings / (double) payment;

        return Math.round(yield * 1000) / 10.0;
    }

    public int calculateTotalWinnings(Map<Winning, Integer> winnings) {
        Set<Winning> winningSet = winnings.keySet();
        int totalWinnings = 0;

        for (Winning winning : winningSet) {
            int count = winnings.get(winning);
            totalWinnings += count * winning.getPrize();
        }

        return totalWinnings;
    }

    private String[] split(String input) {
        return input.replaceAll(Constants.SPACE, Constants.EMPTY_STRING).split(Constants.DELIMITER);
    }
}
