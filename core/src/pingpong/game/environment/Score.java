package pingpong.game.environment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// import pingpong.game.entities.Ball;

public class Score {
    BitmapFont font;
    SpriteBatch batch;

    private final int width = Gdx.graphics.getWidth(), height = Gdx.graphics.getHeight();

    public Score() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        font.getData().setScale(1, 1);
    }

    public void render() {
        // int count;

        String player1 = "Player one: ";
        String player2 = "Player two: ";

        // if (Ball.playerOne_out)
        // count++;

        batch.begin();
        font.draw(batch, player1, width / 6.4f, height - 34.2f);
        font.draw(batch, player2, width / 1.5f, height - 34.2f);
        batch.end();

    }
}
