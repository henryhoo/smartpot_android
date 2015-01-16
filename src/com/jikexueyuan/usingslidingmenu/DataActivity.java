package com.jikexueyuan.usingslidingmenu;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jikexueyuan.usingslidingmenu.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.R.string;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.os.Build;

public class DataActivity extends Activity {
	private SlidingMenu slidingMenu;
	private Db db;
	private SQLiteDatabase dbwrite, dbread;// sql 的操作对象

	private ListView lv;xczvzxvc
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	private Class<com.jikexueyuan.usingslidingmenu.R.drawable> cls = R.drawable.class; // 获取图片id专用

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(R.layout.slidingmenu);

		// ///////////////////////Sqlite init//////////////////////////////////
		db = new Db(this, "db", null, 1);

		dbwrite = db.getWritableDatabase();
		dbread = db.getReadableDatabase();

		// /////////////////////init database//////////////////////////////////
		// dbwrite.execSQL("DROP TABLE IF EXISTS plants");
		dbwrite.execSQL("CREATE TABLE IF NOT EXISTS plants("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "humid TEXT DEFAULT \"\"," + "name TEXT DEFAULT \"\","
				+ "tem TEXT DEFAULT \"\")");

		// /////////////////////inputtestdata//////////////////////////////////
		// ContentValues cv = new ContentValues();
		// cv.put("_id", 8);
		// cv.put("humid", "80");
		// cv.put("tem", "70");
		// cv.put("name", "daisy");
		//
		// dbwrite.insert("plants", null, cv);
		// cv.put("_id", 1556);
		// cv.put("humid", "70");
		// cv.put("tem", "80");
		// cv.put("name", "orchid");
		//
		// dbwrite.insert("plants", null, cv);
		// dbwrite.close();
		// /////////////////////read data//////////////////////////////////
		Cursor datac = dbread.query("plants", null, null, null, null, null,
				null);
		while (datac.moveToNext()) {
			String name = datac.getString(datac.getColumnIndex("name"));
			String wet = datac.getString(datac.getColumnIndex("humid"));
			String hot = datac.getString(datac.getColumnIndex("tem"));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", name);
			map.put("info", "湿度" + wet + "%  " + "温度" + hot + "%");
			// map.put("info", wet);
			// 获取图像
			try {
				int value = cls.getDeclaredField(name).getInt(null);
				map.put("img", value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(map);

		}
		dbread.close();

		// ///////////////////////////////////init
		// listview//////////////////////////////
		lv = (ListView) findViewById(R.id.listView1);
		SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.lvview,
				new String[] { "title", "info", "img" }, new int[] {
						R.id.title, R.id.info, R.id.img });
		lv.setAdapter(adapter);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_MENU:
			slidingMenu.toggle(true);
			break;
		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void socialclick(View view) {
		Intent intent = new Intent(DataActivity.this, SocialActivity.class);
		startActivity(intent);
	}

	public void connectclick(View view) {
		Intent intent = new Intent(DataActivity.this, ConnectActivity.class);
		startActivity(intent);
	}

	public void potclick(View view) {
		Intent intent = new Intent(DataActivity.this, PotActivity.class);
		startActivity(intent);
	}

	public void dataclick(View view) {
		Intent intent = new Intent(DataActivity.this, DataActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_data, container,
					false);
			return rootView;
		}
	}


}
