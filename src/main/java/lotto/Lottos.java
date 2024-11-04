package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private ArrayList<List<Integer>> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public static void sortLottos(ArrayList<List<Integer>> lottos) {
        for(List<Integer> lotto : lottos) {
            sortLotto(lotto);
        }
    }

    private static void sortLotto(List<Integer> lotto) {
        Collections.sort(lotto);
    }
}
