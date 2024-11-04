package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            LottoProgram.run();
        }catch (Exception e){
            Output.printError(e.getMessage());
        }

    }
}
