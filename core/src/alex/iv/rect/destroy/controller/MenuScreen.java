package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.LevelScreen_1;
import alex.iv.rect.destroy.LevelScreen_10;
import alex.iv.rect.destroy.LevelScreen_11;
import alex.iv.rect.destroy.LevelScreen_12;
import alex.iv.rect.destroy.LevelScreen_13;
import alex.iv.rect.destroy.LevelScreen_14;
import alex.iv.rect.destroy.LevelScreen_15;
import alex.iv.rect.destroy.LevelScreen_16;
import alex.iv.rect.destroy.LevelScreen_17;
import alex.iv.rect.destroy.LevelScreen_18;
import alex.iv.rect.destroy.LevelScreen_19;
import alex.iv.rect.destroy.LevelScreen_2;
import alex.iv.rect.destroy.LevelScreen_20;
import alex.iv.rect.destroy.LevelScreen_21;
import alex.iv.rect.destroy.LevelScreen_22;
import alex.iv.rect.destroy.LevelScreen_23;
import alex.iv.rect.destroy.LevelScreen_24;
import alex.iv.rect.destroy.LevelScreen_25;
import alex.iv.rect.destroy.LevelScreen_26;
import alex.iv.rect.destroy.LevelScreen_27;
import alex.iv.rect.destroy.LevelScreen_28;
import alex.iv.rect.destroy.LevelScreen_29;
import alex.iv.rect.destroy.LevelScreen_3;
import alex.iv.rect.destroy.LevelScreen_30;
import alex.iv.rect.destroy.LevelScreen_4;
import alex.iv.rect.destroy.LevelScreen_5;
import alex.iv.rect.destroy.LevelScreen_6;
import alex.iv.rect.destroy.LevelScreen_7;
import alex.iv.rect.destroy.LevelScreen_8;
import alex.iv.rect.destroy.LevelScreen_9;
import alex.iv.rect.destroy.actors.Lock;

public class MenuScreen extends StartScreen {

    public IActivityRequestHandler requestHandler;
    public LevelScreenMain levelScreenMain;
    public static Preferences pref;
    private int countGreenGroup_1;
    private int countGreenGroup_2;
    private int countGreenGroup_3;

    public MenuScreen() {

    }

