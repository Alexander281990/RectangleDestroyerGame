package alex.iv.rect.destroy.controller;

public class RectangleGame extends BaseGame {

    public IActivityRequestHandler requestHandler;

    public RectangleGame(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void create() {
        super.create();
        setActiveScreen(new StartScreen(requestHandler));
    }

}
