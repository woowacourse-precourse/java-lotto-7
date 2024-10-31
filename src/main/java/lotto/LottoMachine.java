package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<Lotto> lotties;
    private int size;

    public LottoMachine() {
        boolean charged = false;
        while (!charged) {
            charged = initMoney();
        }
    }

    public List<Lotto> issueRandomLotto() {
        lotties = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lotties.add(new Lotto(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        printLotties();
        return lotties;
    }

    private void printLotties() {
        System.out.println("\n" + lotties.size() + "개를 구매했습니다.");
        lotties.forEach(System.out::println);
    }

    private boolean initMoney() {
        long payment;
        try {
            payment = Long.parseLong(getInput("구입금액을 입력해 주세요."));
            validatePayment(payment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        this.size = (int) payment / 1000;
        return true;
    }

    private void validatePayment(long payment) {
        if (payment < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액으로 음수는 입력할 수 없습니다.");
        }
        validateThousandUnitAmount(payment);
    }

    private void validateThousandUnitAmount(long payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 단위로 입력해주세요.");
        }
    }

    private String getInput(String output) {
        System.out.println(output);
        return Console.readLine();
    }
}
