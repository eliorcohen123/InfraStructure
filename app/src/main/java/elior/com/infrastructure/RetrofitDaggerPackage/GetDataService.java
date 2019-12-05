package elior.com.infrastructure.RetrofitDaggerPackage;

import elior.com.infrastructure.DataAppPackage.JSONResponse;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

public interface GetDataService {

    @GET()
    Observable<JSONResponse> getAllMovies(@Url String url);
}
