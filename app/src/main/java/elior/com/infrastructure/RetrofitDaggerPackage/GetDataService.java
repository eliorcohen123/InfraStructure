package elior.com.infrastructure.RetrofitDaggerPackage;

import elior.com.infrastructure.ModelPackage.JSONResponse;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

public interface GetDataService {

    @GET()
    Observable<JSONResponse> getAllPlaces(@Url String url);
}
