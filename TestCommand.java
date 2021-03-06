import java.util.ArrayList;
import java.util.Scanner;



        
        
//public class Proba3 {
// Command interface
 interface Command {
    void execute();
}
interface CommandDell {
    void execute (int deleteNumber);
}
// the Invoker class
 class Invoker {
    private Command addVertex;
    private CommandDell deleteVertex;
    private Command printTree;
    private Command printVertex;
    private Command aR;
    
    public Invoker (Command addVert, CommandDell deleteVert, Command printT, Command printV, Command aR) {
        this.addVertex = addVert;
        this.deleteVertex = deleteVert;
        this.printTree = printT;
        this.printVertex = printV;
        this.aR = aR;
    }
    
    public void addVertex() {
        addVertex.execute();
    }
    public void deleteVertex(int deleteNumber) {
        deleteVertex.execute(deleteNumber);
    }
    public void printTree() {
        printTree.execute();
    }
    public void printVertex() {
        printVertex.execute(); 
    }
    public void aR() {
        aR.execute();
    }
        
}
// Receiver 

 class Receiver {
    public Receiver() { }
    
    public void addVertex () {
        System.out.println("FatherVertex");
        int FatherVertex = TestCommand.sc.nextInt();
        if (FatherVertex < TestCommand.tree.size()) {
            TestCommand.numberVertex++;
            ArrayList <Integer> Vertex = new ArrayList <Integer> ();
            Vertex.add(0, 123456789);
            Vertex.add(1, TestCommand.numberVertex);
            Vertex.add(2, FatherVertex);
            TestCommand.tree.add(Vertex);
            TestCommand.tree.get(FatherVertex).add(TestCommand.numberVertex);
        } else if (FatherVertex == 0) {
          TestCommand.numberVertex++;
            ArrayList <Integer> Vertex = new ArrayList <Integer> ();
            Vertex.add(0, 123456789);
            Vertex.add(1, TestCommand.numberVertex);
            Vertex.add(2, FatherVertex);
            TestCommand.tree.add(Vertex);
        } else{
            System.out.println("Error Fater Vertex");
        }
    }
    
    public void printTree() {
        for (int i = 0; i < TestCommand.tree.size(); i++) {
            System.out.println(TestCommand.tree.get(i));
        }
        
    }
    public void printVertex() {
        System.out.println("Number Vertex");
        int printNumber = TestCommand.sc.nextInt();
        if (printNumber <= TestCommand.tree.size()) {
            System.out.println(TestCommand.tree.get(printNumber));
        } else {
            System.out.println("does not have a vertex number " +printNumber );
        }
   }
    public void aR() {
        TestCommand.IA.printTree();
        System.out.println("NewRoot");
        int newRoot = TestCommand.sc.nextInt();
        for (int a = 0; a < TestCommand.tree.size(); a++) {
            for (int c = 3; c < TestCommand.tree.get(a).size(); c++) {
                if (TestCommand.tree.get(a).get(c) == newRoot) {
                    TestCommand.tree.get(a).remove(c);
                } else {                  
                }
            }
            for (int b = 1; b < TestCommand.tree.get(a).size(); b++) {
                if (newRoot > TestCommand.tree.get(a).get(b)) {
                    int z = TestCommand.tree.get(a).get(b);
                    z++;
                    TestCommand.tree.get(a).set(b, z);
                }else {
                }
            }
        }
        for (int a = 0, b = 2; a < TestCommand.tree.size(); a++) {
             if (TestCommand.tree.get(a).get(b) == newRoot) {
                TestCommand.tree.get(a).set(b, 0);
             } else {
             }
        }
        
        TestCommand.tree.get(newRoot).set(1, 0);
        TestCommand.tree.get(newRoot).set(2, 0);
        TestCommand.tree.get(newRoot).add(3, 1);
        TestCommand.tree.get(0).set(2,0);
        TestCommand.IA.printTree();
        TestCommand.tree.add(0, TestCommand.tree.get(newRoot));
        System.out.println(newRoot);
        TestCommand.tree.remove(newRoot+1);
        System.out.println(newRoot+1);
        TestCommand.IA.printTree();
    }   
    
    public void deleteVertex (int deleteNumber) {
       
      if (TestCommand.tree.get(deleteNumber).size() == 3) {
                methodDelete(deleteNumber);
      } else if (TestCommand.tree.get(deleteNumber).size() > 3) {
                for (int i = 3; i < TestCommand.tree.get(deleteNumber).size();) {
                    deleteVertex(TestCommand.tree.get(deleteNumber).get(i));
                }
                methodDelete(deleteNumber);
      } else {
                System.out.println("0_o");
      }
    }
     
     private static void methodDelete (int delete)   {
        TestCommand.tree.remove(delete);
        TestCommand.numberVertex--;
        for (int a = 0; a < TestCommand.tree.size() ; a++) {
            for (int b = 1; b < TestCommand.tree.get(a).size(); b++) {
                if (TestCommand.tree.get(a).get(b) > delete) {
                    int z = TestCommand.tree.get(a).get(b);
                    z--;
                    TestCommand.tree.get(a).set(b, z);
                } else if (TestCommand.tree.get(a).get(b) == delete) {
                    TestCommand.tree.get(a).remove(b);
                    b--;
                } else {
                        
                }
            }
        }
     }
}

//Command for aR
class ARCommand implements Command {
    private Receiver theAR;
    
