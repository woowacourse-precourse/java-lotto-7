package lotto;

public class Application {
    public static void main(String[] args) {
    	Paying pay = new Paying();
    	WinningNumber winningNumber = new WinningNumber();
    	WinningResult result = new WinningResult();
    	pay.payment();
    	winningNumber.printWinningNumber();
    	result.setNumbers(winningNumber.getWinningNumber(),winningNumber.getBonusNum(),pay.getLottoNumbers());
    	result.resultPrint(pay.getTotal());
    }

}