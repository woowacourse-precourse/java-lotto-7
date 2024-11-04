package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<Lotto> purchaseLottos(String inputAmount) {
        try {
            int amount = Integer.parseInt(inputAmount);
            return lottoService.purchaseLottos(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public WinningLotto createWinningLotto(String winningNumbers, String bonusNumber) {
        List<Integer> numbers = parseNumbers(winningNumbers);
        try {
            int bonus = Integer.parseInt(bonusNumber);
            return new WinningLotto(numbers, bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    public Map<PrizeRank, Integer> checkWinning(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottoService.calculateStatistics(lottos, winningLotto);
    }

    public double calculateProfitRate(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottoService.calculateProfitRate(lottos, winningLotto);
    }
}
