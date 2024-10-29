package lotto;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        System.out.println();
        user.showLottoCount();
        user.showLottos();

        Committee committee = new Committee();
    }
}
