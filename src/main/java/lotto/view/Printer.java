package lotto.view;

public class Printer {
    public void printMessage(String string){
        System.out.println(string);
    }

    public void printStringFormatMessage(String stringFormat, Object... values){
        System.out.printf(stringFormat, values);
        System.out.println();
    }
}