    public ARCommand (Receiver aR) {
        this.theAR = aR;
    }
    public void execute () {
        theAR.aR();
   }
}
//Command for printVertex
class PrintVertexCommand implements Command {
    private Receiver thePrintV;
    
    public PrintVertexCommand (Receiver printV) {
        this.thePrintV = printV;
    }
    public void execute() {
        thePrintV.printVertex();
    }
}
//Command for PrintTree
class PrintTreeCommand implements Command {
    private Receiver thePrintT;
    
    public  PrintTreeCommand (Receiver printT) {
        this.thePrintT = printT;
    }
    public void execute() {
        thePrintT.printTree();
    }
}
//Command for add vertex
class AddVertexCommand implements Command {
    private Receiver theTest;
    
    public AddVertexCommand (Receiver test) {
        this.theTest = test;
    }
    public void execute() {
        theTest.addVertex();
    }
}
// Command for delete Vertex
class DeleteVertexCommand implements CommandDell {
    private Receiver theDelete;
    
    public DeleteVertexCommand (Receiver delete) {
        this.theDelete = delete;
    }
    
    public void execute(int deleteNumber) {
        theDelete.deleteVertex(deleteNumber); 
    }
}
    
//test
public class TestCommand { 
    
    public static ArrayList <ArrayList <Integer>> tree = new ArrayList <ArrayList<Integer>> ();
    public static Scanner sc = new Scanner (System.in);
    public static int numberVertex = -1; // ��� �������� ����� Vertex
        
    public static Receiver R = new Receiver();         
    public static CommandDell CDel = new DeleteVertexCommand(R);
    public static Command CAdd = new AddVertexCommand(R);
    public static Command CPrintT = new PrintTreeCommand(R);
    public static Command CPrintV = new PrintVertexCommand(R);
    public static Command CaR = new ARCommand(R);
    public static Invoker IA = new Invoker(CAdd,CDel,CPrintT,CPrintV,CaR);
    
    public static void main(String[] args) {
         
         
        
         
        
        while (true) {
            System.out.println("command: addVertex, printVertex, printTree, deleteVertex, aR(appointment root) or exit ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.equals("addVertex")) {
                IA.addVertex();
            } else if (input.equals("printVertex")) {
                IA.printVertex();
            } else if (input.equals("printTree")) {
                IA.printTree();

            } else if (input.equals("deleteVertex")) {
                System.out.println("numberVertex");
                int deleteNumber = sc.nextInt();
                IA.deleteVertex(deleteNumber);
                        
            //            } else if (input.equals("test")) {
            //                test ();
            } else if (input.equals("aR")) {
                IA.aR();
            } else {
                System.out.println(" ");
            }
        }
    }
}     

     

    /*
    
    private static ArrayList <ArrayList <Integer>> tree = new ArrayList <ArrayList<Integer>> ();
    //private static ArrayList <Integer> DeadList = new ArrayList <Integer> ();
    private static Scanner sc = new Scanner (System.in);
    private static int numberVertex = -1; // ��� �������� ����� Vertex
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Hi");
        
        
        while (true) {
            System.out.println("command: addVertex, printVertex, printTree, deleteVertex, rR or exit");
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
                System.out.println("numberVertex");
                int deleteNumber = sc.nextInt();
                deleteVertex(deleteNumber);
                printTree();
            } else if (input.equals("test")) {
                test ();
            } else if (input.equals("rR")) {
                rR();
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
     
     private static void deleteVertex(int deleteNumber) {
        if (tree.get(deleteNumber).size() == 3) {
                metodDelete(deleteNumber);
        } else if (tree.get(deleteNumber).size() > 3) {
                for (int i = 3; i < tree.get(deleteNumber).size();) {
                    deleteVertex(tree.get(deleteNumber).get(i));
                }
                metodDelete(deleteNumber);
        } else {
                System.out.println("0_o");
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
                } else if (tree.get(a).get(b) == delete) {
                    tree.get(a).remove(b);
                    b--;
                } else {
                        
                }
            }
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
    
    private static void rR () {
        printTree();
        System.out.println("NewRoot");
        int newRoot = sc.nextInt();
        for (int a = 0; a < tree.size(); a++) {
            for (int c = 3; c < tree.get(a).size(); c++) {
                if (tree.get(a).get(c) == newRoot) {
                    tree.get(a).remove(c);
                } else {                  
                }
            }
            for (int b = 1; b < tree.get(a).size(); b++) {
                if (newRoot > tree.get(a).get(b)) {
                    int z = tree.get(a).get(b);
                    z++;
                    tree.get(a).set(b, z);
                }else {
                }
            }
        }
        for (int a = 0, b = 2; a < tree.size(); a++) {
             if (tree.get(a).get(b) == newRoot) {
                tree.get(a).set(b, 0);
             } else {
             }
        }
        
        tree.get(newRoot).set(1, 0);
        tree.get(newRoot).set(2, 0);
        tree.get(newRoot).add(3, 1);
        tree.get(0).set(2,0);
        printTree();
        tree.add(0, tree.get(newRoot));
        System.out.println(newRoot);
        tree.remove(newRoot+1);
        System.out.println(newRoot+1);
        printTree();
    }
    
    private static void test () {
      int i = sc.nextInt();
      int a = tree.get(i).get(0);
      System.out.println(a);  
    }
} 
   
*/