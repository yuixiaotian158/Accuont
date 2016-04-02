package com.example.account;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private TextView tv_huaxia;
	private TextView tv_jiaotong;
	private TextView tv_gupiao;
	private TextView tv_zhifubao;
	private TextView tv_card;
	private TextView tv_sum;
	private CustomDialog mdialog;
	private Button add_huaxia;
	private Button add_jiaotong;
	private Button add_gupiao;
	private Button add_zhifubao;
	private Button add_card;

	private Button sub_huaxia;
	private Button sub_jiaotong;
	private Button sub_gupiao;
	private Button sub_zhifubao;
	private Button sub_card;
	private SharedPreferences preference;
	private Editor editor;
	private static boolean istrue=false;
	@Override
	protected void onDestroy() {
		editor.putString("huaxia", tv_huaxia.getText().toString());
		editor.putString("jiaotong", tv_jiaotong.getText().toString());
		editor.putString("zhifubao", tv_zhifubao.getText().toString());
		editor.putString("card", tv_card.getText().toString());
		editor.putString("gupiao", tv_gupiao.getText().toString());
		editor.putString("sum", tv_sum.getText().toString());
		editor.putBoolean("istrue", true);
		editor.commit();
		super.onDestroy();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		preference = getSharedPreferences("data", Activity.MODE_PRIVATE);
		editor = preference.edit();
		
		initView();

		mdialog = new CustomDialog(this);
	}

	private void initView() {
		tv_huaxia = (TextView) findViewById(R.id.tv_huaxia);
		tv_jiaotong = (TextView) findViewById(R.id.tv_jiaotong);
		tv_gupiao = (TextView) findViewById(R.id.tv_gupiao);
		tv_zhifubao = (TextView) findViewById(R.id.tv_zhifubao);
		tv_sum = (TextView) findViewById(R.id.tv_sum);
		tv_card = (TextView) findViewById(R.id.tv_card);
		add_huaxia = (Button) findViewById(R.id.add_huaxia);
		add_jiaotong = (Button) findViewById(R.id.add_jiaotong);
		add_card = (Button) findViewById(R.id.add_card);
		add_gupiao = (Button) findViewById(R.id.add_gupiao);
		add_zhifubao = (Button) findViewById(R.id.add_zhifubao);
		sub_card = (Button) findViewById(R.id.sub_card);
		sub_gupiao = (Button) findViewById(R.id.sub_gupiao);
		sub_huaxia = (Button) findViewById(R.id.sub_huaxia);
		sub_jiaotong = (Button) findViewById(R.id.sub_jiaotong);
		sub_zhifubao = (Button) findViewById(R.id.sub_zhifubao);

		sub_card.setOnClickListener(this);
		sub_gupiao.setOnClickListener(this);
		sub_huaxia.setOnClickListener(this);
		sub_jiaotong.setOnClickListener(this);
		sub_zhifubao.setOnClickListener(this);
		add_huaxia.setOnClickListener(this);
		add_card.setOnClickListener(this);
		add_jiaotong.setOnClickListener(this);
		add_zhifubao.setOnClickListener(this);
		add_gupiao.setOnClickListener(this);
		tv_gupiao.setOnClickListener(this);
		tv_card.setOnClickListener(this);
		tv_jiaotong.setOnClickListener(this);
		tv_zhifubao.setOnClickListener(this);
		tv_huaxia.setOnClickListener(this);
		setsum();
		Log.i("tag", "preference.getBoolean:"+preference.getBoolean("istrue", false));
		if (preference.getBoolean("istrue", false)) {
			
			tv_huaxia.setText(preference.getString("huaxia", null));
			tv_card.setText(preference.getString("card", null));
			tv_gupiao.setText(preference.getString("gupiao", null));
			tv_jiaotong.setText(preference.getString("jiaotong", null));
			tv_zhifubao.setText(preference.getString("zhifubao", null));
			tv_sum.setText(preference.getString("sum", null));
		}

	}

	private void setsum() {
		int huaxia = Integer.parseInt(tv_huaxia.getText().toString().trim());
		int jiaotong = Integer.parseInt(tv_jiaotong.getText().toString().trim());
		int zhifubao = Integer.parseInt(tv_zhifubao.getText().toString().trim());
		int gupiao = Integer.parseInt(tv_gupiao.getText().toString().trim());
		int card = Integer.parseInt(tv_card.getText().toString().trim());
		int sum = huaxia + jiaotong + zhifubao + gupiao - card;
		tv_sum.setText(String.valueOf(sum));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sub_huaxia:
			mdialog.setTitle("华夏银行减少");
			setSub(tv_huaxia);
			mdialog.show();

			break;
		case R.id.sub_card:
			mdialog.setTitle("信用卡减少");
			setSub(tv_card);
			mdialog.show();
			break;
		case R.id.sub_gupiao:
			mdialog.setTitle("股票减少");
			setSub(tv_gupiao);
			mdialog.show();
			break;
		case R.id.sub_jiaotong:
			mdialog.setTitle("交通银行减少");
			setSub(tv_jiaotong);
			mdialog.show();
			break;
		case R.id.sub_zhifubao:
			mdialog.setTitle("支付宝减少");
			setSub(tv_huaxia);
			mdialog.show();
			break;
		case R.id.add_huaxia:
			mdialog.setTitle("华夏银行增加");
			setAdd(tv_huaxia);
			mdialog.show();
			break;
		case R.id.add_card:
			mdialog.setTitle("信用卡增加");
			setAdd(tv_card);
			mdialog.show();
			break;
		case R.id.add_jiaotong:
			mdialog.setTitle("交通银行增加");
			setAdd(tv_jiaotong);
			mdialog.show();
			break;
		case R.id.add_gupiao:
			mdialog.setTitle("股票增加");
			setAdd(tv_gupiao);
			mdialog.show();
			break;
		case R.id.add_zhifubao:
			mdialog.setTitle("支付宝增加");
			setAdd(tv_zhifubao);
			mdialog.show();
			break;
		case R.id.tv_huaxia:
			mdialog.setTitle("华夏银行");
			setclick(tv_huaxia);
			mdialog.show();
			setsum();
			break;
		case R.id.tv_jiaotong:
			mdialog.setTitle("交通银行");
			setclick(tv_jiaotong);
			mdialog.show();
			setsum();
			break;
		case R.id.tv_gupiao:
			mdialog.setTitle("股票");
			setclick(tv_gupiao);
			mdialog.show();
			setsum();
			break;
		case R.id.tv_zhifubao:
			mdialog.setTitle("支付宝");
			setclick(tv_zhifubao);
			mdialog.show();
			setsum();
			break;

		default:
			break;
		}
	}

	private void setSub(final TextView tv) {
		mdialog.getPositiveButton().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int add = Integer.parseInt(mdialog.getEditText().getText().toString());
				tv.setText(Integer.parseInt(tv.getText().toString()) - add + "");
				mdialog.getEditText().setText("");
				mdialog.dismiss();
				setsum();
				Toast.makeText(MainActivity.this, "操作成功！", Toast.LENGTH_SHORT).show();
			}
		});
		mdialog.getNegativeButton().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mdialog.getEditText().setText("");
				mdialog.dismiss();
			}
		});
	}

	private void setAdd(final TextView tv) {
		mdialog.getPositiveButton().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int add = Integer.parseInt(mdialog.getEditText().getText().toString());
				tv.setText(Integer.parseInt(tv.getText().toString()) + add + "");
				mdialog.getEditText().setText("");
				mdialog.dismiss();
				setsum();
				Toast.makeText(MainActivity.this, "操作成功！", Toast.LENGTH_SHORT).show();
			}
		});
		mdialog.getNegativeButton().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mdialog.getEditText().setText("");
				mdialog.dismiss();
			}
		});
	}

	private void setclick(final TextView tv) {
		mdialog.getPositiveButton().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tv.setText(mdialog.getEditText().getText().toString());
				mdialog.getEditText().setText("");
				mdialog.dismiss();
				setsum();
				Toast.makeText(MainActivity.this, "操作成功！", Toast.LENGTH_SHORT).show();
			}
		});
		mdialog.getNegativeButton().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mdialog.getEditText().setText("");
				mdialog.dismiss();
			}
		});
	}

}
