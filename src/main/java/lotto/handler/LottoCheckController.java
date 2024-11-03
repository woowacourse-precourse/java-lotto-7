package lotto.handler;

import java.util.List;
import java.util.Map;
import lotto.LottoPrize;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.WinningNumberRequestDto;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCheckController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoCheckController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void getResult(List<Lotto> lottoList) {
        WinningNumberRequestDto dto = inputView.getEntireNumber();
        Lotto winningLotto = new Lotto(dto.winningNumbers());

        Map<LottoPrize, Integer> lottoPrizeResult = LottoPrize
            .createLottoPrizeResult(lottoList, winningLotto, dto.bonusNumber());

        List<LottoResultResponseDto> dtoList = lottoPrizeResult.entrySet().stream()
            .map(entry -> new LottoResultResponseDto(
                entry.getKey().getWinningCount(),
                entry.getKey().getPrize(),
                entry.getValue()))
            .toList();

        outputView.printResult(dtoList);
    }
}
