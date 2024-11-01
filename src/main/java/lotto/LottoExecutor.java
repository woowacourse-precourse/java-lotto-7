package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.BonusNumber;
import lotto.input.Cost;
import lotto.input.Input;
import lotto.input.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoExecutor {

    private Cost cost;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private List<Lotto> lottoList;

    public LottoExecutor() {
        this.cost = new Cost();
        this.winningNumber = new WinningNumber();
        this.lottoList = new ArrayList<>();
    }

    public void run() {
        inputValues();
    }

    private void inputValues() {
        validateInput(cost);
        publishLotto(cost.getCost(), lottoList);
        validateInput(winningNumber);
        bonusNumber = new BonusNumber(winningNumber.getLotto().getNumbers());
        validateInput(bonusNumber);
    }

    private void publishLotto(int cost, List<Lotto> lottoList) {
        StringBuilder sb = new StringBuilder();
        int count = cost / 1000;

        for (int i = 0; i < count; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(list));
            printLotto(lottoList.get(i).getNumbers(), sb);
        }

        System.out.println(sb);
    }

    private void printLotto(List<Integer> list, StringBuilder sb) {
        sb.append("[");

        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append(", ");
        }
        sb.append(list.getLast()).append("]\n");
    }

    private void validateInput(Input input) {

        boolean success = false;

        while (!success) {
            try {
                input.validate(Console.readLine());
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
