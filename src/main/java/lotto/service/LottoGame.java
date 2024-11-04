package lotto.service;

import lotto.dto.CalculateResultDto;
import lotto.dto.LottoResultDto;
import lotto.model.Lotto;
import lotto.model.UserLottos;
import lotto.model.WinningLotto;
import lotto.provider.InputNumberProvider;
import lotto.provider.NumberProvider;
import lotto.util.RetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {
    private final int THREE_MATCH_REWARD_AMOUNT = 5000;
    private final int FOUR_MATCH_REWARD_AMOUNT = 50000;
    private final int FIVE_MATCH_REWARD_AMOUNT = 1500000;
    private final int FIVE_AND_BONUS_MATCH_REWARD_AMOUNT = 30000000;
    private final int SIX_MATCH_REWARD_AMOUNT = 2000000000;
    private final NumberProvider numberProvider;

    public LottoGame() {
        this.numberProvider = new InputNumberProvider();
    }

    public WinningLotto generateWinningLotto() {
        List<Integer> inputNums = numberProvider.getNumbers();
        int inputNum = RetryHandler.retryUntilSuccess(() -> InputView.getBonusNum());
        return new WinningLotto(inputNums, inputNum);
    }

    public void announceResult(UserLottos userLottos, WinningLotto winningLotto) {
        LottoResultDto resultDto = calculateResult(userLottos, winningLotto);
        OutputView.printResult(resultDto);
    }

    public LottoResultDto calculateResult(UserLottos userLottos, WinningLotto winningLotto) {
        LottoResultDto resultDto = new LottoResultDto();
        int totalRewardAmount = 0;

        for (Lotto userLotto : userLottos.getLottos()) {
            CalculateResultDto calculateResultDto = new CalculateResultDto();
            checkUserLotto(userLotto.getNumbers(), winningLotto, calculateResultDto);
            totalRewardAmount += calculateMatchAmount(resultDto, calculateResultDto);
        }

        double profitRate = calculateProfitRate(totalRewardAmount, userLottos.getTotalPrice());
        resultDto.setProfitRate(profitRate);
        return resultDto;
    }

    private int calculateMatchAmount(LottoResultDto resultDto, CalculateResultDto calculateResultDto) {
        int matchCount = calculateResultDto.getWinningNumberMatchCount();
        int bonusMatch = calculateResultDto.getBonusNumberMatchCount();

        if (matchCount == 3) {
            resultDto.plusThreeMatchCount();
            return THREE_MATCH_REWARD_AMOUNT;
        }
        if (matchCount == 4) {
            resultDto.plusFourMatchCount();
            return FOUR_MATCH_REWARD_AMOUNT;
        }
        if (matchCount == 5 && bonusMatch == 1) {
            resultDto.plusFiveAndBonusMatchCount();
            return FIVE_AND_BONUS_MATCH_REWARD_AMOUNT;
        }
        if (matchCount == 5 && bonusMatch == 0) {
            resultDto.plusFiveMatchCount();
            return FIVE_MATCH_REWARD_AMOUNT;
        }
        if (matchCount == 6) {
            resultDto.plusSixMatchCount();
            return SIX_MATCH_REWARD_AMOUNT;
        }
        return 0;
    }

    public double calculateProfitRate(int rewordAmount, int purchasePrice) {
        return Math.round(((double) rewordAmount * 100 / purchasePrice) * 10) / 10.0;
    }

    public void checkUserLotto(List<Integer> nums, WinningLotto winningLotto, CalculateResultDto calculateResultDto) {
        for (Integer num : nums) {
            if (winningLotto.getWinningNums().getNumbers().contains(num)) {
                calculateResultDto.plusWinningNumberMatchCount();
            }
            if (winningLotto.getBonusNum() == num) {
                calculateResultDto.plusBonusNumberMatchCount();
            }
        }
    }
}