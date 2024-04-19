package it.epicode.project;

public abstract class MultimediaElement {

    protected String title;

    public MultimediaElement(String title) {
        this.title = title;
    }

    public abstract void play();

}
