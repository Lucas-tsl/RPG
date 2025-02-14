import java.util.ArrayList;
import java.util.Scanner;
//import org.apache.commons.lang3.StringUtils;

public class Menu {
    private String title;
    private ArrayList<MenuItem> items;
    private int defaultChoice;
    private int numberOfChoices = 0;

    public Menu(String title, ArrayList<MenuItem> items, int defaultChoice) {
        this.title = title;
        this.items = items;
        this.defaultChoice = defaultChoice;
        this.items.removeIf(item -> item.isDisabled()); // Supprime de notre ArrayList les MenuItem désactivés
        this.numberOfChoices = this.items.size();
        // TODO Vérifier qu'aucun doublon de valeur de position n'est présent dans notre ArrayList
        this.items.sort((item1, item2) -> item1.getchoiceRank() - item2.getchoiceRank()); // Tri notre ArrayList en fonction du choiceRank
    }

    public Menu(String title, ArrayList<MenuItem> items) {
        this(title, items, 1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public int getDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(int defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    public String exec(Scanner scanner) {
        int choice = -1;
        do {
            System.out.print(this);
            if (choice > numberOfChoices) {
                System.out.println("Veuillez saisie une valeur comprise entre 1 et " + numberOfChoices + ".");
            }
            System.out.print(">>> ");
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                choice = -1;  // En cas d'erreur, on reste dans la boucle d'interaction
                System.out.println("Veuillez saisir quelque chose.");
            }
        } while (choice < 1 || choice > numberOfChoices);
        return items.get(choice - 1).getChoiceAction();
    }

    public String toString() {
        StringBuilder menuItems = new StringBuilder();
        int index = 0;
        for (MenuItem item : items) {
            menuItems.append(item.isEnabled() ? "[" + ++index + "] " + item.getChoiceLabel() + ".\n" : "");
            //menuItems.append(item.isEnabled() ? "[" + item.getChoiceValue() + "] " + item.getChoiceLabel() + ".\n" : "");
        }

        String menuTemplate = """
                ****************************************
                ***** %S
                ****************************************
                %s
                ****************************************
                """;

        String menu = String.format(menuTemplate, this.title, menuItems.toString().trim());

        return menu;
    }
}
