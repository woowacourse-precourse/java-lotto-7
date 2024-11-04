package lotto;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoGame lottoGame = new LottoGame();
        InputHandler inputHandler = new InputHandler();


        lottoGame.setBuyQuantity(inputHandler.getBuyAmount());

        lottoGame.setLottos();
        lottoGame.getLottosToString();

        lottoGame.setNumbers(inputHandler.getInputNumber());

        lottoGame.setBonusNumber(inputHandler.getBonusNumber());

        LottoResult lottoResult = new LottoResult(lottoGame.getLottos(), lottoGame.getNumbers(),lottoGame.getBonusNumber());
        lottoResult.recordResult();
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoResult.getResult();





    }
}
