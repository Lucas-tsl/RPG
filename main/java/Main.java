import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String choice;

    public static void main(String[] args) {
        Level topLevel = new Level(
                "L'ombre du passé",
                "Il était une fois un village perdu dans les montagnes, où une légende ancienne hantait encore les esprits...",
                "Ainsi, le mystère de l’ombre du passé fut levé, laissant derrière lui un village enfin en paix."
        );

        ArrayList<Level> levels = new ArrayList<>();

        levels.add(new Level(
                "Les murmures de la forêt",
                "Alors que Léa s’aventurait seule dans la forêt interdite, elle entendit des voix chuchoter son nom...",
                "Les esprits de la forêt, enfin apaisés, disparurent dans un dernier souffle de vent."
        ));

        levels.add(new Level(
                "Le dernier train pour Minuit",
                "Paul monta à bord du train en direction d’une destination inconnue, sans savoir qu’il ne reviendrait jamais...",
                "À Minuit, le train s’effaça dans l'obscurité, ne laissant derrière lui qu’une gare vide et silencieuse."
        ));

        levels.add(new Level(
                "Le secret du vieux phare",
                "Par une nuit brumeuse, un jeune marin trouva une carte menant à un phare oublié...",
                "Le secret du vieux phare révéla un trésor inestimable : une lettre d’amour jamais envoyée."
        ));

        ArrayList<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(
                1,
                "Combattre",
                "fight"
        ));

        menuItems.add(new MenuItem(
                2,
                "Utiliser un élixir",
                "useElixir",
                false
        ));

        menuItems.add(new MenuItem(
                3,
                "Prendre la fuite",
                "escape"
        ));

        Menu fightMenu = new Menu("choisir une action", menuItems);

        /*
         * ********** Tests des classes Story et Level
         */
        Story story = new Story(topLevel, levels);
        System.out.println("Nombre de niveaux : " + story.getLevelsNumber());

        while (!story.isLastLevel()) {
            System.out.println("Niveau " + story.getCurrentLevelNumber() + " : " + story.getCurrentLevel().getTitle());
            story.nextLevel();
        }

        /*
         * ********** Tests des classes Player et Enemy
         */
        Player player = new Player("Joueur");
        Enemy enemy = new Enemy("Ennemi", player.getExperience());

        do {
            System.out.println(player);
            System.out.println(enemy);
            choice = fightMenu.exec(scanner);
        } while(player.fight(enemy, choice));

        System.out.println(player);
        System.out.println(enemy);
    }
}
