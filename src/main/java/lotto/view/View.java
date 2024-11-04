package lotto.view;

import java.util.List;
import lotto.domain.Lottos;
import lotto.dto.LottoStatisticsDto;

public interface View {

    int getMoney();

    void printLottos(Lottos lottos);

    List<Integer> getWinningNumbers();

    int getBonusNumber();

    void printResult(LottoStatisticsDto result);

}
