import android.content.Context;
import android.widget.ArrayAdapter;

public class LostArrayAdapter extends ArrayAdapter {
    private String[] mCuisines;
    private Context mContext;
    private String[] Lost;

    public  LostArrayAdapter(Context mContext, int resource, String[] Lost, String[] mCuisines){
        super(mContext, resource);
        this.mContext = mContext;
        this.Lost = Lost;
        this.mCuisines =mCuisines;

    }

    @Override
    public Object getItem(int position){
        String lost = Lost[position];
        return String.format("%\nServes great: %S",lost,mCuisines);
    }
    @Override
    public int getCount(){
        return Lost.length;
    }

}
