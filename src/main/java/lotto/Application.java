package lotto;

public class Application {
    private InputHandler inputHandler;
    public Application(){
        inputHandler = new InputHandler();
    }
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run(){
        int price = inputHandler.priceInput();
        int purchasedLottoCount= price/1000;
        System.out.println(purchasedLottoCount+"개를 구매했습니다.");
    }
}
