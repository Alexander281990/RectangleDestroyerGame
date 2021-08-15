package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.MenuScreen;
import alex.iv.rect.destroy.controller.RectangleGame;

public class VictoryScreen extends LevelScreenMain {

    private float windowPlayWidth;
    private float windowPlayHeight;

    public VictoryScreen(IActivityRequestHandler requestHandler, String keyColor) {
        super(requestHandler);
        int attainmentColorLevel = 1;
        live += 3;
        pref.putInteger(keyColor, attainmentColorLevel);
        pref.putInteger("liveMemory", live);
        pref.flush();
        requestHandler.showBannerAd(); // при запуске IntermediateScreen запускается рекламный банер в нижней части экрана
    }

//    public VictoryScreen() {
//
//    }

    public void initialize() {
//        windowPlayWidth = Gdx.graphics.getWidth();
//        windowPlayHeight = Gdx.graphics.getHeight() / 2f - 100;

        final TextButton nextButton = new TextButton( "NEXT", BaseGame.textButtonStyle );
        uiStage.addActor(nextButton);
        nextButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new MenuScreen(requestHandler));
                        //uiModalWindowTable.remove();
                        return false;
                    }
                }
        );
//
//        //uiTable.setDebug(true); // рисует границы ячеек и виджетов для Table(удобно для отладки)
//        uiTable.align(Align.center|Align.top);
//        uiTable.add(menuButton);
//        uiTable.row();

//        // устанавливает фоновый цвет в Table
//        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
//        bgPixmap.setColor(Color.CYAN);
//        bgPixmap.fill();
//        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
//        // устанавливает фоновый цвет в Table(конец)
//
//        uiTable.align(Align.center);
//        uiModalWindowTable.align(Align.center|Align.bottom);
//        uiTable.add(uiModalWindowTable).width(Gdx.graphics.getWidth()-200).height(Gdx.graphics.getHeight()-400);
//        uiModalWindowTable.setBackground(textureRegionDrawableBg);
//        uiModalWindowTable.getColor().a = 0.1f;
//        uiModalWindowTable.add(nextButton).align(Align.bottom);
//        nextButton.getColor().a = 10;


    }

    public void update(float dt) {

    }
}
