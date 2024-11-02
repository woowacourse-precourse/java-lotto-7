package lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    int count;

    ArrayList<List<Integer>> lotto = new ArrayList<>();

    public OutputView(int count, ArrayList<List<Integer>> lotto) {
        this.count = count;
        this.lotto = lotto;
    }

    public void buyCountPrint() {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void lottosPrint() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "OutputView{" +
                "lotto=" + lotto +
                '}';
    }
}
