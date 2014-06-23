import java.util.ArrayList;
import java.util.Scanner;
public class Proba3 {
    private static ArrayList <ArrayList> tree = new ArrayList <ArrayList> ();
    private static Scanner sc = new Scanner (System.in);
    private static int numberVertex; // для создание новых Vertex
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Hi");
        while (true) {
            System.out.println("command: addVertex, printVertex, printTree, deleteVertex or exit");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.equals("addVertex")) {
                addVertex();
            } else if (input.equals("printVertex")) {
                printVertex();
            } else if (input.equals("printTree")) {
                printTree();
            } else if (input.equals("deleteVertex")) {
                deleteVertex();
            } else {
                System.out.println("error");
            }
         
         
         
         }
     }
             
    private static void addVertex() {
        System.out.println("FatherVertex");
        int FatherVertex = sc.nextInt();
        if (FatherVertex <= tree.size()) {
            numberVertex++;
            ArrayList Vertex = new ArrayList ();
            Vertex.add(0, numberVertex);
            Vertex.add(1, FatherVertex);
            tree.add(Vertex);
        } else{
            System.out.println("Error Fater Vertex");
        }
     }
     
    private static void deleteVertex() {
        System.out.println("numberVertex");
        int deleteNumber = sc.nextInt();
        
        tree.remove(deleteNumber);
        for (int i = 0; i <= tree.size(); i++) {
            ArrayList test = tree.get(i);
            System.out.println(test);
            //for (int a = test.get(1); a > deleteNumber;) {
             //   int b = test.get(1);
             //   b--;
             //   test.add(1, b);
            
            
        }
        printTree ();
    }
     
    private static void printTree() {
        System.out.println(tree);
    }
    
    private static void printVertex() {
        System.out.println("Number Vertex");
        int printNumber = sc.nextInt();
        if (printNumber <= tree.size()) {
            System.out.println(tree.get(printNumber));
        } else {
            System.out.println("does not have a vertex number " +printNumber );
        }
    }
}    
