package it.epicode.project;

public class NonPlayableImage extends MultimediaElement {

    private int brightness;

    public NonPlayableImage(String title, int brightness) {
        super(title);
        this.brightness = Math.max(brightness, 0);
    }

    public void increaseBrightness() {
        brightness++;
    }

    public void decreaseBrightness() {
        if (brightness > 0) {
            brightness--;
        }
    }

    public void show() {
        System.out.println(title + " " + "*".repeat(brightness));
    }

    @Override
    public void play() {
        show();
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

}
