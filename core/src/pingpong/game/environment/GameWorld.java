package pingpong.game.environment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.*;

import pingpong.game.entities.*;
import pingpong.game.sound.BGM;

public class GameWorld {
    SpriteBatch batch;
    Player player;
    Enemy enemy;
    Ball ball;
    BitmapFont font;
    BGM music;

    int count1 = 0, count2 = 0;

    private final int width = Gdx.graphics.getWidth(), height = Gdx.graphics.getHeight();

    public void create() {
        batch = new SpriteBatch();

        player = new Player(batch);
        ball = new Ball(batch);
        enemy = new Enemy(batch);

        font = new BitmapFont();
        music = new BGM();

        font.getData().setScale(1, 1);

        player.create();
        enemy.create();
        ball.create();
    }

    public void render() {
        music.play(true);

        batch.begin();

        String player1 = "Player one: " + count1;
        String player2 = "Player two: " + count2;

        font.draw(batch, player1, width / 6.8f, height - 34.2f);
        font.draw(batch, player2, width / 2.0f + 128.8f, height - 34.2f);

        check();

        player.render();
        ball.render();
        enemy.render();
        batch.end();

        drawDottedLine(8, 400, 0, 400, 600);
    }

    public void dispose() {
        batch.dispose();
    }

    private void drawDottedLine(int dotDist, float x1, float y1, float x2, float y2) {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeType.Point);

        Vector2 vec2 = new Vector2(x2, y2).sub(new Vector2(x1, y1));
        float length = vec2.len();
        for (int i = 0; i < length; i += dotDist) {
            vec2.clamp(length - i, length - i);
            shapeRenderer.point(x1 + vec2.x, y1 + vec2.y, 0);
        }

        shapeRenderer.end();
    }

    private void check() {
        // System.out.println("GameWorld.check()" + count1 + " " + count2);
        if (Ball.position.x < Player.position.x)
            count2++;

        else if (Ball.position.x > Enemy.position.x)
            count1++;

    }

}
