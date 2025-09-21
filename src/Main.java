import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Insert some elements
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        linkedList.delete(2);

        //Insert integers from text file
        File file = new File("src/integers");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()){
                linkedList.insert(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Iterate and display elements
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}