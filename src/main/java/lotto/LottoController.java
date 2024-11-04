package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        //금액 입력 받기
        Output.printPurchaseAmountRequestMessage();
        PurchaseAmount purchaseAmount = Input.getPurchaseAmount();

        //로또 발행 하기
        LottoBuyer lottoBuyer = lottoService.getLottoBuyer(purchaseAmount);

        //발행된 로또 개수 출력
        Output.printNumberRequestMessage(lottoBuyer.getLottoCount());

        //발행된 로또 출력
        Output.printLottos(lottoBuyer.getLottos());

        //당첨 번호 입력 받기
        Output.printWinningNumberRequestMessage();
        WinningNumber winningNumber = Input.getWinningNumber();

        //보너스 번호 입력 받기
        Output.printBonusNumberRequestMessage();
        BonusNumber bonusNumber = Input.getBonusNumber(winningNumber);

        Output.printWinningResultsHeader();
        Output.printLine();

        //결산
        List<LottoWinningRanks> lottoWinningRanks = lottoService.summarizeLottoRanks(
                lottoBuyer.getLottos(),winningNumber, bonusNumber);

        //결산 맵핑
        Map<LottoWinningRanks, Integer> rankCounts = lottoService.summarizeRanksToCounts(lottoWinningRanks);

        //결산 내용 출력
        Output.printLottoRankResult(rankCounts);

        //수익률 계산
        double rateOfReturn = lottoService.calculateRateOfReturn(lottoWinningRanks, lottoBuyer);
        Output.printRateOfReturn(rateOfReturn);
    }
}
