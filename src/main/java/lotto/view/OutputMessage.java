package lotto.view;

import lotto.domain.WinningInfo;

public enum OutputMessage {

    OUTPUT_PURCHASE_QUANTITY("\n%d개를 구매했습니다."),
    OUTPUT_EXCEPT_SECOND_PLACE_RESULT("%d개 일치 (%,d원) - %d개"),
    OUTPUT_SECOND_PLACE_RESULT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    OUTPUT_EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String messageTemplate;

    OutputMessage(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    static String formatWinningResult(WinningInfo info) {
        if (info != WinningInfo.SECOND) {
            return OUTPUT_EXCEPT_SECOND_PLACE_RESULT.format(info.getMatchingNumberCount(), info.getPrizeMoney(),
                    info.getWinningTicketCount());
        }
        return OUTPUT_SECOND_PLACE_RESULT.format(info.getMatchingNumberCount(), info.getPrizeMoney(),
                info.getWinningTicketCount());
    }

    public String format(Object... args) {
        return String.format(messageTemplate, args);
    }

}


