package lotto;

public class Application {
    public static void main(String[] args) {

    }

    public void StartBuyingLotto() {
        System.out.println("구입금액을 입력해 주세요.");


        try {
            UserInput = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }
    }
}
