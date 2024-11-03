package lotto;

public class Application {

    public static void buyLotto() {
        int n = inputAmount();
        makeLotto(n);
        outputLottoNumbers();
    }

    public static void main(String[] args) {
        buyLotto();
    }
}
