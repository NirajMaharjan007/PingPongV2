package pingpong.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
    SpriteBatch batch;

    static Sprite sprite;

    protected static Vector2 position = new Vector2(Gdx.graphics.getWidth() - 26.4f, Gdx.graphics.getHeight() / 2);

    private float paddle_speed = 12.8f;

    public Enemy(SpriteBatch batch) {
        this.batch = batch;
    }

    public void create() {
        sprite = new Sprite(new Texture(Gdx.files.internal("./images/paddle_two.png")));
    }

    public void render() {
        move();
        batch.draw(sprite, position.x, position.y);
    }

    private void move() {
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            position.y -= paddle_speed;
        } else if (Gdx.input.isKeyPressed(Keys.UP)) {
            position.y += paddle_speed;
        }

        if (position.y > Gdx.graphics.getHeight() - sprite.getHeight())
            position.y -= paddle_speed;
        else if (position.y < 0)
            position.y += paddle_speed;
    }

    protected static float getWidth() {
        return sprite.getWidth();
    }

    protected static float getHeight() {
        return sprite.getHeight();
    }

}
