package calculator;

import operation.Operation;
import operationHistory.OperationHistory;
import operator.Operator;
import printer.Printer;

import java.time.LocalDateTime;

public class MathCalculator implements Calculator {

    private final Printer printer;
    private final OperationHistory operationHistory;

    public MathCalculator(Printer consolePrinter, OperationHistory operationHistory) {
        this.printer = consolePrinter;
        this.operationHistory = operationHistory;
    }

    public void calculate(double first, double second, Operator operator) {
        double result = 0.0;

        switch (operator) {
            case SUM -> result = first + second;
            case SUBTRACTION -> result = first - second;
            case DIVIDE -> result = first / second;
            case MULTIPLY -> result = first * second;
        }

        printer.print(result);
        operationHistory.addOperation( new Operation(first, second, operator, result, LocalDateTime.now()));

    }
}

