package lotto.controller;

import java.util.List;
import lotto.controller.dto.LotteryStatisticsResultDTO;
import lotto.controller.view.InputView;
import lotto.controller.view.OutputView;
import lotto.controller.view.Validator;
import lotto.domain.gameManager.GameManager;
import lotto.domain.lottery.Lotteries;
import lotto.domain.gameManager.LottoGameManager;
import lotto.domain.statistics.LotteryStatisticsHistory;

public class LottoController {
    private final Policy policy;
    private final InputView inputView;
    private final OutputView outputView;
    private final GameManager gameManager;

    private LottoController(Policy policy, InputView inputView, OutputView outputView,GameManager gameManager) {
        this.policy = policy;
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameManager = gameManager;
    }

    public static LottoController newDefaultInstance(Policy policy){
        return new LottoController(policy, new InputView(Validator.newInstance(policy))
                ,new OutputView(),LottoGameManager.ofInstance(new LottoTierPolicy()));
    }

    public void run(){
        // 구입금액 받기
        int inputAmount = inputView.inputAmount();
        // 로또 객체 생성
        Lotteries boughtLotteries = gameManager.generateLottery(policy, inputAmount);
        // 생성한 로또 객체 출력
        outputView.printLotteries(boughtLotteries);
        // 당첨번호 받기
        List<Integer> winningNumbers = inputView.inputWinningNumber();
        //보너스 번호 받기
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        //수익률 계산
        LotteryStatisticsResultDTO lotteryStatisticsResultDTO = gameManager.checkWinningLottery(inputAmount,
                boughtLotteries, winningNumbers, bonusNumber, LotteryStatisticsHistory.initInstance());
        // 통계 출력
        outputView.printStatisticsResult(lotteryStatisticsResultDTO);

    }


}
