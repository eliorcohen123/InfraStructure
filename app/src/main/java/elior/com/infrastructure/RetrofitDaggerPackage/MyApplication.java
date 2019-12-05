package elior.com.infrastructure.RetrofitDaggerPackage;

import android.app.Application;

public class MyApplication extends Application {

    private ApiComponent mApiComponent;
    private static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://maps.googleapis.com"))
                .build();

        mApplication = this;
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }

    public static Application getApplication() {
        return mApplication;
    }

}
