package it.epicode.project;

public class PlayableVideo extends MultimediaElement implements Playable {

    private int duration;
    private int volume;
    private int brightness;

    public PlayableVideo(String title, int duration, int volume, int brightness) {
        super(title);
        this.duration = duration;
        this.volume = Math.max(volume, 0);
        this.brightness = Math.max(brightness, 0);
    }

    public void lowerVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void raiseVolume() {
        volume++;
    }

    public void increaseBrightness() {
        brightness++;
    }

    public void decreaseBrightness() {
        if (brightness > 0) {
            brightness--;
        }
    }

    public void play() {
        for (int i = 0; i < duration; i++) {
            System.out.println(title + " " + "!".repeat(volume) + " " + "*".repeat(brightness));
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

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

}
