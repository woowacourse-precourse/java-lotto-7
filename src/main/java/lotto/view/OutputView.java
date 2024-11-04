package lotto.view;

import lotto.model.Rank;
import lotto.util.CommonIo;
import lotto.util.Message;

import java.text.NumberFormat;

public class OutputView {
    private final CommonIo io;

    public OutputView(CommonIo io) {
        this.io = io;
    }

    public void printTicketCount(int ticketCount){
        io.printMessage(ticketCount + Message.TICKET_PURCHASE_RESULT.getSentence());
    }

    public void printStaticsFormat(){
        io.printMessage(Message.STATICS.getSentence());
        io.printMessage(Message.THREE_DASH.getSentence());
    }

    public void printWinningResult(int matchCount, int prize, int rankCount){
        String formattedPrize = NumberFormat.getInstance().format(prize);
        if(prize == Rank.SECOND.getPrize()){
            io.printMessage(matchCount + Message.MATCH_COUNT_WITH_BONUS_NUMBER.getSentence()
                    + formattedPrize + Message.MONEY_UNIT.getSentence() + rankCount + Message.COUNT_UNIT.getSentence());
        }
        if(prize != Rank.SECOND.getPrize()){
            io.printMessage(matchCount +Message.MATCH_COUNT.getSentence()
                    + formattedPrize + Message.MONEY_UNIT.getSentence() + rankCount + Message.COUNT_UNIT.getSentence());
        }
    }

    public void printProfit(float profit) {
        io.printMessage(Message.PROFIT_PREFIX.getSentence() + profit + Message.PROFIT_SUFFIX.getSentence());
    }

}
