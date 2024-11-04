package lotto;

import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //Display display = new Display();
        //Lotto lotto = new Lotto();
        Display.requestMoney();
        Display.setInput();
        Amount amount = new Amount(Display.get());

        Display.tellAmount();
        Ticket ticket = new Ticket();
        ticket.print();

        Display.requestNumber();
        Display.setInput();
        System.out.println(Display.get());
        Display.toLotto();

        Display.requestBonus(); //bonus 번호 중복시 validate 구현할것
        Display.setInput();
        System.out.println(Display.get());

        //Matcher matcher = new Matcher(Lotto.getWinningNum());
        //matcher.matches(Ticket.get());

    }
}
