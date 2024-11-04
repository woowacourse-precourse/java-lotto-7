package lotto.controller;

import java.util.Collection;
import java.util.Map;
import lotto.application.model.Model;
import lotto.view.InputView;
import lotto.view.OutputView;

public abstract class AbstractController<I,O> {

    private final InputView<I> inputView;
    private final OutputView<O> outputView;

    public AbstractController(InputView<I> input, OutputView<O> output){
        this.inputView = input;
        this.outputView = output;
    }

    public I input(String inputMessage){
        return inputView.input(inputMessage);
    }

    public void output(O output){
        outputView.print(output);
    }

    public void output(Map<? extends O, ? extends Number> output){
        outputView.print(output);
    }

    public void output(Number output){
        outputView.print(output);
    }

    public void output(Collection<? extends O> output, String message){
        System.out.println(message);
        output.forEach(outputView::print);
    }

}
