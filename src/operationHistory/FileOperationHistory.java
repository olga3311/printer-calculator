package operationHistory;

import operation.Operation;
import operator.Operator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperationHistory implements OperationHistory {

    private String fileName;
    private File file;
    private List<Operation> operationList;

    public FileOperationHistory(String fileName) {
        this.fileName = fileName;
        this.operationList = new ArrayList<>();

       // try {
           // this.load();
       // }
       // catch ( FileNotFoundException e){
       //     System.out.println("cannot load the history");
       //     e.printStackTrace();
       // }
    }

    @Override
    public void addOperation(Operation operation) {
    operationList.add(operation);
    }



    public void saveOperation (){

        try {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (Operation operation : operationList)
            pw.println(operation);
        pw.close();}
        catch (FileNotFoundException e){
            System.out.println("Cannot save history. ");
            e.printStackTrace();
        }
    }


    public void load () throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (Operation operation : operationList)
            pw.println(operation);

        pw.close();
    }


}
