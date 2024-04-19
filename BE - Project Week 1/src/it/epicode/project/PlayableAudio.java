package it.epicode.project;

public class PlayableAudio extends MultimediaElement implements Playable {

    private int duration;
    private int volume;

    public PlayableAudio(String title, int duration, int volume) {
        super(title);
        this.duration = duration;
        this.volume = Math.max(volume, 0);
    }

    public void lowerVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void raiseVolume() {
        volume++;
    }

    public void play() {
        for (int i = 0; i < duration; i++) {
            System.out.println(title + " " + "!".repeat(volume));
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
