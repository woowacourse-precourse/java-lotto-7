package lotto;


public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        LottoMachine lottoMachine = new LottoMachine();

        int lottoTry = input.useMoney();
        Lotto winPrice = input.checkNumber();
        int bonus = input.bonus();

        MyLotto myLotto = new MyLotto(winPrice, bonus);

        lottoMachine.action(lottoTry / 1000, myLotto);
        Output.currentLottos(myLotto);

        myLotto.priceResult();

        output.totalPrice(myLotto.priceResult());

    }

}
