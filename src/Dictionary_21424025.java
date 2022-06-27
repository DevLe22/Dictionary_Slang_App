import java.io.*;
import java.util.*;
public class Dictionary_21424025 {
    public TreeMap<String, Set<String>> data_word, add_history,edit_history;
    public List<String> history, delete_history;
    Scanner scanner;
    String thisDaySlangWord ;

    public Dictionary_21424025(){
        readFileSlang("data/slang.txt");
        loadSlangHistory("activities/search_history.txt");
        loadAdd_history("activities/add.txt");
        loadDelete("activities/delete.txt");
        loadUpdate_history("activities/update.txt");
        thisDaySlangWord = randomASlangWord();
        scanner = new Scanner(System.in);
    }


    public void GUI(){
        while (true){
            System.out.println("\n<----------------------------------------------------------------------->");
            System.out.println("1.  Slang Search");
            System.out.println("2.  Definition Search");
            System.out.println("3.  Show Slang Search History");
            System.out.println("4.  Add Slang");
            System.out.println("5.  Edit Slang");
            System.out.println("6.  Delete Slang");
            System.out.println("7.  Reset dictionary");
            System.out.println("8.  On this day slang word");
            System.out.println("9.  Slang quiz");
            System.out.println("10.  Definition quiz");
            System.out.println("0.  Exit");
            System.out.print("Enter a number to select task: ");
            String choice = scanner.nextLine();
            switch(choice){
                case "1":
                    System.out.print("Enter slang word : ");
                    String word = scanner.nextLine();
                    searchWordSlang(word);
                    showWord(word);
                    break;
                case "2":
                    System.out.print("Enter definition: ");
                    String def = scanner.nextLine();
                    List<String>result = searchByDefinition(def);
                    int lengthResult = result.size();
                    if(lengthResult!=0){
                        System.out.println("Find "+lengthResult+" slang word");
                        for(String i:result){
                            showWord(i);
                        }
                    }
                    else {
                        System.out.println("There no result to display");
                    }
                    break;
                case "0":
                    saveHistory("activities/search_history.txt");
                    saveAddHistory("activities/add.txt");
                    saveDeleteHistory("activities/delete.txt");
                    saveEditHistory("activities/edit.txt");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Dictionary_21424025 dict21424025 = new Dictionary_21424025();
        dict21424025.GUI();

    }
}
