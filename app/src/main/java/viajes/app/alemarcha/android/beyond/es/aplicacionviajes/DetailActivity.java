package viajes.app.alemarcha.android.beyond.es.aplicacionviajes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.DAO.TripDAO;

public class DetailActivity extends AppCompatActivity {

    public static final String POS_ELEMENT_DETAIL="param_pos";
    public static final String ELEMENT_DETAIL_IMG="param_img";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int pos=getIntent().getExtras().getInt(POS_ELEMENT_DETAIL);

        TextView t= (TextView)findViewById(R.id.fromTo);
        t.setText( TripDAO.getProductById(pos).getPrice());
        TextView image= (TextView)findViewById(R.id.urlImage);
        image.setText(getIntent().getExtras().getString(ELEMENT_DETAIL_IMG));
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.with(this.getApplicationContext()).load(getIntent().getExtras().getString(ELEMENT_DETAIL_IMG)).into(imageView);

    }
}
