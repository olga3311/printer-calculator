package main;
import calculator.MathCalculator;
import operationHistory.FileOperationHistory;
import parser.StringParser;
import printer.Printer;
import printer.PrinterSelection;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        PrinterSelection printerSelection = new PrinterSelection();
        Printer printer =  printerSelection.choosePrinter();

        String fileName = "operationHistory.txt";
        FileOperationHistory fileOperationHistory = new FileOperationHistory(fileName);

        MathCalculator mathCalculator = new MathCalculator(printer, fileOperationHistory);

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the equation: ");
        StringParser stringParser = new StringParser(mathCalculator, scanner);

        stringParser.parse();

        scanner.close();

        fileOperationHistory.saveOperation();

    }

}
