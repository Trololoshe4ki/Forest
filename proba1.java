import java.util.ArrayList;
import java.util.Scanner;
public class Proba1 {
  public static ArrayList<ArrayList> wood = new ArrayList<ArrayList> ();
   // public static ArrayList secondLvl = new ArrayList ();
  public static String check;// Переменная для проверки того что ввёл пользователь
  public static int Vertex; //Переменная чтобы новый корень был +1 от Предыдущего

  public static void main (String [] args) {
    Scanner sc = new Scanner (System.in);
    System.out.println("command");
      check = sc.nextLine();
      if(check.equals("command")) {
           // sc.nextLine
          //if (sc.hasNextInt()) {
          command();
      }else {
        System.out.println("Errormain");
    }
  }
  public static void command () {
    Scanner sc = new Scanner (System.in);
    System.out.println("command: addVertex; printVertex; deleteVertex; printWood");
    check = sc.nextLine();
    if(check.equals("addVertex")) {
            System.out.println("Father Vertex");
            
            int check = sc.nextInt();      
            if(check<=wood.size()) {
            System.out.println("executed");
            addVertex(check);
            } else {
            System.out.println("Error addVertex");
            command();
            }
         // System.out.println("Name Vertex");
          //addVertex();
    } else if(check.equals("printVertex")) {
           System.out.println("Number");
           int check = sc.nextInt();
           if (check <= wood.size()) {
              System.out.println("executed");
              printVertex(check);    
           } else { 
              System.out.println("Error printVertex");
              command();
          }
    } else if(check.equals("deleteVertex")) {
          System.out.println("Number");
          int check = sc.nextInt();
          if (check <= wood.size()) {
            System.out.println("executed");
            deleteVertex(check);
          } else {
             System.out.println("Error Number");
             command();
          }
     } else if(check.equals("Test")) {
          System.out.println("Number");
          int check = sc.nextInt();
          if (check <= wood.size()) {
            System.out.println("executed");
            Test(check);
          } else {
             System.out.println("Error Number");
             command();
          }
    } else if(check.equals("printWood")) {
       printWood();   
    } else {
      System.out.println("Errorcommand");
      command();
    }
  }
  
  public static void addVertex (int FatherVertex) {
    Vertex++;
    int NumberVertex = Vertex;
    ArrayList Vertex = new ArrayList ();
    
    Vertex.add(0, null);
    Vertex.set(0, FatherVertex);
    Vertex.add(1,NumberVertex);
    wood.add(Vertex);
    command();
  }
  
  public static void printWood() {         
    System.out.println(wood);
    command ();
  }
  public static void printVertex(int numberVertex) {
    System.out.println(wood.get(numberVertex));
    command ();
    
  }  
  public static void deleteVertex(int NumberVertex) {
    wood.remove(NumberVertex);
    command();
  }
  //Не работает, надо посмотреть
  public static void Test (int numberVertex) {
    System.out.println(wood.get(numberVertex.get(1)));
    command();
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
 
 
 
 }
 
 
 