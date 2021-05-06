package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class BaseGame extends Game {

    private static BaseGame game;
    public static Label.LabelStyle labelStyle;
    public static Label.LabelStyle labelStyleLevel;
    public static Label.LabelStyle labelStylePaddleStop;
    public static TextButton.TextButtonStyle textButtonStyle;
    public static TextButton.TextButtonStyle textButtonStyleLevel;
    public static TextButton.TextButtonStyle textButtonStylePaddleStop;

    public BaseGame() {
        game = this;
    }

    public void create() {

        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 36;
        fontParameters.color = Color.WHITE;
        fontParameters.borderWidth = 2.0F;
        fontParameters.borderColor = Color.BLACK;
        fontParameters.borderStraight = true;
        fontParameters.minFilter = Texture.TextureFilter.Linear;
        fontParameters.magFilter = Texture.TextureFilter.Linear;
        BitmapFont customFont = fontGenerator.generateFont(fontParameters);
        labelStyle = new Label.LabelStyle();
        labelStyle.font = customFont;
        textButtonStyle = new TextButton.TextButtonStyle();
        Texture buttonTex = new Texture(Gdx.files.internal("button.png"));
        NinePatch buttonPatch = new NinePatch(buttonTex, 24, 24, 24, 24);
        textButtonStyle.up = new NinePatchDrawable(buttonPatch);
        textButtonStyle.font = customFont;
        textButtonStyle.fontColor = Color.GRAY;
        ////////////////////////////
        InputMultiplexer imm = new InputMultiplexer();
        Gdx.input.setInputProcessor(imm);
        FreeTypeFontGenerator fontGeneratorLevel = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParametersLevel = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParametersLevel.size = 72;
        fontParametersLevel.color = Color.WHITE;
        fontParametersLevel.borderWidth = 2.0F;
        fontParametersLevel.borderColor = Color.BLACK;
        fontParametersLevel.borderStraight = true;
        fontParametersLevel.minFilter = Texture.TextureFilter.Linear;
        fontParametersLevel.magFilter = Texture.TextureFilter.Linear;
        BitmapFont customFontLevel = fontGeneratorLevel.generateFont(fontParametersLevel);
        labelStyleLevel = new Label.LabelStyle();
        labelStyleLevel.font = customFontLevel;
        textButtonStyleLevel = new TextButton.TextButtonStyle();
        Texture buttonTexLevel = new Texture(Gdx.files.internal("button.png"));
        NinePatch buttonPatchLevel = new NinePatch(buttonTexLevel, 24, 24, 24, 24);
        textButtonStyleLevel.up = new NinePatchDrawable(buttonPatchLevel);
        textButtonStyleLevel.font = customFontLevel;
        textButtonStyleLevel.fontColor = Color.GRAY;
        ///////////////////////////////////////
        InputMultiplexer pdl = new InputMultiplexer();
        Gdx.input.setInputProcessor(pdl);
        FreeTypeFontGenerator fontGeneratorPaddleStop = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParametersPaddleStop = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParametersPaddleStop.size = 144;
        fontParametersPaddleStop.color = Color.WHITE;
        fontParametersPaddleStop.borderWidth = 2.0F;
        fontParametersPaddleStop.borderColor = Color.WHITE;
        fontParametersPaddleStop.borderStraight = true;
        fontParametersPaddleStop.minFilter = Texture.TextureFilter.Linear;
        fontParametersPaddleStop.magFilter = Texture.TextureFilter.Linear;
        BitmapFont customFontPaddleStop = fontGeneratorPaddleStop.generateFont(fontParametersPaddleStop);
        labelStylePaddleStop = new Label.LabelStyle();
        labelStylePaddleStop.font = customFontPaddleStop;
        textButtonStylePaddleStop = new TextButton.TextButtonStyle();
        Texture buttonTexPaddleStop = new Texture(Gdx.files.internal("button.png"));
        NinePatch buttonPatchPaddleStop = new NinePatch(buttonTexPaddleStop, 24, 24, 24, 24);
        textButtonStylePaddleStop.up = new NinePatchDrawable(buttonPatchPaddleStop);
        textButtonStylePaddleStop.font = customFontLevel;
        textButtonStylePaddleStop.fontColor = Color.RED;
    }

    public static void setActiveScreen(BaseScreen s) {
        game.setScreen(s);
    }

    public static void setActiveScreen(LoadingScreen s) {
        game.setScreen(s);
    }

}
