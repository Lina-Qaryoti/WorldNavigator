
public class ImageClient {

    public static void main(String[] args){
        Image image = new ProxyImage("proxy.jpg");
        System.out.println(image.getName());
        image.display();
        image.display();
        image.display();
        image.display();
    }
}
