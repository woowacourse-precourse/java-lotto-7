package lotto.utils;

import static lotto.utils.Constants.ENTER;

import java.util.StringJoiner;
import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.WinnerStatus;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;

public class DtoMapper {

    private DtoMapper() {
    }

    public static ProfitRateResultDto toProfitRateResultDto(String rate) {
        String message = "총 수익률은 " + rate + "%입니다.";

        return new ProfitRateResultDto(message);
    }

    public static MoneyDto toMoneyDto(Money money, long lottoCount) {
        return new MoneyDto(money, ENTER + lottoCount + "개를 구매했습니다.");
    }

    public static WinnerStatusDto toWinnerStatusDto(WinnerStatus winnerStatus, String statusMessage) {
        StringJoiner joiner = new StringJoiner(ENTER);
        joiner.add(ENTER + "당첨 통계")
                .add("---")
                .add(statusMessage);

        return new WinnerStatusDto(winnerStatus, joiner.toString());
    }

    public static LottoListDto toLottoListDto(LottoList lottoList, String listMessage) {
        return new LottoListDto(lottoList, listMessage);
    }
}
