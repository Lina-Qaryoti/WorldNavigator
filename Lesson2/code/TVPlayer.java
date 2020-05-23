
public class TVPlayer {

    public static void main(String[] args){
        TV tv1 = new StandardTV();
        TV tv2 = new HDTV();
        TV tv3 = new AdaptorTV(new UltraTV());

        tv1.playMovie();
        tv2.playMovie();
        tv3.playMovie();
    }
}
