
public class ProxyImage implements Image {
    private String imageName;
    private RealImage realImage;   // Proxy class aggregates original class

    public ProxyImage(String imageName){
        this.imageName = imageName;
        realImage = null;
    }

    @Override
    public String getName() {
        return imageName;      // handle light requests by proxy
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(imageName);    // delegate to original class
        }
        System.out.println("displaying image");
    }
}

