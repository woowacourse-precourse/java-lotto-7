package lotto;

public class Application {
    public static void main(String[] args) {

        LottoGameSetter lottoGameSetter = new LottoGameSetter();
        LottoGame lottoGame = lottoGameSetter.set();

        LottoGameRunner gameRunner = LottoGameRunner.from(lottoGame);
        gameRunner.run();
    }
}
