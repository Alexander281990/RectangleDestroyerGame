package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class BaseScreen implements Screen, InputProcessor {

    protected Stage mainStage = new Stage();
    protected Stage uiStage = new Stage();
    protected Table uiTable = new Table();
    Table myTable = new Table();
    Table uiModalWindowTable = new Table();
    Table uiModalWindowTable_2 = new Table();
    Table uiModalWindowTable_3 = new Table();



    BaseScreen() {
        this.uiTable.setFillParent(true);
        this.myTable.setFillParent(true);
        this.uiStage.addActor(this.uiTable);
        this.uiStage.addActor(this.myTable);
        this.uiStage.addActor(this.uiModalWindowTable);
        this.uiStage.addActor(this.uiModalWindowTable_2);
        this.uiStage.addActor(this.uiModalWindowTable_3);
        this.initialize();
    }

    public void initialize(){
        // Для созранения прогресса игры в случае ее закрытия

        // Для созранения прогресса игры в случае ее закрытия(конец)
    }

    public abstract void update(float var1);

    public void render(float dt) {
        dt = Math.min(dt, 0.033333335F);
        //dt = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
        this.uiStage.act(dt);
        this.mainStage.act(dt);
        this.update(dt);
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.mainStage.draw();
        this.uiStage.draw();
    }

    public void resize(int width, int height) {
    }

    public void pause() {

    }

    public void resume() {
    }

    public void dispose() {
//        // Для созранения прогресса игры в случае ее закрытия

//        // Для созранения прогресса игры в случае ее закрытия(конец)
//        Gdx.app.log("MyTag", "my informative message");
    }

    public void show() {
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.addProcessor(this);
        im.addProcessor(this.uiStage);
        im.addProcessor(this.mainStage);
    }

    public void hide() {
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.removeProcessor(this);
        im.removeProcessor(this.uiStage);
        im.removeProcessor(this.mainStage);
    }

    public boolean isTouchDownEvent(Event e) {
        return e instanceof InputEvent && ((InputEvent)e).getType().equals(InputEvent.Type.touchDown);
    }

    public boolean keyDown(int keycode) {
//            if(keycode == Input.Keys.BACK){ // Если нажали кнопку назад, то вызываем метод dispose();
//
//            }
            return false;
        }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char c) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

}
