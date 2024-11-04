package lotto.view;

import lotto.domain.Lottos;
import lotto.dto.LottoStatisticsDto;

public class CliView implements View {

    private final CliOutputView output;
    private final CliInputView input;

    public CliView(){
        output = new CliOutputView();
        input = new CliInputView();
    }

    @Override
    public String getMoney() {
        return input.getMoney();
    }

    @Override
    public void printLottos(Lottos lottos) {
        output.printLottos(lottos);
    }

    @Override
    public String getWinningNumbers() {
        return input.getWinningNumbers();
    }

    @Override
    public String getBonusNumber() {
        return input.getBonusNumber();
    }

    @Override
    public void printResult(LottoStatisticsDto result) {
        output.printResult(result);
    }

}
