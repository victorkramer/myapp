package com.example.myapp.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListView;

import com.example.myapp.R;
import com.example.myapp.data.CpContract.CpCityContract;
import com.example.myapp.data.DbContract.CityTable;


public class CitiesActivity extends FragmentActivity implements LoaderCallbacks<Cursor> {
	
	private static final String TAG = CitiesActivity.class.getSimpleName();
	
	SimpleCursorAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "OnCreate");
		setContentView(R.layout.activity_listview);
		
		getSupportLoaderManager().initLoader(0, null, this);
		
		String from[] = { CityTable.COLUMN_NAME_CITY_NAME, CityTable.COLUMN_NAME_CITY_REVISION };
		int to[] = { android.R.id.text1, android.R.id.text2 };
		adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, null, from, to, 0);

		ListView lvContact = (ListView) findViewById(R.id.contactsListView);
		lvContact.setAdapter(adapter);

	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		String[] projection = { CityTable._ID, CityTable.COLUMN_NAME_CITY_NAME, CityTable.COLUMN_NAME_CITY_REVISION };
	    CursorLoader cursorLoader = new CursorLoader(this,
	        CpCityContract.CITY_CONTENT_URI, projection, null, null, null);
	    return cursorLoader;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		 adapter.changeCursor(data);
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		 adapter.changeCursor(null);
		
	}
	
}
