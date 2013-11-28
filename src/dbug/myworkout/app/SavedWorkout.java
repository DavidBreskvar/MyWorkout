package dbug.myworkout.app;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class SavedWorkout extends BaseActivity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.saved_workout);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.saved_workout, menu);
		return true;
	}

}
