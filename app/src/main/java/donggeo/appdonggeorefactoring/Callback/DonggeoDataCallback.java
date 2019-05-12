package donggeo.appdonggeorefactoring.Callback;



import java.util.ArrayList;
import donggeo.appdonggeorefactoring.DonggeoData;


public interface DonggeoDataCallback {
    public void onTaskDone(ArrayList<DonggeoData> donggeoData);
    //콜백으로 원하는 뷰에다가 전달해줄거임!


}
