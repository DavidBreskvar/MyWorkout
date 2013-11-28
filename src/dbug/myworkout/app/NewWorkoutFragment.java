package dbug.myworkout.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewWorkoutFragment extends Fragment implements OnItemClickListener {

	ListView days;
	DayClickHandler handler;
	View view;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			handler = (DayClickHandler) getActivity();
		} catch (ClassCastException e) {
			Log.i("NewWorkout", "Activity does not implements DayClickHandler");
		}
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		view = inflater.inflate(R.layout.new_workout, container, false);
		
		days = (ListView)view.findViewById(R.id.daysList);
		String[] allDays  = this.getResources().getStringArray(R.array.days);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.day_list_row, R.id.dayRowText, allDays);
		days.setAdapter(adapter);
		days.setOnItemClickListener(this);
		
		return view;
	}
	
	public interface DayClickHandler {
		public void onDaysClick(int position);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		handler.onDaysClick(position);
	}
	

}
