package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;

import java.util.*;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSystemConstant.*;
import static lotto.constant.SystemMessage.*;

public class LottoController {
    private static final String DELIMITER = ",";
    private final LottoService lottoService = new LottoService();

    public LottoController() {}

    public void execute() {
        int purchaseAmount = inputPurchaseAmount();
        lottoService.purchaseLottos(purchaseAmount);

        List<Lotto> purchasedLottos = lottoService.getPurchasedLottos();
        printPurchasedLottos(purchasedLottos);

        inputWinningNumbers();
        inputBonusNumber();

        printResult();
    }

    private int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);

        while (true) {
            try {
                String input = Console.readLine();
                int amount = convertToNumber(input);
                validateNonNegativeAmount(amount);
                validateNoChangeAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }
    }

    private void validateNonNegativeAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT);
        }
    }

    private void validateNoChangeAmount(int amount) {
        int change = amount % LOTTO_PRICE;

        if(change != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        StringBuilder message = new StringBuilder();
        String numberOfLottosMessage = NUMBER_OF_PURCHASED_LOTTOS.formatted(lottos.size());
        message.append(numberOfLottosMessage);
        for (Lotto lotto: lottos) {
            message.append(lotto.getNumbers());
            message.append('\n');
        }

        System.out.println(message);
    }

    private void inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT);

        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> winningNumbers = parseNumbers(input);
                Lotto winningLotto = new Lotto(winningNumbers);
                lottoService.setWinningLotto(winningLotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = input.split(DELIMITER);

        for (String splitNumber: splitNumbers) {
            int converted = convertToNumber(splitNumber);
            numbers.add(converted);
        }

        return numbers;
    }

    private void inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT);

        while (true) {
            try {
                String input = Console.readLine();
                int bonus = convertToNumber(input);
                lottoService.setBonusNumber(bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult() {
        StringBuilder result = new StringBuilder(STATS_HEADER);

        Map<Rank, Integer> map = countRanks();
        for (Rank rank: Rank.values()) {
            if(rank == Rank.FAILURE) continue;
            String statsOfRankMessage = statsOfRank(rank, map.get(rank));
            result.append(statsOfRankMessage);
            result.append('\n');
        }

        String statsOfBenefitRateMessage = statsOfBenefitRate();
        result.append(statsOfBenefitRateMessage);

        System.out.println(result);
    }

    private String statsOfRank(Rank rank, int count) {
        String bonusExistMessage = "";
        if(rank.hasBonusNumber()) {
            bonusExistMessage = HAS_BONUS_NUMBER;
        }

        return NUMBER_OF_WON_LOTTOS.formatted(rank.getMatchingNumbers(), bonusExistMessage, rank.getPrize(), count);
    }

    private String statsOfBenefitRate() {
        double benefitRate = lottoService.calculateBenefitRate();

        return TOTAL_BENEFIT_RATE.formatted(benefitRate);
    }

    private Map<Rank, Integer> countRanks() {
        Map<Rank, Integer> counts = new HashMap<>();
        for (Rank rank: Rank.values()) {
            counts.put(rank, 0);
        }

        List<Rank> ranks = lottoService.calculateRankOfLottos();
        for (Rank rank: ranks) {
            counts.compute(rank, (key, value) -> value + 1);
        }

        return counts;
    }
}
