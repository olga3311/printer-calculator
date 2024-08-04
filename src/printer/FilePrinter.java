package printer;

import operation.Operation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FilePrinter implements Printer {

    @Override
    public void print(double result){

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("./result.txt"));
                pw.printf( "Ваш результат равен: %.2f ", result);
            pw.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("Cannot save result.");
            e.printStackTrace();
        }
    }




    }
