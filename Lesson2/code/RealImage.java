
public class RealImage implements Image {

    private String imageName;

    public RealImage(String imageName){
        this.imageName = imageName;
        System.out.println("loading image from disk");
    }

    @Override
    public String getName() {
        return imageName;
    }

    @Override
    public void display() {
        System.out.println("displaying image");
    }
}
