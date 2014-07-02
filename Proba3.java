import java.util.ArrayList;
import java.util.Scanner;
public class Proba3 {
    private static ArrayList <ArrayList <Integer>> tree = new ArrayList <ArrayList<Integer>> ();
    //private static ArrayList <Integer> DeadList = new ArrayList <Integer> ();
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
            Vertex.add(0, 123456789);
            Vertex.add(1, numberVertex);
            Vertex.add(2, FatherVertex);
            tree.add(Vertex);
            tree.get(FatherVertex).add(numberVertex);
        } else if (FatherVertex == 0) {
          numberVertex++;
            ArrayList <Integer> Vertex = new ArrayList <Integer> ();
            Vertex.add(0, 123456789);
            Vertex.add(1, numberVertex);
            Vertex.add(2, FatherVertex);
            tree.add(Vertex);
        } else{
            System.out.println("Error Fater Vertex");
        }
        printTree();
     }
     
     private static void deleteVertex() {
        System.out.println("numberVertex");
        int deleteNumber = sc.nextInt();
            if (tree.get(deleteNumber).size() == 3) {
                metodDelete(deleteNumber);
            } else if (tree.get(deleteNumber).size() > 3) {
                for (int i = 3; i < tree.get(deleteNumber).size(); i++) {
                    deleteBranch(tree.get(deleteNumber).get(i));
                }
                metodDelete(deleteNumber);
            } else {
                System.out.println ("Error Number Vertex");
            }
     }
     
     private static void metodDelete (int delete)   {
        tree.remove(delete);
        numberVertex--;
        for (int a = 0; a < tree.size() ; a++) {
            for (int b = 1; b < tree.get(a).size(); b++) {
                if (tree.get(a).get(b) > delete) {
                    int z = tree.get(a).get(b);
                    z--;
                    tree.get(a).set(b, z);
                    System.out.println("uMenhil");
                    printTree();
                    System.out.println(" ");
                } else if (tree.get(a).get(b) == delete) {
                    tree.get(a).remove(b);
                    b--;
                    System.out.println("uDalil");
                    printTree();
                    System.out.println(" ");
                } else {
                        System.out.println("menhe");
                }
            }
        }
     }
       
     private static void deleteBranch(int Branch) {
        if (tree.get(Branch).size() == 3) {
            metodDelete(Branch);
        } else if (tree.get(Branch).size() > 3)  {
                for (int i = 3; i < tree.get(Branch).size(); i++) {
                    deleteBranch(tree.get(Branch).get(i));
                }
                metodDelete(Branch);
        } else {
            System.out.println("WTF ? 0_o");
        }
    }
    
            
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
