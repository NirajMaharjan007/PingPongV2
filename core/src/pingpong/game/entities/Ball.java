package pingpong.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import pingpong.game.sound.Hit;

public class Ball {
    private static final int width = Gdx.graphics.getWidth(), height = Gdx.graphics.getHeight();

    private float directionX, directionY;

    public static Vector2 position = new Vector2(width / 2, height / 2);

    boolean running = true;

    static Sprite sprite;

    SpriteBatch batch;

    Hit hit;

    public Ball(SpriteBatch batch) {
        this.batch = batch;
    }

    private void move() {
        position.x += directionX;
        position.y += directionY;
    }

    public void create() {
        sprite = new Sprite(new Texture(Gdx.files.internal("./images/ball.png")));
        hit = new Hit();

        directionX = directionY = 6.24f;
    }

    public void render() {
        if (running) {
            move();
            collision();
        }

        if (Gdx.input.isKeyJustPressed(Keys.SPACE))
            running = true;

        batch.draw(sprite, position.x, position.y);
    }

    protected void collision() {
        Rectangle paddle_rect = new Rectangle(Player.position.x, Player.position.y,
                Player.getWidth(), Player.getHeight());

        Rectangle ball_rect = new Rectangle(position.x, position.y, sprite.getWidth(), sprite.getHeight());

        Rectangle paddle_rect_two = new Rectangle(Enemy.position.x,
                Enemy.position.y, Enemy.getWidth(), Enemy.getHeight());

        if (ball_rect.overlaps(paddle_rect) || ball_rect.overlaps(paddle_rect_two)) {
            hit.hit();
            directionX = -directionX;
        }

        if (position.y < 0 || position.y > height - sprite.getHeight()) {
            hit.hit();
            directionY = -directionY;
        }

        else if (position.x < 0 || position.x > width - sprite.getWidth()) {
            running = false;
            directionX = -directionX;
            position.y = height / 2.0f;
            if (position.x < 0) {
                position.x = width / 2.0f;
            } else if (position.x > width - sprite.getWidth()) {
                position.x = width / 2.0f - 14.8f;
            }
        }
    }

    protected static float getWidth() {
        return sprite.getWidth();
    }

    protected static float getHeight() {
        return sprite.getHeight();
    }
}
