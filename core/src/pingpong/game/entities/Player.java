package pingpong.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;

public class Player {
    SpriteBatch batch;
    static Sprite sprite;

    protected static Vector2 position = new Vector2();

    protected static float paddle_speed = 12.6f;

    public Player(SpriteBatch batch) {
        this.batch = batch;
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

    public void create() {
        sprite = new Sprite(new Texture(Gdx.files.internal("./images/paddle_one.png")));

        position.x = 20.0f;
        position.y = Gdx.graphics.getHeight() / 2;
    }

    public void render() {
        move();
        batch.draw(sprite, position.x, position.y);
    }

    protected static float getWidth() {
        return sprite.getWidth();
    }

    protected static float getHeight() {
        return sprite.getHeight();
    }
}
