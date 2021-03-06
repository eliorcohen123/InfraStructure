package elior.com.infrastructure.ClassesPackage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.AdapterPackage.CustomAdapterPlacesFavorites;
import elior.com.infrastructure.R;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesViewModelFavorites;

public class FavoritesActivity extends AppCompatActivity {

    private PlacesViewModelFavorites mPlacesViewModelFavorites;
    private CustomAdapterPlacesFavorites mAdapterFavorites;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        initUI();
        myRecyclerView();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerViewFav);
    }

    private void myRecyclerView() {
        try {
            mAdapterFavorites = new CustomAdapterPlacesFavorites(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(mAdapterFavorites);
        } catch (Exception e) {

        }

        mPlacesViewModelFavorites = ViewModelProviders.of(this).get(PlacesViewModelFavorites.class);

        mPlacesViewModelFavorites.getAllPlaces().observe(this, placesFavorites -> mAdapterFavorites.setPlaces(placesFavorites));
    }

}
