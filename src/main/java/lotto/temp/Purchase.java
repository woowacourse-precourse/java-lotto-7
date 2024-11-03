package lotto.temp;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.util.CommonIo;

import java.util.List;
import java.util.stream.IntStream;

public class Purchase {

    private CommonIo io;

    public Purchase(CommonIo io) {
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

    public List<Lotto> createMultipleLottos(int ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(i -> createSingleLotto())
                .toList();

        return lottos;
    }

    public void printTicketCount(int ticketCount){
        io.printMessage(ticketCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottoNumbers(List<Lotto> lottos){
        lottos.forEach(lotto -> io.printMessage(lotto.toString()));
    }
}
