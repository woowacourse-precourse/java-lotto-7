package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;

public class LottoServiceImpl implements LottoService{
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
    public double computeProfitRate(String purchaseAmount, String winningNumbers, String bonusNumber) {
        int numericPurchaseAmount = parseNumeric(purchaseAmount);

        lottoRepository.generateRandomLottos(numericPurchaseAmount);
        return (double) lottoRepository.findTotalPrizeByWinningNumbersAndBonusNumber(
                parseIntegerList(winningNumbers),
                Integer.parseInt(bonusNumber)
        ) / numericPurchaseAmount;
    }

    private int parseNumeric(String stringInput) {
        return Integer.parseInt(stringInput);
    }

    private List<Integer> parseIntegerList(String stringInput) {
        return Arrays.stream(stringInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
