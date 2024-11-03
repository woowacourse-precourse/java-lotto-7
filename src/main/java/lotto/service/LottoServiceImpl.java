package lotto.service;

import static lotto.config.LottoConstants.LOTTO_PRICE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.LottoRule;
import lotto.model.Lotto;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;

    private LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    private static class Holder {
        private static final LottoServiceImpl INSTANCE =
                new LottoServiceImpl(InMemoryLottoRepository.getInstance());
    }

    public static LottoServiceImpl getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void purchaseLotto(String purchaseAmount) {
        int numericPurchaseAmount = safeParsePurchaseAmount(purchaseAmount);

        lottoRepository.generateRandomLottos(numericPurchaseAmount);
    }

    @Override
    public List<String> generateLottoLogs() {
        return lottoRepository.findAll()
                .stream()
                .map(Lotto::toString)
                .toList();
    }

    @Override
    public double computeProfitRate(String purchaseAmount, String winningNumbers, String bonusNumber) {
        return (double) lottoRepository.generatePrizeStreamBy(
                parseIntegerList(winningNumbers),
                        Integer.parseInt(bonusNumber)
                )
                .map(LottoRule::getPrize)
                .mapToInt(Integer::intValue)
                .sum()
                / safeParsePurchaseAmount(purchaseAmount);
    }

    @Override
    public List<String> generateWinningReport(String winningNumbers, String bonusNumber) {
        Map<Object, Long> prizeCountMap = lottoRepository.generatePrizeStreamBy(
                parseIntegerList(winningNumbers),
                Integer.parseInt(bonusNumber))
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        return Arrays.stream(LottoRule.values())
                .filter(i -> i != LottoRule.NONE)
                .sorted(Comparator.reverseOrder())
                .map(i -> String.format("%d개 일치%s (%s원) - %d개",
                        i.getMatchCount(),
                        i.isHasBonus() ? ", 보너스 볼 일치" : "",
                        String.format("%,d", i.getPrize()),
                        prizeCountMap.getOrDefault(i, 0L)))
                .toList();
    }

    private int safeParsePurchaseAmount(String stringInput) {
        validateNullInput(stringInput);
        try {
            int amount = Integer.parseInt(stringInput);
            validatePositive(amount);
            validateDivisibleByLottoPrice(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 숫자를 입력해주세요.", e);
        }
    }

    private List<Integer> parseIntegerList(String stringInput) {
        return Arrays.stream(stringInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNullInput(String stringInput) {
        if (stringInput == null || stringInput.isEmpty()) {
            throw new IllegalArgumentException("구입 금액은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 이상의 양수여야 합니다.");
        }
    }

    private void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
