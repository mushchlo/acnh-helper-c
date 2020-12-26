import java.util.*;

public class firstNineWeeks {
    
    public static void main(String[] args) {
        printHome();
    }
    
    //variables:
    static Scanner now = new Scanner(System.in);
    static int back;
    static ArrayList<String> ar = new ArrayList<>(List.of("check mail", "visit both shops", "visit resident services", "talk to villagers", "shake trees", "water flowers", "dig up fossils", "hit rocks", "find money tree"));
        //calculator:
    static int tBuyPrice = 0;
    static int tNumber = 0;
    static int tSellPrice = 0;
    static int tProfit = 0;
    
    //functions:
    public static void printHome() {
        System.out.println("+------------------------------+\n"+
                           "| AC:NH project!               |\n"+
                           "+------------------------------+\n"+
                           "|                              |\n"+
                           "| #1 → turnip calculator       |\n"+
                           "|                              |\n"+
                           "| #2 → view daily to-do list   |\n"+
                           "|                              |\n"+
                           "| #3 → update to-do list       |\n"+
                           "|                              |\n"+
                           "+------------------------------+");
        
        System.out.println("");
        System.out.println("what would you like to do? (1/2/3)");
        String input = now.nextLine();
        back = Integer.parseInt(input);
        ask();
    }
    
    public static void ask() {
        if (back == 1) {
            printCalc();
        } else if (back == 2) {
            printList();
        } else if (back == 3) {
            updateList();
        }
    }
    
    public static void calculate() {
        System.out.println("what price did you buy your turnips at?");
        String input = now.nextLine();
        tBuyPrice = Integer.parseInt(input);
        
        System.out.println("how many turnips did you buy?");
        String input2 = now.nextLine();
        tNumber = Integer.parseInt(input2);
        
        System.out.println("what price did you sell your turnips at?");
        String input3 = now.nextLine();
        tSellPrice = Integer.parseInt(input3);
        
        tProfit = (tBuyPrice*tNumber)/tSellPrice;
        printCalc();
    }
    
    public static void printCalc() {
        System.out.println("+------------------------------+\n"+
                           "| turnip calculator!           |\n"+
                           "+------------------------------+\n"+
                           "|                              |");
        printLineCalc();
        System.out.println("|                              |\n"+
                           "+------------------------------+");
        
        System.out.println("");
        System.out.println("do you want to update your total profits? (Y/N)");
        String input = now.nextLine();
        
        if (input.equals("Y")) {
            calculate();
        } else if (input.equals("N")) {
            System.out.println("type 'home' when you're ready to return to the main screen.");
            String input6 = now.nextLine();
            if (input6.equals("home")) {
                printHome();
            }
        }
    }
    
    public static void printList() {
        System.out.println("+------------------------------+\n"+
                           "| daily to-do list!            |\n"+
                           "+------------------------------+\n"+
                           "|                              |");
        printLineList();
        System.out.println("|                              |\n"+
                           "+------------------------------+");
        
        System.out.println("");
        System.out.println("type 'home' when you're ready to return to the main screen.");
        String input = now.nextLine();
        if (input.equals("home")) {
            printHome();
        }
    }
    
    //remember line limit = 25, tell input that !!
    public static void updateList() {
        System.out.println("+------------------------------+\n"+
                           "| daily to-do list!            |\n"+
                           "+------------------------------+\n"+
                           "|                              |");
        printLineList();
        System.out.println("|                              |\n"+
                           "+------------------------------+");
        
        System.out.println("");
        System.out.println("here's what your list looks like now. what changes would you like to make?");
        System.out.println("#1: add an item");
        System.out.println("#2: take away an item");
        System.out.println("#3: none, it's finished");
        String input = now.nextLine();
        if (input.equals("1")) {
            addItem();
        } else if (input.equals("2")) {
            removeItem();
        } else if (input.equals("3")) {
            printList();
        }
    }
    
    public static void printLineList() {
        String line;
        String space;
        int a;
        for (int i = 0; i < ar.size(); i++) {
            line = ar.get(i);
            space = "";
            a = 25;
            if (line.length() < a) {
                while (a > line.length()) {
                    space += " ";
                    a--;
                }
            }
            System.out.println("| #"+(i+1)+": "+line+space+"|");
        }
    }
    
    public static void printLineCalc() {
        String space = "|                              |\n";
        int a = 13;
        System.out.print("| turnip price: $"+tBuyPrice);
        System.out.print(printLineCalc2(a,tBuyPrice));
        System.out.print("|\n");
        System.out.print(space);
        int b = 12;
        System.out.print("| turnips bought: "+tNumber);
        System.out.print(printLineCalc2(b,tNumber));
        System.out.print("|\n");
        System.out.print(space);
        int c = 12;
        System.out.print("| price sold at: $"+tSellPrice);
        System.out.print(printLineCalc2(c,tSellPrice));
        System.out.print("|\n");
        System.out.print(space);
        int d = 18;
        System.out.print("| profit → $"+tProfit);
        System.out.print(printLineCalc2(d,tProfit));
        System.out.print("|\n");
    }
    
    public static String printLineCalc2(int x, int y) {
        String space = "";
        String line = Integer.toString(y);
        if (line.length() < x) {
            while (x > line.length()) {
                space += " ";
                x--;
            }
        }
        space += " ";
        return space;
    }
    
    public static void addItem() {
        System.out.println("what would you like to add?");
        System.out.println("(remember, there's a 25 character limit)");
        String input = now.nextLine();
        
        System.out.println("where would you like to add the item?");
        System.out.println("#1: at the start");
        System.out.println("#2: in a specific spot");
        System.out.println("#3: at the end");
        String input2 = now.nextLine();
        if (input2.equals("1")) {
            ar.add(0, input);
        } else if (input2.equals("2")) {
            System.out.println("what number would you like to add the item at?");
            String input3 = now.nextLine();
            int returnInt = Integer.parseInt(input3);
            ar.add((returnInt-1), input);
        } else if (input2.equals("3")) {
            ar.add(input);
        }
        updateList();
    }
    
    public static void removeItem() {
        System.out.println("what number on the list would you like to remove?");
        String input = now.nextLine();
        int returnInt = Integer.parseInt(input);
        ar.remove(returnInt-1);
        updateList();
    }
}

