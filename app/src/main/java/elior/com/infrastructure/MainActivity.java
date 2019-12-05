package elior.com.infrastructure;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.DataAppPackage.JSONResponse;
import elior.com.infrastructure.DataAppPackage.PlaceModel;
import elior.com.infrastructure.RetrofitDagger2Package.GetDataService;
import elior.com.infrastructure.RetrofitDagger2Package.MyApplication;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlacesListAdapter placesListAdapter;
    private ArrayList<PlaceModel> mMovieListInternet;
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        getData();
    }

    private void initUI() {
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        recyclerView = findViewById(R.id.recyclerView);
    }

    private void getData() {
        GetDataService apiService = retrofit.create(GetDataService.class);
        Observable<JSONResponse> observable = apiService.getAllMovies("/maps/api/place/nearbysearch/json?location=31.4,34.1&radius=50000&sensor=true&rankby=prominence&types=&keyword=&key="
                + getString(R.string.api_key_search))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<JSONResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(JSONResponse products) {
                generateDataList(Arrays.asList(products.getResults()));
            }
        });
    }

    private void generateDataList(List<PlaceModel> photoList) {
        mMovieListInternet = new ArrayList<PlaceModel>(photoList);
        placesListAdapter = new PlacesListAdapter(this, mMovieListInternet);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(placesListAdapter);
    }

}