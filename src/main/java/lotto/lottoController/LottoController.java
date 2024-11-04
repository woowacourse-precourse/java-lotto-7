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
    private ExceptionController exceptionController;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMainService = new LottoMainService();
        this.exceptionController = new ExceptionController();
    }

    public void run() {
        String cost = getValidatedCost(); // 유효성 검증
        buyAndPrintLotto(cost);

        List<LottoDTO> allLottosAsDTO = lottoMainService.getAllLottosAsDTO();
        outputView.printLottoNumbers(allLottosAsDTO);
        processHitNumbers();
        HitLottoDTO dto = lottoMainService.getAllHitLottosAsDTO();
        lottoMainService.retainLotto(allLottosAsDTO, dto.getAllHitNumbers());
        StatisticsLottoDTO stats = lottoMainService.getAllStatisticsAsDTO();
        outputView.statisticStart(stats);
        double profit = lottoMainService.sumPrize(stats,cost);
        outputView.profitMessage(profit*100);
    }

    private String getValidatedCost(){
        while (true) {
            String cost = inputView.PrintStartMsg();
            try {
                exceptionController.isValidCost(cost);  // 비용에 대한 유효성 검사 호출
                return cost;  // 유효하면 반환
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] "+e.getMessage());// 에러 메시지 출력 후 재입력 요청
            }
        }
    }

    private void buyAndPrintLotto(String cost){
        outputView.howManyBuy(cost);
        lottoMainService.buyLotto(cost);
    }

    private void processHitNumbers() {
        String hitLottoInput = getValidatedHitLotto();
        String bonusNumberInput = inputView.PrintBonusLottoInputMsg();

        // 유효성 검증 추가

        lottoMainService.saveHitLotto(hitLottoInput, bonusNumberInput);
    }

    private String getValidatedHitLotto(){
        while(true){
            String hitLottoInput = inputView.PrintLottoInputMsg();
            try{
                exceptionController.isValidHitNumbers(hitLottoInput);
                return hitLottoInput;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }


    private void calculateAndDisplayStatistics(String cost) {
        StatisticsLottoDTO stats = lottoMainService.getAllStatisticsAsDTO();

        outputView.statisticStart(stats);

        double profit = lottoMainService.sumPrize(stats, cost);

        outputView.profitMessage(profit);
    }
}
