package operationHistory;

import operation.Operation;
import operator.Operator;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileOperationHistory implements OperationHistory {

    private String fileName;
    private File file;
    private List<Operation> operationList;

    public FileOperationHistory(String fileName) {
        this.fileName = fileName;
        this.operationList = new ArrayList<>();
        load();
        cleanUpHistory();
    }

    @Override
    public void addOperation(Operation operation) {
        operationList.add(operation);
    }


    public void saveOperation() {

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
            for (Operation operation : operationList)
                pw.println(operation);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save history.");
            e.printStackTrace();
        }
    }


    public void load() {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            for (String line; (line = br.readLine()) != null; ) {
                addOperation(new Operation(line));
            }

        } catch (IOException e) {
            System.out.println("Cannot load the history.");
            e.printStackTrace();
        }
    }

    public void cleanUpHistory(){

        List<Operation> temp  = operationList.stream()
                .filter((operation) -> LocalDateTime.now().minusDays(1).isBefore(operation.getLocalDateTime()))
                .toList();

                operationList = new ArrayList<Operation>(temp);
        System.out.println(temp);
    }
}

