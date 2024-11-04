package lotto.view;

import lotto.domain.Lottos;
import lotto.dto.LottoStatisticsDto;

public interface View {

    String getMoney();

    void printLottos(Lottos lottos);

    String getWinningNumbers();

    String getBonusNumber();

    void printResult(LottoStatisticsDto result);

}
