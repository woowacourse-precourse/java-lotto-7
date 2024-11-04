package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		input number = new input();
		int num = number.put_money();
		list_num listnum = new list_num();
		List<ArrayList<Integer>> list = listnum.list(num);
		Win_Num win = new Win_Num();
		List<Integer> winner = win.winArr();
		bonus_num second = new bonus_num();
		int s_num = second.second();
		result result = new result();
		result.setNumbers(winner, s_num, list);
		result.resultPrint(num);
	}
}