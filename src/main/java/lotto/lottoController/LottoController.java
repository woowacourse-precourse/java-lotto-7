package lotto.lottoController;

import static lotto.lottoModel.HitLotto.getInstance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.lottoModel.HitLotto;
import lotto.lottoModel.HitLottoDAO;
import lotto.lottoModel.HitLottoDTO;
import lotto.lottoModel.LottoDAO;
import lotto.lottoModel.LottoDTO;
import lotto.lottoModel.Lotto;
import lotto.lottoModel.StatisticsLottoDAO;
import lotto.lottoModel.StatisticsLottoDTO;
import lotto.lottoModel.StatisticsLotto;
import lotto.lottoView.InputView;
import lotto.lottoView.LottoPrize;
import lotto.lottoView.OutputView;
import lotto.lottoService.LottoMainService;

import lotto.Utility.LottoNumberGenerator;

public class LottoController {
    private LottoDAO lottoDAO;
    private LottoDTO lottoDTO;
    private InputView inputView;
    private OutputView outputView;
    private LottoNumberGenerator lottoNumberGenerator;
    private HitLottoDAO hitLottoDAO;
    private HitLottoDTO hitLottoDTO;
    private StatisticsLottoDAO statisticsDAO;
    private StatisticsLottoDTO statisticsDTO;
    private LottoMainService lottoMainService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();

        this.lottoMainService = new LottoMainService(lottoDAO, hitLottoDAO,statisticsDAO);
    }

    public void run() {
        String cost = inputView.PrintStartMsg();
        //여기에 유효성 검증

        long calcCost = Long.parseLong(cost);
        outputView.howManyBuy(calcCost / 1000);
        lottoMainService.buyLotto(calcCost);

        List<Lotto> allLottos = lottoDAO.getAll(); //todo: dto로 바꾸기

        for (Lotto lotto : allLottos) { //todo:추후 메서드로 빼낼것
            LottoDTO dto = new LottoDTO(lotto.getNumbers());
            System.out.println(dto.getNumbers()); //todo 아웃뷰?
        }

        String hitLottoInput = inputView.PrintLottoInputMsg();
        String bonusNumberInput = inputView.PrintBonusLottoInputMsg();
        //여기에 유효성 검증

        lottoMainService.saveHitLotto(hitLottoInput, bonusNumberInput);

        HitLottoDTO dto = hitLottoDAO.getAsDTO(); //?

        lottoMainService.retainLotto(allLottos, dto.getAllHitNumbers());

        StatisticsLottoDTO stats = statisticsDAO.getStatisticsAsDTO();
        outputView.statisticStart(stats);

        long sumPrize = lottoMainService.sumPrize(stats);
        double profit = sumPrize / calcCost;
        outputView.profitMessage(profit);


    }

}
