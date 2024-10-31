package lotto.utils;

import lotto.domain.Money;
import lotto.domain.WinnerCountList;
import lotto.domain.WinnerStatus;
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
        return new MoneyDto(money, lottoCount + "");
    }

    public static WinnerStatusDto toWinnerStatusDto(WinnerStatus winnerStatus, String message){
        return new WinnerStatusDto(winnerStatus, message);
    }
}
