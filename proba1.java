import java.util.ArrayList;
import java.util.Scanner;
public class Proba1 { 
    private static ArrayList<ArrayList> wood = new ArrayList<ArrayList> ();
    private static int Vertex; //Переменная чтобы новый корень был +1 от Предыдущего

    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("command");
            String input = sc.nextLine();
            if(input.equals("command")) {
            command();
            } else {
            System.out.println("Errormain");
           }
    }
    private static void command () {
        Scanner sc = new Scanner (System.in);
        System.out.println("command: addVertex, printVertex, deleteVertex, printWood");
        String input = sc.nextLine();
            if(input.equals("addVertex")) {
                System.out.println("Father Vertex");
                int value = sc.nextInt();      
                if(value <= wood.size()) {
                    System.out.println("executed");
                    addVertex(value);
                } else {
                    System.out.println("Error addVertex");
                    command();
                }
         
            } else if(input.equals("printVertex")) {
                System.out.println("Number");
                int value = sc.nextInt();
                if (value <= wood.size()) {
                    System.out.println("executed");
                    printVertex(value);    
                } else { 
                    System.out.println("Error printVertex");
                    command();
                }
            } else if(input.equals("deleteVertex")) {
                System.out.println("Number");
                int value = sc.nextInt();
                if (value <= wood.size()) {
                    System.out.println("executed");
                    deleteVertex(value);
                } else {
                    System.out.println("Error Number");
                    command();
                }
            /*} else if(input.equals("Test")) {
                System.out.println("Number");
                int value = sc.nextInt();
                if (value <= wood.size()) {
                    System.out.println("executed");
                    Test(value);
                } else {
                    System.out.println("Error Number");
                    command();
                }
            */
            } else if(input.equals("printWood")) {
                printWood();   
            } else {
                System.out.println("Errorcommand");
                command();
            }
    }
  
    private static void addVertex (int FatherVertex) {
        Vertex++;
        int NumberVertex = Vertex;
        ArrayList Vertex = new ArrayList ();
        Vertex.add(0, null);
        Vertex.set(0, FatherVertex);
        Vertex.add(1,NumberVertex);
        wood.add(Vertex);
        command();
    }
  
    private static void printWood() {         
        System.out.println(wood);
        command ();
    }
    private static void printVertex(int numberVertex) {
        System.out.println(wood.get(numberVertex));
        command ();
    
    }  
    private static void deleteVertex(int NumberVertex) {
        wood.remove(NumberVertex);
        command();
    }
    
    //Не работает, надо посмотреть
    //public static void Test (int numberVertex) {
     //   System.out.println(wood.get(numberVertex.get(1)));
    //    command();
    //}
} 