package iloveu.lanchong.android.diyview;

import android.app.Application;

public class App extends Application {

    private static App ourInstance ;

    public App() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
    }

    public static App getInstance() {
        return ourInstance;
    }

    public static int dip2px(int dp) {
        float density = ourInstance.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }



}
