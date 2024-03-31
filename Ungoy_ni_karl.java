import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Ungoy_ni_karl {

    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();
    static int op;
    static boolean game;

    static String[] deck = new String[52];
    static String[] card = {"Spade","Heart","Clubs","Diamd"};
    static String[] ranks = {"1","2","3","4","5","6","7","8","9","10","jack","Queen","King"};
    static int count = 0;

    static List<String> playerPairedCards = new ArrayList<>();
    static List<String> botPairedCards = new ArrayList<>();

    static String[] playerHand = new String[deck.length/2];
    static int playerCardNum;

    static String[] botHand = new String[deck.length/2];
    static int botCardNum;

    static String[] pairs = new String[50];
    static int pairCount = 0;

    public static String monkey;

    // the main function is where all the funtions are called
    public static void main(String[] args) {
        // for opening display
        opening();

        if (game) {
            // displays the hands
            displayBot();
            displayPlayer();
            
            System.out.print("""
                
                    press 1 to proceed
                    enter here: """);
            int proceed = sc.nextInt();

            while (proceed!=1) {
                System.out.print("that is not an option[try again]: ");
                proceed = sc.nextInt();
            }
           
            if (proceed == 1) {
                // calls the flip coin function
                int first = flipCoin();

                if (first==1) {
                    playerPick();
                }else if(first==2){
                    botPick();
                }
            }else if (proceed==2) {
                end();
            }
        }
        
    
        sc.close();
    }

    // displays the start of the game and options to start or quit and i also included the rules, para dun sa mga di alam ang gagawin nila
    public static void opening(){
        System.out.println("""

                                                                                                        
                                                                ▓▓▓▓▓▓▓▓              
                                                            ▓▓▓▓▓▓      ▓▓            
                                                            ▓▓▓▓          ▓▓            
                                                          ▓▓            ▓▓            
                                                           ▓▓           ▓▓            
                                                           ▓▓      ▓▓▓▓▓▓              
                                                            ▓▓▓▓                        
                                                            ██▓▓▓▓▓▓                  
                                                                ██▓▓▓▓                
                                                                    ██▓▓▓▓              
                                                                    ██▓▓▓▓            
                                                                        ██▓▓▓▓          
                                                                        ██▓▓          
                                                                        ██▓▓          
                            ▓▓▓▓▓▓▓▓                                      ▓▓▓▓          
                        ▓▓▓▓▓▓▓▓  ▓▓▓▓                                ▓▓▓▓██          
                            ▓▓▓▓    ▓▓        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓      ▓▓▓▓██            
                        ██  ▓▓▓▓    ██▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██            
                    ▒▒▒▒▒▒  ▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████              
                    ▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓              
                        ▒▒▒▒▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██              
                            ░░░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██              
                                ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██              
                                ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░░              
                                ▒▒▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██                
                                ▓▓▓▓▓▓▓▓████████░░░░████████▓▓██▓▓▓▓▓▓██                
                            ▒▒▓▓▓▓▓▓██████████  ▓▓████████░░██▓▓▓▓▓▓▓▓                
                            ▓▓▓▓▓▓██░░████████  ████████░░  ░░██▓▓▓▓▓▓▓▓              
                            ▓▓▓▓████    ████████  ████████          ██▓▓▓▓▓▓            
                            ▓▓▓▓██      ██████      ██████            ▓▓▓▓██            
                        ▓▓▓▓██        ██████        ████            ▓▓██              
                    ▓▓▓▓▓▓████  ████████████  ██████████      ████▓▓▓▓██              
                    ██▓▓██▓▓██    ██████████    ████████      ██████▓▓██                
                    ░░    ░░░░    ░░░░  ░░░░    ░░░░░░        ░░░░░░░░░░     
                                                                         
                [=================================================================]
                []    ███╗░░░███╗░█████╗░███╗░░██╗██╗░░██╗███████╗██╗░░░██╗      []
                []    ████╗░████║██╔══██╗████╗░██║██║░██╔╝██╔════╝╚██╗░██╔╝      []
                []    ██╔████╔██║██║░░██║██╔██╗██║█████═╝░█████╗░░░╚████╔╝░      []
                []    ██║╚██╔╝██║██║░░██║██║╚████║██╔═██╗░██╔══╝░░░░╚██╔╝░░      []
                []    ██║░╚═╝░██║╚█████╔╝██║░╚███║██║░╚██╗███████╗░░░██║░░░      []
                []    ╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═╝░░╚═╝╚══════╝░░░╚═╝░░░      []
                []                █▀▄▀█ █▀█ █▄░█ █▄▀ █▀▀ █▄█                     []
                []                █░▀░█ █▄█ █░▀█ █░█ ██▄ ░█░                     []
                []                                                               []
                []  PLEASE CHOOSE AN OPTION                                      []
                []  [1]. PLAY                                                    []
                []  [2]. RULES                                                   []
                []  [3]. QUIT                                                    []
                []                                                               []
                [=================================================================]
                """);
                System.out.print("Enter Here: ");
                op = sc.nextInt();
                // for handling decision
                optionHandler(op);
    }
    
    public static void optionHandler(int op){
        switch (op) {
            case 1:
                play();
                break;
            case 2:
                rules();
                break;
            case 3:
                end();
                break;
            default:
                System.out.print("that is not an option[try again]: ");
                op = sc.nextInt();
                optionHandler(op);
                break;
        }
    }

    // displays the rules for the player
    public static void rules(){
        System.out.println("""
                
                this is the main premise of the game, during the start of the game a random card is taken out of the deck
                inorder for one card to not have a pair until the end, then the remaining cards are shuffled and distributed
                equally among the players.

                After which the players will drop all their cards with a pair (for example the ace of spades and the ace of diamonds
                are a pair), once all paired cards are off handed the players shall take turns picking from each others hands until
                only one card is left which is the one card without a pairing due to the removed card in the beginning.

                the loser is called the monkey, hence the name of the game MONKEY MONKEY.
                """);

        System.out.println("Would you like to play? \n[1] yes \n[2] no");
        System.out.print("Enter Here: ");
        int pl = sc.nextInt();

        while (pl<1||pl>2) {
            System.out.print("Try again: ");
            pl = sc.nextInt();
        }
        if (pl == 1) {
            play();
        }else if (pl == 2) {
            end();
        }
    }
    
    // this handles the start of the game like the set up, allocation of cards and initializing the game loop
    public static void play(){
        // variable used later for the game loop
        game = true;

        // creates the 52 unique cards in a deck
        while(count<52) {
            for(int j = 0; j<card.length;j++){
                for(int x = 0; x<ranks.length;x++){
                    deck[count] = card[j]+":"+ranks[x];
                    count++;
                }
            }
        }
        count = 0;
        int indexing =0;

        // displays the deck for checking if there is any duplicates
        System.out.println("""

        █ █ █▀▀ █▀█ █▀▀   █ █▀   ▀█▀ █ █ █▀▀   █ █▄ █ █ ▀█▀ █ ▄▀█ █     █▀▄ █▀▀ █▀▀ █▄▀
        █▀█ ██▄ █▀▄ ██▄   █ ▄█    █  █▀█ ██▄   █ █ ▀█ █  █  █ █▀█ █▄▄   █▄▀ ██▄ █▄▄ █ █
                """);
        for (int i = 0 ;i < card.length;i++) {
            while (count<13) {
                System.out.print(deck[indexing]+"  ");
                indexing++;
                count++;
            }
            System.out.println("\n");
            count = 0;
        }

        System.out.println("Total cards = "+ deck.length);

        System.out.println("\nthis is the random card that is removed from the deck: "+removeCard()+"\n");

        System.out.println("shuffle the cards?\n[1]yes\n[2]no");
        System.out.print("Enter here: ");
        int shuffle = sc.nextInt();

       
        while (shuffle < 1 || shuffle >2) {
            System.out.print("that is not an option[try again]: ");
            shuffle = sc.nextInt();
        }

        // displays the shuffled cards
        if (shuffle == 1) {

            //shuffles
            shuffle(deck);
            
            // display
            System.out.println("""            
                                
            █ █ █▀▀ █▀█ █▀▀   █ █▀   ▀█▀ █ █ █▀▀   █▀ █ █ █ █ █▀▀ █▀▀ █   █▀▀ █▀▄   █▀▄ █▀▀ █▀▀ █▄▀
            █▀█ ██▄ █▀▄ ██▄   █ ▄█    █  █▀█ ██▄   ▄█ █▀█ █▄█ █▀  █▀  █▄▄ ██▄ █▄▀   █▄▀ ██▄ █▄▄ █ █
            """);
            int numCard = 0;
            for (int cards = 0; cards < card.length; cards++) {
                
                System.out.println("");
                while (count < 52) {
                    if (deck[count]!=null) {
                        System.out.print(deck[count]+"  ");
                        count++;
                        numCard++;
                        if (count == 12) {
                            System.err.println("\n");
                        }
                        if (count == 25) {
                            System.err.println("\n");
                        }
                        if (count == 38) {
                            System.err.println("\n");
                        }
                        if (count == 51) {
                            System.out.println("\n");
                        }
                    }else{
                        count++;
                    }   
                }
            }
            System.out.println("Number of card = "+numCard+"\n");
            count = 0;
        }else if(shuffle == 2){
            end();
            game = false;
        }

        System.out.println("Destribute the Cards?\n[1] yes\n[2] yes parin gusto ko lang may pahinga bago maglabas");
        int walangKwentaNaVariable_PangDelayLang = sc.nextInt();

        // distributes the card for all the players
        if (game) {
            distribute(playerHand, botHand);
        }   
    }
    // removes one card from the game
    public static String removeCard(){
        int removed = ran.nextInt(52);
        String monkeyCard = "{{ "+(deck[removed])+" }}";

        monkey = deck[removed];

        deck[removed]=null;
        return monkeyCard;
    }

    public static String[] shuffle(String[] shuffledDeck){

        java.util.List<String> listDeck = Arrays.asList(shuffledDeck);

        Collections.shuffle(listDeck);

        deck = listDeck.toArray(new String[0]);

        return deck;
    }

    public static void distribute(String[] player, String[] bot){
        int shuffler = 1;
        int playerCount = 0;
        int botCount = 0;
        for (String string : deck) {
            if (shuffler == 1) {
                player[playerCount] = string;
                playerCount++;
                shuffler = 2;
            }else if(shuffler == 2){
                bot[botCount]=string;
                botCount++;
                shuffler = 1; 
            }
        }

        // stores the data of the hands
        playerHand = player;
        botHand = bot;
    }
    

    // for displaying hands and updated hands
    public static void displayHand(String[] hand){
        int numCard = 0;
        for (int i = 0; i<hand.length;i++) {
            if (count==8) {
                System.out.println("\n"); 
                count=0;
                
            }
            if (hand[i] != null) {
                System.out.print(hand[i]+"  ");
                count++;
                numCard++;
            } 
        }
        System.out.println("\n\nNumber of cards in hand = "+numCard);
        count = 0;

        if (hand == botHand) {
            botCardNum = numCard;
        }else if (hand == playerHand) {
            playerCardNum = numCard;
        }
    }

    // this function is used to display the bots hand and find pairs
    public static void displayBot(){
        System.out.println("""

        █ █ █▀▀ █▀█ █▀▀ ▀ █▀   ▀█▀ █ █ █▀▀   █▄▄ █▀█ ▀█▀ ▀ █▀   █ █ ▄▀█ █▄ █ █▀▄   
        █▀█ ██▄ █▀▄ ██▄   ▄█    █  █▀█ ██▄   █▄█ █▄█  █    ▄█   █▀█ █▀█ █ ▀█ █▄▀ 

                """);
        
        // calls the function to display hand
        displayHand(botHand);

        // calls for the function to find and remove pairs from hand
        System.out.println("\n");
        findPairs(botHand);

    }

    // this function is used to display the players hand and find pairs
    public static void displayPlayer(){
        System.out.println("""
                
        █ █ █▀▀ █▀█ █▀▀   █ █▀   █▄█ █▀█ █ █ █▀█   █ █ ▄▀█ █▄ █ █▀▄
        █▀█ ██▄ █▀▄ ██▄   █ ▄█    █  █▄█ █▄█ █▀▄   █▀█ █▀█ █ ▀█ █▄▀
        """);

        // calls the function to display hand
        displayHand(playerHand);

        // calls for the function to find and remove pairs from hand
        System.out.println("\n");
        findPairs(playerHand);

    }

    // finds and removes pair from a hand
    public static void findPairs(String[] hand){
        System.out.println("------{{==={===| HERE ARE THE PAIRS IN HAND |===}===}}------\n");
        for (int i = 0; i < hand.length; i++) {
            String currentCard = hand[i];

            // Check if the current card is not null and if it's not already paired
            if (currentCard != null && !playerPairedCards.contains(currentCard)) {
                for (int j = i + 1; j < hand.length; j++) {

                    // Check if the current card has a pair and if hand[j] is not null
                    if (hand[j] != null && currentCard.split(":")[1].equals(hand[j].split(":")[1])) {
                        // Add the current card and its pair to the paired cards lists
                        playerPairedCards.add(currentCard);
                        playerPairedCards.add(hand[j]);
                        
                        pairCount++;

                        // Store the pair information
                        pairs[pairCount] = currentCard.split(":")[1];

                        // Display the pair
                        System.out.println("\tPair " + pairCount + ": " + currentCard + " - " + hand[j]);

                        // Remove the pair from the hand
                        hand[i] = null;
                        hand[j] = null;
                        break;
                    }
                }
            }
        }
        // Display a message if no paired cards were found
        if (pairCount == 0) {
            System.out.println("\tNo paired cards found in the hand.");
        }
        pairCount = 0;

        System.out.println("\n================================================");
        System.out.println("\t  {===| remaining cards |===}");
        System.out.println("================================================\n");
        displayHand(hand);
    }

    // here is the function used to decide who goes first
    public static int flipCoin(){

        System.out.println("\nflip a coin for first pick, \n1. heads \nOR \n2.tails");
        System.out.print("\nEnter here: ");
        int first;

        int decision = sc.nextInt();

        while (decision <1||decision>2) {
            System.out.print("That is not an option, try again: ");
            decision = sc.nextInt();
        }

        int coin = ran.nextInt(2)+1;

        // checks weather or not the player gets it right, if not the bot goes frst
        if (decision == coin) {
            System.out.println("you win!, you can pick first");
            first = 1;
        }else{
            System.out.println("too bad the bot goes first");
            first = 2;
        }/*if correct the function uses 1 to detemine that the player won,
            medyo nakakalito pero if correct it will always return 1
            else it is 2{meaning the bot goes first} */ 
        return first;
    }
    
    // used to enablet the player to pick
    public static void playerPick(){
        List<String> botList = new ArrayList<>(Arrays.asList(botHand));
        List<String> playerList = new ArrayList<>(Arrays.asList(playerHand));
        botList.removeIf(element -> element == null);

        if (playerList.size()==0) {
            botHand = botList.toArray(new String[0]);
            playerHand = playerList.toArray(new String[0]);
            winner("player");
        }else if (botList.size()==0) {
            botHand = botList.toArray(new String[0]);
            playerHand = playerList.toArray(new String[0]);
            winner("bot");
        }

        if (game!=false) {

            System.out.println("\nthe bot has "+botList.size());
            System.out.print("pick one to steal: ");
            int steal = sc.nextInt();

            // the while loop prevents the user in picking options outside of the number of cards that the opponent has in hand{tinamad ako mag multi line}
            while(steal <1 || steal > botList.size()) {
                System.out.print("That is not an option, try again: ");
                steal = sc.nextInt();
            }
            //display the stolen card
            System.out.println("\n===================================================================");
            System.out.println("\n{{{===| you stole the "+ botList.get(steal-1)+" from the opponent's hand |===}}}" );
            System.out.println("\n===================================================================\n");

            System.out.println("press 1 to proceed");
            int proceed = sc.nextInt();
            while (proceed!=1) {
                System.out.print("try again: ");
                proceed = sc.nextInt();
            }

            if (proceed == 1) {
                // adds the stolen card to the hand
                playerList.add(botList.get(steal-1));
                // removes it from the opponent
                botList.remove(steal-1);

                // convert the array list back to an array
                botHand = botList.toArray(new String[0]);
                playerHand = playerList.toArray(new String[0]);

                displayBot();
                displayPlayer();
            
            
                System.out.print("\nthe bot is next to pick, enter 1 to continue: ");
                int next = sc.nextInt();
                while (next!=1) {
                    System.out.println("try again: ");
                    next = sc.nextInt();
                }
                if (next == 1) {
                    botPick();
                }
            }
            
        }
        
    }

    public static void botPick(){
        List<String> playerList = new ArrayList<>(Arrays.asList(playerHand));
        List<String> botList = new ArrayList<>(Arrays.asList(botHand));
        playerList.removeIf(element -> element == null);

        if (playerList.size()==0) {
            botHand = botList.toArray(new String[0]);
            playerHand = playerList.toArray(new String[0]);
            winner("player");
        }else if (botList.size()==0) {
            botHand = botList.toArray(new String[0]);
            playerHand = playerList.toArray(new String[0]);
            winner("bot");
        }

        if (game != false) {
            // randomly choose a card from the players hand
            int botpick = ran.nextInt(playerList.size())+1;

            // displays stolen card
            System.out.println("\n===================================================================");
            System.out.println("\n{{{===| the bot stole the "+ playerList.get(botpick-1)+" from your hand |===}}}" );
            System.out.println("\n===================================================================\n");

            System.out.println("press 1 to proceed");
            int proceed = sc.nextInt();
            while (proceed!=1) {
                System.out.print("try again: ");
                proceed = sc.nextInt();
            }
            if (proceed ==1) {
                // adds the stolen card to the hand
                botList.add(playerList.get(botpick-1));

                // removes it from the player
                playerList.remove(botpick-1);

                // convert the array list back to an array
                botHand = botList.toArray(new String[0]);
                playerHand = playerList.toArray(new String[0]);

                displayPlayer();
                displayBot();

            
                System.out.print("\nYou are next to pick\n");
                playerPick();
                }   
            }    
    }

    public static void winner(String winner){
        if (winner == "bot") {
            System.out.println("""
                    
            ████████╗██╗░░██╗███████╗  ░██╗░░░░░░░██╗██╗███╗░░██╗███╗░░██╗███████╗██████╗░  ██╗░██████╗
            ╚══██╔══╝██║░░██║██╔════╝  ░██║░░██╗░░██║██║████╗░██║████╗░██║██╔════╝██╔══██╗  ██║██╔════╝
            ░░░██║░░░███████║█████╗░░  ░╚██╗████╗██╔╝██║██╔██╗██║██╔██╗██║█████╗░░██████╔╝  ██║╚█████╗░
            ░░░██║░░░██╔══██║██╔══╝░░  ░░████╔═████║░██║██║╚████║██║╚████║██╔══╝░░██╔══██╗  ██║░╚═══██╗
            ░░░██║░░░██║░░██║███████╗  ░░╚██╔╝░╚██╔╝░██║██║░╚███║██║░╚███║███████╗██║░░██║  ██║██████╔╝
            ░░░╚═╝░░░╚═╝░░╚═╝╚══════╝  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝  ╚═╝╚═════╝░
       
                                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒░░░░░░░░░░▒▒▒░░░░░
                                ░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░▓▓▓▒░░░░░░░░█▓▓▒▒░░░
                                ░░░░░░░░░░░░░░░▓▓█░░░░░░░░░░░░▒█▓░░░░░░░░░██▒█▓▒░░
                                ░░░░▒▒░░░░░░░░░▒▓▓░░░░░░░░░░░░▒██░░░░▒▓▓▒▓█▓▓▓░░░░
                                ░░░▒▓▓▓░░░░░░░░░▒▓▓▒░░░░▒▒░░░▒▓███▒░░▒█▓████▓░░░░░
                                ░░▓▓▓▒▓▓░░▓▓▒░░░▓▓▓▓▓▒░░▓▓▒░▒▓█▓▓██▓▓███████░░░░░░
                                ░░░▒▓▓▒▓█▓▓█▓▒░▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓██████████░░░░░░
                                ░░░░░░▓███▓▓▓▓█▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓█████████▒░░░░░░
                                ░░░░░░░▓██▓▓▓▓▓▓▓▓▒▒▒▒▒▓▓▓▓▓▓▓▓▓████████████░░░░░░
                                ░░░░░░░░▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█████▓░░░░░░
                                ░░░░░░░░░▒██████▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓█████▒▒░░░░
                                ░░░░░░░░░▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▓▓▒░░░
                                ░░░░░░░░░░▓█▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░
                                ░░░░░░░░░▒██▓▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                ░░░░░░░░░░▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░

                                ████████╗██╗░░██╗███████╗  ██████╗░░█████╗░████████╗
                                ╚══██╔══╝██║░░██║██╔════╝  ██╔══██╗██╔══██╗╚══██╔══╝
                                ░░░██║░░░███████║█████╗░░  ██████╦╝██║░░██║░░░██║░░░
                                ░░░██║░░░██╔══██║██╔══╝░░  ██╔══██╗██║░░██║░░░██║░░░
                                ░░░██║░░░██║░░██║███████╗  ██████╦╝╚█████╔╝░░░██║░░░
                                ░░░╚═╝░░░╚═╝░░╚═╝╚══════╝  ╚═════╝░░╚════╝░░░░╚═╝░░░
                    """);
                    System.out.println("\n\nHere is the last card from the game: "+ playerHand[0]);
                    System.out.println("\nthis if the excluded card from the start: "+ monkey);
                    game = false;
        }
        if (winner == "player") {
            System.out.println("""
                                
            ████████╗██╗░░██╗███████╗  ░██╗░░░░░░░██╗██╗███╗░░██╗███╗░░██╗███████╗██████╗   ██╗░██████╗
            ╚══██╔══╝██║░░██║██╔════╝  ░██║░░██╗░░██║██║████╗░██║████╗░██║██╔════╝██╔══██╗  ██║██╔════╝
            ░░░██║░░░███████║█████╗░░  ░╚██╗████╗██╔╝██║██╔██╗██║██╔██╗██║█████╗░░██████╔╝  ██║╚█████╗░
            ░░░██║░░░██╔══██║██╔══╝░░  ░░████╔═████║░██║██║╚████║██║╚████║██╔══╝░░██╔══██╗  ██║░╚═══██╗
            ░░░██║░░░██║░░██║███████╗  ░░╚██╔╝░╚██╔╝░██║██║░╚███║██║░╚███║███████╗██║░░██║  ██║██████╔╝
            ░░░╚═╝░░░╚═╝░░╚═╝╚══════╝  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝  ╚═╝╚═════╝
                        
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒░░░░░░░░░░▒▒▒░░░░░
                            ░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░▓▓▓▒░░░░░░░░█▓▓▒▒░░░
                            ░░░░░░░░░░░░░░░▓▓█░░░░░░░░░░░░▒█▓░░░░░░░░░██▒█▓▒░░
                            ░░░░▒▒░░░░░░░░░▒▓▓░░░░░░░░░░░░▒██░░░░▒▓▓▒▓█▓▓▓░░░░
                            ░░░▒▓▓▓░░░░░░░░░▒▓▓▒░░░░▒▒░░░▒▓███▒░░▒█▓████▓░░░░░
                            ░░▓▓▓▒▓▓░░▓▓▒░░░▓▓▓▓▓▒░░▓▓▒░▒▓█▓▓██▓▓███████░░░░░░
                            ░░░▒▓▓▒▓█▓▓█▓▒░▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓██████████░░░░░░
                            ░░░░░░▓███▓▓▓▓█▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓█████████▒░░░░░░
                            ░░░░░░░▓██▓▓▓▓▓▓▓▓▒▒▒▒▒▓▓▓▓▓▓▓▓▓████████████░░░░░░
                            ░░░░░░░░▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█████▓░░░░░░
                            ░░░░░░░░░▒██████▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓█████▒▒░░░░
                            ░░░░░░░░░▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▓▓▒░░░
                            ░░░░░░░░░░▓█▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░
                            ░░░░░░░░░▒██▓▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            ░░░░░░░░░░▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░

                ████████╗██╗░░██╗███████╗  ██████╗░██╗░░░░░░█████╗░██╗░░░██╗███████╗██████╗░
                ╚══██╔══╝██║░░██║██╔════╝  ██╔══██╗██║░░░░░██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗
                ░░░██║░░░███████║█████╗░░  ██████╔╝██║░░░░░███████║░╚████╔╝░█████╗░░██████╔╝
                ░░░██║░░░██╔══██║██╔══╝░░  ██╔═══╝░██║░░░░░██╔══██║░░╚██╔╝░░██╔══╝░░██╔══██╗
                ░░░██║░░░██║░░██║███████╗  ██║░░░░░███████╗██║░░██║░░░██║░░░███████╗██║░░██║
                ░░░╚═╝░░░╚═╝░░╚═╝╚══════╝  ╚═╝░░░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝

                    """);
            System.out.println("\n\nHere is the last card from the game: "+ botHand[0]);
            System.out.println("=====| this if the excluded card from the start: "+ monkey+" |=====");
            game = false;
        }
    }

    public static void end(){
        System.out.println("""
                                                            
                                  ██████████████                          
                                ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓████                      
                              ████▓▓▓▓▓▓░░░░▓▓▓▓░░██                      
                            ██▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░██                    
                            ██▓▓▓▓▓▓░░░░░░██░░░░██░░██     █ █ ▄▀█ █ █ █▀▀   ▄▀█   █▄ █ █ █▀▀ █▀▀   █▀▄ ▄▀█ █▄█                
                            ██▓▓██▓▓░░░░░░██░░░░██░░██     █▀█ █▀█ ▀▄▀ ██▄   █▀█   █ ▀█ █ █▄▄ ██▄   █▄▀ █▀█  █                
                            ██▓▓██▓▓░░██░░░░░░░░░░░░░░██                  
                              ██▓▓▓▓██░░░░░░░  ░  ░░░░░░██                
                  ██████        ██▓▓██░░░░░░░░████░░░░░░██                
                ██▓▓▓▓▓▓██        ██░░████████░░░░██████                  
              ██▓▓▓▓▓▓▓▓▓▓██      ████░░░░░░░░░░░░░░██                    
              ██▓▓▓▓██▓▓▓▓██    ██▓▓▓▓██████████████                      
              ██▓▓▓▓▓▓██████████▓▓▓▓▓▓▓▓▓▓██▓▓▓▓██                        
                ██▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓██                      
                  ████████████▓▓▓▓▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓██                    
                            ██████████▓▓██░░░░░░██░░░░██                  
                          ██░░░░░░░░░░██░░░░░░░░██░░░░██                  
                          ██░░░░░░░░░░██░░░░░░██░░░░██                    
                          ██████████████████████████                      
                                                           
                    """);
        game=false;
    }
}