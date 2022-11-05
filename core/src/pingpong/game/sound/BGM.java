package pingpong.game.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class BGM {
    Music music;

    public BGM() {
        music = Gdx.audio.newMusic(Gdx.files.internal("./sounds/bg_music.mp3"));
    }

    public void play(boolean loop) {
        music.setLooping(loop);
        music.setVolume(0.46f);
        music.play();
    }

    public void pause() {
        music.pause();
    }
}
