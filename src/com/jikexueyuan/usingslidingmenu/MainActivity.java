package com.jikexueyuan.usingslidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

public class MainActivity extends Activity {

	private SlidingMenu slidingMenu;

aSDaSDzxC
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(R.layout.slidingmenu);
		Log.d("TAG", "start");
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
		Intent intent = new Intent(MainActivity.this, SocialActivity.class);
		startActivity(intent);
	}

	public void connectclick(View view) {
		Intent intent = new Intent(MainActivity.this, ConnectActivity.class);
		startActivity(intent);
	}

	public void potclick(View view) {
		Intent intent = new Intent(MainActivity.this, PotActivity.class);
		startActivity(intent);
	}

	public void dataclick(View view) {
		Intent intent = new Intent(MainActivity.this, DataActivity.class);
		startActivity(intent);
	}

}

// public class MainActivity extends SlidingActivity
// 这是slidingmenu的第二种构造方法，直接继承接口
// {
// @Override
// public void onCreate(Bundle savedInstanceState)
// {
// super.onCreate(savedInstanceState);
// setContentView(R.layout.activity_main);
//
// setBehindContentView(R.layout.slidingmenu);
// // configure the SlidingMenu
// SlidingMenu menu = getSlidingMenu();
// menu.setMode(SlidingMenu.LEFT);
// // 设置触摸屏幕的模式
// menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
// /* menu.setShadowWidthRes(R.dimen.shadow_width);
// menu.setShadowDrawable(R.drawable.shadow); */
//
// // 设置滑动菜单视图的宽度
// //menu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
// // 设置渐入渐出效果的值
// menu.setFadeDegree(0.35f);
// /**
// * SLIDING_WINDOW will include the Title/ActionBar in the content
// * section of the SlidingMenu, while SLIDING_CONTENT does not.
// */
// // menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
// // menu.setMenu(R.layout.leftmenu);
//
// }
//
// }

