/**
 * Classe destinée à gérer les personnages du RPG
 * @author Captain America
 */
public abstract class Character { // Classe abstraite (car non instantiable) imposant un « contrat » pour les classes dérivées
    private final String BATTLE_MODE = "1";
    private final String ESCAPE_MODE = "2";
    // Attributs communs à l'ensemble des classes filles
    private String name;
    private int health;
    private int maxHealth;
    private int experience;

    // Constructeur : définit l'état initial d'un personnage
    public Character(String name, int maxHealth, int experience) {
        this.name = name;
        this.health = this.maxHealth = maxHealth;
        this.experience = experience;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decreaseHealth(int points) {
        this.health -= points;
    }

    public void increaseHealth(int points) {
        this.health += points;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void decreaseExperience(int points) {
        this.experience -= points;
    }

    public void increaseExperience(int points) {
        this.experience += points;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public boolean fight(Character character, String mode) {
        boolean isOngoing = true;
        int dealtDamage;
        int takenDamage;

        switch(mode) {
            case BATTLE_MODE:
                dealtDamage = this.attack() - character.defend();
                takenDamage = character.attack() - this.defend();

                if (takenDamage < 0) {
                    dealtDamage -= takenDamage / 2;
                    takenDamage = 0;
                }

                if (dealtDamage < 0) {
                    dealtDamage = 0;
                }

                this.decreaseHealth(takenDamage);
                character.decreaseHealth(dealtDamage);

                if (this.isDead()) {
                    isOngoing = false;
                } else if (character.isDead()) {
                    // Calcul de montée en points d'expérience
                    this.increaseExperience(character.experience);
                    isOngoing = false;
                }
                break;
            case ESCAPE_MODE:
                if (Math.random() * 10 + 1 <= 3.5) {
                        isOngoing = false;
                    break;
                } else {
                    takenDamage = character.attack();
                    this.decreaseHealth(takenDamage);
                    if (this.isDead()) {
                        isOngoing = false;
                    }
                }
                break;
            default:
                // TODO À implémenter si nécessaire
                break;
        }
        return isOngoing;
    }

    // Méthodes abstraites liées à l'action de « combattre »
    public abstract int attack();

    public abstract int defend();

    public String toString() {
        String statsTemplate = """
                ****************************************
                ***** %S
                ****************************************
                * HP : %d / %d
                * XP : %d
                * Compétences : %s
                * Équipements : %s
                * Position: [X:%d, Y:%d]
                ****************************************
                """;

        String stats = String.format(statsTemplate, this.name, this.health, this.maxHealth, this.experience, "à implémenter", "à implémenter", 0, 0);

        return stats;
    }
}
