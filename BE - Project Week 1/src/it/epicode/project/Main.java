package it.epicode.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MultimediaPlayer player = new MultimediaPlayer();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the type of element to create (audio, video, image):");
            String elementType = scanner.next().toLowerCase();

            switch (elementType) {
                case "audio":
                    System.out.println("Enter the title of the element:");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.println("Enter the duration (in seconds) of the audio:");
                    int audioDuration = scanner.nextInt();
                    System.out.println("Enter the volume level of the audio:");
                    int volume = scanner.nextInt();
                    PlayableAudio audio = new PlayableAudio(title, audioDuration, volume);
                    player.addElement(audio, i);
                    break;
                case "video":
                    System.out.println("Enter the title of the element:");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    System.out.println("Enter the duration (in seconds) of the video:");
                    int videoDuration = scanner.nextInt();
                    System.out.println("Enter the volume level of the video:");
                    int videoVolume = scanner.nextInt();
                    System.out.println("Enter the brightness level of the video:");
                    int brightness = scanner.nextInt();
                    PlayableVideo video = new PlayableVideo(title, videoDuration, videoVolume, brightness);
                    player.addElement(video, i);
                    break;
                case "image":
                    System.out.println("Enter the title of the element:");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    System.out.println("Enter the brightness level of the image:");
                    int imageBrightness = scanner.nextInt();
                    NonPlayableImage image = new NonPlayableImage(title, imageBrightness);
                    player.addElement(image, i);
                    break;
                default:
                    System.out.println("Invalid element type.");
                    i--;
                    break;
            }
        }

        player.playElement();
        scanner.close();
    }

}
