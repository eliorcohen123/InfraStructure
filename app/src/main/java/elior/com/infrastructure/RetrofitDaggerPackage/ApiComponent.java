package elior.com.infrastructure.RetrofitDaggerPackage;

import javax.inject.Singleton;

import dagger.Component;
import elior.com.infrastructure.ClassesPackage.MainActivity;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
