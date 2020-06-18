package elior.com.infrastructure.ClassesPackage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.AdapterPackage.PlacesListAdapterFav;
import elior.com.infrastructure.OthersPackage.NetworkDataProviderFavorites;
import elior.com.infrastructure.R;
import elior.com.infrastructure.RoomFavoritesPackage.PlaceViewModelFavorites;

public class FavoritesPlaces extends AppCompatActivity {

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
        networkDataProviderFavorites.getPlacesByLocation();
    }

    private void myRecyclerView() {
        try {
            mAdapterFavorites = new PlacesListAdapterFav(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(mAdapterFavorites);
        } catch (Exception e) {

        }

        mPlacesViewModelFavorites = ViewModelProviders.of(this).get(PlaceViewModelFavorites.class);

        mPlacesViewModelFavorites.getAllPlaces().observe(this, placesFavorites -> mAdapterFavorites.setPlaces(placesFavorites));
    }

}
