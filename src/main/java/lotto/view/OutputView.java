package lotto.view;

import lotto.util.CommonIo;

public class OutputView {
    private final CommonIo io;

    public OutputView(CommonIo io) {
        this.io = io;
    }

    public void printTicketCount(int ticketCount){
        io.printMessage(ticketCount + "개를 구매했습니다.");
    }

    public void printStaticsFormat(){
        io.printMessage("당첨 통계");
        io.printMessage("---");
    }

}
