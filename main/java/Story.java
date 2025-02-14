import java.util.ArrayList;

public class Story {
    private Level topLevel;
    private ArrayList<Level> levels;
    private int currentLevel = 0;
    private int levelsNumber;

    public Story(Level topLevel, ArrayList<Level> levels) {
        this.topLevel = topLevel;
        this.levels = levels;
        this.levelsNumber = levels.size();
    }

    public Story(ArrayList<Level> levels) {
        this.topLevel = levels.getFirst();
        levels.removeFirst();
        this.levels = levels;
    }

    public Level getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(Level topLevel) {
        this.topLevel = topLevel;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

    public int getLevelsNumber() {
        return this.levelsNumber;
    }

    public int getCurrentLevelNumber() {
        return this.currentLevel;
    }

    public Level getCurrentLevel() {
        return this.levels.get(this.currentLevel);
    }

    public boolean nextLevel() {
        return (this.currentLevel++ < this.levelsNumber);
    }

    public boolean isLastLevel() {
        return this.currentLevel == this.levelsNumber;
    }
}
