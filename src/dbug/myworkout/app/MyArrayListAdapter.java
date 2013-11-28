package dbug.myworkout.app;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class MyArrayListAdapter extends ArrayAdapter<String> {
	
	private ArrayList<String> items;
	private int layoutResourceId;
	private Context context;
	
	public MyArrayListAdapter(Context context, int resource,
			List<String> objects) {
		super(context, resource, objects);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		
		
		return super.getView(position, convertView, parent);
	}
	
	
	

}
