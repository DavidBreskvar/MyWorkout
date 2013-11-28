package dbug.myworkout.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DayFragment extends Fragment {

	View view;
	ListView exercises;
	EditText addExercise;
	Button addButton;
	List<String> exerciseList = new ArrayList<String>();
	MyAdapter adapter;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		view = inflater.inflate(R.layout.day_fragment, container, false);
		exercises = (ListView)view.findViewById(R.id.dailyList);
		addExercise = (EditText)view.findViewById(R.id.searchExercise);
		addButton = (Button)view.findViewById(R.id.addExercise);
		
		Bundle details = this.getArguments();
		int position = details.getInt("position");
		String day = null;
		
		switch(position) {
		case 0:
			day = "Monday";
			break;
		case 1:
			day = "Tuesday";
			break;
		case 2:
			day = "Wednesday";
			break;
		case 3:
			day = "Thursday";
			break;
		case 4:
			day = "Friday";
			break;
		case 5:
			day = "Saturday";
			break;
		case 6:
			day = "Sunday";
			break;
		}
		
		Toast.makeText(getActivity(), day, Toast.LENGTH_SHORT).show();
		
		adapter = new MyAdapter(getActivity(), R.layout.day_exerice_list_row, R.id.exerciseTxt, exerciseList);
		exercises.setAdapter(adapter);
		
		addButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String newExercise = addExercise.getText().toString();
				if (newExercise.length() > 2) {
					exerciseList.add(newExercise);
					adapter.notifyDataSetChanged();
					addExercise.setText("");
				} else {
					Toast.makeText(getActivity(), "Invalid exercise!", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		return view;
	}
	
	private class MyAdapter extends ArrayAdapter<String> {

		private final Context context;
		private final List<String> objects;
		String TAG = "Edit";
		EditText reps, sets;
		TextView exerciseText, repsText, setsText;
		int set, rep;
		int x = 2;
		Button editButton;
		public MyAdapter(Context context, int resource, int textViewResourceId,
				List<String> objects) {
			super(context, resource, R.layout.day_exerice_list_row, objects);
			this.context = context;
			this.objects = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View rowView;
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.day_exerice_list_row, parent, false);
			exerciseText = (TextView)rowView.findViewById(R.id.exerciseTxt);
			repsText = (TextView)rowView.findViewById(R.id.repsTxt);
			setsText = (TextView)rowView.findViewById(R.id.setsTxt);
			editButton = (Button)rowView.findViewById(R.id.editbtn);
			sets = (EditText)rowView.findViewById(R.id.numSets);
			reps = (EditText)rowView.findViewById(R.id.numReps);
			editButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.i(TAG, "X = " + x);
					if (x % 2 == 0) {
						TAG = "Done";
						editButton.setText("Done");
						sets.setVisibility(View.VISIBLE);
						reps.setVisibility(View.VISIBLE);
					} else {
						TAG = "Edit";
						editButton.setText("Edit");
						String testSets = sets.getText().toString();
						String testReps = reps.getText().toString();
						sets.setVisibility(View.INVISIBLE);
						reps.setVisibility(View.INVISIBLE);
						repsText.setVisibility(View.VISIBLE);
						setsText.setVisibility(View.VISIBLE);
					}
					x++;
				}
			});
			
			
			return rowView;
		}
		
		
		
	}
	

}
