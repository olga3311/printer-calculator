package printer;

import java.util.Scanner;

public class PrinterSelection {
    public Printer choosePrinter(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the output:\n" +
                "1. Console \n" +
                "2. File");

        while (true){
            int answer = scanner.nextInt();
            switch (answer) {
                case 1 -> {
                    return new ConsolePrinter();
                }
                case 2 -> {
                    return new FilePrinter();
                }
                default -> System.out.println("Choose 1 or 2: ");
            }

        }

    }

}

