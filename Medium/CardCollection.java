import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Card class to represent a playing card
class Card {
    private String symbol; // The suit of the card (e.g., "Hearts", "Spades")
    private String value;  // The face value of the card (e.g., "A", "2", "King")

    // Constructor to initialize a card
    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    // Getter method for symbol
    public String getSymbol() {
        return symbol;
    }

    // Getter method for value
    public String getValue() {
        return value;
    }

    // Override toString() to provide a user-friendly representation of the card
    @Override
    public String toString() {
        return value + " of " + symbol; // e.g., "A of Hearts"
    }
}

public class CardCollection {

    public static void main(String[] args) {
        // HashMap to store the card deck. Key: symbol, Value: List of cards
        Map<String, List<Card>> cardDeck = new HashMap<>();
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Initialize the deck
        String[] symbols = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Populate the deck with cards
        for (String symbol : symbols) {
            cardDeck.put(symbol, new ArrayList<>()); // Create a new list for each symbol
            for (String value : values) {
                cardDeck.get(symbol).add(new Card(symbol, value)); // Add card to the corresponding symbol's list
            }
        }

        // Main program loop
        while (true) {
            System.out.println("\nEnter a symbol to find cards (or type 'exit'):");
            String inputSymbol = scanner.nextLine(); // Get user input

            if (inputSymbol.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user types "exit"
            }

            // Check if the symbol exists in the deck
            if (cardDeck.containsKey(inputSymbol)) {
                List<Card> cards = cardDeck.get(inputSymbol); // Retrieve the list of cards for the given symbol

                if (cards.isEmpty()) {
                    System.out.println("No cards found for this symbol.");
                } else {
                    System.out.println("Cards of " + inputSymbol + ":");
                    for (Card card : cards) { // Iterate through the cards and print them
                        System.out.println(card);
                    }
                }
            } else {
                System.out.println("Invalid symbol."); // Handle invalid symbol input
            }
        }
        scanner.close(); // Close the scanner to release resources
    }
}
