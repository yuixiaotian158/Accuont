package com.example.account;

import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomDialog extends Dialog {

	private TextView title;
	private EditText editText;
	private Button positiveButton, negativeButton;

	public CustomDialog(Context context) {
		super(context);
		setCustomDialog();
	}

	private void setCustomDialog() {
		View mView = LayoutInflater.from(getContext()).inflate(R.layout.mydialog, null);
		title = (TextView) mView.findViewById(R.id.title);
		editText = (EditText) mView.findViewById(R.id.number);
		positiveButton = (Button) mView.findViewById(R.id.positiveButton);
		negativeButton = (Button) mView.findViewById(R.id.negativeButton);
		super.setContentView(mView);
	}

	public EditText getEditText() {
		return editText;
	}

	public void setEditText(EditText editText) {
		this.editText = editText;
	}

	public Button getPositiveButton() {
		return positiveButton;
	}

	public void setPositiveButton(Button positiveButton) {
		this.positiveButton = positiveButton;
	}

	public Button getNegativeButton() {
		return negativeButton;
	}

	public void setNegativeButton(Button negativeButton) {
		this.negativeButton = negativeButton;
	}

	public TextView getTitle() {
		return title;
	}

	public void setTitle(TextView title) {
		this.title = title;
	}

}
