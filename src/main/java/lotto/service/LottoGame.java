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
        WinningLotto winningLotto = new WinningLotto(inputNums, inputNum);
        return winningLotto;
    }

    public void announceResult(UserLottos userLottos, WinningLotto winningLotto) {
        LottoResultDto resultDto = calculateResult(userLottos, winningLotto);
        OutputView.printResult(resultDto);
    }

    public LottoResultDto calculateResult(UserLottos userLottos, WinningLotto winningLotto) {
        LottoResultDto resultDto = new LottoResultDto();
        CalculateResultDto calculateResultDto = new CalculateResultDto();
        for (Lotto userLotto : userLottos.getLottos()) {
            checkUserLotto(userLotto.getNumbers(), winningLotto, calculateResultDto);
        }
        int rewardAmount = calculateMatchCount(resultDto, calculateResultDto, userLottos.getLottoCount());
        double profitRate = calculateProfitRate(rewardAmount, userLottos.getTotalPrice());
        System.out.println("test: "+profitRate);
        resultDto.setProfitRate(profitRate);
        return resultDto;
    }

    public double calculateProfitRate(int rewordAmount, int purchasePrice) {
        return Math.round(((double) rewordAmount / purchasePrice) * 100) / 100.0;
    }

    public int calculateMatchCount(LottoResultDto resultDto, CalculateResultDto calculateResultDto, Integer lottoCount) {
        int rewordAmount = 0;

        for (int i = 0; i < lottoCount; i++) {
            if (calculateResultDto.getWinningNumberMatchCount() == 3) {
                rewordAmount += THREE_MATCH_REWARD_AMOUNT;
                resultDto.plusThreeMatchCount();
            }
            if (calculateResultDto.getWinningNumberMatchCount() == 4) {
                rewordAmount += FOUR_MATCH_REWARD_AMOUNT;
                resultDto.plusFourMatchCount();
            }
            if (calculateResultDto.getWinningNumberMatchCount() == 5 && calculateResultDto.getBonusNumberMatchCount() == 1) {
                rewordAmount += FIVE_AND_BONUS_MATCH_REWARD_AMOUNT;
                resultDto.plusFiveAndBonusMatchCount();
            }
            if (calculateResultDto.getWinningNumberMatchCount() == 5 && calculateResultDto.getBonusNumberMatchCount() == 0) {
                rewordAmount += FIVE_MATCH_REWARD_AMOUNT;
                resultDto.plusFiveMatchCount();
            }
            if (calculateResultDto.getWinningNumberMatchCount() == 6) {
                rewordAmount += SIX_MATCH_REWARD_AMOUNT;
                resultDto.plusSixMatchCount();
            }
        }

        return rewordAmount;
    }

    public void checkUserLotto(List<Integer> nums, WinningLotto winningLotto, CalculateResultDto calculateResultDto) {
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> winningNumbers = winningLotto.getWinningNums().getNumbers();
            if (winningNumbers.contains(nums.get(i))) calculateResultDto.plusWinningNumberMatchCount();
            if (winningLotto.getBonusNum() == nums.get(i)) calculateResultDto.plusBonusNumberMatchCount();
        }
    }
}
