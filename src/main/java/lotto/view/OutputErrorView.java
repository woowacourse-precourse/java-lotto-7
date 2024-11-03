package lotto.view;

public class OutputErrorView {

    public static void errorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

}
