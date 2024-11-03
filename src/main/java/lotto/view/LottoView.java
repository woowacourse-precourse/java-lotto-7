package lotto.view;

import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.WinningDto;

public class LottoView {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoView() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public LottoDto initLottoGame() {
        int priceInput = inputView.buyLottoPriceInput();
        List<Lotto> lottos = createRandomLottoNumbers(priceInput);
        outputView.buyOutput(priceInput, lottos);

        List<Integer> winningNumbers = inputView.winningNumberInput();
        int bonusNumber = inputView.bonusNumber(winningNumbers);

        return LottoDto.of(lottos, winningNumbers, bonusNumber);
    }

    private List<Lotto> createRandomLottoNumbers(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.createNumber())
                .toList();
    }

    public void displayResults(WinningDto winningDto) {
        outputView.winningStatisticsOutput(winningDto);
    }

}