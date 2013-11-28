package dbug.myworkout.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CelebrityWorkout extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.celebrity_workout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.celebrity_workout, menu);
		return true;
	}

}
