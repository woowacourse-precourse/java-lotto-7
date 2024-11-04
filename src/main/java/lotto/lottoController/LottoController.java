package lotto.lottoController;

import java.util.List;
import lotto.lottoModel.HitLottoDTO;
import lotto.lottoModel.LottoDTO;
import lotto.lottoModel.StatisticsLottoDTO;
import lotto.lottoView.InputView;
import lotto.lottoView.OutputView;
import lotto.lottoService.LottoMainService;


public class LottoController {
    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final static int ONE_HUNDRED = 100;

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
        buyAndPrintLotto(cost); //로또 구매 개수 및 번호 생성 저장
        List<LottoDTO> allLottosAsDTO = lottoMainService.getAllLottosAsDTO(); // 로또 번호 객체 DTO로 가져옴
        outputView.printLottoNumbers(allLottosAsDTO); // 로또 번호 공개
        processHitNumbers(); // 당첨 번호 및 보너스 번호 입력 및 저장
        HitLottoDTO dto = lottoMainService.getAllHitLottosAsDTO(); // 당첨 번호 객체 DTO로 가져옴
        lottoMainService.retainLotto(allLottosAsDTO, dto.getAllHitNumbers()); // 로또 번호와 당첨 번호 비교 및 통계 갱신
        calculateAndDisplayStatistics(cost); // 통계 공개
    }

    private String getValidatedCost() { // 구매 비용 유효성 검증
        while (true) {
            String cost = inputView.PrintStartMsg();
            try {
                exceptionController.isValidCost(cost);  // 비용에 대한 유효성 검사 호출
                return cost;  // 유효하면 반환
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + e.getMessage());// 에러 메시지 출력 후 재입력 요청
            }
        }
    }

    private void buyAndPrintLotto(String cost) {
        outputView.howManyBuy(cost); // #개 구매 메시지
        lottoMainService.buyLotto(cost); // 로또 실제 구매 및 저장
    }

    private void processHitNumbers() {
        String hitLottoInput = getValidatedHitLotto(); // 당첨 번호 유효성 검사
        List<Integer> hitLotto = lottoMainService.covertHitLotto(hitLottoInput); //당첨 번호 리스트 변환
        String bonusNumberInput = getValidateBonusNumber(hitLotto); // 보너스 번호 유효성 검사
        lottoMainService.saveHitLotto(hitLotto, bonusNumberInput); //당첨 번호 저장
    }

    private String getValidatedHitLotto() { // 당첨 번호 유효성 검사
        while (true) {
            String hitLottoInput = inputView.PrintLottoInputMsg();
            try {
                exceptionController.isValidHitNumbers(hitLottoInput);
                return hitLottoInput;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + e.getMessage());
            }
        }
    }

    private String getValidateBonusNumber(List<Integer> hitLottoInput) { // 보너스 번호 유효성 검사
        while (true) {
            String bonusNumberInput = inputView.PrintBonusLottoInputMsg();
            try {
                exceptionController.isValidBonusNumbers(bonusNumberInput, hitLottoInput);
                return bonusNumberInput;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + e.getMessage());
            }
        }
    }


    private void calculateAndDisplayStatistics(String cost) {
        StatisticsLottoDTO stats = lottoMainService.getAllStatisticsAsDTO(); // 통계 객체 DTO로 가져옴
        outputView.statisticStart(stats); // 통계 공개
        double profit = lottoMainService.sumPrize(stats, cost); // 수익 계산
        outputView.profitMessage(profit * ONE_HUNDRED); //수익 공개
    }
}
