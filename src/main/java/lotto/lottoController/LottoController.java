package lotto.lottoController;

import java.util.List;
import lotto.lottoModel.HitLottoDTO;
import lotto.lottoModel.LottoDTO;
import lotto.lottoModel.StatisticsLottoDTO;
import lotto.lottoView.InputView;
import lotto.lottoView.OutputView;
import lotto.lottoService.LottoMainService;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMainService lottoMainService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();


        this.lottoMainService = new LottoMainService();
    }

    public void run() {
        String cost = inputView.PrintStartMsg();
        //여기에 유효성 검증
        outputView.howManyBuy(cost);
        lottoMainService.buyLotto(cost);
        List<LottoDTO> allLottosAsDTO = lottoMainService.getAllLottosAsDTO();
        outputView.printLottoNumbers(allLottosAsDTO);
        String hitLottoInput = inputView.PrintLottoInputMsg();
        String bonusNumberInput = inputView.PrintBonusLottoInputMsg();
        //여기에 유효성 검증
        lottoMainService.saveHitLotto(hitLottoInput, bonusNumberInput);
        HitLottoDTO dto = lottoMainService.getAllHitLottosAsDTO();
        lottoMainService.retainLotto(allLottosAsDTO, dto.getAllHitNumbers());
        StatisticsLottoDTO stats = lottoMainService.getAllStatisticsAsDTO();
        outputView.statisticStart(stats);
        double profit = lottoMainService.sumPrize(stats,cost);
        outputView.profitMessage(profit);
    }

}
