public class Main {
    public static void main(String[] args) {


        interface Playable {
            void play();
        }

        abstract class MediaElement {
            protected String title;

            public MediaElement(String title) {
                this.title = title;
            }

            public String getTitle() {
                return title;
            }
        }

        class Image extends MediaElement {
            private int brightness;

            public Image(String title, int brightness) {
                super(title);
                this.brightness = brightness;
            }

            public void increaseBrightness() {
                brightness++;
            }

            public void decreaseBrightness() {
                brightness--;
            }

            public void show() {
                System.out.println(title + "*".repeat(brightness));
            }
        }

        abstract class PlayableMediaElement extends MediaElement implements Playable {
            protected int duration;

            public PlayableMediaElement(String title, int duration) {
                super(title);
                this.duration = duration;
            }
        }


        class AudioRecording extends PlayableMediaElement {
            private int volume;

            public AudioRecording(String title, int duration, int volume) {
                super(title, duration);
                this.volume = volume;
            }

            public void increaseVolume() {
                volume++;
            }

            public void decreaseVolume() {
                volume--;
            }

            @Override
            public void play() {
                for (int i = 0; i < volume; i++) {
                    System.out.println(title);
                }
            }
        }


        class Video extends PlayableMediaElement {
            private int volume;
            private int brightness;

            public Video(String title, int duration, int volume, int brightness) {
                super(title, duration);
                this.volume = volume;
                this.brightness = brightness;
            }

            public void increaseVolume() {
                volume++;
            }

            public void decreaseVolume() {
                volume--;
            }

            public void increaseBrightness() {
                brightness++;
            }

            public void decreaseBrightness() {
                brightness--;
            }

            @Override
            public void play() {
                for (int i = 0; i < duration; i++) {
                    System.out.println(title + "!".repeat(volume) + "*".repeat(brightness));
                }
            }
        }


        public class MediaPlayer {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                MediaElement[] elements = new MediaElement[5];

                // Creazione degli elementi multimediali
                elements[0] = new Image("Beautiful Sunset", 5);
                elements[1] = new AudioRecording("Classic Symphony", 3, 4);
                elements[2] = new Video("Funny Cat Video", 2, 3, 6);
                elements[3] = new Image("Mountain View", 8);
                elements[4] = new AudioRecording("Podcast Episode", 4, 5);


                while (true) {
                    System.out.println("Select an element to execute (1-5) or 0 to exit:");
                    int choice = scanner.nextInt();

                    if (choice == 0) {
                        break;
                    } else if (choice >= 1 && choice <= 5) {
                        MediaElement element = elements[choice - 1];
                        if (element instanceof Playable) {
                            ((Playable) element).play();
                        } else if (element instanceof Image) {
                            ((Image) element).show();
                        }
                    } else {
                        System.out.println("Invalid choice, please try again.");
                    }
                }

                scanner.close();
            }
        }
    }
}