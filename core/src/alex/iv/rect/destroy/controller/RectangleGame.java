package alex.iv.rect.destroy.controller;

public class RectangleGame extends BaseGame {

    public RectangleGame() {
    }

    public void create() {
        super.create();
        setActiveScreen(new StartScreen());
    }
}
