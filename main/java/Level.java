public class Level {
    private String title;
    private String intro;
    private String outro;

    public Level(String name, String intro, String outro) {
        this.title = name;
        this.intro = intro;
        this.outro = outro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }
}
