
public class AdaptorTV implements TV {

    private UltraTV ultraTV;

    public AdaptorTV(UltraTV ultraTV){
        this.ultraTV = ultraTV;
    }

    public void playMovie(){
        this.ultraTV.play4k();
    }

}
