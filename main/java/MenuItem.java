public class MenuItem {
    private int choiceRank;
    private String choiceLabel;
    private String choiceAction;
    private boolean enabled;

    public MenuItem(int choiceRank, String choiceLabel, String choiceAction, boolean enabled) {
        this.choiceRank = choiceRank;
        this.choiceLabel = choiceLabel;
        this.choiceAction = choiceAction;
        this.enabled = enabled;
    }

    public MenuItem(int choiceRank, String choiceLabel, String choiceAction) {
        this(choiceRank, choiceLabel, choiceAction, true);
    }

    public int getchoiceRank() {
        return choiceRank;
    }

    public void setchoiceRank(int choiceRank) {
        this.choiceRank = choiceRank;
    }

    public String getChoiceLabel() {
        return choiceLabel;
    }

    public void setChoiceLabel(String choiceLabel) {
        this.choiceLabel = choiceLabel;
    }

    public String getChoiceAction() {
        return choiceAction;
    }

    public void setChoiceAction(String choiceAction) {
        this.choiceAction = choiceAction;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isDisabled() {
        return !enabled;
    }
}
