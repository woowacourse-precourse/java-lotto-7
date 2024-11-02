package lotto.temp;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.CommonIo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTemp {
    private final CommonIo io;

    public LottoTemp(CommonIo io) {
        this.io = io;
    }

    public void printRequestPurchase() {
        io.printMessage("구입금액을 입력해 주세요.");
    }

    public String inputPurchaseAmount() {
        return io.receiveInput();
    }

    public int convertInputToInt(String input) {
        return io.convertStringToInt(input);
    }

    public int convertMoneyToTicket(int amount) {
        return amount / 1000;
    }

    public Lotto createSingleLotto() {
        List<Integer> singleLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(singleLottoNumber);
    }

}
