package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrize;
import lotto.app.dto.LottoResultResponseDto;
import lotto.app.dto.WinningNumberRequestDto;
import lotto.domain.Lotto;
import lotto.domain.PositiveNumber;
import lotto.app.LottoService;
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

    public void getResult(List<Lotto> lottoList) {
        WinningNumberRequestDto dto = inputView.getEntireNumber();
        List<LottoResultResponseDto> dtoList = lottoService.getResult(dto, lottoList);

        outputView.printResult(dtoList);
    }

    public PositiveNumber purchaseAll() {
        PositiveNumber price = getPrice();
        PositiveNumber amount = price.divide(1000L);
        List<Lotto> lottoList = lottoService.purchaseAll(amount);

        outputView.printLotties(lottoList);
        return price;
    }

    public void getInvestment(Integer inputPrice, Map<LottoPrize, Integer> prizeIntegerMap) {
        double investment = lottoService.getInvestment(inputPrice, prizeIntegerMap);

        outputView.printInvestment(investment);
    }

    private PositiveNumber getPrice() {
        while (true) {
            try {
                return inputView.getPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
