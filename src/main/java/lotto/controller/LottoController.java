package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.converter.StringToIntegerConverter;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.dto.LottoNumberDto;
import lotto.enums.ErrorMessage;
import lotto.enums.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        Money purchaseAmount = getPurchaseAmount();

        List<Lotto> purchasedLotto = getLottoNumbers(purchaseAmount);
        List<LottoNumberDto> purchasedLottoNumberSets = getLottoNumberDtos(purchasedLotto);
        OutputView.printPurchaseLottoNumbers(purchasedLottoNumberSets);

        Lotto winningLotto = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();
        validateBonusNumberNotInWinningLotto(winningLotto, bonusNumber);

        Map<Rank, Long> statistics = getWinningStatistics(purchasedLotto, winningLotto, bonusNumber);
        double profitRate = calculateProfitRate(statistics, purchaseAmount.getAmount());
        OutputView.printStatistics(statistics, profitRate);
    }

    private Map<Rank, Long> getWinningStatistics(List<Lotto> purchasedLotto, Lotto winningLotto,
                                                 BonusNumber bonusNumber) {
        return purchasedLotto.stream()
                .map(lotto -> {
                    int matchCount = winningLotto.matchCount(lotto);
                    boolean bonusMatch = lotto.contains(bonusNumber.getNumber());
                    return Rank.valueOf(matchCount, bonusMatch);
                })
                .filter(rank -> rank != Rank.NONE)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private double calculateProfitRate(Map<Rank, Long> statistics, int purchaseAmount) {
        long totalPrize = statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private void validateBonusNumberNotInWinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_WITH_LOTTO.getMessage());
        }
    }

    private BonusNumber getBonusNumber() {
        while (true) {
            try {
                OutputView.printBonusNumberInputMessage();
                String bonusNumberInput = InputView.inputBonusNumber();
                int bonusNumber = StringToIntegerConverter.convert(bonusNumberInput);
                return BonusNumber.from(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningNumber() {
        while (true) {
            try {
                OutputView.printWinningNumberInputMessage();
                String winningNumberInput = InputView.inputWinningNumber();
                List<Integer> winningNumbers = Arrays.stream(winningNumberInput.split(","))
                        .map(StringToIntegerConverter::convert)
                        .toList();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<LottoNumberDto> getLottoNumberDtos(List<Lotto> purchasedLotto) {
        return purchasedLotto.stream()
                .map(lotto -> new LottoNumberDto(lotto.getNumbers()))
                .toList();
    }

    private List<Lotto> getLottoNumbers(Money purchaseAmount) {
        return Stream.generate(lottoMachine::generateLotto)
                .limit(purchaseAmount.getPurchaseCount())
                .toList();
    }

    private Money getPurchaseAmount() {
        while (true) {
            try {
                OutputView.printPurchaseAmountInputMessage();
                String purchaseAmountInput = InputView.inputPurchaseAmount();
                int purchaseAmount = StringToIntegerConverter.convert(purchaseAmountInput);
                return Money.from(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
