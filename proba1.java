import java.util.ArrayList;
import java.util.Scanner;
public class Proba1 {
  public static ArrayList<ArrayList> firstLvl = new ArrayList<ArrayList> ();
    public static ArrayList secondLvl = new ArrayList ();
  public static String i;
  public static String name;


  public static void main (String [] args) {
    Scanner sc = new Scanner (System.in);
    
      i = sc.nextLine();
      if(i.equals("command")) {
           // sc.nextLine
          //if (sc.hasNextInt()) {
          command();
     } else if(i.equals("print")) {
       printFirstLvl();   
     
     }else {
      System.out.println("Errormain");
    }
  }
  public static void command () {
    Scanner sc = new Scanner (System.in);
    i = sc.nextLine();
    if(i.equals("addVertex")) {
          System.out.println("Fater Vertex");
          i = sc.nextLine();
          System.out.println("Name Vortex");
          name = sc.nextLine();
          addVertex();
    } else if(i.equals("print")) {
       printFirstLvl();   
     
     }else {
      System.out.println("Errorcommand");
    }
  }
  public static void addVertex () {
    ArrayList name = new ArrayList ();
    
    name.add(i);
    firstLvl.add(name);
    command();
  }
  
  public static void printFirstLvl() {         
    System.out.println(firstLvl);
  }
 }