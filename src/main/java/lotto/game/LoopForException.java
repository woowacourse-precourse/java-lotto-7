package lotto.game;

public class LoopForException {
    public void untilStart() {
        boolean success = false;
        while (!success) {
            try {
                new LottoGame().start();
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
