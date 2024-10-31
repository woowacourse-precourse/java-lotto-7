package lotto.viewer;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class LottoViewer {

    private final LottoController lottoController;

    public LottoViewer(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public void promptMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String getInput() {
        return Console.readLine();
    }

    public void printLottoCount(String lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
}
