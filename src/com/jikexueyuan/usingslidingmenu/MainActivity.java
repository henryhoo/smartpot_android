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
// ����slidingmenu�ĵڶ��ֹ��췽����ֱ�Ӽ̳нӿ�
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
// // ���ô�����Ļ��ģʽ
// menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
// /* menu.setShadowWidthRes(R.dimen.shadow_width);
// menu.setShadowDrawable(R.drawable.shadow); */
//
// // ���û����˵���ͼ�Ŀ��
// //menu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
// // ���ý��뽥��Ч����ֵ
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

