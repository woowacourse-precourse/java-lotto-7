package lotto.service;

import lotto.common.error.CustomException;
import lotto.common.error.ErrorMessage;
import lotto.common.view.input.InputView;
import lotto.common.view.output.OutputView;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Winning;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.util.LottoGenerator;

public class LottoService {
    private static final int PURCHASE_UNIT = 1000;
    private static final int LOTTO_SIZE = 6;

    public Lottos getLottos() {
        while (true) {
            try {
                int amount = InputView.getPurchaseAmount();
                return new Lottos(LottoGenerator.getLottos(amount / PURCHASE_UNIT), amount);
            } catch (CustomException e) {
                OutputView.printErrorMessage(e.getErrorMessage());
            }
        }
    }

    public List<Integer> getWinningNumber() {
        while (true) {
            try {
                List<Integer> winning = InputView.getWinningNumber();
                validate(winning);
                return winning;
            } catch (CustomException e) {
                OutputView.printErrorMessage(e.getErrorMessage());
            }
        }
    }

    public Winning getWinning(List<Integer> numbers) {
        while (true) {
            try {
                int bonus = InputView.getBonusNumber();
                return new Winning(numbers, bonus);
            } catch (CustomException e) {
                OutputView.printErrorMessage(e.getErrorMessage());
            }
        }
    }

    public Map<Rank, Long> getWinningDetails(Lottos lottos, Winning winning) {
        List<Rank> ranks = lottos.getRanks(winning);
        return ranks.stream()
                .collect(Collectors.groupingBy(rank -> rank, LinkedHashMap::new, Collectors.counting()));
    }

    public double getProfitRate(Lottos lottos, Winning winning) {
        List<Rank> ranks = lottos.getRanks(winning);
        return calculate(lottos, sum(ranks));
    }

    private static double calculate(Lottos lottos, double sum) {
        return Math.round(sum / lottos.getAmount() * 100 * 10) / 10.0;
    }

    private static double sum(List<Rank> ranks) {
        return ranks.stream()
                .mapToDouble(Rank::getWinningAmount)
                .sum();
    }

    private static void validate(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new CustomException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE.toString());
        }
    }

    private static boolean isDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicate = new HashSet<>(numbers);
        return duplicate.size() < LOTTO_SIZE;
    }
}
