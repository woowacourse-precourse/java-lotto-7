package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final String DATANAME_AMOUNT = "구입금액을";
    static final String DATANAME_WINNINGNUM = "당첨 번호를";
    static final String DATANAME_BONUSNUM = "보너스 번호를";

    static InputHandler inputHandler = new InputHandler();

    public static void main(String[] args) {
        String purchaseAmount = inputHandler.inputData(DATANAME_AMOUNT);

        new LottoGenerator(Integer.parseInt(purchaseAmount));

        inputHandler.inputData(DATANAME_WINNINGNUM);
        inputHandler.inputData(DATANAME_BONUSNUM);

        //당첨 통계 실행
    }
}

class InputHandler {
    final String REQUEST_MESSAGE = " 입력해 주세요.";

    public String inputData(String dataName) {
        System.out.println(dataName + REQUEST_MESSAGE);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

}

class LottoGenerator {
    final int LOTTO_PRICE = 1000;

    List<Lotto> lottoList = new ArrayList<>();

    public LottoGenerator(int price) {
        generateLotto(calculateTickets(price));
        printLottoList();
    }

    private int calculateTickets(int price) {
        return price / LOTTO_PRICE;
    }

    private void generateLotto(int tickets) {
        int count = 0;
        while(count < tickets) {
            lottoList.add(new Lotto());
            count++;
        }
    }

    private void printLottoList() {
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
