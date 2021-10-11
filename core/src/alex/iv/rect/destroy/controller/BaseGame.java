package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
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
    static Label.LabelStyle labelStyleRU;
    public static Label.LabelStyle labelStyleLevel;
    static Label.LabelStyle labelStylePaddleStop;
    public static TextButton.TextButtonStyle textButtonStyle;
    static TextButton.TextButtonStyle textButtonStyleStartScreen;
    static TextButton.TextButtonStyle textButtonStyleLevel;

    public BaseGame() {
        game = this;
    }

    // метод, который возвращает размер экрана использующегося устройства в дюймах
    private static double getScreenSizeInches() {
        // Use the primary monitor as baseline
        // It would also be possible to get the monitor where the window is displayed
        Graphics.Monitor primary = Gdx.graphics.getPrimaryMonitor();
        Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode(primary);

        float dpi = 160 * Gdx.graphics.getDensity();
        float widthInches = displayMode.width / dpi;
        float heightInches = displayMode.height / dpi;

        //Use the pythagorean theorem to get the diagonal screen size
        return Math.sqrt(Math.pow(widthInches, 2) + Math.pow(heightInches, 2));
    }
    // метод, который возвращает размер экрана использующегося устройства в дюймах(конец)

    public void create() {

        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);

        String FONT_CHARS  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\\\/?-+=()*&.;:,{}\\\"´`'<>";
        BitmapFont font1;
        final String FONT_PATH = "OpenSans.ttf";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = FONT_CHARS;
        parameter.size = 36;
        parameter.color = Color.WHITE;
        parameter.borderWidth = 2.0f;
        parameter.borderStraight = true;
        parameter.minFilter = Texture.TextureFilter.Linear;
        parameter.magFilter = Texture.TextureFilter.Linear;
        font1 = generator.generateFont(parameter);
        labelStyleRU = new Label.LabelStyle();
        labelStyleRU.font = font1;

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
        InputMultiplexer startScreen = new InputMultiplexer();
        Gdx.input.setInputProcessor(startScreen);
        FreeTypeFontGenerator fontGeneratorStartScreen = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParametersStartScreen = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParametersStartScreen.size = 36;
        fontParametersStartScreen.color = Color.WHITE;
        fontParametersStartScreen.borderWidth = 2.0F;
        fontParametersStartScreen.borderColor = Color.BLACK;
        fontParametersStartScreen.borderStraight = true;
        fontParametersStartScreen.minFilter = Texture.TextureFilter.Linear;
        fontParametersStartScreen.magFilter = Texture.TextureFilter.Linear;
        BitmapFont customFontStartScreen = fontGeneratorStartScreen.generateFont(fontParametersStartScreen);
        labelStyleLevel = new Label.LabelStyle();
        labelStyleLevel.font = customFontStartScreen;
        textButtonStyleStartScreen = new TextButton.TextButtonStyle();
        Texture buttonTexStartScreen = new Texture(Gdx.files.internal("background/button_green.png"));
        NinePatch buttonPatchStartScreen = new NinePatch(buttonTexStartScreen, 24, 24, 24, 24);
        textButtonStyleStartScreen.up = new NinePatchDrawable(buttonPatchStartScreen);
        textButtonStyleStartScreen.font = customFontStartScreen;
        textButtonStyleStartScreen.fontColor = Color.GRAY;
        ///////////////////////////////////////
        InputMultiplexer imm = new InputMultiplexer();
        Gdx.input.setInputProcessor(imm);
        FreeTypeFontGenerator fontGeneratorLevel = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParametersLevel = new FreeTypeFontGenerator.FreeTypeFontParameter();
        //fontParametersLevel.size = 72;
        if (getScreenSizeInches() <= 5.7) {
            fontParametersLevel.size = 72;
        } else if (getScreenSizeInches() > 5.7 && getScreenSizeInches() <= 6.1 ) {
            fontParametersLevel.size = 72;
        } else if (getScreenSizeInches() > 6.1 && getScreenSizeInches() <= 7 ) {
            fontParametersLevel.size = 72;
        } else if (getScreenSizeInches() > 7 && getScreenSizeInches() <= 8 ) {
            fontParametersLevel.size = 36;
        }
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
        TextButton.TextButtonStyle textButtonStylePaddleStop = new TextButton.TextButtonStyle();
        Texture buttonTexPaddleStop = new Texture(Gdx.files.internal("button.png"));
        NinePatch buttonPatchPaddleStop = new NinePatch(buttonTexPaddleStop, 24, 24, 24, 24);
        textButtonStylePaddleStop.up = new NinePatchDrawable(buttonPatchPaddleStop);
        textButtonStylePaddleStop.font = customFontLevel;
        textButtonStylePaddleStop.fontColor = Color.RED;
    }

    public static void setActiveScreen(BaseScreen s) {
        game.setScreen(s);
    }


}
