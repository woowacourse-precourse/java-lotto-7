package lotto;

public class Application {

    public static void main(String[] args) {
        User user = InputHandler.inputUserMoney();
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        user.buyLotto(randomNumbersGenerator);

        Lotto lotto = InputHandler.inputWinningNumbers();
        LottoMachine lottoMachine = InputHandler.inputBonusNumbers(lotto);
        user.calculateFinalPrice(lottoMachine);
    }
}
