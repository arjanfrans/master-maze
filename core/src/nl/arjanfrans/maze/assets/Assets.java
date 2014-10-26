package nl.arjanfrans.maze.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ArrayMap;

public class Assets {
    public static AssetManager manager = new AssetManager();
    public static final String GRAPHICS_DIRECTORY = "graphics/spritesheets";
    public static final String FONTS_DIRECTORY = "fonts";
    private static ArrayMap<String, TextureRegion> regions = new ArrayMap<String, TextureRegion>();
    private static ArrayMap<String, BitmapFont> fonts = new ArrayMap<String, BitmapFont>();

    private static TextureAtlas gameAtlas;

    public static void load() {
        manager.load(GRAPHICS_DIRECTORY + "/game.atlas", TextureAtlas.class);
        manager.finishLoading();

        gameAtlas = Assets.manager.get(GRAPHICS_DIRECTORY + "/game.atlas", TextureAtlas.class);
    }


    public static BitmapFont getFont(String name, int size) {
        BitmapFont font = fonts.get(name + "_" + size);
        if(font != null) return font;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONTS_DIRECTORY + "/" + name + ".ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = size;
        BitmapFont f = generator.generateFont(parameters);
        fonts.put(name + "_" + size, f);
        return f;
    }

    public static TextureRegion getGameTexture(String regionName) {
        TextureRegion t = regions.get(regionName);
        if(t != null) return t;
        TextureRegion ar = gameAtlas.findRegion(regionName);
        TextureRegion[] a= ar.split(32, 32)[0];
        regions.put(regionName, a[0]);
        return a[0];
    }

}
