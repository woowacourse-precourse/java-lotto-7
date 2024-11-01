package lotto;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lotto.buyLotto();
    }
}
