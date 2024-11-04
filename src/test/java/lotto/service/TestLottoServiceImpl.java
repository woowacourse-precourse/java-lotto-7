package lotto.service;

import lotto.domain.*;
import lotto.generator.MockRandomLottoNumberGenerator;

import java.util.List;

public class TestLottoServiceImpl implements LottoService {
    private static final int TEST_LOTTO_COUNT = 1;

    private final List<Integer> fixedLottoNumbers;
    private final List<Integer> fixedWinningNumbers;
    private final int fixedBonusNumber;

    public TestLottoServiceImpl(List<Integer> fixedLottoNumbers, List<Integer> fixedWinningNumbers, int fixedBonusNumber) {
        this.fixedLottoNumbers = fixedLottoNumbers;
        this.fixedWinningNumbers = fixedWinningNumbers;
        this.fixedBonusNumber = fixedBonusNumber;
    }

    @Override
    public LottoTicket generateLottoTicket(String purchaseAmountInput) {
        MockRandomLottoNumberGenerator generator = new MockRandomLottoNumberGenerator(fixedLottoNumbers);
        return new LottoTicket(generator, TEST_LOTTO_COUNT);
    }

    @Override
    public WinningLotto createWinningLotto(Lotto winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    @Override
    public Lotto parseAndValidateWinningNumbers(String winningNumbersInput) {
        return new Lotto(fixedWinningNumbers);
    }

    @Override
    public int parseAndValidateBonusNumber(String bonusNumberInput, Lotto winningNumbers) {
        return fixedBonusNumber;
    }

    @Override
    public LottoResult createLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto, String purchaseAmountInput) {
        LottoResult result = new LottoResult();
        lottoTicket.getLottos().forEach(lotto -> {
            Rank rank = calculateRank(lotto, winningLotto);
            result.addResult(rank);
        });
        result.calculateReturnOnInvestment(Integer.parseInt(purchaseAmountInput));
        return result;
    }

    private Rank calculateRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getWinningNumbers().getNumbers()::contains)
                .count();
        boolean isBonusMatched = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return Rank.valueOf(matchCount, isBonusMatched);
    }
}