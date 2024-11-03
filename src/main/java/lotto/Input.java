package lotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Input {
    private final Scanner scanner;

    public Input() {this.scanner = new Scanner(System.in);}

    public Integer getMoney() {
        System.out.println("로또 구매에 얼마를 지불 하실 건가요?");
        Integer money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public List<Integer> getPrizeNumbers() {
        System.out.println("당첨 번호는 뭔가요? (쉼표로 구분)");
        String input = scanner.nextLine();
        return Stream.of(input.split(",")).map(String::trim).map(Integer::parseInt).toList();
    }

    public Integer getBonus() {
        System.out.println("보너스 숫자는 무엇인가요?");
        return scanner.nextInt();
    }
}
