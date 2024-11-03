package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.LottoPrize;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.WinningNumberRequestDto;
import lotto.model.Lotto;
import lotto.model.PositiveNumber;
import lotto.service.LottoService;
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

    public void purchaseAll() {
        PositiveNumber amount = getAmount();
        List<Lotto> lottoList = lottoService.purchaseAll(amount);

        outputView.printLotties(lottoList);
    }

    public void getInvestment(Integer inputPrice, Map<LottoPrize, Integer> prizeIntegerMap) {
        double investment = lottoService.getInvestment(inputPrice, prizeIntegerMap);

        outputView.printInvestment(investment);
    }

    private PositiveNumber getAmount() {
        while (true) {
            try {
                return inputView.getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
