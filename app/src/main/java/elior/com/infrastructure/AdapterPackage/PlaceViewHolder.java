package elior.com.infrastructure.AdapterPackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import elior.com.infrastructure.R;

public class PlaceViewHolder extends RecyclerView.ViewHolder {

    public TextView name1, address1;
    public ImageView image1;
    public RelativeLayout relativeLayout1;

    public PlaceViewHolder(View itemView) {
        super(itemView);

        name1 = itemView.findViewById(R.id.name1);
        address1 = itemView.findViewById(R.id.address1);
        image1 = itemView.findViewById(R.id.image1);
        relativeLayout1 = itemView.findViewById(R.id.relative1);
    }

}
