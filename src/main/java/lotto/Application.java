package lotto;

/**
 * 로또 게임의 실행을 담당하는 클래스
 */
public class Application {

    public static void main(String[] args) {
        try {
            LottoGame game = new LottoGame();
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}