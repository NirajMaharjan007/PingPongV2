package pingpong.game.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Hit {
    Sound sound;

    public Hit() {
        sound = Gdx.audio.newSound(Gdx.files.internal("./sounds/pong.mp3"));
    }

    public void hit() {
        sound.play(1.2f);
    }

    public void stop() {
        sound.pause();
    }
}
