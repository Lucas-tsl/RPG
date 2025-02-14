public class Player extends Character {
    private static final int MAX_HEALTH = 100;
    private static final int EXPERIENCE = 0;
    private static final int SKILLS_NUMBER = 1;

    public int attackSkillsNumber, defenseSkillsNumber;

    public Player(String name) {
        // Appel au constructeur de la classe mère
        super(name, Player.MAX_HEALTH, Player.EXPERIENCE);
        // Initialisation du nombre de compétences (attaque / défense)
        this.attackSkillsNumber = 0; // FIXME Initialiser les compétences en début de partie
        this.defenseSkillsNumber = Player.SKILLS_NUMBER; // FIXME Initialiser les compétences en début de partie
    }

    @Override
    public int attack() { // Définition de l'attaque du point de vue du joueur
        return (int) (Math.random() * ((double) this.getExperience() / 4 + attackSkillsNumber * 3 + 3) + (double) this.getExperience() / 10 + attackSkillsNumber * 2 + defenseSkillsNumber + 1);
    }

    @Override
    public int defend() { // Définition de la défense du point de vue du joueur
        return (int) (Math.random() * ((double) this.getExperience() / 4 + defenseSkillsNumber * 3 + 3) + (double) this.getExperience() / 10 + defenseSkillsNumber * 2 + attackSkillsNumber + 1);
    }
}
