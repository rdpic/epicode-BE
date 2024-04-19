package it.epicode.project;

import java.util.Scanner;

public class MultimediaPlayer {

    private MultimediaElement[] elements;
    private Scanner scanner;

    public MultimediaPlayer() {
        elements = new MultimediaElement[5];
        scanner = new Scanner(System.in);
    }

    public void addElement(MultimediaElement element, int index) {
        if (index >= 0 && index < elements.length) {
            elements[index] = element;
        }
    }

    public void playElement() {
        int lastPlayedElementIndex = -1;

        while (true) {
            System.out.println("Enter a number between 1 and 5 to play an element, 0 to exit:");
            System.out.println("Enter 6 to raise volume, 7 to lower volume, 8 to increase brightness, 9 to decrease brightness of the last played element.");
            int command = scanner.nextInt();

            if (command == 0) {
                break;
            } else if (command >= 1 && command <= 5) {
                lastPlayedElementIndex = command - 1;
                MultimediaElement element = elements[lastPlayedElementIndex];
                if (element != null) {
                    element.play();
                    System.out.println();
                } else {
                    System.out.println("Element not found at this position.");
                }
            } else if (command >= 6 && command <= 9) {
                if (lastPlayedElementIndex != -1) {
                    MultimediaElement element = elements[lastPlayedElementIndex];
                    if (element != null) {
                        if (element instanceof NonPlayableImage && (command == 6 || command == 7)) {
                            System.out.println("Adjusting volume is not applicable for an image.");
                            System.out.println();
                        } else if (element instanceof PlayableAudio && (command == 8 || command == 9)) {
                            System.out.println("Adjusting brightness is not applicable for an audio.");
                            System.out.println();
                        } else {
                            switch (command) {
                                case 6:
                                    if (element instanceof PlayableAudio) {
                                        ((PlayableAudio) element).raiseVolume();
                                        System.out.println("Volume of " + element.title + " increased.");
                                        System.out.println();
                                    } else if (element instanceof PlayableVideo) {
                                        ((PlayableVideo) element).raiseVolume();
                                        System.out.println("Volume of " + element.title + " increased.");
                                        System.out.println();
                                    }
                                    break;
                                case 7:
                                    if (element instanceof PlayableAudio) {
                                        ((PlayableAudio) element).lowerVolume();
                                        System.out.println("Volume of " + element.title + " decreased.");
                                        System.out.println();
                                    } else if (element instanceof PlayableVideo) {
                                        ((PlayableVideo) element).lowerVolume();
                                        System.out.println("Volume of " + element.title + " decreased.");
                                        System.out.println();
                                    }
                                    break;
                                case 8:
                                    if (element instanceof PlayableVideo) {
                                        ((PlayableVideo) element).increaseBrightness();
                                        System.out.println("Brightness of " + element.title + " increased.");
                                        System.out.println();
                                    } else if (element instanceof NonPlayableImage) {
                                        ((NonPlayableImage) element).increaseBrightness();
                                        System.out.println("Brightness of " + element.title + " increased.");
                                        System.out.println();
                                    }
                                    break;
                                case 9:
                                    if (element instanceof PlayableVideo) {
                                        ((PlayableVideo) element).decreaseBrightness();
                                        System.out.println("Brightness of " + element.title + " decreased.");
                                        System.out.println();
                                    } else if (element instanceof NonPlayableImage) {
                                        ((NonPlayableImage) element).decreaseBrightness();
                                        System.out.println("Brightness of " + element.title + " decreased.");
                                        System.out.println();
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid command for adjustments.");
                                    System.out.println();
                                    break;
                            }
                        }
                    }
                } else {
                    System.out.println("No element has been played yet for adjustments.");
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input. Please try again.");
                System.out.println();
            }
        }
    }

}
