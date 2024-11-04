package lotto.utils;

import static lotto.utils.Constants.ENTER;

import java.util.StringJoiner;
import lotto.dto.LottoTicketsDto;
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

    public static MoneyDto toMoneyDto(long lottoCount) {
        return new MoneyDto(ENTER + lottoCount + "개를 구매했습니다.");
    }

    public static WinnerStatusDto toWinnerStatusDto(String statusMessage) {
        StringJoiner joiner = new StringJoiner(ENTER);
        joiner.add(ENTER + "당첨 통계")
                .add("---")
                .add(statusMessage);

        return new WinnerStatusDto(joiner.toString());
    }

    public static LottoTicketsDto toLottoTicketsDto(String ticketsMessage) {
        return new LottoTicketsDto(ticketsMessage);
    }
}
