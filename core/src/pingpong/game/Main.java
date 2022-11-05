package pingpong.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;

import pingpong.game.environment.GameWorld;

public class Main extends ApplicationAdapter {
	GameWorld world;

	@Override
	public void create() {
		world = new GameWorld();

		world.create();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.render();
	}

	@Override
	public void dispose() {
		world.dispose();
	}
}
