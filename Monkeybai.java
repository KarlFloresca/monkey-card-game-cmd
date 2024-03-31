import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Monkeybai{

    static Scanner nasc = new Scanner(System.in);
    static Random modnar = new Random();

    static List<String> deck = new ArrayList<>();
    static List<String> playerDeck = new ArrayList<>();
    static List<String> anianoDeck = new ArrayList<>();

    static String excluded;

    static int first;
    public static void main(String[]args){
        System.out.println("""
                 
                ██████████████████
              ███▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓███                                     
            ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██                                    
          ▓▓▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒██                                  
          ██▒▒▒▒▓▓██▒▒▒▒▓▓██▓▓██▒▒▒▒▒▒▒▒██                                
        ██▒▒▒▒██░░░░▓▓▓▓▓▓░░░░░░██▒▒▒▒▒▒██                                
        ▓▓▒▒██░░░░░░░░██░░░░░░░░░░██▒▒▒▒▒▒██                              
        ▓▓▒▒██░░░░░░░░░░░░░░░░░░░░░░██▒▒▒▒██                ████████      
      ██▓▓▒▒██░░░░░░░░░░░░░░░░░░░░░░▓▓▒▒████▓▓            ▓▓░░▒▒▒▒▒▒██    
    ▓▓░░▓▓▒▒██░░░░██░░░░░░██░░░░░░░░▓▓▒▒██░░░░██        ██░░▓▓██████▒▒██  
    ██░░██▒▒██░░░░██░░░░░░██░░░░░░██▒▒▒▒▓▓░░░░▓▓      ██░░▓▓        ██▓▓██
    ██░░▓▓▒▒▒▒██    ░░░░░░    ░░██▒▒▒▒▒▒██░░░░██      ██▒▒██          ▓▓▓▓
      ▓▓██▒▒▓▓░░░░░░▒▒▒▒▒▒░░░░░░░░▓▓▒▒▒▒██████        ██▒▒██              
        ██▓▓██░░░░░░░░██░░░░░░░░░░░░██▒▒▓▓██          ██▒▒██              
          ████░░░░██░░██░░░░▓▓░░░░░░▓▓▒▒██▓▓██          ██▒▒██            
            ▓▓░░░░░░▓▓██████░░░░░░██▓▓▒▒▒▒▒▒▒▒██          ██▒▒██          
              ██░░░░░░░░░░░░░░░░██▓▓▒▒▒▒▒▒▒▒▒▒▒▒██          ██▒▒▓▓        
                ████▓▓██████████▓▓██▒▒▒▒▒▒██▒▒▒▒░░██        ██▒▒▓▓        
                ██▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒██▓▓▒▒▒▒██        ██▒▒██        
                ██▒▒▒▒▓▓▓▓██▓▓▒▒▒▒▓▓▒▒▒▒▒▒██▓▓▒▒▒▒░░▓▓      ▓▓▒▒▓▓        
                ██▒▒▒▒██    ██▒▒▒▒██▒▒▒▒▒▒██▓▓▒▒▒▒▒▒██    ██▓▓▓▓          
              ██▒▒▒▒▓▓██    ██▒▒▒▒██▒▒▒▒▒▒██▓▓▒▒▒▒▒▒▒▒████▓▓██            
              ██▒▒▒▒▓▓██    ██▒▒▒▒▒▒▓▓▒▒▒▒▓▓██▓▓▒▒▒▒▒▒▒▒▓▓▓▓              
              ██▒▒▓▓██    ▓▓▒▒▒▒▒▒▒▒▓▓▒▒▒▒▓▓██▓▓▒▒▒▒▒▒▒▒░░▓▓              
              ██▒▒▓▓▓▓  ██▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒▓▓██▓▓▓▓▒▒▒▒▒▒▒▒░░██            
              ██████████▒▒▒▒▒▒▒▒▓▓▓▓██████████▓▓██▓▓▒▒▒▒▒▒▒▒██            
              ██░░░░░░▓▓▒▒▒▒▒▒▓▓▓▓████░░░░░░▓▓    ██▓▓▒▒▒▒▒▒░░▓▓          
              ██░░░░░░▓▓▒▒▒▒▓▓▓▓██  ▓▓░░░░░░░░▓▓  ██▓▓▒▒▒▒▒▒▒▒▓▓          
                ██████████████████    ██████████  ████████▓▓████▓▓        
                ██░░██░░██░░░░░░░░██            ▓▓░░░░░░░░██░░██░░▓▓      
                ▓▓██████████▒▒██████            ██████▒▒██████████▓▓      
        
                     ████████████████████████████████████████
                     █▄─▀█▀─▄█─▄▄─█▄─▀█▄─▄█▄─█─▄█▄─▄▄─█▄─█─▄█
                     ██─█▄█─██─██─██─█▄▀─███─▄▀███─▄█▀██▄─▄██
                     ▀▄▄▄▀▄▄▄▀▄▄▄▄▀▄▄▄▀▀▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▀▄▄▄▀▀                         
                     |                                       |
                     |            [1] PLAY                   |
                     |            [2] ABOUT THE GAME         |
                     |            [3] QUIT                   |
                     |_______________________________________|
            """);
    System.out.print("ENTER HERE: ");
    int response = nasc.nextInt();

    if(response==1){
        start();
    }else if(response==2){
        aboutTheGame();
    }else if(response==3){
            close();
    }
    }

    public static void aboutTheGame(){
        System.out.println("""
            \t"Monkey Monkey" is a classic card game typically played with a standard deck of playing cards. 
                The objective is to form pairs and discard them until no cards are left. One card is discarded 
                and the goal is to avoid being left with the card with no pair at the end of the game. Players
                take turns drawing cards from each other's hands, attempting to make pairs and discard them. 
                The game continues until all pairs are formed, and the player with the card with no pair loses.
                                      _______________________________________
                                     |                                       |
                                     |            PLAY THE GAME?             |
                                     |              YES OR NO                |
                                     |_______________________________________|
                """);
                System.out.print("enter here[1.yes 2.no]: ");
                int deci = nasc.nextInt();
                if (deci == 1) {
                  start();
                }else if (deci == 2) {
                  close();
                }
    }

    public static void close(){
        System.out.println("""

                      ██████████████                                                          
                    ▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓                                                      
                    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████                                                  
                  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓                                                
                  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██                                  ████        
                ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒██                              ██░░░░██      
                ██▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██      ████                ▓▓░░  ░░██      
                ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████▒▒██  ██    ██            ▓▓  ░░░░██        
              ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░░░░░▓▓▒▒██░░    ░░██          ██░░    ██        
              ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██        ██▒▒██░░    ██        ██  ░░  ██          
              ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░        ██▒▒██      ██        ██░░░░  ██          
              ██▒▒▒▒████████▒▒▒▒▒▒▒▒▒▒▒▒██            ██▒▒██░░██          ██░░    ██          
            ██▒▒▒▒██        ████▒▒▒▒▒▒██        ██    ██▒▒██  ██          ██░░░░  ██          
            ██▒▒██              ██▒▒▒▒██    ████      ██▒▒▒▒██            ██░░░░  ██          
            ██▒▒██                ████    ██  ▒▒██    ██▒▒▒▒██              ██░░  ░░██        
      ████████▒▒██    ████████            ██▒▒▒▒██    ██▒▒▒▒██              ██  ░░  ██        
    ▓▓░░  ░░██▒▒██    ░░██  ▓▓▓▓          ░░██▓▓░░  ▓▓▒▒▒▒▒▒▒▒▓▓          ▓▓██▓▓░░░░░░▓▓      
    ██      ▓▓▒▒██      ██▒▒▒▒██            ░░░░    ▓▓▒▒▒▒▒▒▒▒██        ▓▓░░░░░░▓▓░░░░░░▓▓    
    ██      ██▒▒██      ░░████░░                  ▓▓▒▒▒▒▒▒▒▒▒▒██        ██      ░░▓▓░░░░██    
    ██      ██▒▒▒▒██                              ██▒▒▒▒▒▒▒▒▒▒██      ██░░        ██████▒▒██  
      ▓▓    ██▒▒▒▒▒▒██▓▓                          ████▒▒▒▒▒▒▒▒██    ██▒▒▓▓██      ██    ████  
        ██████▒▒▒▒▒▒▒▒▒▒████              ████        ██▒▒▒▒▒▒██  ██▒▒▒▒▒▒▒▒██  ██            
              ██▒▒▒▒▒▒▒▒▒▒▒▒██      ▒▒▓▓  ░░░░        ░░██▒▒▒▒██▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓              
              ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒██                  ████    ██▒▒██▒▒▒▒▒▒▒▒▒▒▒▒██                
                ██▒▒▒▒▒▒▒▒▒▒▒▒██              ▓▓▓▓▓▓██    ░░██▒▒▒▒▒▒▒▒▒▒▒▒██                  
                ██▒▒▒▒▒▒▒▒▒▒██            ████    ▒▒██      ██▒▒▒▒▒▒▒▒▒▒██                    
                  ██▒▒▒▒▒▒▒▒██░░      ████    ▓▓▓▓██      ██▒▒▒▒▒▒▒▒▒▒██                      
                    ██▒▒▒▒▒▒██    ████    ▓▓▓▓▒▒▓▓██    ▓▓▒▒▒▒▒▒▒▒▒▒██                        
                      ██▒▒▒▒██    ▓▓▓▓▓▓▓▓▓▓██████    ██▒▒▒▒▒▒▒▒▒▒██                          
                        ██▒▒██      ████████░░░░░░██▓▓██▒▒▒▒▒▒▒▒██            ▓▓████          
                        ░░████▓▓      ░░  ░░▓▓▓▓██░░░░██▒▒▒▒▒▒▒▒██        ██▓▓▒▒▒▒▒▒██        
                          ██▒▒▒▒██████████▓▓░░░░░░    ██▒▒▒▒▒▒██        ██▒▒▒▒▒▒▒▒▒▒▒▒██      
                        ██▒▒▒▒▒▒▒▒▒▒██      ░░        ██▒▒▒▒▒▒██      ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒██      
                      ██▒▒▒▒▒▒▒▒▒▒▒▒██                ██▒▒▒▒▒▒██      ██▒▒▒▒██████▒▒▒▒██      
                    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒██  ░░            ██▒▒▒▒▒▒▒▒██  ██▒▒▒▒██    ██▒▒▒▒██      
                    ██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██              ██▒▒▒▒▒▒▒▒██  ██▒▒▒▒██      ████        
                    ██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██            ▓▓▒▒▒▒▒▒▒▒▒▒██▓▓▒▒▒▒▒▒██                  
                    ██▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██        ██▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██                    
                      ██▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██                    
                        ████████▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒██▒▒██                      
                          ██    ██▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████                        
                          ██    ░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██                          
                            ██████▒▒▒▒▒▒▒▒▒▒████████████▒▒▒▒▒▒▒▒▒▒▒▒██                        
                                ██▒▒▒▒▒▒▒▒██     ██      ██▒▒▒▒▒▒▒▒▒▒██                        
                                ██▒▒▒▒▒▒▒▒██     ██        ██▒▒▒▒▒▒▒▒██                        
                                  ██▒▒████  ██   ██         ██▒▒████  ██                      
                                    ██      ██                ██      ██                      
                                    ██▓▓▓▓▓▓██                  ▓▓██▓▓██                      
                                      ╔╦╦═╦╦╦═╗ ╔═╗ ╔═╦╦╦═╦═╗ ╔═╦═╦╦╗
                                      ║═║╩║║║╦╣ ║╩║ ║║║║║╠╣╦╣ ║╠║╩╠╗║
                                      ╚╩╩╩╩═╩═╝ ╚╩╝ ╚╩═╩╩═╩═╝ ╚═╩╩╝╚╝
                """);
    
    }
    public static void start(){
        generateDeck(); 

        // display deck
        System.out.println(
          """
           
─▀─ █▀▀▄ ─▀─ ▀▀█▀▀ ─▀─ █▀▀█ █──   █▀▀▄ █▀▀ █▀▀ █─█ 
▀█▀ █──█ ▀█▀ ──█── ▀█▀ █▄▄█ █──   █──█ █▀▀ █── █▀▄ 
▀▀▀ ▀──▀ ▀▀▀ ──▀── ▀▀▀ ▀──▀ ▀▀▀   ▀▀▀─ ▀▀▀ ▀▀▀ ▀─▀   
              """);
        display(deck);

        // removes a random card from the deck
        chooseMonke();

        // shuffle
        shuffleDeck(deck);

        // display shuffle
        System.out.println("""
            

█▀▀ █──█ █──█ █▀▀ █▀▀ █── █▀▀   █▀▀▄ █▀▀ █▀▀ █─█ 
▀▀█ █▀▀█ █──█ █▀▀ █▀▀ █── █▀▀   █──█ █▀▀ █── █▀▄ 
▀▀▀ ▀──▀ ─▀▀▀ ▀── ▀── ▀▀▀ ▀▀▀   ▀▀▀─ ▀▀▀ ▀▀▀ ▀─▀
            """);
        display(deck);

        //allocation of cards to the players
        allocate();

        // display the players decks
        displayBai();
        removePairs(playerDeck);

        // display ai
        displayAnianoTheMonke();
        removePairs(anianoDeck);

        // display updated deck
        displayBai();
        displayAnianoTheMonke();
        
        //flip coin
        flipCoin();

        game();
    }

    private static void generateDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + "," + suit);
            }
        }
    }

    private static void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck);

    }

    public static void chooseMonke(){

      int monke = modnar.nextInt(52)+1;

      System.out.println("___________________________________________");
      System.out.println("\tthe removed card is "+ deck.get(monke-1));
      System.out.println("___________________________________________");

      excluded = deck.get(monke-1);
      deck.remove(monke-1);
    }

    public static void display(List<String> hand){
        int count = 0;
        for (String card : hand) {
          
            System.out.print(card+"  ");
            count++;
            if (count==13) {
                System.out.println("\n");
                count=0;
            }
        }

        System.out.println("\nHERE IS THE TOTAL CARDS: "+hand.size()+"\n");
    }

    public static void displayBai(){
      System.out.println("""
          
█──█ █▀▀ █▀▀█ █▀▀   ─▀─ █▀▀   ▀▀█▀▀ █──█ █▀▀   █▀▀█ █── █▀▀█ █──█ █▀▀ █▀▀█ █▀▀   █▀▀▄ █▀▀ █▀▀ █─█ 
█▀▀█ █▀▀ █▄▄▀ █▀▀   ▀█▀ ▀▀█   ──█── █▀▀█ █▀▀   █──█ █── █▄▄█ █▄▄█ █▀▀ █▄▄▀ ▀▀█   █──█ █▀▀ █── █▀▄ 
▀──▀ ▀▀▀ ▀─▀▀ ▀▀▀   ▀▀▀ ▀▀▀   ──▀── ▀──▀ ▀▀▀   █▀▀▀ ▀▀▀ ▀──▀ ▄▄▄█ ▀▀▀ ▀─▀▀ ▀▀▀   ▀▀▀─ ▀▀▀ ▀▀▀ ▀─▀
          """);
      display(playerDeck);
    }

    public static void displayAnianoTheMonke(){
      System.out.println("""
          
█─░█ █▀▀ █▀▀█ █▀▀   ─▀─ █▀▀  ─ █▀▀█ █▀▀▄ ─▀─ █▀▀█ █▀▀▄ █▀▀█ █ █▀▀   █▀▀▄ █▀▀ █▀▀ █─█  | █▀▀▄ █▀▀█ ▀▀█▀▀ |
█▀▀█ █▀▀ █▄▄▀ █▀▀   ▀█▀ ▀▀█    █▄▄█ █──█ ▀█▀ █▄▄█ █──█ █──█ ─ ▀▀█   █──█ █▀▀ █── █▀▄  | █▀▀▄ █──█ ──█── | 
█─░█ ▀▀▀ ▀─▀▀ ▀▀▀   ▀▀▀ ▀▀▀    █─░█ ▀──▀ ▀▀▀ ▀──▀ ▀──▀ ▀▀▀▀ ─ ▀▀▀   ▀▀▀─ ▀▀▀ ▀▀▀ ▀─▀  | ▀▀▀─ ▀▀▀▀ ──▀─  |
          """);
      display(anianoDeck);
    }

    public static void allocate(){
      System.out.println("Do you want to allocate? \n[1] yes [2] edi dont yes parin ");
      int decision = nasc.nextInt();
      int datiLang = modnar.nextInt(2)+1;
      int count = 0;
      while(decision<1||decision>2) {
        System.out.print("try again: ");
        decision = nasc.nextInt();
      }
      switch (decision) {
        case 1:
          while (count < 51) {
            if(datiLang == 1){
              playerDeck.add(deck.get(count));
              count++;
              datiLang = 2;
            }
            else if(datiLang == 2){
              anianoDeck.add(deck.get(count));
              count++;
              datiLang = 1;
            }
          }
          break;
      }
    }

    public static void removePairs(List<String> deck) {
      List<String> pairsToRemove = new ArrayList<>();
      List<String> pairsFound = new ArrayList<>(); // To store the pairs found
      Set<String> alreadyPaired = new HashSet<>(); // To track already paired cards

      // Iterate through the deck to find pairs
      for (int i = 0; i < deck.size(); i++) {
          String currentCard = deck.get(i);
          String[] currentCardDetails = currentCard.split(",");
          String currentRank = currentCardDetails[0];

          // Check if the current card is already paired
          if (alreadyPaired.contains(currentCard)) {
              continue; // Skip this card if it's already paired
          }

          for (int j = i + 1; j < deck.size(); j++) {
              String nextCard = deck.get(j);
              String[] nextCardDetails = nextCard.split(",");
              String nextRank = nextCardDetails[0];

              // Check if the ranks of the two cards match (pair found)
              if (currentRank.equals(nextRank)) {
                  // Add the pair to the list of cards to remove
                  pairsToRemove.add(currentCard);
                  pairsToRemove.add(nextCard);

                  // Add the pair to the list of pairs found
                  pairsFound.add(currentCard);
                  pairsFound.add(nextCard);

                  // Add both cards to the set of already paired cards
                  alreadyPaired.add(currentCard);
                  alreadyPaired.add(nextCard);

                  break; // Exit the inner loop since we found a pair
              }
          }
      }

      // Display the pairs found
      if (!pairsFound.isEmpty()) {
          System.out.println("\nPairs Found:");
          for (int k = 0; k < pairsFound.size(); k += 2) {
              System.out.println(pairsFound.get(k) + " and " + pairsFound.get(k + 1));
          }
      } else {
          System.out.println("\nNo pairs found.");
      }

      // Remove the pairs from the deck
      deck.removeAll(pairsToRemove);
  }
    public static void flipCoin(){
      System.out.println("FLIP A COIN, HEADS OR TAILS TO DETERMINE WHO GOES FIRST");
      System.out.println("""
          [1]HEADS
          OR
          [2]TAILS
          """);
      System.out.print("ENTER HERE:");

      int chosen = nasc.nextInt();
        while(chosen <1||chosen>2){
        System.out.println("PLEASE CHOOSE FROM THE OPTIONS, TRY AGAIN");
        chosen = nasc.nextInt();
       }
       int coin = modnar.nextInt();

       if(chosen == coin){
        System.out.println("YOU'RE LUCKY, YOU GO FIRST");
        first = 1;
       }
      else{
        System.out.println("UNLUCKY, BOT GOES FIRST");
        first = 2;
    }
  }

  public static void game(){
    boolean bantot = true;
    if (playerDeck.size() == 0|| anianoDeck.size()==0) {
      if (playerDeck.size()==0) {
        System.out.println("\nthe Player wins");
        printLastTwoCards(anianoDeck.get(0));
        bantot = false;
      }else if (anianoDeck.size() == 0) {
        System.out.println("\nthe bot wins");
        printLastTwoCards(playerDeck.get(0));
        bantot = false;
      }
    }
    if (bantot!=false) {
      displayBai();
      removePairs(playerDeck);
      System.out.println(playerDeck.toString());

      displayAnianoTheMonke();
      removePairs(anianoDeck);
      System.out.println(anianoDeck.toString());

      if (first == 1) {
        baiPick();
      }else if(first == 2){
        anianoPick();     
      }
    }
  }
  public static void anianoPick(){

    int pick = modnar.nextInt(playerDeck.size())+1;

    System.out.println("the bot choose "+playerDeck.get(pick-1));
    anianoDeck.add(playerDeck.get(pick-1));
    playerDeck.remove(pick-1);

    System.out.print("\npress 1 to proceed: ");
    int proceed = nasc.nextInt();

    while (proceed!=1) {
      System.out.println("try again mag basa ka: ");
      proceed = nasc.nextInt();
    }
    if (proceed == 1) {
      first = 1;
      game();
    }  
  }
  
  public static void baiPick(){
    System.out.println("\nchoose a card to take 1-"+anianoDeck.size());
    System.out.print("enter here: ");
    int pick =  nasc.nextInt();

    while (pick < 1||pick > anianoDeck.size()) {
      System.out.print("BOBO mamili ka sa choices: ");
      pick =  nasc.nextInt();
    }

    System.out.println("you have taken "+ anianoDeck.get(pick-1));
    playerDeck.add(anianoDeck.get(pick-1));
    anianoDeck.remove(pick-1);

    System.out.print("\npress 1 to proceed: ");
    int proceed = nasc.nextInt();

    while (proceed!=1) {
      System.out.println("try again mag basa ka: ");
      proceed = nasc.nextInt();
    }
    if (proceed == 1) {
      first = 2;
      game();
    } 
  }
  public static void printLastTwoCards(String card){
    System.out.println("The last card was "+card);
    System.out.println("The excluded card from the start was "+excluded);
  }
}