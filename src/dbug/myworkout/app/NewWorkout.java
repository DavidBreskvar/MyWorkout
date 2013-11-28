package dbug.myworkout.app;

import dbug.myworkout.app.NewWorkoutFragment.DayClickHandler;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

public class NewWorkout extends FragmentActivity implements DayClickHandler{

	
	boolean dualPane;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_host);

		FrameLayout detailFrame = (FrameLayout)findViewById(R.id.frame_layout);
		dualPane = (detailFrame != null && detailFrame.getVisibility() == View.VISIBLE);
	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_workout, menu);
		return true;
	}

	@Override
	public void onDaysClick(int position) {
		Bundle extra = new Bundle();
		extra.putInt("position", position);
		
		if (dualPane) {
			Fragment NewFragment = new NewWorkoutFragment();
			NewFragment.setArguments(extra);
			
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.frame_layout, NewFragment);
			ft.commit();
			
		} else {
			Intent intent = new Intent(NewWorkout.this, NewWorkoutActivity.class);
			intent.putExtras(extra);
			startActivity(intent);
			
		}
		
	}

}
