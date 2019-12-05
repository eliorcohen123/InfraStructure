package elior.com.infrastructure.RetrofitDagger2Package;

import javax.inject.Singleton;

import dagger.Component;
import elior.com.infrastructure.MainActivity;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
