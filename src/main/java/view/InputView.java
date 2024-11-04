package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private InputView() {}

    public static String getInputBudget() {
        System.out.println(ViewMessage.INPUT_BUDGET_MESSAGE);
        return Console.readLine();
    }

    public static void printQuantity(int quantity) {
        System.out.println(quantity + ViewMessage.PURCHASE_RESULT_MESSAGE);
    }

    public static void printLottos(ArrayList<List<Integer>> lottos) {
        StringBuilder resultLottos = new StringBuilder();
        for(List<Integer> lotto : lottos) {
            resultLottos.append(writeSingleLotto(lotto));
        }
        System.out.println(resultLottos);
    }

    public static String writeSingleLotto(List<Integer> lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer i : lotto) {
            sb.append(i).append(", ");
        }
        sb.append(lotto.get(5)).append("]\n");
        return sb.toString();
    }
}
