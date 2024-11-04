package lotto.view;

import java.util.List;
import lotto.domain.Lottos;
import lotto.dto.LottoStatisticsDto;

public class CliView implements View {

    private final CliOutputView output;
    private final CliInputView input;

    public CliView() {
        output = new CliOutputView();
        input = new CliInputView();
    }

    @Override
    public int getMoney() {
        return input.getMoney();
    }

    @Override
    public List<Integer> getWinningNumbers() {
        return input.getWinningNumbers();
    }

    @Override
    public int getBonusNumber() {
        return input.getBonusNumber();
    }

    @Override
    public void printLottos(Lottos lottos) {
        output.printLottos(lottos);
    }

    @Override
    public void printResult(LottoStatisticsDto result) {
        output.printResult(result);
    }

}
