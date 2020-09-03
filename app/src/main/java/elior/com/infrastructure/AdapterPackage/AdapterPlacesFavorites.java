package elior.com.infrastructure.AdapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.R;
import elior.com.infrastructure.RoomFavoritesPackage.PlacesFavorites;

public class AdapterPlacesFavorites extends RecyclerView.Adapter<ViewHolderFavorites> {

    private final LayoutInflater mInflater;
    private List<PlacesFavorites> mPlacesFavoritesList;

    public AdapterPlacesFavorites(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderFavorites onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.adapter_places, parent, false);
        return new ViewHolderFavorites(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavorites holder, final int position) {
        if (mPlacesFavoritesList != null) {
            PlacesFavorites current = mPlacesFavoritesList.get(position);
            holder.name1.setText(current.getName());
            holder.address1.setText(current.getAddress());
            try {
                Glide.with(mInflater.getContext())
                        .load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="
                                + current.getPhoto() +
                                "&key=" + mInflater.getContext().getString(R.string.api_key_search))
                        .into(holder.image1);
            } catch (Exception e) {

            }

            holder.relativeLayout1.setOnClickListener(v -> {

            });
        } else {
            // Covers the case of data not being ready yet.
            holder.name1.setText("No Places");
        }
    }

    public void setPlaces(List<PlacesFavorites> placesFavorites) {
        mPlacesFavoritesList = placesFavorites;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mPlacesSearchList has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPlacesFavoritesList != null)
            return mPlacesFavoritesList.size();
        else return 0;
    }

}
