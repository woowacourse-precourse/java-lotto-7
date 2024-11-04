package lotto.view;

public class OutputView {
    public void outputLine(String msg) {
        System.out.println(msg);
    }

    public void outputLine() {
        System.out.println();
    }
    public void outputAppendNewLine(Runnable outputMethod){
        outputMethod.run();
        outputLine();
    }
    public void output(String msg) {
        System.out.print(msg);
    }
}