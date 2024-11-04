package lotto.controller;


import static lotto.common.Constants.LOTTO_PRICE;
import static lotto.common.Messages.RESULT_DIVIDER;
import static lotto.common.Messages.RESULT_TITLE;
import static lotto.common.Messages.TOTAL_PROFIT_RATE_FORMAT;
import static lotto.common.Messages.WINNING_STATISTICS_BONUS_FORMAT;
import static lotto.common.Messages.WINNING_STATISTICS_FORMAT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.service.LottoValidationService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input;
    private final Output output;
    private final LottoValidationService lottoValidationService;

    public LottoController(Input input, Output output, LottoValidationService lottoValidationService) {
        this.input = input;
        this.output = output;
        this.lottoValidationService = lottoValidationService;
    }

    public void run() {
        PurchaseAmount purcharseAmount = requestPurchaseAmount();
        int count = purcharseAmount.calculateLottoCount();
        Lottos lottos = purchaseLotto(count);
        List<Integer> winningNumbers = requestWinningLotto();
        BonusNumber bonusNumber = requestBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        displayResults(winningLotto, bonusNumber, lottos, purcharseAmount);

    }

    private PurchaseAmount requestPurchaseAmount() {
        output.printPurchaseAmountPrompt();
        while (true) {
            try {
                String amountInput = input.getPurchaseAmount();
                int amount = lottoValidationService.validatePurchaseAmount(amountInput);
                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos purchaseLotto(int count) {
        Lottos lottos = Lottos.generateLottos(count);
        output.printLottos(lottos);
        return lottos;
    }

    private List<Integer> requestWinningLotto() {
        output.printWinningLottoPrompt();
        while (true) {
            try {
                String winningLottoInput = input.getWinningLotto();
                return lottoValidationService.validateWinningLotto(winningLottoInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber requestBonusNumber(List<Integer> winningNumbers) {
        output.printBonusNumberPrompt();
        while (true) {
            try {
                String bonusNumberInput = input.getBonusNumber();
                int bonusNumber = lottoValidationService.validateBonusNumber(bonusNumberInput, winningNumbers);
                return new BonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateResults(WinningLotto winningLotto, Lottos lottos) {
        int totalPrize = 0;
        int[] results = new int[LottoRank.values().length];

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = winningLotto.matchCount(lotto);
            boolean bonusMatch = winningLotto.isBonusMatched(lotto);
            LottoRank rank = LottoRank.determineRank(matchCount, bonusMatch);

            results[rank.ordinal()]++;
            totalPrize += rank.getPrize();
        }

        output.printResults(results);

        output.printEarningsRate(totalPrize, lottos.size() * LOTTO_PRICE);
    }

    private void displayResults(WinningLotto winningLotto, BonusNumber bonusNumber, Lottos lottos,
                                PurchaseAmount purcharseAmount) {
        Map<LottoRank, Integer> winnings = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = winningLotto.matchCount(lotto);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.determineRank(matchCount, hasBonus);
            winnings.put(rank, winnings.getOrDefault(rank, 0) + 1);
        }

        System.out.println(RESULT_TITLE);
        System.out.println(RESULT_DIVIDER);

        // 모든 등수를 출력합니다.
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder()) // 역순으로 정렬
                .forEach(rank -> {
                    if (rank == LottoRank.SECOND) {
                        System.out.printf(
                                WINNING_STATISTICS_FORMAT.formatted(rank.getMatchCount(),
                                        String.format("%,d", rank.getPrize()),
                                        winnings.getOrDefault(rank, 0)));
                    } else {
                        System.out.printf(WINNING_STATISTICS_BONUS_FORMAT.formatted(rank.getMatchCount(),
                                String.format("%,d", rank.getPrize()),
                                winnings.getOrDefault(rank, 0)));
                    }
                });

        int totalWinnings = winnings.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = (double) totalWinnings / purcharseAmount.getAmount() * 100;
        System.out.printf(TOTAL_PROFIT_RATE_FORMAT, profitRate);
    }
}