    public MenuScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void initialize() {

        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне

        attainmentColorLevel_1 = pref.getInteger("attainmentColorLevelMemory_1");
        attainmentColorLevel_2 = pref.getInteger("attainmentColorLevelMemory_2");
        attainmentColorLevel_3 = pref.getInteger("attainmentColorLevelMemory_3");
        attainmentColorLevel_4 = pref.getInteger("attainmentColorLevelMemory_4");
        attainmentColorLevel_5 = pref.getInteger("attainmentColorLevelMemory_5");
        attainmentColorLevel_6 = pref.getInteger("attainmentColorLevelMemory_6");
        attainmentColorLevel_7 = pref.getInteger("attainmentColorLevelMemory_7");
        attainmentColorLevel_8 = pref.getInteger("attainmentColorLevelMemory_8");
        attainmentColorLevel_9 = pref.getInteger("attainmentColorLevelMemory_9");
        attainmentColorLevel_10 = pref.getInteger("attainmentColorLevelMemory_10");
        attainmentColorLevel_11 = pref.getInteger("attainmentColorLevelMemory_11");
        attainmentColorLevel_12 = pref.getInteger("attainmentColorLevelMemory_12");
        attainmentColorLevel_13 = pref.getInteger("attainmentColorLevelMemory_13");
        attainmentColorLevel_14 = pref.getInteger("attainmentColorLevelMemory_14");
        attainmentColorLevel_15 = pref.getInteger("attainmentColorLevelMemory_15");
        attainmentColorLevel_16 = pref.getInteger("attainmentColorLevelMemory_16");
        attainmentColorLevel_17 = pref.getInteger("attainmentColorLevelMemory_17");
        attainmentColorLevel_18 = pref.getInteger("attainmentColorLevelMemory_18");
        attainmentColorLevel_19 = pref.getInteger("attainmentColorLevelMemory_19");
        attainmentColorLevel_20 = pref.getInteger("attainmentColorLevelMemory_20");
        attainmentColorLevel_21 = pref.getInteger("attainmentColorLevelMemory_21");
        attainmentColorLevel_22 = pref.getInteger("attainmentColorLevelMemory_22");
        attainmentColorLevel_23 = pref.getInteger("attainmentColorLevelMemory_23");
        attainmentColorLevel_24 = pref.getInteger("attainmentColorLevelMemory_24");
        attainmentColorLevel_25 = pref.getInteger("attainmentColorLevelMemory_25");
        attainmentColorLevel_26 = pref.getInteger("attainmentColorLevelMemory_26");
        attainmentColorLevel_27 = pref.getInteger("attainmentColorLevelMemory_27");
        attainmentColorLevel_28 = pref.getInteger("attainmentColorLevelMemory_28");
        attainmentColorLevel_29 = pref.getInteger("attainmentColorLevelMemory_29");
        attainmentColorLevel_30 = pref.getInteger("attainmentColorLevelMemory_30");

        recordsLevel_1 = pref.getInteger("records_1");
        recordsLevel_2 = pref.getInteger("records_2");
        recordsLevel_3 = pref.getInteger("records_3");
        recordsLevel_4 = pref.getInteger("records_4");
        recordsLevel_5 = pref.getInteger("records_5");
        recordsLevel_6 = pref.getInteger("records_6");
        recordsLevel_7 = pref.getInteger("records_7");
        recordsLevel_8 = pref.getInteger("records_8");
        recordsLevel_9 = pref.getInteger("records_9");
        recordsLevel_10 = pref.getInteger("records_10");
        recordsLevel_11 = pref.getInteger("records_11");
        recordsLevel_12 = pref.getInteger("records_12");
        recordsLevel_13 = pref.getInteger("records_13");
        recordsLevel_14 = pref.getInteger("records_14");
        recordsLevel_15 = pref.getInteger("records_15");
        recordsLevel_16 = pref.getInteger("records_16");
        recordsLevel_17 = pref.getInteger("records_17");
        recordsLevel_18 = pref.getInteger("records_18");
        recordsLevel_19 = pref.getInteger("records_19");
        recordsLevel_20 = pref.getInteger("records_20");
        recordsLevel_21 = pref.getInteger("records_21");
        recordsLevel_22 = pref.getInteger("records_22");
        recordsLevel_23 = pref.getInteger("records_23");
        recordsLevel_24 = pref.getInteger("records_24");
        recordsLevel_25 = pref.getInteger("records_25");
        recordsLevel_26 = pref.getInteger("records_26");
        recordsLevel_27 = pref.getInteger("records_27");
        recordsLevel_28 = pref.getInteger("records_28");
        recordsLevel_29 = pref.getInteger("records_29");
        recordsLevel_30 = pref.getInteger("records_30");

        //countGreenLevelScreen = pref.getInteger("countGreenLevels");

        Lock lock1 = new Lock(0, 0, mainStage);
        Lock lock2 = new Lock(0, 0, mainStage);
        Lock lock3 = new Lock(0, 0, mainStage);
        Lock lock4 = new Lock(0, 0, mainStage);
        Lock lock5 = new Lock(0, 0, mainStage);
        Lock lock6 = new Lock(0, 0, mainStage);
        Lock lock7 = new Lock(0, 0, mainStage);
        Lock lock8 = new Lock(0, 0, mainStage);
        Lock lock9 = new Lock(0, 0, mainStage);
        Lock lock10 = new Lock(0, 0, mainStage);
        Lock lock11 = new Lock(0, 0, mainStage);
        Lock lock12 = new Lock(0, 0, mainStage);
        Lock lock13 = new Lock(0, 0, mainStage);
        Lock lock14 = new Lock(0, 0, mainStage);
        Lock lock15 = new Lock(0, 0, mainStage);
        Lock lock16 = new Lock(0, 0, mainStage);
        Lock lock17 = new Lock(0, 0, mainStage);
        Lock lock18 = new Lock(0, 0, mainStage);
        Lock lock19 = new Lock(0, 0, mainStage);
        Lock lock20 = new Lock(0, 0, mainStage);
        Lock lock21 = new Lock(0, 0, mainStage);
        Lock lock22 = new Lock(0, 0, mainStage);
        Lock lock23 = new Lock(0, 0, mainStage);
        Lock lock24 = new Lock(0, 0, mainStage);
        Lock lock25 = new Lock(0, 0, mainStage);
        Lock lock26 = new Lock(0, 0, mainStage);
        Lock lock27 = new Lock(0, 0, mainStage);
        Lock lock28 = new Lock(0, 0, mainStage);
        Lock lock29 = new Lock(0, 0, mainStage);
        Lock lock30 = new Lock(0, 0, mainStage);

        levelScreenMain = new LevelScreenMain(requestHandler);
// инициализация кнопок Level
        TextButton level_1_Button = new TextButton("01", BaseGame.textButtonStyleLevel);
        TextButton level_2_Button = new TextButton("02", BaseGame.textButtonStyleLevel);
        TextButton level_3_Button = new TextButton("03", BaseGame.textButtonStyleLevel);
        TextButton level_4_Button = new TextButton("04", BaseGame.textButtonStyleLevel);
        TextButton level_5_Button = new TextButton("05", BaseGame.textButtonStyleLevel);
        TextButton level_6_Button = new TextButton("06", BaseGame.textButtonStyleLevel);
        TextButton level_7_Button = new TextButton("07", BaseGame.textButtonStyleLevel);
        TextButton level_8_Button = new TextButton("08", BaseGame.textButtonStyleLevel);
        TextButton level_9_Button = new TextButton("09", BaseGame.textButtonStyleLevel);
        TextButton level_10_Button = new TextButton("10", BaseGame.textButtonStyleLevel);
        TextButton level_11_Button = new TextButton("11", BaseGame.textButtonStyleLevel);
        TextButton level_12_Button = new TextButton("12", BaseGame.textButtonStyleLevel);
        TextButton level_13_Button = new TextButton("13", BaseGame.textButtonStyleLevel);
        TextButton level_14_Button = new TextButton("14", BaseGame.textButtonStyleLevel);
        TextButton level_15_Button = new TextButton("15", BaseGame.textButtonStyleLevel);
        TextButton level_16_Button = new TextButton("16", BaseGame.textButtonStyleLevel);
        TextButton level_17_Button = new TextButton("17", BaseGame.textButtonStyleLevel);
        TextButton level_18_Button = new TextButton("18", BaseGame.textButtonStyleLevel);
        TextButton level_19_Button = new TextButton("19", BaseGame.textButtonStyleLevel);
        TextButton level_20_Button = new TextButton("20", BaseGame.textButtonStyleLevel);
        TextButton level_21_Button = new TextButton("21", BaseGame.textButtonStyleLevel);
        TextButton level_22_Button = new TextButton("22", BaseGame.textButtonStyleLevel);
        TextButton level_23_Button = new TextButton("23", BaseGame.textButtonStyleLevel);
        TextButton level_24_Button = new TextButton("24", BaseGame.textButtonStyleLevel);
        TextButton level_25_Button = new TextButton("25", BaseGame.textButtonStyleLevel);
        TextButton level_26_Button = new TextButton("26", BaseGame.textButtonStyleLevel);
        TextButton level_27_Button = new TextButton("27", BaseGame.textButtonStyleLevel);
        TextButton level_28_Button = new TextButton("28", BaseGame.textButtonStyleLevel);
        TextButton level_29_Button = new TextButton("29", BaseGame.textButtonStyleLevel);
        TextButton level_30_Button = new TextButton("30", BaseGame.textButtonStyleLevel);

        if (attainmentColorLevel_1 == 0) {
            level_1_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_1 == 1) {
                level_1_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_2 == 0) {
            level_2_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_2 == 1) {
                level_2_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_3 == 0) {
            level_3_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_3 == 1) {
                level_3_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_4 == 0) {
            level_4_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_4 == 1) {
                level_4_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_5 == 0) {
            level_5_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_5 == 1) {
                level_5_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_6 == 0) {
            level_6_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_6 == 1) {
                level_6_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_7 == 0) {
            level_7_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_7 == 1) {
                level_7_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_8 == 0) {
            level_8_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_8 == 1) {
                level_8_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_9 == 0) {
            level_9_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_9 == 1) {
                level_9_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_10 == 0) {
            level_10_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_10 == 1) {
                level_10_Button.setColor(Color.GREEN);
                countGreenGroup_1++;
            }
        }

