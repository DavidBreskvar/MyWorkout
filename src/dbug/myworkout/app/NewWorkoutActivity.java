package dbug.myworkout.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.Toast;

public class NewWorkoutActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_workout_activity);
		
if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			
			Toast.makeText(this, "Rotate your phone please", Toast.LENGTH_SHORT).show();
			finish();
		}
		
		Intent details = this.getIntent();
		Bundle element = details.getExtras();
		
		Fragment Details = new DayFragment();
		Details.setArguments(element);
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.frame_layout_activity, Details);
		ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_workout, menu);
		return true;
	}

}
