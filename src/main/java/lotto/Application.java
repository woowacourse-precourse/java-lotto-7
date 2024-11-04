package lotto;

public class Application {

    public static void main(String[] args) {
        LottoMachine lottoMachine = ObjectGenerator.getLottoMachine();
        lottoMachine.run();
    }
}
