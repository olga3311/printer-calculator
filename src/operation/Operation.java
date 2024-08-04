package operation;

import operator.Operator;

import java.time.LocalDateTime;

public class Operation {
    private double first;
    private double second;
    private Operator operator;
    private double result;
    private LocalDateTime localDateTime;

    public Operation(String s) {
        s = s.substring(10, s.length() - 1);
        String[] sl = s.split(",");

        for (int i = 0; i < sl.length; i++) {
            String[] pair = sl[i].split("=");

            switch (pair[0].trim()) {
                case "first" -> first = Double.parseDouble(pair[1]);

                case "second" -> second = Double.parseDouble(pair[1]);

                case "operator"-> operator = Operator.valueOf(pair[1]);

                case "result" -> result = Double.parseDouble(pair[1]);

                case "localDateTime" -> localDateTime = LocalDateTime.parse(pair[1]);

            }
        }
    }

    public Operation(double first, double second, Operator operator, double result, LocalDateTime localDateTime) {
        this.first = first;
        this.second = second;
        this.operator = operator;
        this.result = result;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "first=" + first +
                ", second=" + second +
                ", operator=" + operator +
                ", result=" + result +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
