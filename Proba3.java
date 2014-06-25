import java.util.ArrayList;
import java.util.Scanner;
public class Proba3 {
    private static ArrayList <ArrayList <Integer>> tree = new ArrayList <ArrayList<Integer>> ();
    private static Scanner sc = new Scanner (System.in);
    private static int numberVertex = -1; // для создание новых Vertex
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
            } else if (input.equals("test")) {
                test ();
            } else {
                System.out.println("error");
            }
         
         
         
         }
     }
             
    private static void addVertex() {
        System.out.println("FatherVertex");
        int FatherVertex = sc.nextInt();
        if (FatherVertex < tree.size()) {
            numberVertex++;
            ArrayList <Integer> Vertex = new ArrayList <Integer> ();
            Vertex.add(0, numberVertex);
            Vertex.add(1, FatherVertex);
            Vertex.add(2, 123456789);
            tree.add(Vertex);
            tree.get(FatherVertex).add(numberVertex);
        } else if (FatherVertex == 0) {
          numberVertex++;
            ArrayList <Integer> Vertex = new ArrayList <Integer> ();
            Vertex.add(0, numberVertex);
            Vertex.add(1, FatherVertex);
            Vertex.add(2, 123456789);
            tree.add(Vertex);
        } else{
            System.out.println("Error Fater Vertex");
        }
     }
     
    private static void deleteVertex() {
        System.out.println("numberVertex");
        int deleteNumber = sc.nextInt();
        for (int i = deleteNumber--; i < tree.size(); i++) {
            tree.get(i).set(0, i);
        //    for (i = 3; i < tree.get(deleteNumber).size(); i++) {
      //          int Branch = tree.get(deleteNumber).get(i);
    //            tree.remove(Branch);
        }
        tree.remove(deleteNumber);
    }
    
    
   /* private static void deleteBranch(deleteNumber) {
         for (int i = deleteNumber--; i < tree.size(); i++) {
            tree.get(i).set(0, i);
            for (i = 3; i < tree.get(deleteNumber).size(); i++) {
                int Branch = tree.get(deleteNumber).get(i);
                tree.remove(Branch);
                
    */
    private static void printTree() {
        for (int i = 0; i < tree.size(); i++) {
            System.out.println(tree.get(i));
        }
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
    private static void test () {
      int i = sc.nextInt();
      int a = tree.get(i).get(0);
      System.out.println(a);  
    }
}    
