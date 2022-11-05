package pingpong.game.environment;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

import pingpong.game.entities.*;

public class GameWorld {
    SpriteBatch batch;
    Player player;
    Enemy enemy;
    Ball ball;
    Score score;

    public void create() {
        batch = new SpriteBatch();

        player = new Player(batch);
        ball = new Ball(batch);
        enemy = new Enemy(batch);

        score = new Score();

        player.create();
        enemy.create();
        ball.create();
    }

    public void render() {
        batch.begin();
        player.render();
        ball.render();
        enemy.render();
        batch.end();

        score.render();
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

}
