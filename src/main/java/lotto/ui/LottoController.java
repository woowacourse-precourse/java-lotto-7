package lotto.ui;

import java.util.List;
import lotto.app.LottoService;
import lotto.app.dto.LottoPurchaseResponseDto;
import lotto.app.dto.LottoResultDto;
import lotto.app.dto.WinningNumberRequestDto;
import lotto.domain.Lotto;
import lotto.domain.PositiveNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public List<LottoResultDto> getResult(List<Lotto> lottoList) {
        WinningNumberRequestDto dto = inputView.getEntireNumber();
        List<LottoResultDto> dtoList = lottoService.getResult(dto, lottoList);

        outputView.printResult(dtoList);
        return dtoList;
    }

    public LottoPurchaseResponseDto purchaseAll() {
        PositiveNumber price = getPrice();
        PositiveNumber amount = price.divide(1000L);
        List<Lotto> lottoList = lottoService.purchaseAll(amount);

        outputView.printLotties(lottoList);
        return new LottoPurchaseResponseDto(price, lottoList);
    }

    public void getInvestment(PositiveNumber inputPrice, List<LottoResultDto> dto) {
        double investment = lottoService.getInvestment(inputPrice, dto);

        outputView.printInvestment(investment);
    }

    private PositiveNumber getPrice() {
        return inputView.getPrice();
    }
}
