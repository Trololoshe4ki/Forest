import java.util.ArrayList;
import java.util.Scanner;
public class Proba3 {
    private static ArrayList <ArrayList <Integer>> tree = new ArrayList <ArrayList<Integer>> ();
    private static ArrayList <Integer> DeadList = new ArrayList <Integer> ();
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
                int deleteNumber = sc.nextInt();
                deleteVertex(deleteNumber);
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
        printTree();
     }
     
    /* private static void deleteVertex() {
        System.out.println("numberVertex");
        int deleteNumber = sc.nextInt();
        
            if (tree.get(deleteNumber).size() == 3) {
                tree.remove(deleteNumber);
            } else if (tree.get(deleteNumber).size() > 3) {
                for (int i = 3; i < tree.get(deleteNumber).size(); i++) {
                    deleteBranch(tree.get(deleteNumber).get(i));
                }
                tree.remove(deleteNumber);
            } else {
                System.out.println ("Error Number Vertex");
            }    
           for (i = 3; i < tree.get(deleteNumber).size(); i++) {
                int Branch = tree.get(deleteNumber).get(i);
                tree.remove(Branch);
        }
        tree.remove(deleteNumber);
        for (int i = deleteNumber--; i < tree.size(); i++) {
            tree.get(i).set(0, i);
    */ 
    
    
    private static void deleteVertex(int deleteNumber) {
        
        
        if (tree.get(deleteNumber).size() > 3) {
            for (int i = 3; i < tree.get(deleteNumber).size(); i++) {
                DeadList.add(tree.get(deleteNumber).get(i));
                System.out.println(DeadList);
            }
            startDeadList();
        } else if (tree.get(deleteNumber).size() == 3) {
            DeadList.add(tree.get(deleteNumber).get(0));
        } else {
        System.out.println("WTF ?");
        }
    System.out.println("exelent!");
    }
    
    private static void startDeadList() {
        for (int i = 0; i <= DeadList.size();i++) {
            System.out.println(DeadList.get(i));
            for( int a = DeadList.get(i); a <= tree.size(); a++) {
                int temp = tree.get(a).get(0);
                temp--;
                tree.get(a).set(0, temp);
            }
            tree.remove(DeadList.get(i));
            
                
        }
        DeadList.clear();
    }
        
    /*  if (tree.get(deleteNumber).size() > 3) {
            for (int i = 3; i < tree.get(deleteNumber).size();) {
                System.out.println("tree="+tree.size()+" vertex="+tree.get(deleteNumber).size()+" i=  "+i);
                deleteVertex(tree.get(deleteNumber).get(i));
                tree.get(deleteNumber).remove(i);
            }
            tree.remove(deleteNumber);
        } else if (tree.get(deleteNumber).size() == 3) {
            tree.remove(deleteNumber);
        } else {
        System.out.println("WTF ?");
        }
    System.out.println("exelent!");
    }
         
       
   /*  private static void deleteBranch(int Branch) {
        if (tree.get(Branch).size() == 3) {
            tree.remove(Branch);
        } else if (tree.get(Branch).size() > 3)  {
            for (int i = 3; i < tree.get(Branch).size(); i++) {
                deleteBranch(tree.get(Branch).get(i));
            }
            tree.remove(Branch);
        } else {
            System.out.println("WTF ? 0_o");
        }
    }
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
