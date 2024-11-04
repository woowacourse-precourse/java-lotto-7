package lotto.view;

import java.util.List;

public class OutputView {
    public void println(String message) {
        System.out.println(message);
    }

    public void newLine() {
        System.out.println();
    }

    public void printList(List<Integer> list) {
        System.out.println(list);
    }
}