        if (attainmentColorLevel_11 == 0) {
            level_11_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_11 == 1) {
                level_11_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_12 == 0) {
            level_12_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_12 == 1) {
                level_12_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_13 == 0) {
            level_13_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_13 == 1) {
                level_13_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_14 == 0) {
            level_14_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_14 == 1) {
                level_14_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_15 == 0) {
            level_15_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_15 == 1) {
                level_15_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_16 == 0) {
            level_16_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_16 == 1) {
                level_16_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_17 == 0) {
            level_17_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_17 == 1) {
                level_17_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_18 == 0) {
            level_18_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_18 == 1) {
                level_18_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_19 == 0) {
            level_19_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_19 == 1) {
                level_19_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_20 == 0) {
            level_20_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_20 == 1) {
                level_20_Button.setColor(Color.GREEN);
                countGreenGroup_2++;
            }
        }

        if (attainmentColorLevel_21 == 0) {
            level_21_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_21 == 1) {
                level_21_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_22 == 0) {
            level_22_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_22 == 1) {
                level_22_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_23 == 0) {
            level_23_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_23 == 1) {
                level_23_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_24 == 0) {
            level_24_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_24 == 1) {
                level_24_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_25 == 0) {
            level_25_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_25 == 1) {
                level_25_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_26 == 0) {
            level_26_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_26 == 1) {
                level_26_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_27 == 0) {
            level_27_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_27 == 1) {
                level_27_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_28 == 0) {
            level_28_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_28 == 1) {
                level_28_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_29 == 0) {
            level_29_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_29 == 1) {
                level_29_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_30 == 0) {
            level_30_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_30 == 1) {
                level_30_Button.setColor(Color.GREEN);
            }
        }

        // устанавливает фоновую картинку в Table
        NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("background/fon_level_4.png")),
                3, 3, 3, 3);
        NinePatchDrawable background = new NinePatchDrawable(patch);
        // устанавливает фоновую картинку в Table(конец)

        uiTable.setBackground(background);
        uiTable.add(level_1_Button).pad(15,15,15,15);
        uiTable.add(level_2_Button).pad(15,15,15,15);
        uiTable.add(level_3_Button).pad(15,15,15,15);
        uiTable.add(level_4_Button).pad(15,15,15,15);
        uiTable.add(level_5_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_6_Button).pad(15,15,15,15);
        uiTable.add(level_7_Button).pad(15,15,15,15);
        uiTable.add(level_8_Button).pad(15,15,15,15);
        uiTable.add(level_9_Button).pad(15,15,15,15);
        uiTable.add(level_10_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_11_Button).pad(15,15,15,15);
        uiTable.add(level_12_Button).pad(15,15,15,15);
        uiTable.add(level_13_Button).pad(15,15,15,15);
        uiTable.add(level_14_Button).pad(15,15,15,15);
        uiTable.add(level_15_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_16_Button).pad(15,15,15,15);
        uiTable.add(level_17_Button).pad(15,15,15,15);
        uiTable.add(level_18_Button).pad(15,15,15,15);
        uiTable.add(level_19_Button).pad(15,15,15,15);
        uiTable.add(level_20_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_21_Button).pad(15,15,15,15);
        uiTable.add(level_22_Button).pad(15,15,15,15);
        uiTable.add(level_23_Button).pad(15,15,15,15);
        uiTable.add(level_24_Button).pad(15,15,15,15);
        uiTable.add(level_25_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_26_Button).pad(15,15,15,15);
        uiTable.add(level_27_Button).pad(15,15,15,15);
        uiTable.add(level_28_Button).pad(15,15,15,15);
        uiTable.add(level_29_Button).pad(15,15,15,15);
        uiTable.add(level_30_Button).pad(15,15,15,15);


        // устанавливает фоновый цвет в Table
        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Color.BLACK);
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
        // устанавливает фоновый цвет в Table(конец)

        // устанавливает затемненный блок на вторую и третью десятки кнопок LevelScreens
        myTable.align(Align.center);
        myTable.add(uiModalWindowTable).width((level_16_Button.getWidth() * 5) + 130).height((level_1_Button.getHeight() * 2) + 30).padBottom(15);
        uiModalWindowTable.setBackground(textureRegionDrawableBg);
        uiModalWindowTable.getColor().a = 0f;
        myTable.row();
        myTable.add(uiModalWindowTable_2).width((level_16_Button.getWidth() * 5) + 130).height((level_1_Button.getHeight() * 2) + 30).padBottom(15).padTop(15);
        uiModalWindowTable_2.setBackground(textureRegionDrawableBg);
        switch (countGreenGroup_1) {
            case 0:
                uiModalWindowTable_2.getColor().a = 0.8f;
                break;
            case 1:
                uiModalWindowTable_2.getColor().a = 0.7f;
                break;
            case 2:
                uiModalWindowTable_2.getColor().a = 0.65f;
                break;
            case 3:
                uiModalWindowTable_2.getColor().a = 0.6f;
                break;
            case 4:
                uiModalWindowTable_2.getColor().a = 0.5f;
                break;
            case 5:
                uiModalWindowTable_2.getColor().a = 0.45f;
                break;
            case 6:
                uiModalWindowTable_2.getColor().a = 0.4f;
                break;
            case 7:
                uiModalWindowTable_2.getColor().a = 0.3f;
                break;
            case 8:
                uiModalWindowTable_2.getColor().a = 0.2f;
                break;
            case 9:
                uiModalWindowTable_2.getColor().a = 0f;
                break;
        }
        myTable.row();
        myTable.add(uiModalWindowTable_3).width((level_16_Button.getWidth() * 5) + 130).height((level_1_Button.getHeight() * 2) + 30).padTop(15);
        uiModalWindowTable_3.setBackground(textureRegionDrawableBg);
        switch (countGreenGroup_2) {
            case 0:
                uiModalWindowTable_3.getColor().a = 0.8f;
                break;
            case 1:
                uiModalWindowTable_3.getColor().a = 0.7f;
                break;
            case 2:
                uiModalWindowTable_3.getColor().a = 0.65f;
                break;
            case 3:
                uiModalWindowTable_3.getColor().a = 0.6f;
                break;
            case 4:
                uiModalWindowTable_3.getColor().a = 0.5f;
                break;
            case 5:
                uiModalWindowTable_3.getColor().a = 0.45f;
                break;
            case 6:
                uiModalWindowTable_3.getColor().a = 0.4f;
                break;
            case 7:
                uiModalWindowTable_3.getColor().a = 0.3f;
                break;
            case 8:
                uiModalWindowTable_3.getColor().a = 0.2f;
                break;
            case 9:
                uiModalWindowTable_3.getColor().a = 0f;
                break;
        }
        // устанавливает затемненный блок на вторую и третью десятки кнопок LevelScreens (конец)


        level_1_Button.addActor(lock1);
        lock1.setPosition(level_1_Button.getWidth() / 2 - lock1.getWidth() / 2, level_1_Button.getHeight() / 2 - lock1.getHeight() / 2);
        level_3_Button.addActor(lock3);
        lock3.setPosition(level_3_Button.getWidth() / 2 - lock3.getWidth() / 2, level_3_Button.getHeight() / 2 - lock3.getHeight() / 2);
        level_2_Button.addActor(lock2);
        lock2.setPosition(level_2_Button.getWidth() / 2 - lock2.getWidth() / 2, level_2_Button.getHeight() / 2 - lock2.getHeight() / 2);
        level_4_Button.addActor(lock4);
        lock4.setPosition(level_4_Button.getWidth() / 2 - lock4.getWidth() / 2, level_4_Button.getHeight() / 2 - lock4.getHeight() / 2);
        level_5_Button.addActor(lock5);
        lock5.setPosition(level_5_Button.getWidth() / 2 - lock5.getWidth() / 2, level_5_Button.getHeight() / 2 - lock5.getHeight() / 2);
        level_6_Button.addActor(lock6);
        lock6.setPosition(level_6_Button.getWidth() / 2 - lock6.getWidth() / 2, level_6_Button.getHeight() / 2 - lock6.getHeight() / 2);
        level_7_Button.addActor(lock7);
        lock7.setPosition(level_7_Button.getWidth() / 2 - lock7.getWidth() / 2, level_7_Button.getHeight() / 2 - lock7.getHeight() / 2);
        level_8_Button.addActor(lock8);
        lock8.setPosition(level_8_Button.getWidth() / 2 - lock8.getWidth() / 2, level_8_Button.getHeight() / 2 - lock8.getHeight() / 2);
        level_9_Button.addActor(lock9);
        lock9.setPosition(level_9_Button.getWidth() / 2 - lock9.getWidth() / 2, level_9_Button.getHeight() / 2 - lock9.getHeight() / 2);
        level_10_Button.addActor(lock10);
        lock10.setPosition(level_10_Button.getWidth() / 2 - lock10.getWidth() / 2, level_10_Button.getHeight() / 2 - lock10.getHeight() / 2);
        level_11_Button.addActor(lock11);
        lock11.setPosition(level_11_Button.getWidth() / 2 - lock11.getWidth() / 2, level_11_Button.getHeight() / 2 - lock11.getHeight() / 2);
        level_12_Button.addActor(lock12);
        lock12.setPosition(level_12_Button.getWidth() / 2 - lock12.getWidth() / 2, level_12_Button.getHeight() / 2 - lock12.getHeight() / 2);
        level_13_Button.addActor(lock13);
        lock13.setPosition(level_13_Button.getWidth() / 2 - lock13.getWidth() / 2, level_13_Button.getHeight() / 2 - lock13.getHeight() / 2);
        level_14_Button.addActor(lock14);
        lock14.setPosition(level_14_Button.getWidth() / 2 - lock14.getWidth() / 2, level_14_Button.getHeight() / 2 - lock14.getHeight() / 2);
        level_15_Button.addActor(lock15);
        lock15.setPosition(level_15_Button.getWidth() / 2 - lock15.getWidth() / 2, level_15_Button.getHeight() / 2 - lock15.getHeight() / 2);
        level_16_Button.addActor(lock16);
        lock16.setPosition(level_16_Button.getWidth() / 2 - lock16.getWidth() / 2, level_16_Button.getHeight() / 2 - lock16.getHeight() / 2);
        level_17_Button.addActor(lock17);
        lock17.setPosition(level_17_Button.getWidth() / 2 - lock17.getWidth() / 2, level_17_Button.getHeight() / 2 - lock17.getHeight() / 2);
        level_18_Button.addActor(lock18);
        lock18.setPosition(level_18_Button.getWidth() / 2 - lock18.getWidth() / 2, level_18_Button.getHeight() / 2 - lock18.getHeight() / 2);
        level_19_Button.addActor(lock19);
        lock19.setPosition(level_19_Button.getWidth() / 2 - lock19.getWidth() / 2, level_19_Button.getHeight() / 2 - lock19.getHeight() / 2);
        level_20_Button.addActor(lock20);
        lock20.setPosition(level_20_Button.getWidth() / 2 - lock20.getWidth() / 2, level_20_Button.getHeight() / 2 - lock20.getHeight() / 2);
        level_21_Button.addActor(lock21);
        lock21.setPosition(level_21_Button.getWidth() / 2 - lock21.getWidth() / 2, level_21_Button.getHeight() / 2 - lock21.getHeight() / 2);
        level_22_Button.addActor(lock22);
        lock22.setPosition(level_22_Button.getWidth() / 2 - lock22.getWidth() / 2, level_22_Button.getHeight() / 2 - lock22.getHeight() / 2);
        level_23_Button.addActor(lock23);
        lock23.setPosition(level_23_Button.getWidth() / 2 - lock23.getWidth() / 2, level_23_Button.getHeight() / 2 - lock23.getHeight() / 2);
        level_24_Button.addActor(lock24);
        lock24.setPosition(level_24_Button.getWidth() / 2 - lock24.getWidth() / 2, level_24_Button.getHeight() / 2 - lock24.getHeight() / 2);
        level_25_Button.addActor(lock25);
        lock25.setPosition(level_25_Button.getWidth() / 2 - lock25.getWidth() / 2, level_25_Button.getHeight() / 2 - lock25.getHeight() / 2);
        level_26_Button.addActor(lock26);
        lock26.setPosition(level_26_Button.getWidth() / 2 - lock26.getWidth() / 2, level_26_Button.getHeight() / 2 - lock26.getHeight() / 2);
        level_27_Button.addActor(lock27);
        lock27.setPosition(level_27_Button.getWidth() / 2 - lock27.getWidth() / 2, level_27_Button.getHeight() / 2 - lock27.getHeight() / 2);
        level_28_Button.addActor(lock28);
        lock28.setPosition(level_28_Button.getWidth() / 2 - lock28.getWidth() / 2, level_28_Button.getHeight() / 2 - lock28.getHeight() / 2);
        level_29_Button.addActor(lock29);
        lock29.setPosition(level_29_Button.getWidth() / 2 - lock29.getWidth() / 2, level_29_Button.getHeight() / 2 - lock29.getHeight() / 2);
        level_30_Button.addActor(lock30);
        lock30.setPosition(level_30_Button.getWidth() / 2 - lock30.getWidth() / 2, level_30_Button.getHeight() / 2 - lock30.getHeight() / 2);

        switch (attainment) {
            case 0:
                lock1.remove();
                break;
            case 1:
                lock1.remove();
                lock2.remove();
                break;
            case 2:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                break;
            case 3:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                break;
            case 4:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                break;
            case 5:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                break;
            case 6:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                break;
            case 7:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                break;
            case 8:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                break;
            case 9:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                break;
            case 10:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                break;
            case 11:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                break;
            case 12:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                break;
            case 13:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                break;
            case 14:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                break;
            case 15:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                break;
            case 16:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                break;
            case 17:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                break;
            case 18:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                break;
            case 19:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                break;
            case 20:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                break;
            case 21:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                break;
            case 22:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                break;
            case 23:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                lock24.remove();
                break;
            case 24:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                lock24.remove();
                lock25.remove();
                break;
            case 25:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                lock24.remove();
                lock25.remove();
                lock26.remove();
                break;
            case 26:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                lock24.remove();
                lock25.remove();
                lock26.remove();
                lock27.remove();
                break;
            case 27:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                lock24.remove();
                lock25.remove();
                lock26.remove();
                lock27.remove();
                lock28.remove();
                break;
            case 28:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                lock24.remove();
                lock25.remove();
                lock26.remove();
                lock27.remove();
                lock28.remove();
                lock29.remove();
                break;
            case 29:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                lock19.remove();
                lock20.remove();
                lock21.remove();
                lock22.remove();
                lock23.remove();
                lock24.remove();
                lock25.remove();
                lock26.remove();
                lock27.remove();
                lock28.remove();
                lock29.remove();
                lock30.remove();
                break;
            default:
        }

        level_1_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
                        if (attainment >= 0) {
                            RectangleGame.setActiveScreen(new LevelScreen_1(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_2_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
                        if (attainment >= 1) {
                            RectangleGame.setActiveScreen(new LevelScreen_2(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_3_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 2) {
                            RectangleGame.setActiveScreen(new LevelScreen_3(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_4_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 3) {
                            RectangleGame.setActiveScreen(new LevelScreen_4(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_5_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 4) {
                            RectangleGame.setActiveScreen(new LevelScreen_5(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_6_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 5) {
                            RectangleGame.setActiveScreen(new LevelScreen_6(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_7_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 6) {
                            RectangleGame.setActiveScreen(new LevelScreen_7(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_8_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 7) {
                            RectangleGame.setActiveScreen(new LevelScreen_8(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_9_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 8) {
                            RectangleGame.setActiveScreen(new LevelScreen_9(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_10_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 9) {
                            RectangleGame.setActiveScreen(new LevelScreen_10(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_11_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 10 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_11(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_12_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 11 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_12(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_13_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 12 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_13(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_14_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 13 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_14(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_15_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 14 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_15(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_16_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 15 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_16(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_17_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 16 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_17(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_18_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 17 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_18(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_19_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 18 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_19(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_20_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 19 && uiModalWindowTable_2.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_20(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_21_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 20 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_21(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_22_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 21 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_22(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_23_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 22 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_23(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_24_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 23 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_24(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_25_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 24 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_25(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_26_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 25 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_26(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_27_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 26 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_27(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_28_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 27 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_28(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_29_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 28 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_29(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_30_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 29 && uiModalWindowTable_3.getColor().a < 0.2f) {
                            RectangleGame.setActiveScreen(new LevelScreen_30(requestHandler));
                        }
                        return false;
                    }
                }
        );

        Gdx.app.log("MyTag", String.valueOf(countGreenGroup_1));
    }

    @Override
    public void update(float var1) {

    }
}
