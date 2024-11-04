package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Machine machine = new Machine();
        try {
            machine.init();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
