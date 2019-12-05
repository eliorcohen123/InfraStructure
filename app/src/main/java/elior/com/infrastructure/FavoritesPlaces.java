package elior.com.infrastructure;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.DataAppPackage.PlaceModel;
import elior.com.infrastructure.RoomFavoritesPackage.IPlacesDataReceived;
import elior.com.infrastructure.RoomFavoritesPackage.PlaceViewModelFavorites;

public class FavoritesPlaces extends AppCompatActivity implements IPlacesDataReceived {

    private PlaceViewModelFavorites mPlacesViewModelFavorites;
    private NetworkDataProviderFavorites networkDataProviderFavorites;
    private PlacesListAdapterFav mAdapterFavorites;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        initUI();
        getData();
        myRecyclerView();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerViewFav);
        networkDataProviderFavorites = new NetworkDataProviderFavorites();
    }

    private void getData() {
        networkDataProviderFavorites.getPlacesByLocation(this);
    }

    private void myRecyclerView() {
        try {
            mAdapterFavorites = new PlacesListAdapterFav(this);
            recyclerView.setAdapter(mAdapterFavorites);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception e) {

        }

        mPlacesViewModelFavorites = ViewModelProviders.of(this).get(PlaceViewModelFavorites.class);
    }

    @Override
    public void onPlacesDataReceived(ArrayList<PlaceModel> results_) {
        // pass data result to mAdapterFavorites
        mPlacesViewModelFavorites.getAllPlaces().observe(this, placesFavorites -> mAdapterFavorites.setPlaces(placesFavorites));
    }

}
